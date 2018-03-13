package com.java.template;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.model.PAREligRequest;
import com.java.model.PAREligResponse;

public class PAREligJDBCTemplate {

	private static final Logger log = LoggerFactory.getLogger(PAREligJDBCTemplate.class);
	public String store = "D253AA.N253PARE";
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public PAREligResponse getPARElig(PAREligRequest pareligRequest) throws NullPointerException, SQLException {
		PAREligResponse pareligResponse = new PAREligResponse();
		Connection conn = null;
		CallableStatement proc = null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Please include Classpath  Where your DB2 Driver is located");
			e.printStackTrace();
		}
		System.out.println("DB2 driver is loaded successfully");

		try {
			conn = DriverManager.getConnection("jdbc:db2://db2connectdvlp.us.ups.com:50000/DS51", "ext2yjn", "dinesh1");
			if (conn != null) {
				System.out.println("DB2 Database Connected");
			} else {
				System.out.println("Db2 connection Failed ");
			}
			proc = conn
					.prepareCall("{ call D253AA.N253PARE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			proc.setString(1, pareligRequest.getDatasrc());
			proc.setString(2, pareligRequest.getShipperact());
			proc.setString(3, pareligRequest.getThirdpartyact());
			proc.setString(4, pareligRequest.getFreightact());
			proc.setString(5, pareligRequest.getConsbilact());
			proc.setString(6, pareligRequest.getPudate());
			proc.setString(7, pareligRequest.getSmtref1());
			proc.setString(8, pareligRequest.getSmtref2());
			proc.setString(9, pareligRequest.getSdclval());
			proc.setString(10, pareligRequest.getSdclccy());
			proc.setString(11, pareligRequest.getSvctyp());
			proc.setString(12, pareligRequest.getSmtchrgetyp());
			proc.setString(13, pareligRequest.getSmtaccessrl());
			proc.setString(14, pareligRequest.getTrknum());
			proc.setString(15, pareligRequest.getPdclval());
			proc.setString(16, pareligRequest.getPdclccy());
			proc.setString(17, pareligRequest.getHazmat());
			proc.setString(18, pareligRequest.getPkgref1());
			proc.setString(19, pareligRequest.getPkgref2());
			proc.setString(20, pareligRequest.getPkgref3());
			proc.setString(21, pareligRequest.getPkgref4());
			proc.setString(22, pareligRequest.getPkgref5());
			proc.setString(23, pareligRequest.getPkgaccessrl());

			proc.registerOutParameter(24, Types.CHAR);
			proc.registerOutParameter(25, Types.CHAR);
			proc.registerOutParameter(26, Types.CHAR);
			proc.registerOutParameter(27, Types.CHAR);
			proc.registerOutParameter(28, Types.CHAR);

			proc.execute();
			pareligResponse.setStatuscd(proc.getString(24));
			pareligResponse.setReqtrknum(proc.getString(25));
			pareligResponse.setParind(proc.getString(26));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return pareligResponse;
	}

}
