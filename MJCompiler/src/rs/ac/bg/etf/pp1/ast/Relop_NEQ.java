// generated with ast extension for cup
// version 0.8
// 13/0/2024 14:0:52


package rs.ac.bg.etf.pp1.ast;

public class Relop_NEQ extends Relop {

    public Relop_NEQ () {
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
        buffer.append("Relop_NEQ(\n");

        buffer.append(tab);
        buffer.append(") [Relop_NEQ]");
        return buffer.toString();
    }
}
