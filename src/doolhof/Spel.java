/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

//http://forum.codecall.net/topic/63862-maze-tutorial/
public class Spel {
        public static void main(String[] args) {        
        // use JFrame to put the created panel o
        Speler speler=new Speler();
        JComponent doolhof=new Doolhof(speler);
        JPanel panel=new JPanel();
        
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.getContentPane().add(doolhof);
        frame.pack();
        frame.setVisible(true);
        frame.add(panel);
        
        KeyListener listener=new PressListener(doolhof, speler);
        frame.addKeyListener(listener);
        doolhof.addKeyListener(listener);
        frame.validate();
        frame.repaint();
            
    }// end of main
}
