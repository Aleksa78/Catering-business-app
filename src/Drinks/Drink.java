/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drinks;

/**
 *
 * @author Incognito
 */
public abstract class Drink {
    private int cena;
    private String naziv;
    
    public abstract String getTip();

    public Drink(String naziv, int cena) {
        this.cena = cena;
        this.naziv = naziv;
    }

    public int getCena() {
        return cena;
    }
    
    public void setCena(int cena) {
        this.cena = cena;
    }
 
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Drink{" + "naziv=" + naziv + ", cena=" + cena + '}';
    }
    
    
}
