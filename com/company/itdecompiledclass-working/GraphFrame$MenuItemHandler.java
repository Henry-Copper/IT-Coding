//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GraphFrame$MenuItemHandler implements ActionListener {
    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == GraphFrame.access$0(this.this$0)) {
            System.exit(0);
        }

        if (var1.getSource() == GraphFrame.access$1(this.this$0)) {
            this.this$0.getNewValue("Please enter a minimum value for the X axis", (byte)0);
        } else if (var1.getSource() == GraphFrame.access$2(this.this$0)) {
            this.this$0.getNewValue("Please enter a maximum value for the X axis", (byte)1);
        } else if (var1.getSource() == GraphFrame.access$3(this.this$0)) {
            this.this$0.getNewValue("Please enter a minimum value for the Y axis", (byte)2);
        } else if (var1.getSource() == GraphFrame.access$4(this.this$0)) {
            this.this$0.getNewValue("Please enter a maximum value for the Y axis", (byte)3);
        } else if (var1.getSource() == GraphFrame.access$5(this.this$0)) {
            this.this$0.graphPanel.setAxisValue(0.0D, 10.0D, 0.0D, 10.0D);
        } else if (var1.getSource() == GraphFrame.access$6(this.this$0)) {
            this.this$0.getNewLabel("Please enter a label for the X axis", (byte)4);
        } else if (var1.getSource() == GraphFrame.access$7(this.this$0)) {
            this.this$0.getNewLabel("Please enter a label for the Y axis", (byte)5);
        } else {
            if (var1.getSource() == GraphFrame.access$8(this.this$0)) {
                this.this$0.graphPanel.setShowAxisLabels(GraphFrame.access$8(this.this$0).getState());
            }

        }
    }

    GraphFrame$MenuItemHandler(GraphFrame var1) {
        this.this$0 = var1;
    }
}
