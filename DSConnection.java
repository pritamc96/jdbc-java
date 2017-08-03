import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.*;
class DSConnection
{
	public static void main(String args[])throws SQLException
	{
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:pritam/pritam@localhost:1521/xe");
		Connection con=ods.getConnection();
		System.out.println("connected");
		con.close();
	}
}