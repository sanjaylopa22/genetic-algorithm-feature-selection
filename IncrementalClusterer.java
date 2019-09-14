package weka.clusterers;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.clusterers.Cobweb;
import java.io.File;


/**
 * This example trains Cobweb incrementally on data obtained
 
* from the ArffLoader.
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 
*/



public class IncrementalClusterer 
{

  

/**
   * Expects an ARFF file as first argument.
   *
   * @param args        
the commandline arguments
   * @throws Exception  if something goes wrong
   */
 

 public static void main(String[] args) throws Exception
 {
    // load data
	long start;
	long end;
	start=System.currentTimeMillis();
	  
 ArffLoader loader = new ArffLoader();
   
 loader.setFile(new File("C:\\test.arff"));
    
 Instances structure = loader.getStructure();

    // train Cobweb
   
 Cobweb cw = new Cobweb();
    
 cw.buildClusterer(structure);
    
 Instance current;
    
 while ((current = loader.getNextInstance(structure)) != null)
      
 cw.updateClusterer(current);
    
 cw.updateFinished();

    // output generated model
   
 System.out.println(cw);
 end=System.currentTimeMillis();
 long Timerequired=(end - start);
 
 System.out.println("---The needed time for the cobweb on test.arff file: "+Timerequired+" ms");
  
  }

}
