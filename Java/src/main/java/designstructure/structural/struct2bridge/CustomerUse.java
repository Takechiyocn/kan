package designstructure.structural.struct2bridge;

import designstructure.structural.struct2bridge.colorif.impl.Green;
import designstructure.structural.struct2bridge.colorif.impl.Red;
import designstructure.structural.struct2bridge.colorif.impl.Yellow;
import designstructure.structural.struct2bridge.shapeif.impl.Rectangle;
import designstructure.structural.struct2bridge.shapeif.impl.Round;
import designstructure.structural.struct2bridge.shapeif.impl.Triangle;

/**
 * @ClassName CustomerUse
 * @Description
 * @Author moku
 * @Date 2022/12/22 16:58
 * @Version 1.0
 */
public class CustomerUse {
    public static void main(String[] args) {

        Rectangle r = new Rectangle();
        r.setColor(new Red());
        r.draw();

        Round rd = new Round();
        rd.setColor(new Green());
        rd.draw();

        Triangle t = new Triangle();
        t.setColor(new Yellow());
        t.draw();
    }
}
