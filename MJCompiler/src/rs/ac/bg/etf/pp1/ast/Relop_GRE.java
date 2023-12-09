// generated with ast extension for cup
// version 0.8
// 9/11/2023 14:9:51


package rs.ac.bg.etf.pp1.ast;

public class Relop_GRE extends Relop {

    public Relop_GRE () {
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
        buffer.append("Relop_GRE(\n");

        buffer.append(tab);
        buffer.append(") [Relop_GRE]");
        return buffer.toString();
    }
}
