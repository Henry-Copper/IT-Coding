//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import it.GoggaGrid.Message;
import it.GoggaGrid.Status;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

class GoggaGrid$GridCanvas extends Canvas implements Printable {
    static final int GRID_SIZE = 25;
    static final int LEFT_TOP_MARGIN = 5;
    static final int RIGHT_BOTTOM_MARGIN = 15;
    static final int TEXT_MARGIN = 10;
    static final int ROWS_GRABBED_AT_A_TIME = 75;
    static final int BI_RGB = 0;
    static final int BI_COMPRESSED_RLE8 = 1;
    static final int BI_COMPRESSED_RLE4 = 2;
    GoggaGrid gr;
    Font gridLabelFont;
    Font goggaLabelFont;
    int textWidth;
    int textHeight;
    int canvasWidth;
    int canvasHeight;
    Image offscreen;
    int[] goggaX;
    int[] goggaY;
    int[] goggaDirection;
    Color[] goggaColor;
    String[] goggaLabel;
    int numGoggas;
    Status status;
    DataOutputStream out;

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        int var2 = 5 + this.textWidth + 10;
        int var3 = 5 + this.textHeight + 10;
        if (this.offscreen == null) {
            this.initializeOffscreen();
        }

        var1.drawImage(this.offscreen, 0, 0, (ImageObserver)null);

