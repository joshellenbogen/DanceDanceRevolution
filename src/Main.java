import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
 
//TODO: PUT YOUR NAME HERE
 
public class Main extends JPanel {
 
    //instance fields for the general environment
    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;
    private Timer timer;
    private boolean[] keys;
 
    public Main() {
        keys = new boolean[512]; //should be enough to hold any key code.

        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
 
                repaint();
            }
        });
        timer.start();
 
        setKeyListener();
 
    }
 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(0,0,1000,800);

        for (int i = 10; i < 1000; i+=50) {
            for (int j = 10; j < 800; j+=50) {
                g2.setColor(new Color(255,218,33));
                g2.fillRect(i,j,20,20);


            }

        }



    }

    public void setKeyListener() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {/*intentionally left blank*/ }
 
            //when a key is pressed, its boolean is switch to true.
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = true;
            }
 
            //when a key is released, its boolean is switched to false.
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = false;
            }
        });
    }
    //sets ups the panel and frame.  Probably not much to modify here.
    public static void main(String[] args) {
        JFrame window = new JFrame("Dance Bitch!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22); //(x, y, w, h) 22 due to title bar.
 
        Main panel = new Main();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);
 
        panel.setFocusable(true);
        panel.grabFocus();
 
        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}