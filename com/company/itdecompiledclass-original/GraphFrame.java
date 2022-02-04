//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class GraphFrame extends JFrame implements XYValWatcher {
    private Container contentsPane = this.getContentPane();
    protected JPanel statusBar;
    protected JLabel statusBarMessage;
    protected JLabel xyVal;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu propertiesMenu;
    private JMenu helpMenu;
    private JMenuItem exitItem;
    private JMenuItem borderColourItem;
    private JMenuItem graphColourItem;
    private JMenuItem axisColourItem;
    private JMenuItem xMinItem;
    private JMenuItem xMaxItem;
    private JMenuItem yMinItem;
    private JMenuItem yMaxItem;
    private JMenuItem axisResetItem;
    private JMenuItem setXAxisLabelItem;
    private JMenuItem setYAxisLabelItem;
    private JCheckBoxMenuItem showAxisLabelsItem;
    protected GraphPanel graphPanel;
    private GraphFrame.MenuItemHandler menuHandler;

    public void setAxes(double var1, double var3, double var5, double var7) {
        this.graphPanel.setAxisValue(var1, var3, var5, var7);
    }

    public double[] getAxisValues() {
        return this.graphPanel.getAxisValues();
    }

    public void setAxisLabels(String var1, String var2) {
        this.graphPanel.setAxisLabel(var1, (byte)4);
        this.graphPanel.setAxisLabel(var2, (byte)5);
    }

    private void buildGUI() {
        this.setUpStatusBar();
        this.setUpMenus();
    }

    private void setUpStatusBar() {
        this.statusBar = new JPanel(new GridBagLayout());
        this.statusBar.setBorder(new BevelBorder(1));
        GridBagConstraints var1 = new GridBagConstraints();
        var1.anchor = 17;
        var1.gridx = 0;
        var1.weightx = 1.0D;
        var1.gridwidth = 1;
        this.statusBarMessage = new JLabel("GraphFrame", 2);
        this.statusBar.add(this.statusBarMessage, var1);
        var1.gridx = 1;
        var1.weightx = 0.0D;
        var1.gridwidth = 1;
        this.xyVal = new JLabel();
        this.xyVal.setForeground(Color.red);
        this.statusBar.add(this.xyVal, var1);
        this.contentsPane.add(this.statusBar, "South");
    }

    private void setUpMenus() {
        this.menuBar = new JMenuBar();
        GraphFrame.MenuItemHandler var10001 = new GraphFrame.MenuItemHandler;
        if (this == null) {
            throw null;
        } else {
            var10001.<init>();
            this.menuHandler = var10001;
            this.setUpFileMenu();
            this.setUpPropertiesMenu();
            this.setJMenuBar(this.menuBar);
        }
    }

    private void setUpFileMenu() {
        this.fileMenu = new JMenu("File");
        this.exitItem = new JMenuItem("Exit");
        this.exitItem.addActionListener(this.menuHandler);
        this.fileMenu.add(this.exitItem);
        this.menuBar.add(this.fileMenu);
    }

    private void setUpPropertiesMenu() {
        this.propertiesMenu = new JMenu("Properties");
        this.xMinItem = new JMenuItem("Set Xmin");
        this.propertiesMenu.add(this.xMinItem);
        this.xMinItem.addActionListener(this.menuHandler);
        this.xMaxItem = new JMenuItem("Set Xmax");
        this.propertiesMenu.add(this.xMaxItem);
        this.xMaxItem.addActionListener(this.menuHandler);
        this.yMinItem = new JMenuItem("Set Ymin");
        this.propertiesMenu.add(this.yMinItem);
        this.yMinItem.addActionListener(this.menuHandler);
        this.yMaxItem = new JMenuItem("Set Ymax");
        this.propertiesMenu.add(this.yMaxItem);
        this.yMaxItem.addActionListener(this.menuHandler);
        this.propertiesMenu.addSeparator();
        this.axisResetItem = new JMenuItem("Reset Axis Values");
        this.propertiesMenu.add(this.axisResetItem);
        this.axisResetItem.addActionListener(this.menuHandler);
        this.propertiesMenu.addSeparator();
        this.showAxisLabelsItem = new JCheckBoxMenuItem("Show Axis Labels", this.graphPanel.showAxisLabels);
        this.propertiesMenu.add(this.showAxisLabelsItem);
        this.showAxisLabelsItem.addActionListener(this.menuHandler);
        this.propertiesMenu.addSeparator();
        this.setXAxisLabelItem = new JMenuItem("Set X Axis Label");
        this.propertiesMenu.add(this.setXAxisLabelItem);
        this.setXAxisLabelItem.addActionListener(this.menuHandler);
        this.setYAxisLabelItem = new JMenuItem("Set Y Axis Label");
        this.propertiesMenu.add(this.setYAxisLabelItem);
        this.setYAxisLabelItem.addActionListener(this.menuHandler);
        this.menuBar.add(this.propertiesMenu);
    }

    public void addGraph(Graphable var1) {
        this.graphPanel.addGraph(var1);
    }

    public boolean removeGraph(Graphable var1) {
        return this.graphPanel.removeGraph(var1);
    }

    public Enumeration getGraphs() {
        return this.graphPanel.getGraphs();
    }

    public void updateStatusBar(String var1) {
        this.statusBarMessage.setText(var1);
    }

    public void updateXYVals(String var1, String var2) {
        this.xyVal.setText("x = " + (var1.length() > 5 ? var1.substring(0, 5) : var1) + " : y = " + (var2.length() > 5 ? var2.substring(0, 5) : var2));
    }

    protected final void getNewValue(String var1, byte var2) {
        try {
            String var3 = (String)JOptionPane.showInputDialog(this, var1, "Enter Axis Value", 1, (Icon)null, (Object[])null, "10");
            if (var3 == null) {
                return;
            }

            double var4 = Double.parseDouble(var3);
            boolean var6 = this.graphPanel.setAxisValue(var4, var2);
            if (!var6) {
                JOptionPane.showMessageDialog(this, "Illegal value entered.  Please try again.", "Error", 0);
            }
        } catch (NumberFormatException var7) {
            JOptionPane.showMessageDialog(this, "The value entered does not appear to be a valid number", "Error", 0);
        }

    }

    protected final void getNewLabel(String var1, byte var2) {
        String var3 = (String)JOptionPane.showInputDialog(this, var1, "Enter Axis Label", 1, (Icon)null, (Object[])null, "label");
        if (var3 != null) {
            this.graphPanel.setAxisLabel(var3, var2);
        }
    }

    protected void pushChanges() {
        this.graphPanel.repaint();
    }

    public void deleteAllGraphs() {
        this.graphPanel.deleteAllGraphs();
        this.pushChanges();
    }

    public GraphFrame() {
        super("IT Grapher");
        this.contentsPane.setLayout(new BorderLayout());
        ((JComponent)this.contentsPane).setBorder(new BevelBorder(1));
        GraphFrame$1 var10001 = new GraphFrame$1;
        if (this == null) {
            throw null;
        } else {
            var10001.<init>(this);
            this.addWindowListener(var10001);
            this.graphPanel = new GraphPanel(this);
            this.graphPanel.addGraphListener(this);
            this.contentsPane.add(this.graphPanel, "Center");
            this.buildGUI();
            this.setSize(600, 400);
            this.show();
        }
    }

    private class MenuItemHandler implements ActionListener {
        public void actionPerformed(ActionEvent var1) {
            if (var1.getSource() == GraphFrame.this.exitItem) {
                System.exit(0);
            }

            if (var1.getSource() == GraphFrame.this.xMinItem) {
                GraphFrame.this.getNewValue("Please enter a minimum value for the X axis", (byte)0);
            } else if (var1.getSource() == GraphFrame.this.xMaxItem) {
                GraphFrame.this.getNewValue("Please enter a maximum value for the X axis", (byte)1);
            } else if (var1.getSource() == GraphFrame.this.yMinItem) {
                GraphFrame.this.getNewValue("Please enter a minimum value for the Y axis", (byte)2);
            } else if (var1.getSource() == GraphFrame.this.yMaxItem) {
                GraphFrame.this.getNewValue("Please enter a maximum value for the Y axis", (byte)3);
            } else if (var1.getSource() == GraphFrame.this.axisResetItem) {
                GraphFrame.this.graphPanel.setAxisValue(0.0D, 10.0D, 0.0D, 10.0D);
            } else if (var1.getSource() == GraphFrame.this.setXAxisLabelItem) {
                GraphFrame.this.getNewLabel("Please enter a label for the X axis", (byte)4);
            } else if (var1.getSource() == GraphFrame.this.setYAxisLabelItem) {
                GraphFrame.this.getNewLabel("Please enter a label for the Y axis", (byte)5);
            } else {
                if (var1.getSource() == GraphFrame.this.showAxisLabelsItem) {
                    GraphFrame.this.graphPanel.setShowAxisLabels(GraphFrame.this.showAxisLabelsItem.getState());
                }

            }
        }

        MenuItemHandler() {
        }
    }
}
