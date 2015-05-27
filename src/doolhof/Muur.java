package doolhof;

/*
 * @author http://forum.codecall.net/topic/63862-maze-tutorial/
 */
public class Muur
{   
   private Tegel currentRoom, nextRoom; 
   private boolean isGone = false;
   
   //Constructor tegel met buur
   public Muur(Tegel huidige, Tegel buur)
   {
      currentRoom = huidige;
      nextRoom = buur;
   }

   //Constructor tegel zonder buur
   public Muur(Tegel r)
   {
      currentRoom = r;
      nextRoom = null;
   }

    public Tegel getCurrentRoom()
    {
        return currentRoom;
    }

    public void setCurrentRoom(Tegel currentRoom)
    {
        this.currentRoom = currentRoom;
    }

    public boolean getIsGone()
    {
        return isGone;
    }

    public void setIsGone(boolean isGone)
    {
        this.isGone = isGone;
    }

    public Tegel getNextRoom()
    {
        return nextRoom;
    }

    public void setNextRoom(Tegel nextRoom)
    {
        this.nextRoom = nextRoom;
    }
}