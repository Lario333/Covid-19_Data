/*
 *********************************
 *       2021(c) Project by      *
 *                               * 
 *           Davide I.           *
 *           Alessio Z.          *
 *********************************
 */
package Source;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class
 */ 
public class Main { 

    static ArrayList<Day> daysData = new ArrayList<Day>();

    /**
     * Main that will run the program
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    	
        DataUploader loader = new DataUploader(); 

        // Download latest data from the COVID Github Repo
        loader.downloadData();
        loader.readCsvGeneralFile(); // upload Covid-Data csv file
        Day.calcDiffData();
        // Creating the frame
        Covid19_Frame frame = new Covid19_Frame();

        // Frame settings
        frame.setBackground(new Color(247,246,242)); 
        frame.setTitle("Covid Graphs");
        frame.setResizable(false);
        frame.setSize(1455, 850);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
