/*
 *********************************
 *       2021(c) Project by      *
 *                               * 
 *           Davide I.           *
 *           Alessio Z.          *
 *********************************
 */
package Source;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.math.RoundingMode;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * JFrame of the program
 */
public class Covid19_Frame extends JFrame {

    // ------------------ PANEL ------------------
    private JPanel mainPanel = new JPanel(); // mainPanel, BorderLayout

    // ----------- MAIN PANEL -----------
    // This panel will contain West and East North panel
    private JPanel mainNorthWrapperPanel = new JPanel(); // Main North panel in the mainPanel
    // This panel will contain dateLblPanel
    private JPanel northWestWrapperPanel = new JPanel(); // West panel in the mainNorthPanel
    // This panel will contain pieChartPanel
    private JPanel northEastWrapperPanel = new JPanel(); // West panel in the mainNorthPanel
    // This panel will contain datelabel
    private JPanel dateLlbPanel = new JPanel(); // West Panel in the North Panel

    // --- Main Panel South
    // This panel will contain West, Center, and East South panel
    private JPanel mainSouthWrapperPanel = new JPanel(); // Main South panel in the mainPanel
    // This panel will contain dataLinearChart
    private JPanel southWestWrapperPanel = new JPanel(); // West panel in the mainSouthPanel
    // This panel will contain ItalyMap
    private JPanel southCenterWrapperPanel = new JPanel(); // Center panel in the mainSouthPanel
    // AGGIUNGERE DESCRIZIONE SPECIFICA
    private JPanel southEastWrapperPanel = new JPanel(); // East panel in the mainSouthPanel

    // This panel will contain pieChart
    private JPanel pieChartPanel = new JPanel(); // contains percentage of positive
    private PieChart pieChart = new PieChart(); // PieCart Object

    // This panel will contain linearChart
    private JPanel dataLinearChartPnl = new JPanel(); // linear chart of main data
    private DataLinearChart dataLinearChart = new DataLinearChart(); // dataLinearChart Object
    // This panel will contain italyMap
    private JPanel italyMapPanel = new JPanel(); // contains an italyMap with all regions colored of corrispondent color
    // This panel will contain linearChart of tampons
    private JPanel dataLinearChartTPnl = new JPanel(); // linear chart of tampons
    private DataLinearChartT dataLinearChartT = new DataLinearChartT(); // dataLinearChart Object

    // Refresh button
    JButton refreshBtn = new JButton();

    // ----------------------------------------------
    // --------------------- TITLE LABELS ---------------------
    // Date Labels
    private JLabel lblPositivi = new JLabel( Main.useLanguage.getActiveLanguage().getP() , SwingConstants.CENTER);
    private JLabel lblMorti = new JLabel(Main.useLanguage.getActiveLanguage().getM(), SwingConstants.CENTER);
    private JLabel lblGuariti = new JLabel(Main.useLanguage.getActiveLanguage().getG(), SwingConstants.CENTER);
    private JLabel lblT_I = new JLabel(Main.useLanguage.getActiveLanguage().getTi(), SwingConstants.CENTER);
    private JLabel lblRicoverati = new JLabel(Main.useLanguage.getActiveLanguage().getR(), SwingConstants.CENTER);
    private JLabel lblTamponi = new JLabel(Main.useLanguage.getActiveLanguage().getT(), SwingConstants.CENTER);

    // Date Difference Labels
    private JLabel lblDiffPositivi = new JLabel();
    private JLabel lblDiffMorti = new JLabel();
    private JLabel lblDiffGuariti = new JLabel();
    private JLabel lblDiffT_I = new JLabel();
    private JLabel lblDiffRicoverati = new JLabel();
    private JLabel lblDiffTamponi = new JLabel();

    // Date Percentage Labels
    private JLabel lblPerPositivi = new JLabel();
    private JLabel lblPerMorti = new JLabel();
    private JLabel lblPerGuariti = new JLabel();
    private JLabel lblPerT_I = new JLabel();
    private JLabel lblPerRicoverati = new JLabel();
    private JLabel lblPerTamponi = new JLabel();

    // Date Total Labels
    private JLabel lblTotPositivi = new JLabel();
    private JLabel lblTotMorti = new JLabel();
    private JLabel lblTotGuariti = new JLabel();
    private JLabel lblTotT_I = new JLabel();
    private JLabel lblTotRicoverati = new JLabel();
    private JLabel lblTotTamponi = new JLabel();
    
    private JLabel lblDate = new JLabel();

