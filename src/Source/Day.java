/*
 *********************************
 *       2021(c) Project by      *
 *                               * 
 *           Davide Iaci         *
 *         Alessio Zarola        *
 *********************************
 */
package Source;

public class Day{
    private String data,stato,ricoverati_con_sintomi,terapia_intensiva,totale_ospedalizzati,isolamento_domiciliare,totale_positivi,variazione_totale_positivi,nuovi_positivi,dimessi_guariti,deceduti,casi_da_sospetto_diagnostico,casi_da_screening,totale_casi,tamponi,casi_testati,note,ingressi_terapia_intensiva,note_test,note_casi,totale_positivi_test_molecolare,totale_positivi_test_antigenico_rapido,tamponi_test_molecolare,tamponi_test_antigenico_rapido;
    int nuoviVaccini;
    int vacciniTotali = 0;
    // Calculated data
    private static String nuoviMorti , nuoviGuariti, nuoviT_I, nuoviRicoverati, nuoviTamponi;
    /**
     * Constructor
     * @param data
     * @param stato
     * @param ricoverati_con_sintomi
     * @param terapia_intensiva
     * @param totale_ospedalizzati
     * @param isolamento_domiciliare
     * @param totale_positivi
     * @param variazione_totale_positivi
     * @param nuovi_positivi
     * @param dimessi_guariti
     * @param deceduti
     * @param casi_da_sospetto_diagnostico
     * @param casi_da_screening
     * @param totale_casi
     * @param tamponi
     * @param casi_testati
     * @param note
     * @param ingressi_terapia_intensiva
     * @param note_test
     * @param note_casi
     * @param totale_positivi_test_molecolare
     * @param totale_positivi_test_antigenico_rapido
     * @param tamponi_test_molecolare
     */
    public Day(String data, String stato, String ricoverati_con_sintomi, String terapia_intensiva, String totale_ospedalizzati, String isolamento_domiciliare, String totale_positivi, String variazione_totale_positivi, String nuovi_positivi, String dimessi_guariti, String deceduti, String casi_da_sospetto_diagnostico, String casi_da_screening, String totale_casi, String tamponi, String casi_testati, String note, String ingressi_terapia_intensiva, String note_test, String note_casi, String totale_positivi_test_molecolare, String totale_positivi_test_antigenico_rapido, String tamponi_test_molecolare, String tamponi_test_antigenico_rapido) {
        this.data = data;
        this.stato = stato;
        this.ricoverati_con_sintomi = ricoverati_con_sintomi;
        this.terapia_intensiva = terapia_intensiva;
        this.totale_ospedalizzati = totale_ospedalizzati;
        this.isolamento_domiciliare = isolamento_domiciliare;
        this.totale_positivi = totale_positivi;
        this.variazione_totale_positivi = variazione_totale_positivi;
        this.nuovi_positivi = nuovi_positivi;
        this.dimessi_guariti = dimessi_guariti;
        this.deceduti = deceduti;
        this.casi_da_sospetto_diagnostico = casi_da_sospetto_diagnostico;
        this.casi_da_screening = casi_da_screening;
        this.totale_casi = totale_casi;
        this.tamponi = tamponi;
        this.casi_testati = casi_testati;
        this.note = note;
        this.ingressi_terapia_intensiva = ingressi_terapia_intensiva;
        this.note_test = note_test;
        this.note_casi = note_casi;
        this.totale_positivi_test_molecolare = totale_positivi_test_molecolare;
        this.totale_positivi_test_antigenico_rapido = totale_positivi_test_antigenico_rapido;
        this.tamponi_test_molecolare = tamponi_test_molecolare;
        this.tamponi_test_antigenico_rapido = tamponi_test_antigenico_rapido;
    }
    
