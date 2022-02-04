//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.Graphics;

public abstract class PointShape {
    public static final byte TRIANGLE = 1;
    public static final byte CIRCLE = 2;
    public static final byte SQUARE = 3;
    public static final byte CROSS = 4;
    public static final byte NONE = 5;
    public static final byte FILLED = 17;
    public static final byte UNFILLED = 18;
    protected byte style = 17;
    protected int width = 10;
    protected int height = 10;

    public void setSize(int var1, int var2) {
        this.width = var1;
        this.height = var2;
    }

    protected void setStyle(byte var1) {
        switch(var1) {
        case 17:
            this.style = 17;
            return;
        case 18:
            this.style = 18;
            return;
        default:
        }
    }

    public abstract void drawPoint(Graphics var1, int var2, int var3);

    PointShape() {
    }

    PointShape(byte var1) {
        this.style = (byte)(var1 == 18 ? 18 : 17);
    }
}
