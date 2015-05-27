/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;

/*
 * Author: http://forum.codecall.net/topic/63862-maze-tutorial/
 */

public class PressListener implements KeyListener {
    
    private JComponent comp;
    private Speler speler;
    public PressListener(JComponent comp, Speler speler) {
        this.comp = comp;
        this.speler=speler;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            speler.move("up");
            comp.repaint();
        }
        if (key == KeyEvent.VK_DOWN) {
            speler.move("down");
            comp.repaint();
        }
        if (key == KeyEvent.VK_LEFT) {
            speler.move("left");
            comp.repaint();
        }
        if (key == KeyEvent.VK_RIGHT) {
            speler.move("right");
            comp.repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
