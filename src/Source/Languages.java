package Source;

import java.util.ArrayList;

public class Languages {
    ArrayList<Language> languages = new ArrayList<Language>();
    public static Language ita = new Language("IT" , "Positivi" , "Morti" , "Guariti" , "Terapia Intensiva" , "Ricoverati" , "Tamponi" , "Nuovi casi" , "Dati" , "Totali" , "Tempo" , "Dati aggiornati al " , "Ricoverati con sintomi" , "Isolamento domiciliare");
    public static Language eng = new Language("ENG" , "Positives" , "Deaths" , "Healed" , "Intensive care" ,"Hospitalized" ,  "Swabs" , "New cases" , "Data" , "Total" , "Time" , "Data updated to ", "Hospitalized with symptoms" , "Home isolation");


    private Language activeLanguage;

    /**
     * Constructor
     * @param toUse
     */
    public Languages(Language toUse){
        activeLanguage = toUse;
        languages.add(ita);
        languages.add(eng);
    }

    /**
     * Return the active lenguage
     * 
     * @return the active lenguage
     */
    public Language getActiveLanguage() {
        return activeLanguage;
    }

    /**
     * Set the active lenguage
     * @param title 
     */
    public void setActiveLanguage(String title) {
        for(int i = 0 ; i < (languages.size()); i++){
            if (title.equals(languages.get(i).getTitle())){
                this.activeLanguage = languages.get(i);
                break;
            }
        }
    }
}
