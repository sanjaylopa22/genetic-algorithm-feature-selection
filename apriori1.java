package weka.associations;
import weka.core.Instances;
import weka.associations.Apriori;
import java.io.BufferedReader;
import java.io.FileReader; 
public class apriori1 
{
     public double support1;
     public double confidence1;
	 public apriori1(String filename) throws Exception 
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
		
//		1 Calculating Support 
		String supportLine = strArr[4];
		String []suppV = supportLine.split(":");
		String sup = suppV[1];
		sup = sup.split("\\(")[0];
	    support1 = Double.parseDouble(sup);
		System.out.println(support1);
		

		//2 Calculating Confidence 
 	    String  confidenceLine = strArr[5];
		//System.out.println(confidenceLine);
		String  []confV = confidenceLine.split(":");
		String con = confV[1];
		confidence1 = Double.parseDouble(con);
		System.out.println(confidence1);
		
		// 3 Calculating Scans
		String scanLine = strArr[6];
		String []scanV = scanLine.split(" ");
		String scn = scanV[1];
		System.out.println(scn);
		
       // 4Calculating  Association rule
		/*String arLine = strArr[18];
		System.out.println("arline"+ arLine);
		String []arnum = arLine.split(".");
		String ar=arnum[1];
		//System.out.println(ar);
		 ar = ar.split("\\.")[0];
		 //int arn1 = 
		System.out.println(ar);*/
		//String[] suppVl = supportLine1.split("==>");
		//System.out.println("n"+suppVl);
		/*String supp = suppVl[0];
		 for (String t :suppVl)
		System.out.println(t);*/

	    /*String arLine[] = strArr[18];
		String[] arVl = arLine.split("==>");
		//System.out.println(suppVl);
		String ar = arVl[1];
		 for (String t :arVl)
		System.out.println(t);
		}*/
		/* String s = supp;
		 String[] tokens = s.split("/");
		 for (String t : tokens)
		   System.out.println(t);*/
		 
		/*for(int i=0;i<10;i++)
		{
	    String arLine[i] = strArr[18+i];
		String[] arVl = arLine[i].split("==>");
		//System.out.println(suppVl);
		String ar = arVl[i];
		 for (String t :arVl)
		System.out.println(t);
		}*/


	}
  public static void main(String[] args) throws Exception
	// public void f1() throws Exception
	  {
		  long start;
		  long end;
		  start=System.currentTimeMillis();
		  new apriori1("C:\\Program Files\\Weka-3.6\\data\\soybean.arff");
		  end=System.currentTimeMillis();
		  long Timerequired=(end - start);
		  System.out.println("---The needed time for the apriori on test file .arff file: "+Timerequired+" ms");
	  }
	public double get_support()
	{
		return support1;
	}
	public double get_con()
	{
		return confidence1;
	}
	}


