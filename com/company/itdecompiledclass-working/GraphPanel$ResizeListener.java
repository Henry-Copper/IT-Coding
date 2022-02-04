//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

class GraphPanel$ResizeListener implements ComponentListener {
    public void componentResized(ComponentEvent var1) {
        try {
            this.this$0.sizeOK = true;
            if (this.this$0.getSize().width > 80 && this.this$0.getSize().height > 80) {
                GraphPanel.access$1(this.this$0, this.this$0.createImage(this.this$0.getSize().width, this.this$0.getSize().height));
                GraphPanel.access$3(this.this$0, GraphPanel.access$0(this.this$0).getGraphics());
            } else {
                this.this$0.sizeOK = false;
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

    GraphPanel$ResizeListener(GraphPanel var1) {
        this.this$0 = var1;
    }
}
