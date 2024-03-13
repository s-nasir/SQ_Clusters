import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class ClusterVisualization extends ApplicationFrame {

    public ClusterVisualization(String title, double[][] data, int[] labels) {
        super(title);
        final JFreeChart chart = createChart(data, labels);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        setContentPane(chartPanel);
    }

    private JFreeChart createChart(double[][] data, int[] labels) {
        final XYSeriesCollection dataset = new XYSeriesCollection();
        Color[] colors = new Color[]{Color.RED, Color.BLUE, Color.GREEN};
        
        // Assuming the maximum label value indicates the number of clusters
        int numClusters = 0;
        for (int label : labels) {
            if (label > numClusters) {
                numClusters = label;
            }
        }

        // Initialize series for each cluster
        XYSeries[] seriesArray = new XYSeries[numClusters + 1];
        for (int i = 0; i <= numClusters; i++) {
            seriesArray[i] = new XYSeries("Cluster " + i);
        }

        // Populate series data
        for (int i = 0; i < data.length; i++) {
            int clusterIndex = labels[i];
            seriesArray[clusterIndex].add(data[i][0], data[i][1]);
        }

        // Add all series to dataset
        for (XYSeries series : seriesArray) {
            dataset.addSeries(series);
        }

        JFreeChart chart = ChartFactory.createScatterPlot(
                "Cluster Visualization",
                "X Dimension",
                "Y Dimension",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        XYPlot plot = chart.getXYPlot();
        for (int i = 0; i <= numClusters; i++) {
            plot.getRenderer().setSeriesPaint(i, colors[i % colors.length]);
        }

        return chart;
    }

    public static void show(double[][] data, int[] labels) {
        ClusterVisualization demo = new ClusterVisualization("Clustering Visualization", data, labels);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
