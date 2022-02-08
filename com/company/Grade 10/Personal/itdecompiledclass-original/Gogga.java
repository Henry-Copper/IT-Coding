//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.Color;

public class Gogga {
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;
    static final int DEFAULT_X = -99;
    static final int DEFAULT_DIR = 1;
    static final int DEFAULT_TRAIL_WIDTH = 5;
    static final Color DEFAULT_COLOR;
    static boolean gridInitialized;
    static int xSize;
    static int ySize;
    static GoggaGrid gr;
    int xPos;
    int yPos;
    int direction;
    Color color;
    int trailWidth;
    boolean trailVisible;
    String label;

    private void initializeGridIfNecessary() {
        if (!gridInitialized) {
            if (xSize != 0) {
                gr = new GoggaGrid(xSize, ySize);
            } else {
                gr = new GoggaGrid();
            }

            gridInitialized = true;
        }

    }

    public void move() {
        switch(this.direction) {
        case 1:
            if (this.yPos == 0) {
                System.out.println("The Gogga hit the top of the grid!");
                System.out.println("Command ignored");
            } else {
                if (this.trailVisible) {
                    gr.drawGoggaTrail(this.xPos, this.yPos, this.xPos, this.yPos - 1, this.color, this.trailWidth);
                }

                this.setPosition(this.xPos, this.yPos - 1);
            }
            break;
        case 2:
            if (this.yPos == gr.getYSize() - 1) {
                System.out.println("The Gogga hit the bottom of the grid!");
                System.out.println("Command ignored");
            } else {
                if (this.trailVisible) {
                    gr.drawGoggaTrail(this.xPos, this.yPos, this.xPos, this.yPos + 1, this.color, this.trailWidth);
                }

                this.setPosition(this.xPos, this.yPos + 1);
            }
            break;
        case 3:
            if (this.xPos == 0) {
                System.out.println("The Gogga hit the left side of the grid!");
                System.out.println("Command ignored");
            } else {
                if (this.trailVisible) {
                    gr.drawGoggaTrail(this.xPos, this.yPos, this.xPos - 1, this.yPos, this.color, this.trailWidth);
                }

                this.setPosition(this.xPos - 1, this.yPos);
            }
            break;
        case 4:
            if (this.xPos == gr.getXSize() - 1) {
                System.out.println("The Gogga hit the right side of the grid!");
                System.out.println("Command ignored");
            } else {
                if (this.trailVisible) {
                    gr.drawGoggaTrail(this.xPos, this.yPos, this.xPos + 1, this.yPos, this.color, this.trailWidth);
                }

                this.setPosition(this.xPos + 1, this.yPos);
            }
        }

    }

    public void turnRight() {
        switch(this.direction) {
        case 1:
            this.setDirection(4);
            break;
        case 2:
            this.setDirection(3);
            break;
        case 3:
            this.setDirection(1);
            break;
        case 4:
            this.setDirection(2);
        }

    }

    public void turnLeft() {
        switch(this.direction) {
        case 1:
            this.setDirection(3);
            break;
        case 2:
            this.setDirection(4);
            break;
        case 3:
            this.setDirection(2);
            break;
        case 4:
            this.setDirection(1);
        }

    }

    public int getXPos() {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    public int getDirection() {
        return this.direction;
    }

    public void setPosition(int var1, int var2) {
        gr.hideGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
        this.xPos = var1;
        this.yPos = var2;
        gr.showGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
    }

    public void setDirection(int var1) {
        gr.hideGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
        this.direction = var1;
        gr.showGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
    }

    public void setColor(Color var1) {
        gr.hideGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
        this.color = var1;
        gr.showGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
    }

    public void setTrailWidth(int var1) {
        this.trailWidth = var1;
    }

    public void setLabel(String var1) {
        gr.hideGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
        this.label = var1;
        gr.showGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
    }

    public void trailOn() {
        this.trailVisible = true;
    }

    public void trailOff() {
        this.trailVisible = false;
    }

    public static void setGridSize(int var0, int var1) {
        if (gridInitialized) {
            System.out.println("The Gogga.setGridSize method must be called before the first Gogga is created");
        } else {
            xSize = var0;
            ySize = var1;
        }

    }

    public Gogga(int var1, int var2, int var3, Color var4) {
        this.initializeGridIfNecessary();
        if (var1 == -99) {
            this.xPos = gr.getXSize() / 2;
            this.yPos = gr.getYSize() / 2;
        } else {
            this.xPos = var1;
            this.yPos = var2;
        }

        this.direction = var3;
        this.color = var4;
        this.trailWidth = 5;
        this.trailVisible = true;
        this.label = "";
        gr.showGogga(this.xPos, this.yPos, this.direction, this.color, this.label);
    }

    public Gogga() {
        this(-99, -99, 1, DEFAULT_COLOR);
    }

    public Gogga(int var1, int var2) {
        this(var1, var2, 1, DEFAULT_COLOR);
    }

    public Gogga(Color var1) {
        this(-99, -99, 1, var1);
    }

    public Gogga(int var1, int var2, Color var3) {
        this(var1, var2, 1, var3);
    }

    static {
        DEFAULT_COLOR = Color.red;
        gridInitialized = false;
        xSize = 0;
        ySize = 0;
    }
}
