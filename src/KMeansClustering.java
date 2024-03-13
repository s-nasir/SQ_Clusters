import smile.clustering.KMeans;
import smile.data.DataFrame;

public class KMeansClustering {
    public int[] clusterData(double[][] data, int clusters) {
        KMeans kmeans = KMeans.fit(data, clusters);
        return kmeans.y;
    }
}
