/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.util.LinkedList;
import java.util.List;
//http://forum.codecall.net/topic/63862-maze-tutorial/
public class Tegel {
    // represent four muurs

    private Muur muurN, muurE, muurS, muurW; // the muur class will be created next
    private int x, y; // represent the row and column of the maze
    private List<Tegel> buren; // adjacency list using linked list
    private int roomName; // for this the room will be a number
    private Speler speler;
    private Tegel tegelN, tegelE, tegelS, tegelW;
    public void setRoomName(int roomName) {
        this.roomName = roomName;
    }
    private Tegel prev; // last room pointer

    public List<Tegel> getBuren() {
        return buren;
    }

    public Tegel getTegelE() {
        return tegelE;
    }

    public void setTegelE(Tegel tegelE) {
        this.tegelE = tegelE;
    }

    public Tegel getTegelN() {
        return tegelN;
    }

    public void setTegelN(Tegel tegelN) {
        this.tegelN = tegelN;
    }

    public Tegel getTegelS() {
        return tegelS;
    }

    public void setTegelS(Tegel tegelS) {
        this.tegelS = tegelS;
    }

    public Tegel getWestBuur() {
        return tegelW;
    }

    public void setWestBuur(Tegel westBuur) {
        this.tegelW = westBuur;
    }

    public void setburen(List<Tegel> buren) {
        this.buren = buren;
    }

    public Muur getMuurE() {
        return muurE;
    }

    public void setMuurE(Muur muurE) {
        this.muurE = muurE;
    }

    public Muur getMuurN() {
        return muurN;
    }

    public void setMuurN(Muur muurN) {
        this.muurN = muurN;
    }

    public Tegel getPrev() {
        return prev;
    }

    public void setPrev(Tegel prev) {
        this.prev = prev;
    }

    public Muur getSouth() {
        return muurS;
    }

    public void setSouth(Muur south) {
        this.muurS = south;
    }

    public Muur getWest() {
        return muurW;
    }

    public void setWest(Muur west) {
        this.muurW = west;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }


    // now we code the constructer 
    public Tegel(int x, int y) {
        this.x = x;// row
        this.y = y;// column
        buren = new LinkedList<>();
        prev = null;// we have not progressed, so prev is nothing
        roomName = 0;// we will use the concept of arrays start 0
    }// end of constructor

    // we have to increment the room name so lets do it
    public int getRoomName() {
        return roomName++;
    }// end of getRoomName()
}