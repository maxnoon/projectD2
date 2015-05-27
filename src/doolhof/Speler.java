/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import javax.swing.JLabel;

/**
 *
 * @author Chie-cheung
 */
public class Speler {

    private Tegel locatie;
    private Speler speler;

//http://forum.codecall.net/topic/63862-maze-tutorial/
    public Tegel getLokatie() {
        return locatie;
    }

    public void setLokatie(Tegel Lokatie) {
        this.locatie = Lokatie;
    }

    public void move(String richting) {
        if (richting.equals("up") && locatie.getMuurN().getIsGone()) {
            locatie.setSpeler(null);
            locatie.getTegelN().setSpeler(this);
            locatie=locatie.getTegelN();

        }
        if (richting.equals("left") && locatie.getWest().getIsGone()) {
            locatie.setSpeler(null);
            locatie.getWestBuur().setSpeler(this);
            locatie=locatie.getWestBuur();

        }
        if (richting.equals("down") && locatie.getTegelS().getMuurN().getIsGone()) {
            locatie.setSpeler(null);
            locatie.getTegelS().setSpeler(this);
            locatie=locatie.getTegelS();

        }
        if (richting.equals("right") && locatie.getTegelE().getWest().getIsGone()){
            locatie.setSpeler(null);
            locatie.getTegelE().setSpeler(this);
            locatie=locatie.getTegelE();

        }
       
    }
}
