import java.awt.*;

public class BlueArrow3 extends  Sprite {

    public BlueArrow3(int x, int y, int direction) {
        super(x, y, direction);
        setPic("BlueArrow.png", EAST);
        setSpeed(5);
    }


    @Override
    public void update() {
        super.update();
        if (getLoc().x > Main.FRAMEWIDTH)
            setLoc(new Point(0, getLoc().y));
    }
}


