package weka.clusterers;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
//import weka.clusterers.DBScan;
//import weka.clusterers.DensityBasedClusterer;
import weka.clusterers.EM;
import weka.clusterers.ClusterEvaluation;
import java.io.File;


public class incrementaldbscan
{
	 
  public incrementaldbscan(String filename)throws Exception 
  {
	  
    String[] options;
    
    
    //data = new Instances(new BufferedReader(new FileReader(filename)));
    
    System.out.println("\n--> Density based clutering");
    options    = new String[2];
	options[0] = "-t";
	options[1] = "C:\\incremental air pollution data.arff";
	ArffLoader loader1 = new ArffLoader();
	loader1.setFile(new File("C:\\incremental air pollution data.arff"));
    Instances data = loader1.getStructure();
    
    System.out.println(ClusterEvaluation.evaluateClusterer(new EM(), options));
    
    Cobweb cw = new Cobweb();
	cw.buildClusterer(data);
    Instance current;
    while((current = loader1.getNextInstance(data))!= null)
    cw.updateClusterer(current);
    cw.updateFinished();
      
  }
 
 
  public static void main(String[] args) 
  {
	  try{

	  long start;
	  long end;
	  start=System.currentTimeMillis();
	  
	  new incrementaldbscan("C:\\original air pollution data.arff");
	  
	  end=System.currentTimeMillis();
	  long Timerequired=(end - start);
	  
	  System.out.println("---The needed time for the incremental DBSCAN on original air pollution data.arff file: "+Timerequired+" ms");
	  }
	 
	  catch(Exception e)
	  {
	  System.out.println(e);
	  }
  }
  
}
