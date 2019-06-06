import java.awt.*;

public class BlueArrow2 extends  Sprite {

    public BlueArrow2(int x, int y, int direction) {
        super(x, y, direction);
        setPic("BlueArrow.png",SOUTH);
        setSpeed(5);
    }


    @Override
    public void update() {
        super.update();
        if (getLoc().x > Main.FRAMEWIDTH)
            setLoc(new Point(0, getLoc().y));
    }
}


