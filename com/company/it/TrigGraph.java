//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.geom.Point2D.Double;

public class TrigGraph extends Graphable {
    public static final byte SIN = 0;
    public static final byte ASIN = 1;
    public static final byte COS = 2;
    public static final byte ACOS = 3;
    public static final byte TAN = 4;
    public static final byte ATAN = 5;
    private byte type;
    private double amplitude;
    private double period;
    private double phase;

    public final void setAmplitude(double var1) {
        this.amplitude = var1;
        Graphable.grapher.pushChanges();
    }

    public final void setPeriod(double var1) {
        this.period = var1;
        Graphable.grapher.pushChanges();
    }

    public final void setPhase(double var1) {
        this.phase = var1;
        Graphable.grapher.pushChanges();
    }

    public final void setTrigParams(double var1, double var3, double var5) {
        this.amplitude = var1;
        this.period = var3;
        this.phase = var5;
        Graphable.grapher.pushChanges();
    }

    protected final void evaluateXY(Double var1) {
        switch(this.type) {
        case 0:
            var1.y = this.amplitude * Math.sin(this.period * var1.x + this.phase);
            return;
        case 1:
            if (this.amplitude != 0.0D && this.period != 0.0D) {
                var1.y = (Math.asin(var1.x / this.amplitude) - this.phase) / this.period;
                return;
            }

            var1.y = 0.0D / 0.0;
            return;
        case 2:
            var1.y = this.amplitude * Math.cos(this.period * var1.x + this.phase);
            return;
        case 3:
            if (this.amplitude != 0.0D && this.period != 0.0D) {
                var1.y = (Math.acos(var1.x / this.amplitude) - this.phase) / this.period;
                return;
            }

            var1.y = 0.0D / 0.0;
            return;
        case 4:
            var1.y = this.amplitude * Math.tan(this.period * var1.x + this.phase);
            return;
        case 5:
            if (this.amplitude != 0.0D && this.period != 0.0D) {
                var1.y = (Math.atan(var1.x / this.amplitude) - this.phase) / this.period;
                return;
            }

            var1.y = 0.0D / 0.0;
            return;
        default:
            var1.y = 0.0D;
        }
    }

    private TrigGraph() {
        super((byte)3);
        this.amplitude = 1.0D;
        this.period = 1.0D;
        this.phase = 0.0D;
    }

    public TrigGraph(byte var1) {
        super((byte)3);
        this.amplitude = 1.0D;
        this.period = 1.0D;
        this.phase = 0.0D;
        this.type = var1;
        Graphable.grapher.pushChanges();
    }

    public TrigGraph(byte var1, double var2, double var4, double var6) {
        this(var1);
        this.amplitude = var2;
        this.period = var4;
        this.phase = var6;
        Graphable.grapher.pushChanges();
    }
}
