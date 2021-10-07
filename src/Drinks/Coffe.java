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
public class Coffe extends Drink{

     public static final String TIP = "Coffe";

    public static String getTIP() {
        return TIP;
    }

    public Coffe(int cena, String naziv) {
        super(naziv, cena);
    }
     
    @Override
    public String getTip() {
       return TIP;
    }
    
}
