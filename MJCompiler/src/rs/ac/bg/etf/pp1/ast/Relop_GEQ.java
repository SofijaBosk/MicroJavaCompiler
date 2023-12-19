// generated with ast extension for cup
// version 0.8
// 19/11/2023 14:58:43


package rs.ac.bg.etf.pp1.ast;

public class Relop_GEQ extends Relop {

    public Relop_GEQ () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Relop_GEQ(\n");

        buffer.append(tab);
        buffer.append(") [Relop_GEQ]");
        return buffer.toString();
    }
}
