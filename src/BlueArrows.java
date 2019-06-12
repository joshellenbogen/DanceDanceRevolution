import java.awt.*;

public class BlueArrows extends Sprite {

    public BlueArrows(int x, int y, int direction) {
        super(x, y, direction);

        if(direction == NORTH){
            setPic("BlueArrow.png", NORTH);
            setDir(NORTH);
        }else if (direction == SOUTH){
            setPic("BlueArrow.png", SOUTH);
            setDir(NORTH);
        }else if(direction == EAST){
            setPic("BlueArrow.png", EAST);
            setDir(NORTH);

        }else if(direction == WEST){
            setPic("BlueArrow.png", WEST);
            setDir(NORTH);

        }

        setSpeed(10);
    }


    @Override
    public void update() {
        super.update();
        if (getLoc().x > Main.FRAMEWIDTH)
            setLoc(new Point(0, getLoc().y));
    }
}


