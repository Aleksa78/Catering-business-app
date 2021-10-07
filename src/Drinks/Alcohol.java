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
public class Alcohol extends Drink {

     public static final String TIP = "Alcohol";

    public Alcohol(int cena, String naziv) {
        super(naziv, cena);
    }
    @Override
    public String getTip() {
        return TIP;
    }
    
}
