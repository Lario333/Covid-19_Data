/*
 *********************************
 *       2021(c) Project by      *
 *                               * 
 *           Davide I.           *
 *           Alessio Z.          *
 *********************************
 */
package Source;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
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
            dataset.addValue(Integer.parseInt(Main.daysData.get(i).getTamponi()), title, Main.daysData.get(i).getData());
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
