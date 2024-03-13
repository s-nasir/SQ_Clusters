import smile.clustering.DBSCAN;

public class Dbscan{
    public int[] clusterData(double[][] data, double radius, int minPts) {
        DBSCAN<double[]> dbscan = DBSCAN.fit(data, minPts, radius);
        return dbscan.y;
    }
}
