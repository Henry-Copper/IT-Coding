//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;

public abstract class Graphable {
    public static final byte LINEAR = 0;
    public static final byte PARABOLA = 1;
    public static final byte POINT = 2;
    public static final byte TRIG = 3;
    public static final byte EXPONENTIAL = 4;
    public static GraphFrame grapher = new GraphFrame();
    public static final byte CONTINUOUS = 0;
    public static final byte PLOTPOINTS = 1;
    protected boolean drawTitle;
    protected Double p;
    protected boolean userSetAxes = false;
    protected String title;
    protected Color graphColor;
    protected boolean NaN;
    protected byte mainType;
    protected byte drawingStyle;

    public void removeGraph() {
        grapher.removeGraph(this);
        grapher.pushChanges();
    }

    public void setDrawingStyle(byte var1) {
        if (var1 == 1) {
            this.drawingStyle = 1;
        } else {
            this.drawingStyle = 0;
            grapher.pushChanges();
        }
    }

    public final void setAxes(double var1, double var3, double var5, double var7) {
        grapher.setAxes(var1, var3, var5, var7);
        this.userSetAxes = true;
        grapher.pushChanges();
    }

    public final double[] getAxisValues() {
        return grapher.getAxisValues();
    }

    public final void setAxisLabels(String var1, String var2) {
        grapher.setAxisLabels(var1, var2);
        grapher.pushChanges();
    }

    public final void setTitle(String var1) {
        this.title = var1;
        grapher.pushChanges();
    }

    public final void setDrawTitle(boolean var1) {
        this.drawTitle = var1;
        grapher.pushChanges();
    }

    public final void setColor(Color var1) {
        this.graphColor = var1;
        grapher.pushChanges();
    }

    public void drawGraph(Graphics var1, GraphPanel var2) {
        double var3 = var2.xMin;
        double var5 = var2.yMin;
        double var7 = var2.xMax;
        double var9 = var2.yMax;
        double var11 = var2.xPixelIncrement;
        double var13 = var2.yPixelIncrement;
        int var15 = var2.width - 80;
        this.p.x = var3;
        this.evaluateXY(this.p);
        int var16 = 0;
        int var17 = (int)((var9 - this.p.y) / var13);
        int var18 = 0;
        int var19 = 0;
        var1.setColor(this.graphColor);

        for(int var20 = 0; var20 <= var15; ++var20) {
            var18 = var20;
            this.p.x = var3 + (double)var20 * var11;
            this.evaluateXY(this.p);
            var19 = (int)((var9 - this.p.y) / var13);
            if (java.lang.Double.isNaN(this.p.y)) {
                System.out.println("NAN at " + var20);
                this.NaN = true;
            } else {
                var1.setColor(this.graphColor);
                if (this.NaN) {
                    var16 = var20;
                    var17 = var19;
                    this.NaN = false;
                }

                if (this.drawingStyle == 0) {
                    var1.drawLine(var16, var17, var20, var19);
                } else {
                    var1.drawLine(var20, var19, var20, var19);
                }

                var16 = var20;
                var17 = var19;
            }
        }

        if (this.drawTitle) {
            Rectangle2D var21 = var1.getFontMetrics().getStringBounds(this.title, var1);
            var18 = (int)((double)var18 - (var21.getWidth() + 10.0D));
            var19 = (int)((double)var19 + var21.getHeight() + 10.0D);
            var1.drawString(this.title, var18, var19 < 0 ? 10 : var19);
        }

    }

    abstract void evaluateXY(Double var1);

    Graphable(byte var1) {
        this.mainType = var1;
        this.drawingStyle = 0;
        this.p = new Double();
        this.graphColor = Color.blue;
        this.title = "No Title";
        grapher.addGraph(this);
        grapher.pushChanges();
    }
}
