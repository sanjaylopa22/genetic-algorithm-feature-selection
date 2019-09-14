
package weka.clusterers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import weka.core.DistanceFunction;
//import weka.core.Instances;

public class Mysqlconnect1 
{
	public static void main(String[] args) 
	{
		Connection conn = null;

		try 
		{
			String userName = "root";
			String password = "root";
			Statement stmt = null;
			ResultSet rst = null;
			String url = "jdbc:mysql://localhost/sanjay";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			stmt = conn.createStatement();
			wekaexam2 we=new wekaexam2("C:\\original air pollution data.arff");
			int temp=we.numberOfClusters();
			double Clit=we.getIterations();
			double sq=we.squareerror();
			//Instances mean1=we.clustermean();
			String insertQuery = "insert into sandb(clusternum,distancefunc,clusteriteration,squareError) values("+temp+",'EuclideanDistance',"+Clit+","+sq+")";
			System.out.println("insertion complete");
			rst = stmt.executeQuery("select * from sandb");
			
			System.out.println("Database connection established");

			while (rst.next()) 
			{
				System.out.print(rst.getInt(2));
				System.out.println(rst.getString(3));
				System.out.println(rst.getDouble(4));
				System.out.println(rst.getDouble(5));
				//System.out.println(rst.getInstances(6));
				System.out.print("\n");

			}
			stmt.execute(insertQuery);
			
			}
		catch (Exception e) 
		{
			System.err.println("Cannot connect to database server" + e);
		}
	}
}
