/*
 *********************************
 *       2021(c) Project by      *
 *                               * 
 *           Davide Iaci         *
 *         Alessio Zarola        *
 *********************************
 */
package Source;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * LinearChart of data
 */
public class DataLinearChart extends JPanel {

    /**
     * Creation of LinearChart
     */
    public DataLinearChart() {
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String title1 = "Morti";
        String title2 = "Guariti";
        String title3 = "Positivi";

        // deaths
        for (int i = 0; i < Main.daysData.size(); i++) {
            dataset.addValue(Integer.parseInt(Main.daysData.get(i).getDeceduti()), title1, Main.daysData.get(i).getData());
        }

        // healed
        for (int i = 0; i < Main.daysData.size(); i++) {
            dataset.addValue(Integer.parseInt(Main.daysData.get(i).getDimessi_guariti()), title2, Main.daysData.get(i).getData());
        }

        // positive
        for (int i = 0; i < Main.daysData.size(); i++) {
            dataset.addValue(Integer.parseInt(Main.daysData.get(i).getTotale_positivi()), title3, Main.daysData.get(i).getData());
        }

        return dataset;
    }

    // create of the object chart
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart lineChart = ChartFactory.createLineChart(
                null,
                "Tempo", "Dati",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);
        return lineChart;
    }

    /**
     * Returns a new chartPanel containing the linearChart
     *
     * @return a new chartPanel containing the linearChart
     */
    public JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel pan = new ChartPanel(chart);
        pan.setPreferredSize(new Dimension(500, 300));

        return pan;
    }
}
