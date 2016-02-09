package sk.ics.upjs.hikeapp;

import java.sql.Date;

public class Statistika {
    Long idS;
    
    Long idU;
    
    int pocetTur;
    
    double kmSpolu;
    
    double priemernaObtiaznost;
    
    int pocetFotiek;
        
    int spoluTurJar;
    
    int spoluTurLeto;
    
    int spoluTurJesen;
    
    int spoluTurZima;
    
    int pocetHodnoteni;
    
    double hodSpolu;
    
    double priemernaRychlost;
    
    Date vynulovanie;

    public Date getVynulovanie() {
        return vynulovanie;
    }

    public void setVynulovanie(Date vynulovanie) {
        this.vynulovanie = vynulovanie;
    }
    
    public Long getIdS() {
        return idS;
    }

    public void setIdS(Long idS) {
        this.idS = idS;
    }

    public Long getIdU() {
        return idU;
    }

    public void setIdU(Long idU) {
        this.idU = idU;
    }

    public int getPocetTur() {
        return pocetTur;
    }

    public void setPocetTur(int pocetTur) {
        this.pocetTur = pocetTur;
    }

    public double getKmSpolu() {
        return kmSpolu;
    }

    public void setKmSpolu(double kmSpolu) {
        this.kmSpolu = kmSpolu;
    }

    public double getPriemernaObtiaznost() {
        return priemernaObtiaznost;
    }

    public void setPriemernaObtiaznost(double priemernaObtiaznost) {
        this.priemernaObtiaznost = priemernaObtiaznost;
    }

    public int getPocetFotiek() {
        return pocetFotiek;
    }

    public void setPocetFotiek(int pocetFotiek) {
        this.pocetFotiek = pocetFotiek;
    }

    public int getSpoluTurJar() {
        return spoluTurJar;
    }

    public void setSpoluTurJar(int spoluTurJar) {
        this.spoluTurJar = spoluTurJar;
    }

    public int getSpoluTurLeto() {
        return spoluTurLeto;
    }

    public void setSpoluTurLeto(int spoluTurLeto) {
        this.spoluTurLeto = spoluTurLeto;
    }

    public int getSpoluTurJesen() {
        return spoluTurJesen;
    }

    public void setSpoluTurJesen(int spoluTurJesen) {
        this.spoluTurJesen = spoluTurJesen;
    }

    public int getSpoluTurZima() {
        return spoluTurZima;
    }

    public void setSpoluTurZima(int spoluTurZima) {
        this.spoluTurZima = spoluTurZima;
    }

    public int getPocetHodnoteni() {
        return pocetHodnoteni;
    }

    public void setPocetHodnoteni(int pocetHodnoteni) {
        this.pocetHodnoteni = pocetHodnoteni;
    }

    public double getHodSpolu() {
        return hodSpolu;
    }

    public void setHodSpolu(double hodSpolu) {
        this.hodSpolu = hodSpolu;
    }

    public double getPriemernaRychlost() {
        return priemernaRychlost;
    }

    public void setPriemernaRychlost(double priemernaRychlost) {
        this.priemernaRychlost = priemernaRychlost;
    }
}
