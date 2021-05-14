/*
 *********************************
 *       2021(c) Project by      *
 *                               * 
 *           Davide Iaci         *
 *         Alessio Zarola        *
 *********************************
 */
package Source;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

// alphabetical order of all italy regions
enum Regions {
    ABRUZZO(1),
    BASILICATA(2),
    CALABRIA(3),
    CAMPANIA(4),
    EMILIA_ROMAGNA(5),
    FRIULI_VENEZIA_GIULIA(6),
    LAZIO(7),
    LIGURIA(8),
    LOMBARDIA(9),
    MARCHE(10),
    MOLISE(11),
    PIEMONTE(12),
    PUGLIA(13),
    SARDEGNA(14),
    SICILIA(15),
    TOSCANA(16),
    TRENTINO_ALTO_ADIGE(17),
    UMBRIA(18),
    VALLE_AOSTA(19),
    VENETO(20);

    int number;

    private Regions(int number) {
        this.number = number;
    }
}

/**
 * Creation of the Italy map The regions are called with number from 1 to 20
 * (alphabetic order) for ease the work
 */
public class ItalyMap extends JPanel {

    public static final BufferedImage[] regions = new BufferedImage[20]; // all 20 regions
    /*
    According to the following color by index:
    0-red
    1- orange
    2- yellow
    3- white
     */
    public static String[][] colors = new String[4][];

    /**
     * Constructs a new ItalyMap
     */
    public ItalyMap() {
        uploadResource();
        colorRegions(); // it color regions based on data 
        setToollTip();
        super.setPreferredSize(new Dimension(400, 440));
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g); // prints the component as if you hadn't overridden the paintComponent method
        this.setBackground(Color.blue); // background of italyMap

