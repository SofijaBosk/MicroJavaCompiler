// generated with ast extension for cup
// version 0.8
// 9/0/2024 13:33:46


package rs.ac.bg.etf.pp1.ast;

public class Relop_LEQ extends Relop {

    public Relop_LEQ () {
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
        buffer.append("Relop_LEQ(\n");

        buffer.append(tab);
        buffer.append(") [Relop_LEQ]");
        return buffer.toString();
    }
}