        for(int var4 = 0; var4 < this.numGoggas; ++var4) {
            this.drawOneGogga(var1, var2 + this.goggaX[var4] * 25, var3 + this.goggaY[var4] * 25, this.goggaDirection[var4], this.goggaColor[var4], this.goggaLabel[var4]);
        }

    }

    private void drawOneGogga(Graphics var1, int var2, int var3, int var4, Color var5, String var6) {
        var1.setColor(var5);
        if (!var6.equals("")) {
            var1.setFont(this.goggaLabelFont);
            var1.drawString(var6, var2 + 10, var3 - 10);
        }

        switch(var4) {
        case 1:
            var1.fillOval(var2 - 4, var3 - 8, 8, 16);
            var1.setColor(Color.black);
            var1.drawOval(var2 - 4, var3 - 8, 7, 15);
            var1.setColor(Color.black);
            var1.drawArc(var2 - 4, var3 - 13, 4, 8, 135, 90);
            var1.drawArc(var2, var3 - 13, 4, 8, 315, 90);
            break;
        case 2:
            var1.fillOval(var2 - 4, var3 - 8, 8, 16);
            var1.setColor(Color.black);
            var1.drawOval(var2 - 4, var3 - 8, 7, 15);
            var1.setColor(Color.black);
            var1.drawArc(var2 - 4, var3 + 5, 4, 8, 135, 120);
            var1.drawArc(var2, var3 + 5, 4, 8, 315, 90);
            break;
        case 3:
            var1.fillOval(var2 - 8, var3 - 4, 16, 8);
            var1.setColor(Color.black);
            var1.drawOval(var2 - 8, var3 - 4, 15, 7);
            var1.setColor(Color.black);
            var1.drawArc(var2 - 13, var3 - 4, 8, 4, 45, 120);
            var1.drawArc(var2 - 13, var3, 8, 4, 225, 90);
            break;
        case 4:
            var1.fillOval(var2 - 8, var3 - 4, 16, 8);
            var1.setColor(Color.black);
            var1.drawOval(var2 - 8, var3 - 4, 15, 7);
            var1.setColor(Color.black);
            var1.drawArc(var2 + 4, var3 - 4, 8, 4, 30, 110);
            var1.drawArc(var2 + 5, var3, 8, 4, 225, 90);
        }

    }

    public void hideGogga(int var1, int var2, int var3, Color var4, String var5) {
        for(int var6 = 0; var6 < this.numGoggas; ++var6) {
            if (var1 == this.goggaX[var6] && var2 == this.goggaY[var6] && var3 == this.goggaDirection[var6] && var4.equals(this.goggaColor[var6]) && var5.equals(this.goggaLabel[var6])) {
                for(int var7 = var6 + 1; var7 < this.numGoggas; ++var7) {
                    this.goggaX[var7 - 1] = this.goggaX[var7];
                    this.goggaY[var7 - 1] = this.goggaY[var7];
                    this.goggaDirection[var7 - 1] = this.goggaDirection[var7];
                    this.goggaColor[var7 - 1] = this.goggaColor[var7];
                    this.goggaLabel[var7 - 1] = this.goggaLabel[var7];
                }

                --this.numGoggas;
                break;
            }
        }

        this.repaint();
    }

    public void showGogga(int var1, int var2, int var3, Color var4, String var5) {
        this.goggaX[this.numGoggas] = var1;
        this.goggaY[this.numGoggas] = var2;
        this.goggaDirection[this.numGoggas] = var3;
        this.goggaColor[this.numGoggas] = var4;
        this.goggaLabel[this.numGoggas] = var5;
        ++this.numGoggas;
        this.repaint();
    }

    public void drawGoggaTrail(int var1, int var2, int var3, int var4, Color var5, int var6) {
        int var11 = 5 + this.textWidth + 10;
        int var12 = 5 + this.textHeight + 10;
        int var7 = var11 + Math.min(var1, var3) * 25;
        int var8 = var12 + Math.min(var2, var4) * 25;
        int var9 = var11 + Math.max(var1, var3) * 25;
        int var10 = var12 + Math.max(var2, var4) * 25;
        this.waitForOffscreen();
        Graphics var13 = this.offscreen.getGraphics();
        var13.setColor(var5);
        int var14;
        int var15;
        int var16;
        if (var7 != var9) {
            var14 = var8 - var6 / 2;
            var15 = var14 + var6;

            for(var16 = var14; var16 < var15; ++var16) {
                var13.drawLine(var7, var16, var9, var16);
            }

            var13.fillOval(var7 - var6 / 2, var14, var6, var6);
            var13.fillOval(var9 - var6 / 2, var14, var6, var6);
        } else {
            var14 = var7 - var6 / 2;
            var15 = var14 + var6;

            for(var16 = var14; var16 < var15; ++var16) {
                var13.drawLine(var16, var8, var16, var10);
            }

            var13.fillOval(var14, var8 - var6 / 2, var6, var6);
            var13.fillOval(var14, var10 - var6 / 2, var6, var6);
        }

    }

    public void saveToFile(String var1) {
        Image var2 = this.createImage(this.canvasWidth, this.canvasHeight);
        this.update(var2.getGraphics());
        long var3 = 0L;
        Status var10001 = new Status;
        GoggaGrid var10003 = this.this$0;
        if (var10003 == null) {
            throw null;
        } else {
            var10001.<init>(var10003, "Calculating Size", "Converting to BMP");
            this.status = var10001;
            int[] var5 = new int[this.canvasHeight * this.canvasWidth];
            byte[] var6 = new byte[this.canvasHeight * this.canvasWidth];
            int[] var7 = new int[256];
            int var8 = 0;

            int var10;
            for(var10 = 0; var10 < this.canvasHeight; var10 += 75) {
                if (System.currentTimeMillis() - var3 > 1000L) {
                    var3 = System.currentTimeMillis();
                    this.status.setMessage("Grabbing pixels: " + var10 * 100 / this.canvasHeight + "% Done");
                }

                PixelGrabber var9 = new PixelGrabber(var2, 0, var10, this.canvasWidth, Math.min(75, this.canvasWidth - var10), var5, var10 * this.canvasWidth, this.canvasWidth);

                Message var10000;
                GoggaGrid var17;
                try {
                    if (!var9.grabPixels()) {
                        this.status.dispose();
                        var10000 = new Message;
                        var17 = this.this$0;
                        if (var17 == null) {
                            throw null;
                        }

                        var10000.<init>(var17, "Unable to get picture image");
                        return;
                    }
                } catch (InterruptedException var14) {
                    this.status.dispose();
                    var10000 = new Message;
                    var17 = this.this$0;
                    if (var17 == null) {
                        throw null;
                    }

                    var10000.<init>(var17, "Unable to get picture image");
                    return;
                }
            }

            for(int var11 = 0; var11 < this.canvasHeight; ++var11) {
                if (System.currentTimeMillis() - var3 > 1000L) {
                    var3 = System.currentTimeMillis();
                    this.status.setMessage("Making Colormap: " + var11 * 100 / this.canvasHeight + "% Done");
                }

                for(int var12 = 0; var12 < this.canvasWidth; ++var12) {
                    int var13 = var5[var11 * this.canvasWidth + var12] & 16777215;

                    for(var10 = 0; var10 < var8 && var13 != var7[var10]; ++var10) {
                    }

                    if (var10 > 255) {
                        Object var16 = null;
                        this.write24BitBMP(var5, this.canvasWidth, this.canvasHeight, var1);
                        if (this.status != null) {
                            this.status.dispose();
                        }

                        return;
                    }

                    var6[var11 * this.canvasWidth + var12] = (byte)var10;
                    if (var10 == var8) {
                        var7[var8++] = var13;
                    }
                }
            }

            Object var15 = null;
            if (var8 <= 2) {
                this.write1BitBMP(var6, var7, this.canvasWidth, this.canvasHeight, var1);
            } else if (var8 <= 16) {
                this.write4BitBMP(var6, var7, this.canvasWidth, this.canvasHeight, var1);
            } else {
                this.write8BitBMP(var6, var7, this.canvasWidth, this.canvasHeight, var1);
            }

            if (this.status != null) {
                this.status.dispose();
            }

        }
    }

    public int print(Graphics var1, PageFormat var2, int var3) {
        if (var3 > 0) {
            return 1;
        } else {
            int var4 = (int)var2.getImageableX();
            int var5 = (int)var2.getImageableY();
            int var6 = var4 + (int)var2.getImageableWidth();
            SimpleDateFormat var7 = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
            var7.setTimeZone(TimeZone.getDefault());
            String var8 = var7.format(new Date());
            String var9 = System.getProperty("user.name");
            Font var10 = new Font("SansSerif", 1, 12);
            FontMetrics var11 = this.getFontMetrics(var10);
            var1.setColor(Color.black);
            var1.setFont(var10);
            if (var9.length() != 0) {
                var1.drawString(var9, var4 + 2, var5 + var11.getHeight() + 2);
            }

            var1.drawString(var8, var6 - 2 - var11.stringWidth(var8), var5 + var11.getHeight() + 2);
            int var12 = ((int)var2.getImageableWidth() - this.canvasWidth) / 2 + var4;
            int var13 = 3 * var11.getHeight() + var5;
            var1.translate(var12, var13);
            this.update(var1);
            return 0;
        }
    }

    private synchronized void initializeOffscreen() {
        this.offscreen = this.createImage(this.canvasWidth, this.canvasHeight);
        int var1 = 5 + this.textWidth + 10;
        int var2 = var1 + (this.gr.xSize - 1) * 25;
        int var3 = 5 + this.textHeight + 10;
        int var4 = var3 + (this.gr.ySize - 1) * 25;
        Graphics var7 = this.offscreen.getGraphics();
        var7.setFont(this.gridLabelFont);
        var7.setColor(Color.black);
        int var6 = var3;

        int var5;
        int var8;
        for(var8 = 0; var8 < this.gr.ySize; ++var8) {
            var5 = 5;
            if (var8 < 10) {
                var5 += this.textWidth / 2;
            }

            var7.drawString("" + var8, var5, var6 + this.textWidth / 2);
            var7.drawLine(var1, var6, var2, var6);
            var6 += 25;
        }

        var5 = var1;
        var6 = 5 + this.textHeight;

        for(var8 = 0; var8 < this.gr.xSize; ++var8) {
            int var9 = var5 - this.textWidth / 2;
            if (var8 < 10) {
                var9 += this.textWidth / 4;
            }

            var7.drawString("" + var8, var9, var6);
            var7.drawLine(var5, var3, var5, var4);
            var5 += 25;
        }

        this.notifyAll();
    }

    private synchronized void waitForOffscreen() {
        if (this.offscreen == null) {
            try {
                this.wait();
            } catch (InterruptedException var2) {
            }
        }

    }

    protected void write1BitBMP(byte[] var1, int[] var2, int var3, int var4, String var5) {
        long var6 = 0L;
        this.status.setMessage("Writing 1 bit BMP");
        int var8 = (4 - var3 / 8 % 4) % 4;
        int var9 = (var3 / 8 + var8) * var4;
        byte[] var10 = new byte[var9];
        int var11 = 0;

        for(int var12 = 0; var12 < var4; ++var12) {
            if (System.currentTimeMillis() - var6 > 1000L) {
                var6 = System.currentTimeMillis();
                this.status.setMessage("Converting to BMP: " + var12 * 100 / var4 + "% Done");
            }

            int var13;
            for(var13 = 0; var13 < var3; ++var13) {
                byte var14 = var1[(var4 - 1 - var12) * var3 + var13];
                var10[var11] = (byte)(var10[var11] | var14 << 7 - var13 % 8);
                if (var13 % 8 == 7 || var13 == var3 - 1) {
                    ++var11;
                }
            }

            for(var13 = 0; var13 < var8; ++var13) {
                var10[var11++] = 0;
            }
        }

        this.writeBMPFile(var5, var9, 2, var3, var4, 1, 0, var2, var10);
    }

    protected void write24BitBMP(int[] var1, int var2, int var3, String var4) {
        long var5 = 0L;
        this.status.setMessage("Writing 24 bit BMP");
        int var7 = (4 - var2 * 3 % 4) % 4;
        int var8 = (var2 * 3 + var7) * var3;
        byte[] var9 = new byte[var8];
        int var10 = 0;

        for(int var11 = 0; var11 < var3; ++var11) {
            if (System.currentTimeMillis() - var5 > 1000L) {
                var5 = System.currentTimeMillis();
                this.status.setMessage("Converting to BMP: " + var11 * 100 / var3 + "% Done");
            }

            int var12;
            for(var12 = 0; var12 < var2; ++var12) {
                int var13 = var1[(var3 - 1 - var11) * var2 + var12];
                var9[var10++] = (byte)(var13 & 255);
                var9[var10++] = (byte)(var13 >> 8 & 255);
                var9[var10++] = (byte)(var13 >> 16 & 255);
            }

            for(var12 = 0; var12 < var7; ++var12) {
                var9[var10++] = 0;
            }
        }

        this.writeBMPFile(var4, var8, 0, var2, var3, 24, 0, (int[])null, var9);
    }

    protected void write4BitBMP(byte[] var1, int[] var2, int var3, int var4, String var5) {
        int[] var6 = new int[]{4, 0};
        long var7 = 0L;
        this.status.setMessage("Writing 4 bit BMP");
        int var9 = (4 - var3 / 2 % 4) % 4;
        int var10 = (var3 / 2 + var9) * var4;
        byte[] var11 = new byte[var10];
        int var12 = 0;

        int var14;
        for(int var13 = 0; var13 < var4; ++var13) {
            if (System.currentTimeMillis() - var7 > 1000L) {
                var7 = System.currentTimeMillis();
                this.status.setMessage("Converting to BMP: " + var13 * 100 / var4 + "% Done");
            }

            for(var14 = 0; var14 < var3; ++var14) {
                byte var15 = var1[(var4 - 1 - var13) * var3 + var14];
                var11[var12] = (byte)(var11[var12] | var15 << var6[var14 % 2]);
                if (var14 % 2 == 1 || var14 == var3 - 1) {
                    ++var12;
                }
            }

            for(var14 = 0; var14 < var9; ++var14) {
                var11[var12++] = 0;
            }
        }

        this.status.setMessage("Compressing the bitmap");
        byte[] var24 = new byte[var10];
        var14 = var3 / 2 + var9;
        int var25 = 0;

        for(int var16 = 0; var16 < var4; ++var16) {
            int var18 = 0;

            while(var18 < (var3 + 1) / 2) {
                int var19 = var18;

                boolean var20;
                int var21;
                for(var20 = false; !var20 && var18 < var3 - 4; ++var18) {
                    var21 = var16 * var14 + var18;
                    if (var11[var21] == var11[var21 + 1] && var11[var21 + 1] == var11[var21 + 2]) {
                        var20 = true;
                        break;
                    }
                }

                if (!var20) {
                    var18 = (var3 + 1) / 2;
                }

                int var23;
                for(; var18 - var19 > 2; var19 += var21) {
                    if (var25 + 300 > var10) {
                        this.writeBMPFile(var5, var10, 16, var3, var4, 4, 0, var2, var11);
                        return;
                    }

                    var21 = Math.min(var18 - var19, 127);
                    var24[var25++] = 0;
                    var24[var25++] = (byte)(var21 * 2);
                    int var22 = var16 * var14 + var19;

                    for(var23 = 0; var23 < var21; ++var23) {
                        var24[var25++] = var11[var22 + var23];
                    }

                    if (var21 % 2 == 1) {
                        var24[var25++] = 0;
                    }
                }

                if (var19 == var3) {
                    break;
                }

                byte var26 = var11[var16 * var14 + var19];
                boolean var27 = true;

                for(var18 = var19 + 1; var27 && var18 < (var3 + 1) / 2; ++var18) {
                    if (var11[var16 * var14 + var18] != var26) {
                        var27 = false;
                        break;
                    }
                }

                while(var18 != var19) {
                    if (var25 + 300 > var10) {
                        this.writeBMPFile(var5, var10, 16, var3, var4, 4, 0, var2, var11);
                        return;
                    }

                    var23 = Math.min(var18 - var19, 127);
                    var24[var25++] = (byte)(var23 * 2);
                    var24[var25++] = var26;
                    var19 += var23;
                }
            }

            var24[var25++] = 0;
            var24[var25++] = 0;
        }

        var24[var25++] = 0;
        var24[var25++] = 1;
        this.writeBMPFile(var5, var25, 16, var3, var4, 4, 2, var2, var24);
    }

    protected void write8BitBMP(byte[] var1, int[] var2, int var3, int var4, String var5) {
        long var6 = 0L;
        this.status.setMessage("Writing 8 bit BMP");
        int var8 = (4 - var3 % 4) % 4;
        int var9 = (var3 + var8) * var4;
        byte[] var10 = new byte[var9];
        int var11 = 0;

        int var13;
        for(int var12 = 0; var12 < var4; ++var12) {
            if (System.currentTimeMillis() - var6 > 1000L) {
                var6 = System.currentTimeMillis();
                this.status.setMessage("Converting to BMP: " + var12 * 100 / var4 + "% Done");
            }

            for(var13 = 0; var13 < var3; ++var13) {
                int var10001 = var11++;
                var10[var10001] |= var1[(var4 - 1 - var12) * var3 + var13];
            }

            for(var13 = 0; var13 < var8; ++var13) {
                var10[var11++] = 0;
            }
        }

        this.status.setMessage("Compressing the bitmap");
        byte[] var23 = new byte[var9];
        var13 = var3 + var8;
        int var14 = 0;

        for(int var15 = 0; var15 < var4; ++var15) {
            int var17 = 0;

            while(var17 < var3) {
                int var18 = var17;

                boolean var19;
                int var20;
                for(var19 = false; !var19 && var17 < var3 - 4; ++var17) {
                    var20 = var15 * var13 + var17;
                    if (var10[var20] == var10[var20 + 1] && var10[var20 + 1] == var10[var20 + 2]) {
                        var19 = true;
                        break;
                    }
                }

                if (!var19) {
                    var17 = var3;
                }

                int var22;
                for(; var17 - var18 > 2; var18 += var20) {
                    if (var14 + 300 > var9) {
                        this.writeBMPFile(var5, var9, 256, var3, var4, 8, 0, var2, var10);
                        return;
                    }

                    var20 = Math.min(var17 - var18, 255);
                    var23[var14++] = 0;
                    var23[var14++] = (byte)var20;
                    int var21 = var15 * var13 + var18;

                    for(var22 = 0; var22 < var20; ++var22) {
                        var23[var14++] = var10[var21 + var22];
                    }

                    if (var20 % 2 == 1) {
                        var23[var14++] = 0;
                    }
                }

                if (var18 == var3) {
                    break;
                }

                byte var24 = var10[var15 * var13 + var18];
                boolean var25 = true;

                for(var17 = var18 + 1; var25 && var17 < var3; ++var17) {
                    if (var10[var15 * var13 + var17] != var24) {
                        var25 = false;
                        break;
                    }
                }

                while(var17 != var18) {
                    if (var14 + 300 > var9) {
                        this.writeBMPFile(var5, var9, 256, var3, var4, 8, 0, var2, var10);
                        return;
                    }

                    var22 = Math.min(var17 - var18, 255);
                    var23[var14++] = (byte)var22;
                    var23[var14++] = var24;
                    var18 += var22;
                }
            }

            var23[var14++] = 0;
            var23[var14++] = 0;
        }

        var23[var14++] = 0;
        var23[var14++] = 1;
        this.writeBMPFile(var5, var14, 256, var3, var4, 8, 1, var2, var23);
    }

    protected void writeBMPFile(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int[] var8, byte[] var9) {
        this.status.setMessage("Writing image");

        try {
            this.out = new DataOutputStream(new FileOutputStream(var1));
            this.writeShort(19778);
            this.writeInt(var2 + 54 + var3 * 4);
            this.writeShort(0);
            this.writeShort(0);
            this.writeInt(54 + var3 * 4);
            this.writeInt(40);
            this.writeInt(var4);
            this.writeInt(var5);
            this.writeShort(1);
            this.writeShort(var6);
            this.writeInt(var7);
            this.writeInt(var2);
            this.writeInt(2835);
            this.writeInt(2835);
            this.writeInt(var3);
            this.writeInt(var3);

            for(int var12 = 0; var12 < var3; ++var12) {
                int var13 = var8[var12];
                this.out.writeByte(var13 & 255);
                this.out.writeByte(var13 >> 8 & 255);
                this.out.writeByte(var13 >> 16 & 255);
                this.out.writeByte(0);
            }

            this.out.write(var9, 0, var2);
            this.out.close();
            this.out = null;
        } catch (IOException var20) {
        } finally {
            if (this.out != null) {
                try {
                    this.out.close();
                    this.out = null;
                } catch (IOException var19) {
                }
            }

        }

    }

    protected void writeInt(int var1) {
        try {
            this.out.writeByte(var1 & 255);
            this.out.writeByte(var1 >> 8 & 255);
            this.out.writeByte(var1 >> 16 & 255);
            this.out.writeByte(var1 >> 24 & 255);
        } catch (IOException var3) {
        }

    }

    protected void writeShort(int var1) {
        try {
            this.out.writeByte(var1 & 255);
            this.out.writeByte(var1 >> 8 & 255);
        } catch (IOException var3) {
        }

    }

    public GoggaGrid$GridCanvas(GoggaGrid var1, GoggaGrid var2, int var3, int var4) {
        this.this$0 = var1;
        this.goggaX = new int[100];
        this.goggaY = new int[100];
        this.goggaDirection = new int[100];
        this.goggaColor = new Color[100];
        this.goggaLabel = new String[100];
        this.numGoggas = 0;
        this.gr = var2;
        this.gridLabelFont = new Font("Serif", 0, 12);
        FontMetrics var5 = this.getFontMetrics(this.gridLabelFont);
        this.textWidth = var5.stringWidth("00");
        this.textHeight = var5.getAscent();
        this.goggaLabelFont = new Font("SanSerif", 1, 10);
        this.canvasWidth = 25 * (var3 - 1) + 5 + 15 + 10 + this.textWidth;
        this.canvasHeight = 25 * (var4 - 1) + 5 + 15 + 10 + this.textHeight;
        this.setSize(this.canvasWidth, this.canvasHeight);
    }
}
