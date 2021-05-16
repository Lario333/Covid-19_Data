/*
 *********************************
 *       2021(c) Project by      *
 *                               * 
 *           Davide I.           *
 *           Alessio Z.          *
 *********************************
 */
package Source;

import static Source.ItalyMap.colors;
import static Source.Main.daysData;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;


/**
 * Download csv file from https://lab24.ilsole24ore.com/coronavirus/# this file
 * will downloaded after that program is run, and replaced with the old file
 */
public class DataUploader {

    String path = "src/Data/Italia-trend-giornaliero.csv";


    /**
     * Method to read the language to set to the program in settings.txt file
     * @return
     */
    public String checkLanguage(){
        String lang = "";
        String read = "";
        try{
            FileReader fr = new FileReader("src/../settings.txt");
            BufferedReader b = new BufferedReader(fr);
            read = b.readLine();
            read = read.replaceAll(" " , "");
            lang = read.substring(9);
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(lang);
        return lang;
    }

    /**
     * Method to download covid data from the official COVID Github Repo and write it into the csv data file
     * 
     * @throws IOException
     */
    public void downloadData() throws IOException {
        this.clearData();
         FileWriter fw = new FileWriter(path, true);
        
        Document doc = Jsoup.connect("https://github.com/pcm-dpc/COVID-19/blob/master/dati-andamento-nazionale/dpc-covid19-ita-andamento-nazionale.csv").get();
        Elements codes = doc.select("tr[class=js-file-line]");
        // initializing length
        int length = 0;

        // CODES = All LCs
        // CODE = ONE LC
        for (Element code : codes) {
            Elements children = code.children();
            // CHILDREN = ALL TD or TH OF An LC
            // CHILD = ONE TD OF An LC
            length = children.size() - 1;
            for (Element child : children) {
                // HEADER ( LC1 )
                if (code.id().equals("LC1")) {
                    if (child.tag().toString().equals("th")) {
                        if (length != 0) {
                            fw.write(child.text() + ";");
                        } else {
                            fw.write(child.text() );
                        }
                    }
                    length--;
                } else {
                    if (child.tag().toString().equals("td")) {
                        if( length != ( children.size() - 1 )){
                            String toSet = child.text().replaceAll(";", "");
                            if (toSet == ""){
                                toSet = "0";
                            }
                            if (length != 0){
                                fw.write(toSet + ";");
                            } else {
                                fw.write(toSet);
                            }
                        }
                    }
                    length--;
                }
            }
            fw.write("\n");
        }
        fw.close();
    }
    /**
     * clearData
     * @throws IOException
     * Clears csv file
     */
    private void clearData() throws IOException {
        FileWriter fw = new FileWriter(path);
        fw.write("");
        fw.close();
    }

    /**
     * Read csv file with italian covid data trends and initalize daysData ArrayList
     */

    public void readCsvGeneralFile(){
        String line;
        try{
             BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            while((line = br.readLine()) != null){
                // System.out.println(line);
                String[] v = line.split(";"); // splitting all day value
                Day d = new Day(v[0], v[1], v[2], v[3], v[4], v[5], v[6], v[7], v[8], v[9], v[10], v[11], v[12], v[13],
                v[14], v[15], v[16], v[17], v[18], v[19], v[20], v[21], v[22], v[23]);
                daysData.add(d);
            }

        } catch (Exception e ){
            e.printStackTrace();
        }
    }

    /**
     * Returns the BufferedImage of the argument
     *
     * @param position of the image file
     * @return the BufferedImage of the argument
     */
    public BufferedImage uploadImage(String position) {
        BufferedImage image = null;
        BufferedImage convertedImage = null;// is the image converted to TYPE_4BYTE_AGBR so that all images can be colored later
        try {
            image = ImageIO.read(getClass().getResource(position)); // save image
            // conversion
            convertedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_4BYTE_ABGR); // convertedImage has the same dimensiuon and contentr but change the image type
            convertedImage.getGraphics().drawImage(image, 0, 0, null); // the content of convertedImage becomes that of image
        } catch (IOException ex) {
            Logger.getLogger(DataUploader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convertedImage;
    }

    /**
     * Estract the color of Italyregions from www.salute.gov.it and save it in the
     * matrix colors of the ItalyMap class
     */
    public void readRegionsColorsWebPage() {
        try {
            URL url = new URL(
                    "https://www.salute.gov.it/portale/nuovocoronavirus/dettaglioContenutiNuovoCoronavirus.jsp?lingua=italiano&id=5351&area=nuovoCoronavirus&menu=vuoto"); // website's url
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line; // single line of source from website

            // read all line of source
            while ((line = br.readLine()) != null) {
                // search the interested line
                if (line.contains("(areaRossa)") && line.contains("(areaArancione)") && line.contains("(areaGialla)")
                        && line.contains("(areaBianca)")) {
                    // replace html tag
                    line = line.replaceAll("<br\\b[^>]*>(.*?)", "-");
                    line = line.replaceAll("<([/a-z][a-z0-9]*)\\b[^>]*>(.*?)", "");
                    line = line.substring(0, line.length() - 4) + "document";
                    // System.out.println(line);

                    // temporary start and end index that increase for each name of region in the
                    // string 'line'
                    int start = 0;
                    int end = 0;
                    String tempRegion; // temporary name that contains all regions for each color

                    // these lines fix a bug that occurs when there are no regions in the red zone
                    for (int i = 0; i < colors.length; i++) {
                        if (line.charAt(line.indexOf(';', end) + 1) != 'd') {
                            start = line.indexOf(';', end) + 1;
                        } else {
                            start = line.indexOf(';', end) + 2;
                        }
                        end = line.indexOf("document", start);
                        tempRegion = line.substring(start, end); // estract the string from start to end
                        tempRegion = tempRegion.replaceAll("PA Bolzano-", "");
                        tempRegion = tempRegion.replaceAll("PA Trento", "Trentino Alto Adige");
                        // these lines fix a bug that occurs when there are no regions in the red zone
                        if (tempRegion.equals("ocument.write(noRegione);")) {
                            tempRegion = "";
                        }
                        colors[i] = tempRegion.split("-"); // regions are splitted in the colors matrix
                    }
                }
            }
            br.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(DataUploader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataUploader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Return true if the internet connection is available
     *
     * @return true if the internet connection is available
     */
    public static boolean checkConnection() {

        try {
            URL url = new URL(
                    "http://www.salute.gov.it/portale/nuovocoronavirus/dettaglioContenutiNuovoCoronavirus.jsp?area=nuovoCoronavirus&id=5351&lingua=italiano&menu=vuoto");
            URLConnection con = url.openConnection();
            con.connect();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
