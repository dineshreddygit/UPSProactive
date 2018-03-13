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
import com.java.model.CustomerProfile;
import com.java.model.InvalidAccountDetails;
import com.java.model.ResultSetOut;

public class AccountDetailsTemplate {

	private static final Logger log = LoggerFactory.getLogger(AccountDetailsTemplate.class);

	public AccountDetailsResponse getAccountDetails(AccountDetailsRequest accountDetailsRequest) {
		AccountDetailsResponse accountDetailsResponse = new AccountDetailsResponse();
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
			proc = conn.prepareCall("{ call D253AA.N253ACCV (?,?,?,?,?,?) }");
			proc.setString(1, "");
			proc.setString(2, accountDetailsRequest.getAccountsList());
			proc.setString(3, accountDetailsRequest.getCountryCode());
			proc.registerOutParameter(4, Types.CHAR);
			proc.registerOutParameter(5, Types.VARCHAR);
			proc.registerOutParameter(6, Types.CHAR);
			boolean results = proc.execute();
			int rsCount = 0;
			accountDetailsResponse.setErrorCode(proc.getString(4));
			accountDetailsResponse.setErrorText(proc.getString(5));
			accountDetailsResponse.setSqlCode(proc.getString(6));
			List<ValidAccountDetails> validaccountDetailsList = new ArrayList<ValidAccountDetails>();
			List<InvalidAccountDetails> invalidaccountDetailsList = new ArrayList<InvalidAccountDetails>();
			ValidAccountDetails validaccountDetails = null;
			InvalidAccountDetails invalidaccountDetails = null;
			do {
				if (results) {
					rs = proc.getResultSet();
					while (rs.next()) {
						rsCount++;
						if (rsCount == 1) {
							validaccountDetails = new ValidAccountDetails();
							validaccountDetails.setAccountNumber(rs.getString("N253ACCV_ACCT_NR"));
							validaccountDetails.setRoleCode(rs.getString("N253ACCV_ROLE_CD"));
							validaccountDetails.setAccountValidation(rs.getString("N253ACCV_ACCT_VAL"));
							validaccountDetails.setParType(rs.getString("N253ACCV_ACCT_PAR"));
							validaccountDetailsList.add(validaccountDetails);
						} else if (rsCount == 2) {
							invalidaccountDetails = new InvalidAccountDetails();
							invalidaccountDetails.setAccountNumber(rs.getString("N253ACCV_ACCT_NR"));
							invalidaccountDetails.setRoleCode(rs.getString("N253ACCV_ROLE_CD"));
							invalidaccountDetails.setAccountValidation(rs.getString("N253ACCV_ACCT_VAL"));
							invalidaccountDetails.setParType(rs.getString("N253ACCV_ACCT_PAR"));
							invalidaccountDetailsList.add(invalidaccountDetails);
						}
					}
					rs.close();

				}
				results = proc.getMoreResults();
			} while (results);
			for (ValidAccountDetails temp : validaccountDetailsList) {
				accountDetailsResponse.getValidaccountDetails().add(temp);
			}
			for (InvalidAccountDetails temp : invalidaccountDetailsList) {
				accountDetailsResponse.getInvalidaccountDetails().add(temp);
			}
			proc.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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

		return accountDetailsResponse;
	}
}
