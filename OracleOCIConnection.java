import java.sql.*;
public class OracleOCIConnection
{
	public static void main(String args[])
	{
		try
		{
			//load oracle driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connect using NativeApI(OCI)driver
			Connection con= DriverManager.getConnection("jdbc:oracle:oci8:@","pritam","pritam");
			System.out.println("connected Sucessfully to oracle using OCI driver");
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}