    /** 
     * Calculates of data difference
     */
    public static void calcDiffData(){
        // Morti
        int lenght = Main.daysData.size() - 1;
        String yesterday = Main.daysData.get(lenght - 1).getDeceduti();
        String today = Main.daysData.get(lenght).getDeceduti();
        int diff =  Integer.parseInt(today) - Integer.parseInt(yesterday);
        nuoviMorti = String.valueOf(diff);
        // System.out.println(nuoviMorti);

        // Guariti
        yesterday = Main.daysData.get(lenght - 1).getDimessi_guariti();
        today = Main.daysData.get(lenght).getDimessi_guariti();
        diff =  Integer.parseInt(today) - Integer.parseInt(yesterday);
        nuoviGuariti = String.valueOf(diff);
        // System.out.println(nuoviGuariti);

        // Terapia intensiva
        yesterday = Main.daysData.get(lenght - 1).getTerapia_intensiva();
        today = Main.daysData.get(lenght).getTerapia_intensiva();
        diff =  Integer.parseInt(today) - Integer.parseInt(yesterday);
        nuoviT_I = String.valueOf(diff);
        // System.out.println(nuoviT_I);

        // Ricoverati 
        yesterday = Main.daysData.get(lenght - 1).getRicoverati_con_sintomi();
        today = Main.daysData.get(lenght).getRicoverati_con_sintomi();
        diff =  Integer.parseInt(today) - Integer.parseInt(yesterday);
        nuoviRicoverati = String.valueOf(diff);
        // System.out.println(nuoviRicoverati);
        
        // Tamponi
        yesterday = Main.daysData.get(lenght - 1).getTamponi();
        today = Main.daysData.get(lenght).getTamponi();
        diff =  Integer.parseInt(today) - Integer.parseInt(yesterday);
        nuoviTamponi = String.valueOf(diff);
        // System.out.println(nuoviTamponi);
    }
    
    // getters and setters

    public  void setVacciniTotali(int n ){
        vacciniTotali = n;
    }

    public  int getVacciniTotali(){
        return vacciniTotali;
    }

    public void addNuoviVaccini(int n){
        nuoviVaccini += n;
    }

    public int getNuoviVaccini(){
        return nuoviVaccini;
    }
    public void setNuoviVaccini(int n){
        nuoviVaccini = n;
    }

    public String getNuoviMorti(){
        return this.nuoviMorti;
    }
    
    public String getNuoviGuariti() {
        return this.nuoviGuariti;
    }
    
    public String getNuoviRicoverati() {
        return this.nuoviRicoverati;
    }

    public String getNuoviT_I() {
        return this.nuoviT_I;
    }
    
    public String getNuoviTamponi() {
        return this.nuoviTamponi;
    }
    
    public void setNuoviMorti(String nuoviMorti) {
        this.nuoviMorti = nuoviMorti;
    }
    
    public void setNuoviGuariti(String nuoviGuariti) {
        this.nuoviGuariti = nuoviGuariti;
    }

    public void setNuoviT_I(String nuoviT_I) {
        this.nuoviT_I = nuoviT_I;
    }

    public void setNuoviRicoverati(String nuoviRicoverati) {
        this.nuoviRicoverati = nuoviRicoverati;
    }

