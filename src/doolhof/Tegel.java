package doolhof;

import java.util.LinkedList;
import java.util.List;

/*
 * Author: http://forum.codecall.net/topic/63862-maze-tutorial/
 */

public class Tegel {
    
    //Een tegel bestaat uit vier muren
    private Muur muurN, muurE, muurS, muurW; // the muur class will be created next
    private int x, y; // represent the row and column of the maze
    private List<Tegel> buren; // adjacency list using linked list
    private int roomName; // for this the room will be a number
    private Speler speler;
    private Tegel tegelN, tegelE, tegelS, tegelW;
    private Tegel prev; // last room pointer
    
    //Getter / Setter
    public void setRoomName(int roomName) 
    {
        this.roomName = roomName;
    }
    
    public List<Tegel> getBuren()
    {
        return buren;
    }

    public Tegel getTegelE() 
    {
        return tegelE;
    }

    public void setTegelE(Tegel tegelE)
    {
        this.tegelE = tegelE;
    }

    public Tegel getTegelN() 
    {
        return tegelN;
    }

    public void setTegelN(Tegel tegelN)
    {
        this.tegelN = tegelN;
    }

    public Tegel getTegelS()
    {
        return tegelS;
    }

    public void setTegelS(Tegel tegelS)
    {
        this.tegelS = tegelS;
    }

    public Tegel getWestBuur() 
    {
        return tegelW;
    }

    public void setWestBuur(Tegel westBuur)
    {
        this.tegelW = westBuur;
    }

    public void setburen(List<Tegel> buren)
    {
        this.buren = buren;
    }

    public Muur getMuurE()
    {
        return muurE;
    }

    public void setMuurE(Muur muurE) 
    {
        this.muurE = muurE;
    }

    public Muur getMuurN() 
    {
        return muurN;
    }

    public void setMuurN(Muur muurN)
    {
        this.muurN = muurN;
    }

    public Tegel getPrev()
    {
        return prev;
    }

    public void setPrev(Tegel prev)
    {
        this.prev = prev;
    }

    public Muur getSouth()
    {
        return muurS;
    }

    public void setSouth(Muur south) 
    {
        this.muurS = south;
    }

    public Muur getWest()
    {
        return muurW;
    }

    public void setWest(Muur west)
    {
        this.muurW = west;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y) 
    {
        this.y = y;
    }

    public Speler getSpeler() 
    {
        return speler;
    }

    public void setSpeler(Speler speler)
    {
        this.speler = speler;
    }


    //Constructor
    public Tegel(int x, int y)
    {
        this.x = x;
        this.y = y;
        buren = new LinkedList<>();
        prev = null; //prev is null want er is nog niks veranderd dus er is geen prev
        roomName = 0; //array start 0
    }

    //Return de naam (maar uit een lijst dus index dus + 1 voor de correcte naam
    public int getRoomName()
    {
        return roomName++;
    }
}