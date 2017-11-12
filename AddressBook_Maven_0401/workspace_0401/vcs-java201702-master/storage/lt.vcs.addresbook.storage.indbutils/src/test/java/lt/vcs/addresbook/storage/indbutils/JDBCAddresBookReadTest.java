package lt.vcs.addresbook.storage.indbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

public class JDBCAddresBookReadTest {

	@Test
	public void test() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/address_book";
		String driver = "com.mysql.jdbc.Driver";
		String usr = "root";
		String pwd = "sysop";
		JdbcAddresEntry addres = null;
		try {
			// Loading the Driver using DbUtils static method
			DbUtils.loadDriver(driver);
			conn = DriverManager.getConnection(url, usr, pwd);
			QueryRunner query = new QueryRunner();
			addres = (JdbcAddresEntry) query.query(conn, "select * from contacts where id=3",
					new BeanHandler(JdbcAddresEntry.class));

			System.out.println("User Object::  " + addres.getId() + "\t" + addres.getName() + "\t" + addres.getEmail()
					+ "\t" + addres.getMobilePhone());

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			// Closing the connection quietly, means it will handles the
			// SQLException
			DbUtils.closeQuietly(conn);
		}
	}

}
