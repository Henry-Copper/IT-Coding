//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.geom.Point2D.Double;

public class LineGraph extends Graphable {
    protected double gradient = 1.0D;
    protected double intercept = 0.0D;

    public final void setGradient(double var1) {
        this.gradient = var1;
        Graphable.grapher.pushChanges();
    }

    public final void setIntercept(double var1) {
        this.intercept = var1;
        Graphable.grapher.pushChanges();
    }

    public final void setLinearParams(double var1, double var3) {
        this.gradient = var1;
        this.intercept = var3;
        Graphable.grapher.pushChanges();
    }

    protected final void evaluateXY(Double var1) {
        var1.y = this.gradient * var1.x + this.intercept;
    }

    public LineGraph() {
        super((byte)0);
    }

    public LineGraph(double var1, double var3) {
        super((byte)0);
        this.gradient = var1;
        this.intercept = var3;
        Graphable.grapher.pushChanges();
    }
}
