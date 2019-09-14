
package weka.clusterers;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import weka.core.DistanceFunction;


public class wekaexam2
{
	double support1;
	double support2;
	double clusteriteration;
    double squareError;
    //double centroid;
    int numcluster;
    //Instances clustmean;
  public wekaexam2(String filename)throws Exception 
  {
	 
    
    String[] options;
     
    Instances data = new Instances(new BufferedReader(new FileReader(filename)));
    
    System.out.println("\n--> K-means clutering");
    options    = new String[2];
    options[0] = "-t";
    options[1] = filename;
   

   SimpleKMeans kMeans = new SimpleKMeans();
   kMeans.setNumClusters(5);
   System.out.println(ClusterEvaluation.evaluateClusterer(kMeans,options));
   
   
// calculate number of iteration
   kMeans.buildClusterer(data);
   String kmeansresult=kMeans.toString();
   String []strArr=kmeansresult.split("\n");
  
   String supportLine=strArr[4];
   String []suppV = supportLine.split(":");
	String sup = suppV[1];
	sup = sup.split("\\(")[0];
	support1 = Double.parseDouble(sup);
	System.out.println(support1);
	
//	calculate sum of squared error
	  kMeans.buildClusterer(data);
	  String kmeansresult1=kMeans.toString();
	  String []strArr1=kmeansresult1.split("\n");
	  String supportLine1=strArr1[5];
	  String []suppV1 = supportLine1.split(":");
      String sup1 = suppV1[1];
	  sup1 = sup1.split("\\(")[0];
	  support2 = Double.parseDouble(sup1);
	  System.out.println(support2);
	   
  
//	 calculate number of clusters
	   ClusterEvaluation eval = new ClusterEvaluation();
	   eval.setClusterer(kMeans);
	   eval.evaluateClusterer(new Instances(data));
	   int numcluster= eval.getNumClusters();
	   System.out.println("# of cluster:"+numcluster);
	   
	
	//caculate cluster revision string
	String clusterrev=eval.getRevision();
	System.out.println("cluster revision string is:"+clusterrev);	
	
  /*calculate sum of squared error
  double squareError=kMeans.getSquaredError(); 
  System.out.println("sum of squared error:"+squareError);*/
  
  //calculate maximum cluster iteration
  int clustiteration=kMeans.getMaxIterations();
  System.out.println("maximum cluster iteration:"+clustiteration);
  
  System.out.println("\nDistance function is EuclideanDistance");
  String df=kMeans.distanceFunctionTipText();
  System.out.println(df); 
     
  //DistanceFunction df=kMeans.getDistanceFunction();
  //System.out.println("distance function is:"+df);
 /* Instances clustmean=kMeans.getClusterCentroids();
  System.out.println(clustmean);*/
  }
 
 
  public static void main(String[] args) 
  {
	  try{
    
	  long start;
	  long end;
	  start=System.currentTimeMillis();
	  
	  new wekaexam2("C:\\original air pollution data.arff");
	  
	  end=System.currentTimeMillis();
	  long Timerequired=(end - start);
	  
	  System.out.println("---The needed time for the actual k-means on original air pollution data.arff file: "+Timerequired+" ms");
	  }
	 
	  catch(Exception e)
	  {
	  System.out.println(e);
	  }
  }
  
  public int numberOfClusters()throws Exception
  {
	   Instances data = new Instances(new BufferedReader(new FileReader("C:\\original air pollution data.arff")));
	   SimpleKMeans kMeans = new SimpleKMeans();
	   kMeans.setNumClusters(5);
	   ClusterEvaluation eval = new ClusterEvaluation();
	   eval.setClusterer(kMeans);
	   eval.evaluateClusterer(new Instances(data));
	   int numcluster= eval.getNumClusters(); 
	   return numcluster;  
  }
  
     public double getIterations()
	 {
	  return support1;
	 }
  
  public double squareerror()
  {
	  return support2;
  }
 public double MaxIterations()
  {
	 
	  return clusteriteration;
  }
  
  /*public Instances clustermean()
  {
	  return clustmean;
  }*/
  
  
}

  
	  
 
  

