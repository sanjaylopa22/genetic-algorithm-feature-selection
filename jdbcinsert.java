package weka.clusterers;

import java.sql.*;
public class jdbcinsert 

{	
	public static void main(String[] args) {
	
   String str,s1;
   System.out.println("this is jdbc insertion");
   try
   {
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   Connection con=DriverManager.getConnection("jdbc:odbc:data2","","");
	   PreparedStatement ps=con.prepareStatement("insert into sample values(4,'Surya','ETC',65,25)");
	  
	   int i= ps.executeUpdate();
	   System.out.println(i);
	  
	   con.close();
	   }
  
   catch(Exception e)
   {}
   System.out.println("Insertion complete");
	}
}