    // Format to formatter thousands numbers of date labels
    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ITALY);
    // ---------------------------------------------------------

    /**
     * Constructor
     */
    public Covid19_Frame() {



        // total capacity of daysData vector
        int totCap = Main.daysData.size() - 1;
        // Main panel settings
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(mainNorthWrapperPanel, "North");
        mainPanel.add(mainSouthWrapperPanel, "South");

        // North wrapper panel settings
        mainNorthWrapperPanel.setLayout(new BoxLayout(mainNorthWrapperPanel, BoxLayout.X_AXIS));
        mainNorthWrapperPanel.add(northWestWrapperPanel);
        mainNorthWrapperPanel.add(northEastWrapperPanel);

        northWestWrapperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 60));

        // Main panel south wrapper panel settings
        mainSouthWrapperPanel.setLayout(new BoxLayout(mainSouthWrapperPanel, BoxLayout.X_AXIS));
        mainSouthWrapperPanel.add(southWestWrapperPanel);
        mainSouthWrapperPanel.add(southCenterWrapperPanel);
        mainSouthWrapperPanel.add(southEastWrapperPanel);

        // Date labels panel settings
        dateLlbPanel.setLayout(new GridLayout(4, 6, 0, 10));

        // --------------------- LABELS TITLE ---------------------
        // Settings data labels FONT
        lblPositivi.setFont(new Font("Arial", Font.PLAIN, 20));
        lblMorti.setFont(new Font("Arial", Font.PLAIN, 20));
        lblGuariti.setFont(new Font("Arial", Font.PLAIN, 20));
        lblT_I.setFont(new Font("Arial", Font.PLAIN, 20));
        lblRicoverati.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTamponi.setFont(new Font("Arial", Font.PLAIN, 20));
        // Settings difference data labels FOREGROUND
        lblPositivi.setForeground(Color.darkGray);
        lblMorti.setForeground(Color.darkGray);
        lblGuariti.setForeground(Color.darkGray);
        lblT_I.setForeground(Color.darkGray);
        lblRicoverati.setForeground(Color.darkGray);
        lblTamponi.setForeground(Color.darkGray);
        
        
        // --------------------- LABELS DIFFERENCE ---------------------
        // Settings difference data labels TEXT
        lblDiffPositivi.setText(Main.daysData.get(totCap).getNuovi_positivi());
        lblDiffMorti.setText(Main.daysData.get(totCap).getNuoviMorti());
        lblDiffGuariti.setText(Main.daysData.get(totCap).getNuoviGuariti());
        lblDiffT_I.setText(Main.daysData.get(totCap).getNuoviT_I());
        lblDiffRicoverati.setText(Main.daysData.get(totCap).getNuoviRicoverati());
        lblDiffTamponi.setText(Main.daysData.get(totCap).getNuoviTamponi());
        // Settings difference data labels FONT
        lblDiffPositivi.setFont(new Font("Arial", Font.PLAIN, 36));
        lblDiffMorti.setFont(new Font("Arial", Font.PLAIN, 36));
        lblDiffGuariti.setFont(new Font("Arial", Font.PLAIN, 36));
        lblDiffT_I.setFont(new Font("Arial", Font.PLAIN, 36));
        lblDiffRicoverati.setFont(new Font("Arial", Font.PLAIN, 36));
        lblDiffTamponi.setFont(new Font("Arial", Font.PLAIN, 36));
        // Settings difference data labels ALIGNMENT
        lblDiffPositivi.setHorizontalAlignment(SwingConstants.CENTER);
        lblDiffMorti.setHorizontalAlignment(SwingConstants.CENTER);
        lblDiffGuariti.setHorizontalAlignment(SwingConstants.CENTER);
        lblDiffT_I.setHorizontalAlignment(SwingConstants.CENTER);
        lblDiffRicoverati.setHorizontalAlignment(SwingConstants.CENTER);
        lblDiffTamponi.setHorizontalAlignment(SwingConstants.CENTER);
        // Creating a thousands SEPARATOR for the difference data labels
        lblDiffPositivi.setText(formatter.format(Integer.parseInt(lblDiffPositivi.getText())));
        lblDiffMorti.setText(formatter.format(Integer.parseInt(lblDiffMorti.getText())));
        lblDiffGuariti.setText(formatter.format(Integer.parseInt(lblDiffGuariti.getText())));
        lblDiffT_I.setText(formatter.format(Integer.parseInt(lblDiffT_I.getText())));
        lblDiffRicoverati.setText(formatter.format(Integer.parseInt(lblDiffRicoverati.getText())));
        lblDiffTamponi.setText(formatter.format(Integer.parseInt(lblDiffTamponi.getText())));
        
        // Adding "+" before the formatted numbers
        if (lblDiffPositivi.getText().charAt(0) != '-') {
            lblDiffPositivi.setText("+" + lblDiffPositivi.getText());
        }
        if( lblDiffMorti.getText().charAt(0) != '-'){
            lblDiffMorti.setText("+" + lblDiffMorti.getText());
        }
        if (lblDiffGuariti.getText().charAt(0) != '-') {
            lblDiffGuariti.setText("+" + lblDiffGuariti.getText());
        }
        if (lblDiffRicoverati.getText().charAt(0) != '-') {
            lblDiffRicoverati.setText("+" + lblDiffRicoverati.getText());
        }
        if(lblDiffT_I.getText().charAt(0) != '-'){
            lblDiffT_I.setText("+" + lblDiffT_I.getText());
        }
        if (lblDiffTamponi.getText().charAt(0) != '-') {
            lblDiffTamponi.setText("+" + lblDiffTamponi.getText());
        }
        
        // Settings difference data labels FOREGROUND
        lblDiffPositivi.setForeground(Color.red);
        lblDiffMorti.setForeground(Color.darkGray);
        lblDiffGuariti.setForeground(new Color(0, 154, 220));
        lblDiffT_I.setForeground(new Color(247, 128, 128));
        lblDiffRicoverati.setForeground(new Color(247, 128, 128));
        lblDiffTamponi.setForeground(new Color(247, 128, 128));

        // --------------------- LABELS PERCENTAGE ---------------------
        // Rounding
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        // Settings percetage data labels TEXT
        String temp; // contains the temporary calculation 
        // to obtain these values the following formula was used: (((xf - xi) / xi) * 100) %
        // tot casi
        temp = df.format(((Double.parseDouble(Main.daysData.get(totCap).getTotale_casi()) - (Double.parseDouble(Main.daysData.get(totCap - 1).getTotale_casi()))) / Double.parseDouble(Main.daysData.get(totCap - 1).getTotale_casi()) * 100));
        lblPerPositivi.setText(temp + "%");
        temp = df.format(((Double.parseDouble(Main.daysData.get(totCap).getDeceduti()) - (Double.parseDouble(Main.daysData.get(totCap - 1).getDeceduti()))) / Double.parseDouble(Main.daysData.get(totCap - 1).getDeceduti()) * 100));
        lblPerMorti.setText(temp + "%");
        temp = df.format(((Double.parseDouble(Main.daysData.get(totCap).getDimessi_guariti()) - (Double.parseDouble(Main.daysData.get(totCap - 1).getDimessi_guariti()))) / Double.parseDouble(Main.daysData.get(totCap - 1).getDimessi_guariti()) * 100));
        lblPerGuariti.setText(temp + "%");
        temp = df.format(((Double.parseDouble(Main.daysData.get(totCap).getTerapia_intensiva()) - (Double.parseDouble(Main.daysData.get(totCap - 1).getTerapia_intensiva()))) / Double.parseDouble(Main.daysData.get(totCap - 1).getTerapia_intensiva()) * 100));
        lblPerT_I.setText(temp + "%");
        temp = df.format(((Double.parseDouble(Main.daysData.get(totCap).getRicoverati_con_sintomi()) - (Double.parseDouble(Main.daysData.get(totCap - 1).getRicoverati_con_sintomi()))) / Double.parseDouble(Main.daysData.get(totCap - 1).getRicoverati_con_sintomi()) * 100));
        lblPerRicoverati.setText(temp + "%");
        temp = df.format(((Double.parseDouble(Main.daysData.get(totCap).getTamponi()) - (Double.parseDouble(Main.daysData.get(totCap - 1).getTamponi()))) / Double.parseDouble(Main.daysData.get(totCap - 1).getTamponi()) * 100));
        lblPerTamponi.setText(temp + "%");
        // Settings percetage data labels FONT
        lblPerPositivi.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPerMorti.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPerGuariti.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPerT_I.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPerRicoverati.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPerTamponi.setFont(new Font("Arial", Font.PLAIN, 20));
        // Settings percetage data labels ALIGNMENT
        lblPerPositivi.setHorizontalAlignment(SwingConstants.CENTER);
        lblPerMorti.setHorizontalAlignment(SwingConstants.CENTER);
        lblPerGuariti.setHorizontalAlignment(SwingConstants.CENTER);
        lblPerT_I.setHorizontalAlignment(SwingConstants.CENTER);
        lblPerRicoverati.setHorizontalAlignment(SwingConstants.CENTER);
        lblPerTamponi.setHorizontalAlignment(SwingConstants.CENTER);
        // Adding "+" before the rounded numbers
        if (lblPerPositivi.getText().charAt(0) != '-') {
            lblPerPositivi.setText("+" + lblPerPositivi.getText());
        }
        if (lblPerMorti.getText().charAt(0) != '-') {
            lblPerMorti.setText("+" + lblPerMorti.getText());
        }
        if (lblPerGuariti.getText().charAt(0) != '-') {
            lblPerGuariti.setText("+" + lblPerGuariti.getText());
        }
        if (lblPerT_I.getText().charAt(0) != '-') {
            lblPerT_I.setText("+" + lblPerT_I.getText());
        }
        if (lblPerRicoverati.getText().charAt(0) != '-') {
            lblPerRicoverati.setText("+" + lblPerRicoverati.getText());
        }
        if (lblPerTamponi.getText().charAt(0) != '-') {
            lblPerTamponi.setText("+" + lblPerTamponi.getText());
        }
        // Settings percetage data labels FOREGROUND
        lblPerPositivi.setForeground(Color.red);
        lblPerMorti.setForeground(Color.darkGray);
        lblPerGuariti.setForeground(new Color(0, 154, 220));
        lblPerT_I.setForeground(new Color(247, 128, 128));
        lblPerRicoverati.setForeground(new Color(247, 128, 128));
        lblPerTamponi.setForeground(new Color(247, 128, 128));

        // --------------------- LABELS TOTALS ---------------------
        // Settings total data labels TEXT
        lblTotPositivi.setText(Main.daysData.get(totCap).getTotale_casi());
        lblTotMorti.setText(Main.daysData.get(totCap).getDeceduti());
        lblTotGuariti.setText(Main.daysData.get(totCap).getDimessi_guariti());
        lblTotT_I.setText(Main.daysData.get(totCap).getTerapia_intensiva());
        lblTotRicoverati.setText(Main.daysData.get(totCap).getRicoverati_con_sintomi());
        lblTotTamponi.setText(Main.daysData.get(totCap).getTamponi());
        // Settings total data labels FONT
        lblTotPositivi.setFont(new Font("Arial", Font.BOLD, 20));
        lblTotMorti.setFont(new Font("Arial", Font.BOLD, 20));
        lblTotGuariti.setFont(new Font("Arial", Font.BOLD, 20));
        lblTotT_I.setFont(new Font("Arial", Font.BOLD, 20));
        lblTotRicoverati.setFont(new Font("Arial", Font.BOLD, 20));
        lblTotTamponi.setFont(new Font("Arial", Font.BOLD, 20));
        // Settings total data labels ALIGNMENT
        lblTotPositivi.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotMorti.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotGuariti.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotT_I.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotRicoverati.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotTamponi.setHorizontalAlignment(SwingConstants.CENTER);
        // Creating a thousands SEPARATOR for the total data labels
        lblTotPositivi.setText(formatter.format(Integer.parseInt(lblTotPositivi.getText())));
        lblTotMorti.setText(formatter.format(Integer.parseInt(lblTotMorti.getText())));
        lblTotGuariti.setText(formatter.format(Integer.parseInt(lblTotGuariti.getText())));
        lblTotT_I.setText(formatter.format(Integer.parseInt(lblTotT_I.getText())));
        lblTotRicoverati.setText(formatter.format(Integer.parseInt(lblTotRicoverati.getText())));
        lblTotTamponi.setText(formatter.format(Integer.parseInt(lblTotTamponi.getText())));
        // Adding "totali" before the formatted number
        lblTotPositivi.setText(Main.useLanguage.getActiveLanguage().getTot() + " " + lblTotPositivi.getText());
        lblTotMorti.setText(Main.useLanguage.getActiveLanguage().getTot() + " "+ lblTotMorti.getText());
        lblTotGuariti.setText(Main.useLanguage.getActiveLanguage().getTot() + " "+ lblTotGuariti.getText());
        lblTotT_I.setText(Main.useLanguage.getActiveLanguage().getTot() + " "+ lblTotT_I.getText());
        lblTotRicoverati.setText(Main.useLanguage.getActiveLanguage().getTot() + " "+ lblTotRicoverati.getText());
        lblTotTamponi.setText(Main.useLanguage.getActiveLanguage().getTot() + " "+ lblTotTamponi.getText());
        // Settings total data labels FOREGROUND
        lblTotPositivi.setForeground(Color.red);
        lblTotMorti.setForeground(Color.darkGray);
        lblTotGuariti.setForeground(new Color(0, 154, 220));
        lblTotT_I.setForeground(new Color(247, 128, 128));
        lblTotRicoverati.setForeground(new Color(247, 128, 128));
        lblTotTamponi.setForeground(new Color(247, 128, 128));

        // North main panel adding components
        // date
        dateLlbPanel.add(lblPositivi);
        dateLlbPanel.add(lblMorti);
        dateLlbPanel.add(lblGuariti);
        dateLlbPanel.add(lblT_I);
        dateLlbPanel.add(lblRicoverati);
        dateLlbPanel.add(lblTamponi);
        // diff
        dateLlbPanel.add(lblDiffPositivi);
        dateLlbPanel.add(lblDiffMorti);
        dateLlbPanel.add(lblDiffGuariti);
        dateLlbPanel.add(lblDiffT_I);
        dateLlbPanel.add(lblDiffRicoverati);
        dateLlbPanel.add(lblDiffTamponi);
        // perc
        dateLlbPanel.add(lblPerPositivi);
        dateLlbPanel.add(lblPerMorti);
        dateLlbPanel.add(lblPerGuariti);
        dateLlbPanel.add(lblPerT_I);
        dateLlbPanel.add(lblPerRicoverati);
        dateLlbPanel.add(lblPerTamponi);
        // tot
        dateLlbPanel.add(lblTotPositivi);
        dateLlbPanel.add(lblTotMorti);
        dateLlbPanel.add(lblTotGuariti);
        dateLlbPanel.add(lblTotT_I);
        dateLlbPanel.add(lblTotRicoverati);
        dateLlbPanel.add(lblTotTamponi);

        // PieChartPanel settings
        pieChartPanel.add(pieChart.createDemoPanel());

        // Addition of labels and chart
        northWestWrapperPanel.add(dateLlbPanel);
        northEastWrapperPanel.add(pieChartPanel);

        // Addition of dataLinearChart in the southWestPanel
        dataLinearChartPnl.add(dataLinearChart.createDemoPanel());
        southWestWrapperPanel.add(dataLinearChartPnl);

        // Test
        southEastWrapperPanel.setLayout(new BorderLayout());
        
        // Addition of italyMap in the southCenterPanel
        /*
             * Addition of DataLinearChartT in the southEastPanel 70 value is obtained by
             * (italyMap.getHeight() - dataLinearChart.getHeight()) / 2) for place the
             * graphics in the center of italyMap in the Y axis
         */
        dataLinearChartPnl.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0));
        dataLinearChartTPnl.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0));
        ItalyMap italyMap = new ItalyMap(); // ItalyMap Object
        italyMapPanel.add(italyMap);
        southCenterWrapperPanel.add(italyMapPanel);

        // Adding dataLinearChartT to southEastWrapperPanel
        dataLinearChartTPnl.add(dataLinearChartT.createDemoPanel());
        southEastWrapperPanel.add(dataLinearChartTPnl , "West");
        
        // Date label
        String date = Main.daysData.get(totCap).getData();
        date = Main.useLanguage.getActiveLanguage().getDateLbl() + date.substring(0 , 10);
        lblDate.setHorizontalAlignment(4);
        lblDate.setHorizontalAlignment(4);
        lblDate.setText(date);
        lblDate.setFont(new Font("Arial" , Font.ITALIC, 15));

        JPanel southEastnanoComponentsPanel = new JPanel();
        southEastWrapperPanel.add(southEastnanoComponentsPanel , "South");

        southEastnanoComponentsPanel.setLayout(new BorderLayout());

        JLabel blank = new JLabel("");
        blank.setBorder(new EmptyBorder(0,0,32,0));

        // Refresh button
        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataUploader d = new DataUploader();
                try{
                    d.downloadData();
                    d.readCsvGeneralFile();
                    Day.calcDiffData();

                    clearFrame();

                } catch(Exception ex ){
                    ex.printStackTrace();
                }
            }
        });
        refreshBtn.setSize(new Dimension(40,40));
//        refreshBtn.setBackground(new Color(247,246,242));
        try{
            refreshBtn.setIcon(new ImageIcon("src/Data/refresh_image.png"));
        } catch( Exception e ){
            e.printStackTrace();
        }
        
        southEastnanoComponentsPanel.add(refreshBtn , "West");
        southEastnanoComponentsPanel.add(blank , "West");

        southEastnanoComponentsPanel.add(lblDate , "South");



        // Adding mainPanel to contentPane
        this.getContentPane().add(mainPanel);
    }

    public void clearFrame(){
        this.setVisible(false);

        Covid19_Frame frame = new Covid19_Frame();
        frame.setBackground(new Color(247,246,242));
        frame.setTitle("Covid Graphs");
        frame.setResizable(false);
        frame.setSize(1455, 850);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
