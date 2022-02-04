//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class GoggaGrid extends Frame implements ActionListener, AdjustmentListener {
    static final int DEFAULT_XSIZE = 15;
    static final int DEFAULT_YSIZE = 10;
    int xSize;
    int ySize;
    int delayTime;
    GoggaGrid.GridCanvas gc;
    Button saveButton;
    Button printButton;
    Scrollbar scrollBar;

    public int getXSize() {
        return this.xSize;
    }

    public int getYSize() {
        return this.ySize;
    }

    public void drawGoggaTrail(int var1, int var2, int var3, int var4, Color var5, int var6) {
        this.gc.drawGoggaTrail(var1, var2, var3, var4, var5, var6);
    }

    public void hideGogga(int var1, int var2, int var3, Color var4, String var5) {
        this.gc.hideGogga(var1, var2, var3, var4, var5);
    }

    public void showGogga(int var1, int var2, int var3, Color var4, String var5) {
        this.gc.showGogga(var1, var2, var3, var4, var5);

        try {
            Thread.sleep((long)this.delayTime);
        } catch (InterruptedException var7) {
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.saveButton) {
            FileDialog var2 = new FileDialog(this, "Save Gogga Grid", 1);
            var2.setFile("Gogga.bmp");
            var2.show();
            if (var2.getFile() == null) {
                return;
            }

            String var3 = var2.getDirectory() + var2.getFile();
            if (var3.indexOf(".*.*") != -1) {
                var3 = var3.substring(0, var3.length() - 4);
            }

            this.gc.saveToFile(var3);
        } else if (var1.getSource() == this.printButton) {
            PrinterJob var6 = PrinterJob.getPrinterJob();
            Book var7 = new Book();
            var7.append(this.gc, new PageFormat());
            var6.setPageable(var7);
            if (!var6.printDialog()) {
                return;
            }

            try {
                var6.print();
            } catch (PrinterException var5) {
                System.err.println("Printing error: " + var5);
            }
        }

    }

    public void adjustmentValueChanged(AdjustmentEvent var1) {
        int var2 = var1.getValue();
        if (var2 <= 10) {
            this.delayTime = 1500 + (10 - var2) * 250;
        } else if (var2 < 25) {
            this.delayTime = 750 + (25 - var2) * 50;
        } else {
            this.delayTime = (100 - var2) * 10;
        }

    }

    public GoggaGrid() {
        this(15, 10);
    }

    public GoggaGrid(int var1, int var2) {
        super("Gogga Grid");
        this.delayTime = 500;
        this.xSize = var1;
        this.ySize = var2;
        GoggaGrid.GridCanvas var10001 = new GoggaGrid.GridCanvas();
        if (this == null) {
            throw null;
        } else {
            var10001.<init>(this, this.xSize, this.ySize);
            this.gc = var10001;
            GoggaGrid.WindowCloser var14 = new GoggaGrid.WindowCloser();
            if (this == null) {
                throw null;
            } else {
                var14.<init>();
                this.addWindowListener(var14);
                this.saveButton = new Button("Save");
                this.printButton = new Button("Print");
                this.scrollBar = new Scrollbar(0, 50, 0, 0, 100);
                this.saveButton.addActionListener(this);
                this.printButton.addActionListener(this);
                this.scrollBar.addAdjustmentListener(this);
                Panel var3 = new Panel();
                Label var4 = new Label("Slower", 2);
                Label var5 = new Label("Faster", 0);
                Label var6 = new Label("Set Speed", 1);
                Font var7 = new Font("SansSerif", 0, 10);
                var4.setFont(var7);
                var5.setFont(var7);
                var6.setFont(var7);
                var3.setLayout(new BorderLayout());
                var3.add(var4, "West");
                var3.add(var5, "East");
                var3.add(var6, "North");
                var3.add(this.scrollBar, "Center");
                Panel var8 = new Panel();
                GridBagLayout var9 = new GridBagLayout();
                GridBagConstraints var10 = new GridBagConstraints();
                Label var11 = new Label("   ");
                Label var12 = new Label("   ");
                var8.setBackground(Color.lightGray);
                var8.setLayout(var9);
                var8.add(var11);
                var8.add(this.saveButton);
                var8.add(this.printButton);
                var8.add(var3);
                var8.add(var12);
                var10.insets = new Insets(4, 4, 4, 4);
                var9.setConstraints(this.saveButton, var10);
                var9.setConstraints(this.printButton, var10);
                var10.insets = new Insets(0, 4, 4, 4);
                var10.fill = 2;
                var10.weightx = 1.0D;
                var9.setConstraints(var3, var10);
                this.add(var8, "North");
                this.add(this.gc, "South");
                this.pack();
                Dimension var13 = Toolkit.getDefaultToolkit().getScreenSize();
                this.setLocation(var13.width - this.getSize().width, 0);
                this.show();
            }
        }
    }

    class WindowCloser extends WindowAdapter {
        public void windowClosing(WindowEvent var1) {
            var1.getWindow().dispose();
            System.exit(0);
        }

        WindowCloser() {
        }
    }

    class Status {
        public void setMessage(String var1) {
        }

        public void dispose() {
        }

        public Status(String var2, String var3) {
        }
    }

    class Message {
        public Message(String var2) {
        }
    }
}
