//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.Enumeration;
import java.util.Vector;

public class Graph extends Graphable {
    protected static final int X = 0;
    protected static final int Y = 1;
    protected Graph.PointVector points;
    protected Enumeration coords;
    protected PointShape shape;
    protected boolean drawPoints = true;

    public void setDrawingStyle(byte var1) {
        if (var1 == 1 && this.shape.getClass().getName().equals("essential.NoPoint")) {
            this.setPointShape((byte)3);
            this.shape.setSize(1, 1);
        }

        super.setDrawingStyle(var1);
    }

    public void setPointShape(PointShape var1) {
        this.shape = var1;
        Graphable.grapher.pushChanges();
    }

    public void setDrawPoints(boolean var1) {
        this.drawPoints = var1;
        Graphable.grapher.pushChanges();
    }

    public void setPointShape(byte var1) {
        switch(var1) {
        case 1:
            this.shape = new TrianglePoint((byte)17);
            return;
        case 2:
            this.shape = new CirclePoint((byte)17);
            return;
        case 3:
            this.shape = new SquarePoint((byte)17);
            return;
        case 4:
            this.shape = new CrossPoint();
            return;
        case 5:
            this.shape = new NoPoint();
            return;
        default:
            Graphable.grapher.pushChanges();
        }
    }

    public void setDrawShape(boolean var1) {
        this.drawPoints = var1;
        Graphable.grapher.pushChanges();
    }

    public void addPoint(Double var1) {
        this.points.addElement(var1);
        Graphable.grapher.pushChanges();
    }

    public void addPoint(double var1, double var3) {
        Double var5 = new Double(var1, var3);
        this.points.addElement(var5);
        Graphable.grapher.pushChanges();
    }

    public void replaceElements(double[][] var1) {
        this.points.replaceElements(var1);
        Graphable.grapher.pushChanges();
    }

    protected void evaluateXY(Double var1) {
        if (this.coords != null && this.coords.hasMoreElements()) {
            Double var2 = (Double)this.coords.nextElement();
            var1.x = var2.x;
            var1.y = var2.y;
        } else {
            var1 = null;
        }
    }

    public void drawGraph(Graphics var1, GraphPanel var2) {
        double var3 = var2.xMin;
        double var5 = var2.yMin;
        double var7 = var2.xMax;
        double var9 = var2.yMax;
        double var11 = var2.xPixelIncrement;
        double var13 = var2.yPixelIncrement;
        var1.setClip(0, 0, var2.width - 80, var2.height - 80);
        this.coords = this.points.getPoints();
        int var15 = 0;
        int var16 = 0;
        boolean var17 = false;
        boolean var18 = false;
        var1.setColor(super.graphColor);
        if (super.drawingStyle == 0) {
            this.evaluateXY(super.p);
            if (super.p == null) {
                return;
            }

            var15 = (int)((super.p.x - var3) / var11);
            var15 = Math.abs(var15);
            var16 = (int)((var9 - super.p.y) / var13);
            if (this.drawPoints) {
                this.shape.drawPoint(var1, var15, var16);
            }

            while(this.coords.hasMoreElements()) {
                this.evaluateXY(super.p);
                if (super.p == null) {
                    return;
                }

                int var19 = (int)((super.p.x - var3) / var11);
                int var20 = (int)((var9 - super.p.y) / var13);
                var1.drawLine(var15, var16, var19, var20);
                if (this.drawPoints) {
                    this.shape.drawPoint(var1, var19, var20);
                }

                var15 = var19;
                var16 = var20;
            }
        } else {
            while(this.coords.hasMoreElements()) {
                this.evaluateXY(super.p);
                if (super.p == null) {
                    return;
                }

                var15 = (int)((super.p.x - var3) / var11);
                var16 = (int)((var9 - super.p.y) / var13);
                this.shape.drawPoint(var1, var15, var16);
            }
        }

        this.coords = null;
        if (super.drawTitle) {
            var15 -= var1.getFontMetrics().stringWidth(super.title) + 10;
            var1.drawString(super.title, var15, var16);
        }

    }

    public Graph() {
        super((byte)2);
        Graph.PointVector var10001 = new Graph.PointVector;
        if (this == null) {
            throw null;
        } else {
            var10001.<init>();
            this.points = var10001;
            this.shape = new NoPoint();
            Graphable.grapher.pushChanges();
        }
    }

    public Graph(double[][] var1) {
        super((byte)2);
        Graph.PointVector var10001 = new Graph.PointVector;
        if (this == null) {
            throw null;
        } else {
            var10001.<init>();
            this.points = var10001;
            this.points.add(var1);
            this.shape = new NoPoint();
            Graphable.grapher.pushChanges();
        }
    }

    private class PointVector {
        protected static final int X = 0;
        protected static final int Y = 1;
        private Vector points = new Vector();

        public void addElement(Point2D var1) {
            this.points.addElement(var1);
        }

        public Point2D elementAt(int var1) {
            return (Point2D)this.points.elementAt(var1);
        }

        public void add(double[][] var1) {
            int var2 = var1.length;

            for(int var4 = 0; var4 < var2; ++var4) {
                Double var3 = new Double(var1[var4][0], var1[var4][1]);
                this.addElement(var3);
            }

        }

        public void replaceElements(double[][] var1) {
            this.points.removeAllElements();
            this.add(var1);
        }

        public Enumeration getPoints() {
            return this.points.elements();
        }

        PointVector() {
        }
    }
}