    public void setNuoviTamponi(String t){
        this.nuoviTamponi = t;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStato() {
        return this.stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getRicoverati_con_sintomi() {
        return this.ricoverati_con_sintomi;
    }

    public void setRicoverati_con_sintomi(String ricoverati_con_sintomi) {
        this.ricoverati_con_sintomi = ricoverati_con_sintomi;
    }

    public String getTerapia_intensiva() {
        return this.terapia_intensiva;
    }

    public void setTerapia_intensiva(String terapia_intensiva) {
        this.terapia_intensiva = terapia_intensiva;
    }

    public String getTotale_ospedalizzati() {
        return this.totale_ospedalizzati;
    }

    public void setTotale_ospedalizzati(String totale_ospedalizzati) {
        this.totale_ospedalizzati = totale_ospedalizzati;
    }

    public String getIsolamento_domiciliare() {
        return this.isolamento_domiciliare;
    }

    public void setIsolamento_domiciliare(String isolamento_domiciliare) {
        this.isolamento_domiciliare = isolamento_domiciliare;
    }

    public String getTotale_positivi() {
        return this.totale_positivi;
    }

    public void setTotale_positivi(String totale_positivi) {
        this.totale_positivi = totale_positivi;
    }

    public String getVariazione_totale_positivi() {
        return this.variazione_totale_positivi;
    }

    public void setVariazione_totale_positivi(String variazione_totale_positivi) {
        this.variazione_totale_positivi = variazione_totale_positivi;
    }

    public String getNuovi_positivi() {
        return this.nuovi_positivi;
    }

    public void setNuovi_positivi(String nuovi_positivi) {
        this.nuovi_positivi = nuovi_positivi;
    }

    public String getDimessi_guariti() {
        return this.dimessi_guariti;
    }

    public void setDimessi_guariti(String dimessi_guariti) {
        this.dimessi_guariti = dimessi_guariti;
    }

    public String getDeceduti() {
        return this.deceduti;
    }

    public void setDeceduti(String deceduti) {
        this.deceduti = deceduti;
    }

    public String getCasi_da_sospetto_diagnostico() {
        return this.casi_da_sospetto_diagnostico;
    }

    public void setCasi_da_sospetto_diagnostico(String casi_da_sospetto_diagnostico) {
        this.casi_da_sospetto_diagnostico = casi_da_sospetto_diagnostico;
    }

    public String getCasi_da_screening() {
        return this.casi_da_screening;
    }

    public void setCasi_da_screening(String casi_da_screening) {
        this.casi_da_screening = casi_da_screening;
    }

    public String getTotale_casi() {
        return this.totale_casi;
    }

    public void setTotale_casi(String totale_casi) {
        this.totale_casi = totale_casi;
    }

    public String getTamponi() {
        return this.tamponi;
    }

    public void setTamponi(String tamponi) {
        this.tamponi = tamponi;
    }

    public String getCasi_testati() {
        return this.casi_testati;
    }

    public void setCasi_testati(String casi_testati) {
        this.casi_testati = casi_testati;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIngressi_terapia_intensiva() {
        return this.ingressi_terapia_intensiva;
    }

    public void setIngressi_terapia_intensiva(String ingressi_terapia_intensiva) {
        this.ingressi_terapia_intensiva = ingressi_terapia_intensiva;
    }

    public String getNote_test() {
        return this.note_test;
    }

    public void setNote_test(String note_test) {
        this.note_test = note_test;
    }

    public String getNote_casi() {
        return this.note_casi;
    }

    public void setNote_casi(String note_casi) {
        this.note_casi = note_casi;
    }

    public String getTotale_positivi_test_molecolare() {
        return this.totale_positivi_test_molecolare;
    }

    public void setTotale_positivi_test_molecolare(String totale_positivi_test_molecolare) {
        this.totale_positivi_test_molecolare = totale_positivi_test_molecolare;
    }

    public String getTotale_positivi_test_antigenico_rapido() {
        return this.totale_positivi_test_antigenico_rapido;
    }

    public void setTotale_positivi_test_antigenico_rapido(String totale_positivi_test_antigenico_rapido) {
        this.totale_positivi_test_antigenico_rapido = totale_positivi_test_antigenico_rapido;
    }

    public String getTamponi_test_molecolare() {
        return this.tamponi_test_molecolare;
    }

    public void setTamponi_test_molecolare(String tamponi_test_molecolare) {
        this.tamponi_test_molecolare = tamponi_test_molecolare;
    }

    public String getTamponi_test_antigenico_rapido() {
        return this.tamponi_test_antigenico_rapido;
    }

    public void setTamponi_test_antigenico_rapido(String tamponi_test_antigenico_rapido) {
        this.tamponi_test_antigenico_rapido = tamponi_test_antigenico_rapido;
    }
}