//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GoggaGrid$WindowCloser extends WindowAdapter {
    public void windowClosing(WindowEvent var1) {
        var1.getWindow().dispose();
        System.exit(0);
    }

    GoggaGrid$WindowCloser(GoggaGrid var1) {
        this.this$0 = var1;
    }
}
