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

        String title = Main.useLanguage.getActiveLanguage().getT();

        for (int i = 0; i < Main.daysData.size(); i++) {
            dataset.addValue(Main.daysData.get(i).getNuoviVaccini(), title, Main.daysData.get(i).getData());
        }

        return dataset;
    }

    // creation of the object chart
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart lineChart = ChartFactory.createLineChart(
                null,
                Main.useLanguage.getActiveLanguage().getTem(), Main.useLanguage.getActiveLanguage().getD(),
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);
        lineChart.setBackgroundPaint(new Color(247, 246, 242));
        
        CategoryPlot plot = lineChart.getCategoryPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer(true, false);
        // change of color lines
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.darkGray);
        renderer.setSeriesPaint(2, new Color(0, 154, 220));
        // change of line thickness
        renderer.setSeriesStroke(0, new BasicStroke(1.5f));
        renderer.setSeriesStroke(1, new BasicStroke(1.5f));
        renderer.setSeriesStroke(2, new BasicStroke(1.5f));
        
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
