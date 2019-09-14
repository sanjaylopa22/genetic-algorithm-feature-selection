package weka.associations;
import weka.core.Instances;
import weka.associations.Apriori;
import java.io.BufferedReader;
import java.io.FileReader; 

public class apriori2 
{

	 public apriori2(String filename) throws Exception 
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
		
		
	

		// Calculating Confidence 
		String  confidenceLine = strArr[5];
		System.out.println(confidenceLine);
		String  []confV = confidenceLine.split(":");
		String con = confV[1];
		System.out.println(con);
		
		
		// Calculating Scans
		String scanLine = strArr[10];
		System.out.println(scanLine);
		String []scanV = scanLine.split(":");
		String scn = scanV[1];
		
		double scans1 = Double.parseDouble(scn);
		System.out.println(scans1);
		String  confidence = strArr[16];
		System.out.println(confidence);
		String  []conV1 = confidence.split("==>");
		String con1 = conV1[1];
		System.out.println(con1);
		double confidenc = Double.parseDouble(con1);
		System.out.println(confidenc);
		
//		 Calculating descendent 
	    String ar= strArr[18];
		String[] rV = ar.split("==>");
		String rV1 = rV[1];
		//System.out.println(sup);
		//sup = sup.split("\\(")[0];
	
		for (String t :rV)
			  System.out.println(t);
		

	}
	public static void main(String[] args) throws Exception 
	  {
	    
		 
		  long start;
		  long end;
		  start=System.currentTimeMillis();
		  
		  new apriori2("C:\\Program Files\\Weka-3.6\\data\\weather.nominal.arff");
		 // new apriori1("G:\\M TECH\\MTech3rd sem\\neeraj project\\DATA SET1\\xorg.arff");
		  
		  end=System.currentTimeMillis();
		  long Timerequired=(end - start);
		  
		  System.out.println("---The needed time for the apriori on test.arff file: "+Timerequired+" ms");
	  }
}

