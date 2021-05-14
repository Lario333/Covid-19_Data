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
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * PieChart of the data
 */
public class PieChart extends JPanel {

    /**
     * Constructs a new PieChart
     */
    public PieChart() {
    }

    // creation of data Chart
    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        dataset.setValue("Ricoverati con sintomi", Double.parseDouble(Main.daysData.get(Main.daysData.size() - 1).getRicoverati_con_sintomi()));
        dataset.setValue("Isolamento domiciliare", Double.parseDouble(Main.daysData.get(Main.daysData.size() - 1).getIsolamento_domiciliare()));
        dataset.setValue("Terapia intensiva", Double.parseDouble(Main.daysData.get(Main.daysData.size() - 1).getTerapia_intensiva()));

        return dataset;
    }

    // create of the object chart
    private JFreeChart createChart(PieDataset dataset) {
        JFreeChart pieChart = ChartFactory.createPieChart("Nuovi casi", // chart title
                dataset, // data
                true, // include legend
                true, // tooltips
                false);
        PiePlot plot = (PiePlot) pieChart.getPlot();
        // change font of chart title
        pieChart.getTitle().setFont(new Font("Arial", Font.BOLD, 20));
        // background color 
        pieChart.setBackgroundPaint(new Color(247, 246, 242));
        plot.setBackgroundPaint(new Color(247, 246, 242));
        // set color of each slice
        plot.setSectionPaint(1, new Color(22, 131, 195, 255));
        plot.setSectionPaint(2, new Color(208, 92, 49, 255));
        plot.setSectionPaint(2, new Color(233, 181, 63, 255));
        return pieChart;
    }

    /**
     * Returns a new chartPanel containing the pieChart
     *
     * @return a new chartPanel containing the pieChart
     */
    public JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel pan = new ChartPanel(chart);
        pan.setPreferredSize(new Dimension(400, 270));
        return pan;
    }
}
