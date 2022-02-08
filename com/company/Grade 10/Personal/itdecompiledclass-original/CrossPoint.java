//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.Graphics;

public final class CrossPoint extends PointShape {
    public final void drawPoint(Graphics var1, int var2, int var3) {
        var1.drawLine(var2, var3 - super.height / 2, var2, var3 + super.height / 2);
        var1.drawLine(var2 - super.width / 2, var3, var2 + super.width / 2, var3);
    }

    public CrossPoint() {
    }

    public CrossPoint(byte var1) {
        super(var1);
    }
}
