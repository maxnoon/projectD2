package doolhof;

import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Author: http://forum.codecall.net/topic/63862-maze-tutorial/
 */

public class Spel
{
    public static void main(String[] args)
    {
        //Maak speler, panel
        Speler speler=new Speler();
        JComponent doolhof=new Doolhof(speler);
        JPanel panel=new JPanel();

        //Maak frame en voeg content toe
   
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440, 460);
        frame.getContentPane().add(doolhof);
        frame.setTitle("doolhof");
        frame.setVisible(true);
        frame.add(panel);

        //start keylistener
        KeyListener listener=new PressListener(doolhof, speler);
        frame.addKeyListener(listener);
        doolhof.addKeyListener(listener);
        frame.validate();
        frame.repaint();           
    }
}
