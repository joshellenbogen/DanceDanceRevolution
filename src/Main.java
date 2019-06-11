import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
 
//TODO: Josh Ellenbogen, Alex Kashian

public class Main extends JPanel {

    //instance fields for the general environment
    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;
    private Timer timer;
    private boolean[] keys;
    private Sprite arrow1, arrow2, arrow3, arrow4;
    private ArrayList<ArrowSpawner> arrowSpawners;
    private javafx.scene.media.MediaPlayer mediaPlayer;
    private boolean a1, a2, a3, a4;

    public Main() {
        keys = new boolean[512];

        arrowSpawners = new ArrayList();

        arrowSpawners.add(new ArrowSpawner(20, 20, ArrowSpawner.WEST));
        arrowSpawners.add(new ArrowSpawner(220, 20, ArrowSpawner.SOUTH));
        arrowSpawners.add(new ArrowSpawner(440, 20, ArrowSpawner.NORTH));
        arrowSpawners.add(new ArrowSpawner(660, 20, ArrowSpawner.EAST));

        arrow1 = new BlackArrow(20, 20, Sprite.WEST);
        arrow2 = new BlackArrow(220, 20, Sprite.SOUTH);
        arrow3 = new BlackArrow(440, 20, Sprite.NORTH);
        arrow4 = new BlackArrow(660, 20, Sprite.EAST);

        timer = new Timer(40, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                repaint();
            }
        });
        JFXPanel fxPanel = new JFXPanel();
        String aLot = "./res/ALot.mp3";
        String love = "./res/ILoveIt.mp3";
        Media song = new Media(new File(aLot).toURI().toString());
        mediaPlayer = new MediaPlayer(song);
        mediaPlayer.play();

        timer.start();

        Timer spawnArrows = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrowSpawners.get(new Random().nextInt(4)).spawn();
            }
        });

        spawnArrows.start();

        setKeyListener();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 1000, 800);

        for (int i = 10; i < 1000; i += 50) {
            for (int j = 10; j < 800; j += 50) {
                g2.setColor(new Color(255, 218, 33));
                g2.fillRect(i, j, 20, 20);


            }

        }
        arrow1.draw(g2);
        arrow2.draw(g2);
        arrow3.draw(g2);
        arrow4.draw(g2);

        for(ArrowSpawner arrowSpawner : arrowSpawners){
            arrowSpawner.draw(g2);
        }

        }

        public void setKeyListener () {
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent keyEvent) {/*intentionally left blank*/ }

                //when a key is pressed, its boolean is switch to true.
                @Override
                public void keyPressed(KeyEvent keyEvent) {
                    keys[keyEvent.getKeyCode()] = true;

                    int count = 0;
                    if (keyEvent.VK_LEFT == keyEvent.getKeyCode()){
                        a1 = true;
                    }
                    if (keyEvent.VK_DOWN == keyEvent.getKeyCode()){
                        a2 = true;
                    }
                    if (keyEvent.VK_UP == keyEvent.getKeyCode()){
                        a3 = true;
                    }
                    if (keyEvent.VK_RIGHT == keyEvent.getKeyCode()){
                        a4 = true;
                    }

                    for (Sprite spr : arrowSpawners) {
                        if (a1 == true && spr.getLoc().y >0 && spr.getLoc().y < 70)
                            count++;
                        if (a2 == true && spr.getLoc().y >0 && spr.getLoc().y < 70)
                            count++;
                        if (a3 == true && spr.getLoc().y >0 && spr.getLoc().y < 70)
                            if(spr.getLoc().x < 460 && spr.getLoc().x > 420)
                                count++;
                        if (a4 == true && spr.getLoc().y >0 && spr.getLoc().y < 70)
                            count++;

                        System.out.println(count);

                    }


                    a1 = false;
                    a2 = false;
                    a3 = false;
                    a4 = false;
                }

                //when a key is released, its boolean is switched to false.
                @Override
                public void keyReleased(KeyEvent keyEvent) {
                    keys[keyEvent.getKeyCode()] = false;
                }
            });
        }
        //sets ups the panel and frame.  Probably not much to modify here.
        public static void main (String[]args){
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