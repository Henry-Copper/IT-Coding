//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.ImageObserver;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphPanel extends JPanel {
    public static final byte XMIN = 0;
    public static final byte XMAX = 1;
    public static final byte YMIN = 2;
    public static final byte YMAX = 3;
    public static final byte XAXISLABEL = 4;
    public static final byte YAXISLABEL = 5;
    public static final int OFFSETX = 40;
    public static final int OFFSETY = 40;
    private JFrame controller;
    public int width;
    public int height;
    public double xFullScale;
    public double yFullScale;
    public double xPixelIncrement;
    public double yPixelIncrement;
    private int originX;
    private int originY;
    private Image backBufferImage;
    private Graphics backBuffer;
    public Color BORDER = new Color(238, 238, 255);
    protected Color borderColour;
    protected Color backgroundColour;
    protected boolean sizeOK = true;
    public double xMin = -5.0D;
    public double xMax = 5.0D;
    public double yMin = -5.0D;
    public double yMax = 5.0D;
    public boolean showAxisLabels = true;
    public String xAxisLabel = "X";
    public String yAxisLabel = "Y";
    public int numTicks = 4;
    protected GraphPanel.GraphVector theGraphs;

    public void setBorderColour(Color var1) {
        this.borderColour = var1;
    }

    public void setBackgroundColour(Color var1) {
        this.backgroundColour = var1;
    }

    public void addGraph(Graphable var1) {
        this.theGraphs.addElement(var1);
    }

    public boolean removeGraph(Graphable var1) {
        return this.theGraphs.removeElement(var1);
    }

    public void deleteAllGraphs() {
        this.theGraphs.deleteAllGraphs();
    }

    public final boolean setAxisValue(double var1, double var3, double var5, double var7) {
        if (!(var1 > var3) && !(var5 > var7)) {
            this.xMin = var1;
            this.xMax = var3;
            this.yMin = var5;
            this.yMax = var7;
            this.repaint();
            return true;
        } else {
            return false;
        }
    }

    public final boolean setAxisValue(double var1, byte var3) {
        switch(var3) {
        case 0:
            if (var1 < this.xMax) {
                this.xMin = var1;
                this.repaint();
                return true;
            }
            break;
        case 1:
            if (var1 > this.xMin) {
                this.xMax = var1;
                this.repaint();
                return true;
            }
            break;
        case 2:
            if (var1 < this.yMax) {
                this.yMin = var1;
                this.repaint();
                return true;
            }
            break;
        case 3:
            if (var1 > this.yMin) {
                this.yMax = var1;
                this.repaint();
                return true;
            }
        }

        return false;
    }

    public double[] getAxisValues() {
        double[] var1 = new double[]{this.xMin, this.xMax, this.yMin, this.yMax};
        return var1;
    }

    public void setShowAxisLabels(boolean var1) {
        this.showAxisLabels = var1;
        this.repaint();
    }

    public void setAxisLabel(String var1, byte var2) {
        switch(var2) {
        case 4:
            this.xAxisLabel = var1;
            this.repaint();
            break;
        case 5:
            this.yAxisLabel = var1;
            this.repaint();
        }

    }

    public void paint(Graphics var1) {
        this.width = this.getSize().width;
        this.height = this.getSize().height;
        this.checkAxisMetrics();
        if (this.backBufferImage == null) {
            this.backBufferImage = this.createImage(this.width, this.height);
            this.backBuffer = this.backBufferImage.getGraphics();
        }

        this.backBuffer.setClip(0, 0, this.width, this.height);
        if (!this.sizeOK) {
            var1.setColor(Color.red);
            var1.fillRect(0, 0, this.width, this.height);
            var1.setColor(Color.yellow);
            var1.drawString("Too small...", 5, 15);
        } else {
            this.backBuffer.setColor(this.BORDER);
            this.backBuffer.fillRect(0, 0, this.width, this.height);
            this.drawAxes(this.backBuffer);
            this.backBuffer.translate(40, 40);
            this.backBuffer.setClip(0, 0, this.width, this.height - 80);
            Enumeration var2 = this.theGraphs.getGraphs();

            while(var2.hasMoreElements()) {
                ((Graphable)var2.nextElement()).drawGraph(this.backBuffer, this);
            }

            this.backBuffer.translate(-40, -40);
            var1.drawImage(this.backBufferImage, 0, 0, (ImageObserver)null);
        }
    }

    private final void checkAxisMetrics() {
        if (this.xMin >= this.xMax) {
            this.xMin = -5.0D;
            this.xMax = 5.0D;
        }

        if (this.yMin >= this.yMax) {
            this.yMin = -5.0D;
            this.yMax = 5.0D;
        }

    }

    private final void drawAxes(Graphics var1) {
        this.xFullScale = this.xMax - this.xMin;
        this.xPixelIncrement = this.xFullScale / (double)(this.width - 80);
        this.yFullScale = this.yMax - this.yMin;
        this.yPixelIncrement = this.yFullScale / (double)(this.height - 80);
        if (this.xMin < 0.0D && this.xMax < 0.0D) {
            this.originX = (int)(this.xFullScale / this.xPixelIncrement);
        } else if (this.xMin > 0.0D && this.xMax > 0.0D) {
            this.originX = 0;
        } else {
            this.originX = (int)(-this.xMin / this.xPixelIncrement);
        }

        if (this.yMin < 0.0D && this.yMax < 0.0D) {
            this.originY = (int)(this.yFullScale / this.yPixelIncrement);
        } else if (this.yMin > 0.0D && this.yMax > 0.0D) {
            this.originY = 0;
        } else {
            this.originY = (int)(-this.yMin / this.yPixelIncrement);
        }

        var1.setColor(this.backgroundColour);
        var1.fillRect(40, 40, this.width - 80, this.height - 80);
        var1.setColor(Color.black);
        var1.drawLine(40, this.height - this.originY - 40, this.width - 40, this.height - this.originY - 40);
        var1.drawLine(this.originX + 40, this.height - 40, this.originX + 40, 40);
        if (this.showAxisLabels) {
            int var2 = this.xAxisLabel.length();
            if (var2 > 5) {
                var1.drawString(this.xAxisLabel, this.width - 40 - var2 * 3, this.height - this.originY - 40 - 2);
            } else {
                var1.drawString(this.xAxisLabel, this.width - 40 + 10, this.height - this.originY - 40 - 2);
            }

            int var3 = this.yAxisLabel.length();
            var1.drawString(this.yAxisLabel, this.originX + 40 - var3 * 3, 25);
        }

        boolean var11 = true;
        if (this.numTicks <= 0) {
            this.numTicks = 1;
        }

        double var12 = this.xFullScale / (double)this.numTicks / this.xPixelIncrement;
        double var5 = this.yFullScale / (double)this.numTicks / this.yPixelIncrement;
        Rectangle var7 = new Rectangle(0, 0, this.width, this.height);

        for(int var8 = 0; var8 <= this.numTicks; ++var8) {
            int var9 = (int)(40.0D + var12 * (double)var8);
            var1.drawLine(var9, this.height - this.originY - 40, var9, this.height - this.originY - 40 + 10);
            var1.setClip(var9, this.height - this.originY - 40, (int)var12 - 10, 20);
            var1.drawString(String.valueOf(this.xMin + (double)var8 * (this.xFullScale / (double)this.numTicks)), var9, this.height - this.originY - 40 + 20);
            var1.setClip(var7);
            int var10 = (int)(40.0D + var5 * (double)var8);
            var1.drawLine(this.originX + 40 - 10, var10, this.originX + 40, var10);
            var1.drawString(String.valueOf(this.yMax - (double)var8 * (this.yFullScale / (double)this.numTicks)), this.originX, var10);
            var1.setClip(var7);
        }

    }

    public final Enumeration getGraphs() {
        return this.theGraphs.getGraphs();
    }

    private final void drawErrorMessage(Graphics var1) {
        var1.setColor(Color.red);
        var1.fillRect(0, 0, this.width, this.height);
        var1.setColor(Color.yellow);
        var1.drawString("Can't draw at this size", 10, 10);
    }

    public void addGraphListener(XYValWatcher var1) {
        this.addMouseMotionListener(new GraphListener(this, var1));
    }

    public GraphPanel(JFrame var1) {
        this.controller = var1;
        this.borderColour = this.BORDER;
        this.backgroundColour = Color.white;
        GraphPanel.ResizeListener var10001 = new GraphPanel.ResizeListener;
        if (this == null) {
            throw null;
        } else {
            var10001.<init>();
            this.addComponentListener(var10001);
            GraphPanel.GraphVector var2 = new GraphPanel.GraphVector;
            if (this == null) {
                throw null;
            } else {
                var2.<init>();
                this.theGraphs = var2;
            }
        }
    }

    private class ResizeListener implements ComponentListener {
        public void componentResized(ComponentEvent var1) {
            try {
                GraphPanel.this.sizeOK = true;
                if (GraphPanel.this.getSize().width > 80 && GraphPanel.this.getSize().height > 80) {
                    GraphPanel.this.backBufferImage = GraphPanel.this.createImage(GraphPanel.this.getSize().width, GraphPanel.this.getSize().height);
                    GraphPanel.this.backBuffer = GraphPanel.this.backBufferImage.getGraphics();
                } else {
                    GraphPanel.this.sizeOK = false;
                }
            } catch (Exception var3) {
                System.err.println("Can't create a backbuffer for drawing, using old one");
            }

        }

        public void componentMoved(ComponentEvent var1) {
        }

        public void componentShown(ComponentEvent var1) {
        }

        public void componentHidden(ComponentEvent var1) {
        }

        ResizeListener() {
        }
    }

    private class GraphVector {
        private Vector graphs = new Vector();

        public void addElement(Graphable var1) {
            this.graphs.addElement(var1);
        }

        public boolean removeElement(Graphable var1) {
            return this.graphs.removeElement(var1);
        }

        public void deleteAllGraphs() {
            this.graphs.removeAllElements();
        }

        public Enumeration getGraphs() {
            return this.graphs.elements();
        }

        GraphVector() {
        }
    }
}
