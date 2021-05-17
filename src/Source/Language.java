package Source;

public class Language {
    String title;
    String p , m , g , ti, r , t , nc , d, tot, tem, dateLbl , r_c_s, i_d;
    /**
     * Constructor
     * @param p , m , g , ti, r , t , nc , d, tot, tem, dateLbl
     */
    public Language(String title, String p, String m, String g, String ti, String r, String t, String nc, String d, String tot, String tem, String dateLbl , String rcs , String i_d) {
        super();
        this.title = title;
        this.p = p;
        this.m = m;
        this.g = g;
        this.ti = ti;
        this.r = r;
        this.t = t;
        this.nc = nc;
        this.d = d;
        this.tot = tot;
        this.tem = tem;
        this.dateLbl = dateLbl;
        this.r_c_s = rcs;
        this.i_d = i_d;
    }

    /**
     * Clear constructor
     * @param title
     */
    public Language(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getTi() {
        return ti;
    }

    public void setTi(String ti) {
        this.ti = ti;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getNc() {
        return nc;
    }

    public void setNc(String nc) {
        this.nc = nc;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getTot() {
        return tot;
    }

    public void setTot(String tot) {
        this.tot = tot;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getDateLbl() {
        return dateLbl;
    }

    public void setDateLbl(String dateLbl) {
        this.dateLbl = dateLbl;
    }

    public String getR_c_s() {
        return r_c_s;
    }

    public void setR_c_s(String r_c_s) {
        this.r_c_s = r_c_s;
    }

    public String getI_d() {
        return i_d;
    }

    public void setI_d(String i_d) {
        this.i_d = i_d;
    }
}
