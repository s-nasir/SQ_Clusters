import smile.clustering.HierarchicalClustering;
import smile.clustering.linkage.CompleteLinkage;

public class Hierarchical {
    private int clusters;

    public Hierarchical(int clusters) {
        this.clusters = clusters;
    }

    public int[] clusterData(double[][] data, int i) {
        CompleteLinkage linkage = CompleteLinkage.of(data);
        HierarchicalClustering hc = HierarchicalClustering.fit(linkage);
        return hc.partition(clusters);
    }
}