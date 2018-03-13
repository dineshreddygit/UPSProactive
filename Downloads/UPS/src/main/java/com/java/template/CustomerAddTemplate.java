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

import com.java.model.ValidAccountDetails;
import com.java.model.AccountDetailsRequest;
import com.java.model.AccountDetailsResponse;
import com.java.model.CustomerAddRequest;
import com.java.model.CustomerAddResponse;

public class CustomerAddTemplate {

	private static final Logger log = LoggerFactory.getLogger(CustomerAddTemplate.class);

	public CustomerAddResponse customerAdd(CustomerAddRequest customerAddRequest) {
		CustomerAddResponse customerAddResponse = new CustomerAddResponse();
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
			proc = conn.prepareCall("{ call D253AA.N253ACCV (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			proc.setString(1, "");
			proc.setString(2, customerAddRequest.getCustomerId());
			proc.setString(3, customerAddRequest.getGroupName());
			proc.setString(4, customerAddRequest.getRoles());
			proc.setString(5, customerAddRequest.getParType());
			proc.setString(6, customerAddRequest.getCountryCode());
			proc.setString(7, customerAddRequest.getStatusType());
			proc.setString(8, customerAddRequest.getHazmat());
			proc.setString(9, customerAddRequest.getDclValue());
			proc.setString(10, customerAddRequest.getDclAmt());
			proc.setString(11, customerAddRequest.getPckgeMvntTyp());
			proc.setString(12, customerAddRequest.getStartDate());
			proc.setString(13, customerAddRequest.getEndDate());
			proc.setString(14, customerAddRequest.getMnfSunday());
			proc.setString(15, customerAddRequest.getMnfMonday());
			proc.setString(16, customerAddRequest.getMnfTuesday());
			proc.setString(17, customerAddRequest.getMnfWednesday());
			proc.setString(18, customerAddRequest.getMnfThursday());
			proc.setString(19, customerAddRequest.getMnfFriday());
			proc.setString(20, customerAddRequest.getMnfSaturday());
			proc.setString(21, customerAddRequest.getGrpWrkCatageory());
			proc.setString(22, customerAddRequest.getGrpType());
			proc.setString(23, customerAddRequest.getServiceTypeList());
			proc.setString(24, customerAddRequest.getAccessorialList());
			proc.setString(25, customerAddRequest.getShipmentChargeType());
			proc.setString(26, customerAddRequest.getExceptions());
			proc.setString(27, customerAddRequest.getPckgeRefNum());
			proc.setString(28, customerAddRequest.getMnrcnd());
			proc.setString(29, customerAddRequest.getOverRideTimes());
			proc.setString(30, customerAddRequest.getUserId());
			proc.setString(31, customerAddRequest.getUserName());
			proc.registerOutParameter(32, Types.CHAR);
			proc.registerOutParameter(33, Types.VARCHAR);
			proc.registerOutParameter(34, Types.CHAR);
			boolean results = proc.execute();
			customerAddResponse.setErrorCode(proc.getString(32));
			customerAddResponse.setErrorText(proc.getString(33));
			customerAddResponse.setSqlCode(proc.getString(34));
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

		return customerAddResponse;
	}
}
