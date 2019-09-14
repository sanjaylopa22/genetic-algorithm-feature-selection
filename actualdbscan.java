package weka.clusterers;
import weka.core.Instances;
//import weka.core.neighboursearch.kdtrees.KMeansInpiredMethod;
//import weka.clusterers.DBScan;
import weka.clusterers.DensityBasedClusterer;
import weka.clusterers.EM;
import weka.clusterers.ClusterEvaluation;
import java.io.BufferedReader;
import java.io.FileReader;

public class actualdbscan
{
	 
  public actualdbscan(String filename)throws Exception 
  {
	  
    Instances data;
    String[] options;
    DensityBasedClusterer cl;  
    ClusterEvaluation eval; 
    
    
    data = new Instances(new BufferedReader(new FileReader(filename)));
    
    System.out.println("\n--> Density based clutering");
    options    = new String[2];
    options[0] = "-t";
    options[1] = filename;
    
    System.out.println(ClusterEvaluation.evaluateClusterer(new EM(), options));
    
    eval = new ClusterEvaluation();
    System.out.println("\n--> manual");
    cl   = new EM();
    cl.buildClusterer(data);
    eval = new ClusterEvaluation();
    eval.setClusterer(cl);
    eval.evaluateClusterer(new Instances(data));
    System.out.println("# of clusters: " + eval.getNumClusters());

  }
 
  public static void main(String[] args) 
  {
	  try{
		  
	  long start;
	  long end;
	  start=System.currentTimeMillis();
	  
	  new actualdbscan("C:\\original air pollution data.arff");
	  
	  end=System.currentTimeMillis();
	  long Timerequired=(end - start);
	  
	  System.out.println("---The needed time for the actual DBSCAN on original air pollution data.arff file: "+Timerequired+" ms");
	  }
	 
	  catch(Exception e)
	  {
	  System.out.println(e);
	  }
  }
  
}
