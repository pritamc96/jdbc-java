import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.*;
public class Login extends Frame
{
	Label l1,l2;
	TextField  tf1,tf2;
	Button b1,b2;
	public Login()
	{
			l1= new Label("Username");
			l2= new Label("Password");
			tf1 = new TextField(30);
			tf2 = new TextField(15);
			b1= new Button("submit");
		    b2= new Button("cancel");
			setLayout(new GridLayout(3,2));
			add(l1);
			add(tf1);
			add(l2);
			add(tf2);
			add(b1);
			add(b2);
			
			b1.addActionListener(new MyButton());
		    b2.addActionListener(new MyButton());
	} 
	class MyButton implements ActionListener{
		public void actionPerformed(ActionEvent ae)
		{ 
			String uname=tf1.getText();
			String pwd=tf2.getText();
			int f=0;
			try
			{
				OracleDataSource ods = new OracleDataSource();
				ods.setURL("jdbc:oracle:thin:pritam/pritam@localhost:1521/xe");
				Connection con=ods.getConnection();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("Select * from login");
				while(rs.next())
				{
					String a=rs.getString(1);
					String b=rs.getString(2);
					
					if(a.equals(uname) && b.equals(pwd))
					{
						System.out.println("Valid User");
						f=1;
						break;
					}
				}
				if(f==0)
					System.out.println("Invalid driver");
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e){}
		}
	}
	public static void main(String args[])
	{
		Login l1 = new Login();
		l1.setSize(500, 500);
     l1.setVisible(true);	}
}
