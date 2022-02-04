//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class GraphListener extends MouseInputAdapter {
    private double xVal;
    private double yVal;
    private GraphPanel graphPanel;
    private XYValWatcher listener;

    public void mouseMoved(MouseEvent var1) {
        if (var1.getX() >= 40 && var1.getY() >= 40 && var1.getX() <= this.graphPanel.width - 40 && var1.getY() <= this.graphPanel.height - 40) {
            this.xVal = (double)(var1.getX() - 40) * this.graphPanel.xPixelIncrement + this.graphPanel.xMin;
            this.yVal = (double)(this.graphPanel.height - var1.getY() - 40) * this.graphPanel.yPixelIncrement + this.graphPanel.yMin;
            this.listener.updateXYVals(String.valueOf(this.xVal), String.valueOf(this.yVal));
        } else {
            this.listener.updateXYVals("-n/a-", "-n/a-");
        }

    }

    public GraphListener(GraphPanel var1, XYValWatcher var2) {
        this.graphPanel = var1;
        this.listener = var2;
    }
}
