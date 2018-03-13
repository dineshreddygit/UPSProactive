package com.java.template;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.java.model.Accessrls;
import com.java.model.Chgtyps;
import com.java.model.CustomerAct;
import com.java.model.CustomerProfile;
import com.java.model.CustomerProfileRequest;
import com.java.model.CustomerProfileResponse;
import com.java.model.Reffltr;
import com.java.model.Svctypes;

public class CustomerJDBCTemplate {

	public CustomerProfileResponse getCustomerDetails(CustomerProfileRequest customerprofileRequest) {
		CustomerProfileResponse customerProfileResponse = new CustomerProfileResponse();
		Connection conn = initConnection();
		try {
			CallableStatement proc = initStoredProc(conn, customerprofileRequest);
			boolean results = proc.execute();
			customerProfileResponse.setStatuscd(proc.getString(2));
			Map<String, CustomerProfile> customerProfileMap = new HashMap<>();
			int rsCount = 0;
			ResultSet rs;
			String custProfileKey;
			CustomerProfile customerProfile;
			do {
				if (results) {
					rs = proc.getResultSet();
					rsCount++;
					while (rs.next()) {
						if (rsCount == 1) {
							addCustomerAct(customerProfileResponse, rs);
						} else if (rsCount == 2) {
							addCustomerProfile(customerProfileMap, rs);
						} else {
							custProfileKey = getCustomerProfileKey(rs);
							customerProfile = customerProfileMap.get(custProfileKey);
							if (customerProfile != null) {
								switch (rsCount) {
								case 3:
									customerProfile.getSvctypes().add(Svctypes.getInstance(rs.getString("SVC_TYP_CD")));
									break;
								case 4:
									customerProfile.getAccessrls()
											.add(Accessrls.getInstance(rs.getString("ASY_SVC_TYP_CD")));
									break;
								case 5:
									customerProfile.getChgtyps()
											.add(Chgtyps.getInstance(rs.getString("SMT_CHG_TYP_CD")));
									break;
								case 6:
									customerProfile.getReffltr().add(Reffltr.getInstance(rs.getString("REF_NR_TYP_CD"),
											rs.getString("REF_NR_CPA_CRI_CD"), rs.getString("CUS_REF_NR")));
									break;
								}
							}
						}
					}
					rs.close();
				}
				results = proc.getMoreResults();
			} while (results);
			customerProfileResponse.setCustomerProfile(new ArrayList<CustomerProfile>(customerProfileMap.values()));
			proc.close();
		} catch (Exception e) {
			System.out.println("DB2 Database connection Failed");
			e.printStackTrace();
		}
		return customerProfileResponse;
	}

	private void addCustomerProfile(Map<String, CustomerProfile> customerProfileMap, ResultSet rs) throws SQLException {
		String custProfileKey;
		CustomerProfile customerProfile = new CustomerProfile();
		custProfileKey = getCustomerProfileKey(rs);
		customerProfile.setCusid(rs.getString("CUS_ID_NR"));
		customerProfile.setGrpid(rs.getString("GRP_NR"));
		customerProfile.setPkgmvmind(rs.getString("PKG_MVM_TYP_CD"));
		customerProfile.setHazmatind(rs.getString("HAZ_MAT_IR"));
		customerProfile.setDclval(rs.getString("TOT_DCL_VLU_A"));
		customerProfile.setDclccy(rs.getString("DCL_VLU_CCY_CD"));
		customerProfile.setDowsun(rs.getString("MNF_FER_SUN_IR"));
		customerProfile.setDowmon(rs.getString("MNF_FER_MON_IR"));
		customerProfile.setDowtue(rs.getString("MNF_FER_TUE_IR"));
		customerProfile.setDowwed(rs.getString("MNF_FER_WED_IR"));
		customerProfile.setDowthu(rs.getString("MNF_FER_THU_IR"));
		customerProfile.setDowfri(rs.getString("MNF_FER_FRI_IR"));
		customerProfile.setDowsat(rs.getString("MNF_FER_SAT_IR"));
		customerProfileMap.put(custProfileKey, customerProfile);
	}

	private void addCustomerAct(CustomerProfileResponse customerProfileResponse, ResultSet rs) throws SQLException {
		CustomerAct custAct = new CustomerAct();
		custAct.setSmtcusrole(rs.getString("SMT_CUS_RL_CD"));
		custAct.setReqact(rs.getString("AC_NR"));
		custAct.setActcusid(rs.getString("CUS_ID_NR"));
		custAct.setActgrpid(rs.getString("GRP_NR"));
		customerProfileResponse.getCustomerAct().add(custAct);
	}

	private CallableStatement initStoredProc(Connection conn, CustomerProfileRequest customerprofileRequest)
			throws SQLException {
		CallableStatement proc = null;
		proc = conn.prepareCall("{ call D253AA.N253CUST(?,?) }");
		proc.setString(1, customerprofileRequest.getAct());
		proc.registerOutParameter(2, Types.CHAR);
		return proc;
	}
	

	private Connection initConnection() {
		Connection conn = null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Please include Classpath  Where your DB2 Driver is located");
			e.printStackTrace();
		}
		System.out.println("DB2 driver is loaded successfully");

		try {
			conn = DriverManager.getConnection("jdbc:db2://153.2.18.133:6026/DS51", "T253RMT1", "T2532018");
			if (conn != null) {
				System.out.println("DB2 Database Connected");
			} else {
				System.out.println("Db2 connection Failed ");
			}
		} catch (Exception e) {
			System.out.println("DB2 Database connection Failed");
			e.printStackTrace();
		}
		return conn;
	}

	private String getCustomerProfileKey(ResultSet rs) throws SQLException {
		return rs.getString("CUS_ID_NR") + "___" + rs.getString("GRP_NR");
	}

}
