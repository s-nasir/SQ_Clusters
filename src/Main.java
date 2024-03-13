import smile.io.Read;

public class Main {
    public static void main(String[] args) {
        try {
            double[][] data = Read.csv("./iris.data", CSVFormat.DEFAULT.withDelimiter(','));

            // KMeans Clustering
            KMeansClustering kMeansClustering = new KMeansClustering();
            int[] kMeansLabels = kMeansClustering.clusterData(data, 3);
            System.out.println("KMeans Clustering Labels:");
            for (int label : kMeansLabels) {
                System.out.print(label + " ");
            }
            System.out.println();

            // Hierarchical Clustering
            Hierarchical hierarchicalClustering = new Hierarchical(3);
            int[] hierarchicalLabels = hierarchicalClustering.clusterData(data, 3);
            System.out.println("Hierarchical Clustering Labels:");
            for (int label : hierarchicalLabels) {
                System.out.print(label + " ");
            }
            System.out.println();

            // DBSCAN Clustering
            Dbscan dbscanClustering = new Dbscan();
            int[] dbscanLabels = dbscanClustering.clusterData(data, 0.5, 5);
            System.out.println("DBSCAN Clustering Labels:");
            for (int label : dbscanLabels) {
                System.out.print(label + " ");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
