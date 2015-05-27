package doolhof;

import javax.swing.JLabel;

/*
 * Author: http://forum.codecall.net/topic/63862-maze-tutorial/
 */
public class Speler {

    private Tegel locatie;
    private Speler speler;
    
    //Getter
    public Tegel getLocatie() {
        return locatie;
    }
    
    //Setter
    public void setLocatie(Tegel Locatie) {
        this.locatie = Locatie;
    }

    //Movement
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
