package weka.clusterers;
import weka.core.Instances;
import weka.core.neighboursearch.kdtrees.KMeansInpiredMethod;
import weka.clusterers.DBScan;
import weka.clusterers.DensityBasedClusterer;
import weka.clusterers.EM;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.clusterers.forOPTICSAndDBScan.Databases.Database;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * An example class that shows the use of Weka clusterers from Java.
 * @author  FracPete
 */

public class ClusteringDemo 
{
  public ClusteringDemo(String filename) throws Exception 
  {
    ClusterEvaluation eval;
    Instances               data;
    String[]                options;
    DensityBasedClusterer   cl;    
    SimpleKMeans km;
    data = new Instances(new BufferedReader(new FileReader(filename)));
    
    // normal
   System.out.println("\n--> normal");
    options    = new String[2];
    options[0] = "-t";
    options[1] = filename;
    //System.out.println(ClusterEvaluation.evaluateClusterer(new EM(), options));
    
    // manual call
    /*System.out.println("\n--> manual");
    cl   = new EM();
    cl.buildClusterer(data);
    eval = new ClusterEvaluation();
    eval.setClusterer(cl);
    eval.evaluateClusterer(new Instances(data));
    System.out.println("# of clusters: " + eval.getNumClusters());*/

    // density based
    /*System.out.println("\n--> density (CV)");
    cl   = new EM();
    eval = new ClusterEvaluation();
    eval.setClusterer(cl);
    eval.crossValidateModel(cl, data, 10, data.getRandomNumberGenerator(1));
    System.out.println("# of clusters: " + eval.getNumClusters());*/
    
    SimpleKMeans kMeans = new SimpleKMeans();
    kMeans.setNumClusters(5);
    //String dist = "weka.clusterers.forOPTICSAndDBScan.DataObjects.ManhattanDataObject";
    System.out.println(ClusterEvaluation.evaluateClusterer(kMeans, options));
    
    /*DBScan scan = new DBScan();
    scan.setEpsilon(0.05);
    scan.setMinPoints(2);
    String dist = "weka.clusterers.forOPTICSAndDBScan.DataObjects.ManhattanDataObject";
    scan.setDatabase_distanceType(dist);
    System.out.println(ClusterEvaluation.evaluateClusterer(scan, options));*/

  }

  /**
   * usage:
   *   ClusteringDemo arff-file
   */
  public static void main(String[] args) throws Exception 
  {
    //new ClusteringDemo("C:\\Program Files\\Weka-3-6\\data\\cpu.arff");
	  new ClusteringDemo("C:\\test.arff");
  }
}

