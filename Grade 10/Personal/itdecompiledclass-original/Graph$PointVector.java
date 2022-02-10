//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.Enumeration;
import java.util.Vector;

class Graph$PointVector {
    protected static final int X = 0;
    protected static final int Y = 1;
    private Vector points;

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

    Graph$PointVector(Graph var1) {
        this.this$0 = var1;
        this.points = new Vector();
    }
}
