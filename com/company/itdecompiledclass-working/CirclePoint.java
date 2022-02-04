//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.Graphics;

public final class CirclePoint extends PointShape {
    public final void drawPoint(Graphics var1, int var2, int var3) {
        switch(super.style) {
        case 17:
            var1.fillOval(var2 - super.width / 2, var3 - super.height / 2, super.width, super.height);
            return;
        case 18:
            var1.drawOval(var2 - super.width / 2, var3 - super.height / 2, super.width, super.height);
            return;
        default:
        }
    }

    public CirclePoint(byte var1) {
        super(var1);
    }
}
