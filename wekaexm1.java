package weka.clusterers;
import weka.core.converters.ArffLoader;
import weka.core.Instance;
import weka.core.Instances;
import java.io.File;
import weka.clusterers.Cobweb;


public class wekaexm1 
{
  public static void main(String[] args)  
  {
    // load data
	  try {
		
		   
	  long start;
	  long end;
	  start=System.currentTimeMillis();
	  String[]  options;
		  
	  options    = new String[2];
	  options[0] = "-t";
	  options[1] = "C:\\incremental air pollution data.arff";
	  ArffLoader loader1 = new ArffLoader();
	  loader1.setFile(new File("C:\\incremental air pollution data.arff"));
	  Instances data = loader1.getStructure();
	  
	  SimpleKMeans kMeans = new SimpleKMeans();
	  kMeans.setNumClusters(5);
	  System.out.println(ClusterEvaluation.evaluateClusterer(kMeans,options));
	  
	  Cobweb cw = new Cobweb();
	  cw.buildClusterer(data);
      Instance current;
      while((current = loader1.getNextInstance(data))!= null)
      cw.updateClusterer(current);
      cw.updateFinished();
      
      
    // generate data for clusterer (w/o class)
    /*Remove filter = new Remove();
    filter.setAttributeIndices("" + (data.classIndex() + 1));
    //filter.setInputFormat(data);
    Instances dataClusterer = Filter.useFilter(data, filter);
	 
     // train clusterer
   // EM clusterer = new EM();
    //HierarchicalClusterer clusterer = new HierarchicalClusterer();
	 
    // set further options for EM, if necessary...
    //clusterer.buildClusterer(dataClusterer);
	  kMeans.buildClusterer(data);
    //evaluate clusterer
    ClusterEvaluation eval = new ClusterEvaluation();
    eval.setClusterer(kMeans);
    eval.evaluateClusterer(data);

    // print results
    System.out.println(eval.getNumClusters());*/
	  
	  
	  
      end =System.currentTimeMillis();
	
      long Timerequired=(end-start);
	
	  System.out.println("---The needed  time for the incremental K-means on incremental air pollution data.arff file: "+Timerequired+" ms");
	  
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();  
	  }
	}
  
  
  
}
