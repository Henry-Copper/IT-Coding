//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it;

import java.util.Enumeration;
import java.util.Vector;

class GraphPanel$GraphVector {
    private Vector graphs;

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

    GraphPanel$GraphVector(GraphPanel var1) {
        this.this$0 = var1;
        this.graphs = new Vector();
    }
}
