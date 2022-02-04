//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.Graphics;

public final class TrianglePoint extends PointShape {
    protected static final int NUMPOINTS = 3;
    private int[] xpoints = new int[3];
    private int[] ypoints = new int[3];

    public final void drawPoint(Graphics var1, int var2, int var3) {
        this.xpoints[0] = var2;
        this.ypoints[0] = var3 - super.height / 2;
        this.xpoints[1] = var2 - super.width / 2;
        this.ypoints[1] = var3 + super.height / 2;
        this.xpoints[2] = var2 + super.width / 2;
        this.ypoints[2] = var3 + super.height / 2;
        switch(super.style) {
        case 17:
            var1.fillPolygon(this.xpoints, this.ypoints, 3);
            return;
        case 18:
            var1.drawPolygon(this.xpoints, this.ypoints, 3);
            return;
        default:
        }
    }

    public TrianglePoint() {
    }

    public TrianglePoint(byte var1) {
        super(var1);
    }
}