        // DRAW ALL REGIONS with his position
        g.drawImage(regions[0], 208, 181, regions[0].getWidth(), regions[0].getHeight(), this); // Abruzzo
        g.drawImage(regions[1], 280, 251, regions[1].getWidth(), regions[1].getHeight(), this); // Basilicata
        g.drawImage(regions[2], 294, 290, regions[2].getWidth(), regions[2].getHeight(), this); // Calabria
        g.drawImage(regions[3], 231, 236, regions[3].getWidth(), regions[3].getHeight(), this); // Campania
        g.drawImage(regions[4], 99, 88, regions[4].getWidth(), regions[4].getHeight(), this); // Emilia-Romagna
        g.drawImage(regions[5], 190, 30, regions[5].getWidth(), regions[5].getHeight(), this); // Friuli Venezia Giulia
        g.drawImage(regions[6], 162, 183, regions[6].getWidth(), regions[6].getHeight(), this); // Lazio
        g.drawImage(regions[7], 45, 105, regions[7].getWidth(), regions[7].getHeight(), this); // Liguria
        g.drawImage(regions[8], 80, 28, regions[8].getWidth(), regions[8].getHeight(), this); // Lombardia 
        g.drawImage(regions[9], 182, 136, regions[9].getWidth(), regions[9].getHeight(), this); // Marche
        g.drawImage(regions[10], 238, 213, regions[10].getWidth(), regions[10].getHeight(), this); // Molise
        g.drawImage(regions[11], 24, 33, regions[11].getWidth(), regions[11].getHeight(), this); // Piemonte
        g.drawImage(regions[12], 267, 216, regions[12].getWidth(), regions[12].getHeight(), this); // Puglia
        g.drawImage(regions[13], 57, 244, regions[13].getWidth(), regions[13].getHeight(), this); // Sardegna
        g.drawImage(regions[14], 190, 365, regions[14].getWidth(), regions[14].getHeight(), this); // Sicilia
        g.drawImage(regions[15], 113, 114, regions[15].getWidth(), regions[15].getHeight(), this); // Toscana
        g.drawImage(regions[16], 134, 10, regions[16].getWidth(), regions[16].getHeight(), this); // Trentino-Alto Adige        
        g.drawImage(regions[17], 176, 151, regions[17].getWidth(), regions[17].getHeight(), this); // Umbria
        g.drawImage(regions[18], 30, 49, regions[18].getWidth(), regions[18].getHeight(), this); // Valle d'Aosta        
        g.drawImage(regions[19], 141, 28, regions[19].getWidth(), regions[19].getHeight(), this); // Veneto
    }

    // upload the image file and initalization of array regions
    private void uploadResource() {
        DataUploader loader = new DataUploader();

        // uploading of all 20 image
        for (int i = 1; i <= regions.length; i++) {
            regions[i - 1] = loader.uploadImage("/Data/Regions/" + i + ".png");
        }

        // reading of the color of all regions
        loader.readRegionsColorsWebPage();
    }

    // set color image, changing each pixel
    private void setColor(BufferedImage img, Color rgb) {
        for (int col = 0; col < img.getWidth(); col++) {
            for (int row = 0; row < img.getHeight(); row++) {
                if ((img.getRGB(col, row) == Color.white.getRGB())) {
                    img.setRGB(col, row, rgb.getRGB());
                }
            }
        }
    }

    // set color of all regions
    private void colorRegions() {
        Color col_temp = null; // temporary color
        String nomeRegione; // temporary name of region
        int indiceRegione; // temporary index of region
        for (int color = 0; color < colors.length; color++) { // row
            // based on index of for loop change col_temp
            switch (color) {
                case 0 -> 
                    col_temp = new Color(255, 0, 0); // red
                case 1 ->
                    col_temp = new Color(255, 153, 0); // orange
                case 2 ->
                    col_temp = new Color(255, 255, 0); // yellow
                case 3 ->
                    col_temp = Color.white; // white

            }
            //prima matricola dell'array
            for (int region = 0; region < colors[color].length; region++) { // columns
                nomeRegione = colors[color][region].replaceAll(" ", "_").toUpperCase(); // name of region is converted to conventional form
                // if name of region is empty
                if (!nomeRegione.isBlank()) {
                    indiceRegione = Regions.valueOf(nomeRegione).number - 1; // index of region is equal to the number relative to name in the enum minus 1
                    setColor(regions[indiceRegione], col_temp); // set color of image
                }
            }
        }
    }

    /**
     * Creates a transparent labels for each region and when the mouse passes
     * over it, is shown the name of the corrisponding region
     */
    public void setToollTip() {
        JLabel[] lblToolTips = new JLabel[regions.length];

        // inizialize of array
        for (int i = 0; i < lblToolTips.length; i++) {
            lblToolTips[i] = new JLabel();
        }

        // set of the size of all label
        for (int i = 0; i < lblToolTips.length; i++) {
            lblToolTips[i].setSize(regions[i].getWidth() / 2, regions[i].getHeight() / 2);
        }

        // set the location of all labels
        lblToolTips[0].setLocation(208 + 15, 181 + 15); // Abruzzo
        lblToolTips[1].setLocation(280 + 15, 251 + 15); // Basilicata
        lblToolTips[2].setLocation(294 + 15, 290 + 15); // Calabria
        lblToolTips[3].setLocation(231 + 15, 236 + 12); // Campania
        lblToolTips[4].setLocation(99 + 25, 88 + 12); // Emilia-Romagna
        lblToolTips[5].setLocation(190 + 10, 30 + 9); // Friuli Venezia Giulia
        lblToolTips[6].setLocation(162 + 15, 183 + 22); // Lazio
        lblToolTips[7].setLocation(45 + 20, 105 + 5); // Liguria
        lblToolTips[8].setLocation(80 + 15, 28 + 20); // Lombardia
        lblToolTips[9].setLocation(182 + 18, 136 + 11); // Marche
        lblToolTips[10].setLocation(238 + 10, 213 + 9); // Molise
        lblToolTips[11].setLocation(24 + 18, 33 + 30); // Piemonte
        lblToolTips[12].setLocation(267 + 27, 216 + 10); // Puglia
        lblToolTips[13].setLocation(57 + 15, 244 + 23); // Sardegna
        lblToolTips[14].setLocation(190 + 30, 365 + 15); // Sicilia
        lblToolTips[15].setLocation(113 + 17, 114 + 12); // Toscana
        lblToolTips[16].setLocation(134 + 10, 10 + 15); // Trentino-Alto Adige
        lblToolTips[17].setLocation(176 + 7, 151 + 15); // Umbria
        lblToolTips[18].setLocation(30 + 9, 49 + 5); // Valle d'Aosta
        lblToolTips[19].setLocation(141 + 15, 28 + 24); // Veneto

        String tempName; // temporary name of region
        // set the text of ToolTips
        for (int i = 0; i < lblToolTips.length; i++) {
            tempName = String.valueOf(Regions.values()[i]);
            lblToolTips[i].setToolTipText(tempName.replace('_', ' '));
        }

        setLayout(null);
        
        // adding of all label in the panel
        for (int i = 0; i < lblToolTips.length; i++) {
            add(lblToolTips[i]);
        }
    }
}
