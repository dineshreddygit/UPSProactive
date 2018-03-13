package com.java.template;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.model.CustomersProfileResponse;
import com.java.model.ResultSetOut;

public class CustomersProfileTemplate {

	private static final Logger log = LoggerFactory.getLogger(CustomersProfileTemplate.class);

	public CustomersProfileResponse getCustomerDetails() {
		CustomersProfileResponse customersProfileResponse = new CustomersProfileResponse();
		Connection conn = null;
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Please include Classpath  Where your DB2 Driver is located");
		}
		System.out.println("DB2 driver is loaded successfully");

		try {
			conn = DriverManager.getConnection("jdbc:db2://db2connectdvlp.us.ups.com:50000/DS51", "ext2yjn", "dinesh1");
			if (conn != null) {
				System.out.println("DB2 Database Connected");
			} else {
				System.out.println("Db2 connection Failed ");
			}
			proc = conn.prepareCall("{ call D253AA.N253CUSP(?,?,?,?) }");
			proc.setString(1, "");
			proc.registerOutParameter(2, Types.CHAR);
			proc.registerOutParameter(3, Types.VARCHAR);
			proc.registerOutParameter(4, Types.CHAR);
			boolean results = proc.execute();
			customersProfileResponse.setErrorCode(proc.getString(2));
			customersProfileResponse.setErrorText(proc.getString(3));
			customersProfileResponse.setSqlCode(proc.getString(4));

			List<ResultSetOut> resultsetoutList = new ArrayList<ResultSetOut>();
			ResultSetOut resultsetout = null;
			if (results) {
				rs = proc.getResultSet();
				while (rs.next()) {
					resultsetout = new ResultSetOut();
					resultsetout.setCustomerId(rs.getString("GTT_CUS_ID_NR"));
					resultsetout.setCustomerName(rs.getString("GTT_CUS_NA"));
					resultsetout.setEndDate(rs.getString("GTT_REC_EFF_END_DT"));
					resultsetout.setGroupId(rs.getString("GTT_GRP_NR"));
					resultsetout.setGroupName(rs.getString("GTT_GRP_NA"));
					resultsetout.setParType(rs.getString("GTT_PJR_ENT_MTH_CD"));
					resultsetout.setProfileStatus(rs.getString("GTT_CUS_STS_TYP_CD"));
					resultsetout.setStartDate(rs.getString("GTT_REC_EFF_STT_DT"));
					resultsetoutList.add(resultsetout);
				}

			}
			for (ResultSetOut temp : resultsetoutList) {
				customersProfileResponse.getResultSetOut().add(temp);
			}

		} catch (SQLException e) {
			System.out.println("SQLEX");
		} catch (NullPointerException e) {
			System.out.println("NUll ex");
		} finally {

			try {
				rs.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("Exception");
			}

		}

		return customersProfileResponse;
	}

}
