package weka.associations;
import weka.core.Instances;
import weka.associations.Apriori;
import java.io.BufferedReader;
import java.io.FileReader; 

public class apriori3 
{
	 public apriori3(String filename) throws Exception 
	   {
		Apriori apr = new Apriori();
		Instances data;
		String[] options;

		data = new Instances(new BufferedReader(new FileReader(filename)));
		options = new String[2];
		options[0] = "-t";
		options[1] = filename;
		apr.buildAssociations(data);
		System.out.println(apr.toString());
		String aprioriResult = apr.toString();
		String []strArr = aprioriResult.split("\n");
		
        //1 Calculating Support 
		String supportLine = strArr[4];
		String []suppV = supportLine.split(":");
		String sup = suppV[1];
		sup = sup.split("\\(")[0];
		double support = Double.parseDouble(sup);
		System.out.println(support);
		

		//2 Calculating Confidence 
 	    String  confidenceLine = strArr[5];
		//System.out.println(confidenceLine);
		String  []confV = confidenceLine.split(":");
		String con = confV[1];
		System.out.println(con);
		
         // 3 Calculating Scans
		String scanLine = strArr[6];
		String []scanV = scanLine.split(":");
		String scn = scanV[1];
		System.out.println(scn);
		
       // 4Calculating  Association rule
	    String supportLine1 = strArr[18];
		String[] suppVl = supportLine1.split("==>");
		//System.out.println(suppVl);
		String supp = suppVl[1];
		 for (String t :suppVl)
		System.out.println(t);
		/* String s = supp;
		 String[] tokens = s.split("/");
		 for (String t : tokens)
		   System.out.println(t);*/


	}
	public static void main(String[] args) throws Exception 
	  {
		  long start;
		  long end;
		  start=System.currentTimeMillis();
		  new apriori3("C:\\Program Files\\Weka-3.6\\data\\soybean.arff");
		  end=System.currentTimeMillis();
		  long Timerequired=(end - start);
		  System.out.println("---The needed time for the apriori on test file .arff file: "+Timerequired+" ms");
	  }
}


