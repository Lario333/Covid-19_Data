/*
 *********************************
 *       2021(c) Project by      *
 *                               * 
 *           Davide I.           *
 *           Alessio Z.          *
 *********************************
 */
package Source;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Linear chart of the tampons
 */
public class DataLinearChartT extends JPanel {

    /**
     * Construct a new LinearChart
     */
    public DataLinearChartT() {
    }

    // creation of data Chart
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String title = "Tamponi";

        for (int i = 0; i < Main.daysData.size(); i++) {
            dataset.addValue(Integer.parseInt(Main.daysData.get(i).getTamponi()), title, Main.daysData.get(i).getData());
        }

        return dataset;
    }

    // creation of the object chart
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart lineChart = ChartFactory.createLineChart(
                null,
                "Tempo", "Dati",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);
        lineChart.setBackgroundPaint(new Color(247, 246, 242));

        CategoryPlot plot = lineChart.getCategoryPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer(true, false);
        // change of color lines
        renderer.setSeriesPaint(0, new Color(247, 128, 128));
        // change of line thickness
        renderer.setSeriesStroke(0, new BasicStroke(1.5f));

        plot.setRenderer(renderer);

        return lineChart;
    }

    /**
     * Returns a new chartPanel containing the linearChart of tampons
     *
     * @return a new chartPanel containing the linearChart of tampons
     */
    public JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel pan = new ChartPanel(chart);
        pan.setPreferredSize(new Dimension(500, 300));

        return pan;
    }
}
