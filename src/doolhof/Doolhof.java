package doolhof;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;

/*
 * @author http://forum.codecall.net/topic/63862-maze-tutorial/
 */
public class Doolhof extends JComponent {
    // the maze can be seen as a matrix of squares so well use a multidimensional array of the room 
    // class

    private Tegel[][] tegels;// the maze can be seen as a matrix of squares so well use
    private ArrayList<Muur> muren; // List of muren
    private Random rand;// We are going to have to randomize the tegels chosen to unionize
    private final int hoogte = 20;// users desired height of matrix 
    private final int breedte = 20;// users desired breedte of matrix
    private int num;// we will have to increment a few times so lets just use num as an incrementor
    private int[] set;
    private int x_cord; // x-axis rep
    private int y_cord;// y-axis rep
    private final int kamerGrote = 20;
    private int randommuur;
    private Speler speler;
    private int roomNumber = 0;

    public Doolhof(Speler speler)
    {
        this.speler = speler;
        tegels = new Tegel[hoogte][breedte];
        muren = new ArrayList<>((hoogte - 1) * (breedte - 1));
        maakRandomDoolhof();
        setPreferredSize(new Dimension(800, 700));
    }

    private void maakRandomDoolhof() 
    {
        maakKamer();// see next method

        initSet(breedte * hoogte);
        rand = new Random(); // here is the random room generator
        num = breedte * hoogte;

        while (num > 1) 
        {
            // when we pick a random muur we want to avoid the borders getting eliminated
            randommuur = rand.nextInt(muren.size());
            Muur temp = muren.get(randommuur);
            // we will pick two tegels randomly 
            int roomA = temp.getCurrentRoom().getY() + temp.getCurrentRoom().getX() * breedte;
            int roomB = temp.getNextRoom().getY() + temp.getNextRoom().getX() * breedte;

            // check roomA and roomB to see if they are already members 
            if (find(roomA) != find(roomB)) 
            {
                muren.remove(randommuur);
                unionRooms(find(roomA), find(roomB));
                temp.setIsGone(true);
                temp.getCurrentRoom().getBuren().add(temp.getNextRoom());
                temp.getNextRoom().getBuren().add(temp.getCurrentRoom());
                num--;
            }// end of if
        }// end of while
        tegels[0][0].setSpeler(speler);
        speler.setLocatie(tegels[0][0]);
        
    }



    /**
     * Sets the grid of tegels to be initially boxes This is self explanitory,
     * we are only creating an reverse L for all The tegels and there is an L
     * for the border
     */
    private void maakKamer()
    {
        for (int i = 0; i < hoogte; i++) 
        {
            for (int j = 0; j < breedte; j++)
            {
                // create north muren
                tegels[i][j] = new Tegel(i, j);
                if (i == 0)
                {
                    tegels[i][j].setMuurN(new Muur(tegels[i][j]));
                } 
                else
                {
                    tegels[i][j].setMuurN(new Muur(tegels[i - 1][j], tegels[i][j]));
                    muren.add(tegels[i][j].getMuurN());
                    tegels[i][j].setTegelN(tegels[i - 1][j]);
                    tegels[i - 1][j].setTegelS(tegels[i][j]);
                }
                if (i == hoogte - 1) 
                {
                    tegels[i][j].setSouth(new Muur(tegels[i][j]));
                }
                if (j == 0) 
                {
                    tegels[i][j].setWest(new Muur(tegels[i][j]));
                } 
                else
                {
                    tegels[i][j].setWest(new Muur(tegels[i][j - 1], tegels[i][j]));
                    muren.add(tegels[i][j].getWest());
                    tegels[i][j].setWestBuur(tegels[i][j - 1]);
                    tegels[i][j - 1].setTegelE(tegels[i][j]);
                }
                if (j == breedte - 1)
                {
                    tegels[i][j].setMuurE(new Muur(tegels[i][j]));
                }
                tegels[i][j].setRoomName(roomNumber++);// we will name the tegels
            }
        }
        // initalize entrance and exit
        // this is just saying the roomName for top left is 0 
        tegels[0][0].setRoomName(0);
        // this is just saying the roomName for bottom right is the last element in the mxn room matrix
        tegels[hoogte - 1][breedte - 1].setRoomName(hoogte * breedte);
    }

    @Override
    public void paintComponent(Graphics g) 
    {
        x_cord = 10;
        y_cord = 10;


        // temp variables used for painting
        int x = x_cord;
        int y = y_cord;

        for (int i = 0; i <= hoogte - 1; i++)
        {
            for (int j = 0; j <= breedte - 1; j++)
            {
                if (!(tegels[i][j].getMuurN().getIsGone()))
                {
                    g.drawLine(x, y, x + kamerGrote, y);
                }//end of north if
                // west muur not there draw the line
                if (tegels[i][j].getWest().getIsGone() == false)
                {
                    g.drawLine(x, y, x, y + kamerGrote);
                }// end of west if
                if ((i == hoogte - 1) && tegels[i][j].getSouth().getIsGone() == false)
                {
                    g.drawLine(x, y + kamerGrote, x + kamerGrote,
                            y + kamerGrote);
                }// end of south if
                if ((j == breedte - 1) && tegels[i][j].getMuurE().getIsGone() == false)
                {
                    g.drawLine(x + kamerGrote, y, x + kamerGrote,
                            y + kamerGrote);
                }// end of east if
                if (tegels[i][j].getSpeler() != null) 
                {
                    g.setColor(Color.red);
                    g.fillRect(x + kamerGrote / 4, y + kamerGrote / 4, kamerGrote / 2, kamerGrote / 2);
                    g.setColor(Color.black);
                    //waarom zit het tekenen van het doolhof gekoppeld aan het tekenen van de speler
                }//tekent speler

                x += kamerGrote;// change the horizontal
            }// end of inner for loop
            x = x_cord;
            y += kamerGrote;
        }// end of outer for loop
    }

    private int find(int r)
    {
        if (set[r] < 0)
        {
            return r;
        } 
        else
        {
            return set[r] = find(set[r]);
        }
    }// end of find
    private void initSet(int elem)
    {
        set = new int[elem];
      // initialize every element in the set
      for(int i = 0; i < set.length; i++)
      {
         set[i] = -1;
      }
    }
    private void unionRooms(int roomA, int roomB)
    {
        if (set[roomB] < set[roomA])
        {
            set[roomA] = roomB;
        }
        else
        {
            if (set[roomA] == set[roomB])
            {
                set[roomA]--;
            }
            set[roomB] = roomA;
        }
    }// end of union rooms

    public ArrayList<Tegel> getLijstTegels()
    {
        ArrayList<Tegel> lijst=new ArrayList<>();
        for (int i = 0; i < hoogte-1; i++)
        {
            for (int j = 0; j < breedte-1; j++)
            {
               lijst.add(tegels[i][j]);
                
            }
            
        }
        return lijst;
        
    }
    
}// END OF CLASS 
