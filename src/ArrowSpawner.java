import java.awt.*;
import java.util.ArrayList;

public class ArrowSpawner extends Sprite {

    private int arrowSpeed;
    private ArrayList<BlueArrows> arrows;

    public ArrowSpawner(int x, int y, int dir){
        super(x, y, dir);
        this.arrowSpeed = arrowSpeed;
        arrows = new ArrayList<>();
    }

//    public void update(Graphics2D g2){
//        for(BlueArrows arrow : arrows){
//            arrow.draw(g2);
//        }
//    }

    public BlueArrows spawn(){
        return new BlueArrows(getLoc().x, getLoc().y, getDir());

    }


}
