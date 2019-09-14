package weka.clusterers;

import java.sql.*;
public class jdbcselect 

{	
	public static void main(String[] args) {
	
   String str,s1;
   System.out.println("this is jdbc selection");
   try
   {
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   Connection con=DriverManager.getConnection("jdbc:odbc:data1","","");
	   //PreparedStatement ps=con.prepareStatement("insert into sample values(4,'Surya','ETC',65,25)");
	   PreparedStatement ps=con.prepareStatement("select *from sample");
	   ResultSet rs=ps.executeQuery();
	   while(rs.next())
	   {
		   int s=rs.getInt(1);
		   System.out.println("The Rollno is"+s);
		  
		   str=rs.getString(2);
		   System.out.println("The Name is"+str);
		   
		   s1=rs.getString(3);
		   System.out.println("The Branch is"+s1);
		   
		   int a=rs.getInt(4);
		   System.out.println("The Marks is"+a);
		   
		   int b=rs.getInt(5);
		   System.out.println("The Age is"+b);
	   
	   //int i= ps.executeUpdate();
	   //System.out.println(+i);
	  
	   
	   }
	   con.close();
   }
   catch(Exception e)
   {}
   System.out.println("Insertion complete");
	}
}

