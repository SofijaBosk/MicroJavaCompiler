// generated with ast extension for cup
// version 0.8
// 15/11/2023 23:57:14


package rs.ac.bg.etf.pp1.ast;

public class Relop_EQ extends Relop {

    public Relop_EQ () {
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
        buffer.append("Relop_EQ(\n");

        buffer.append(tab);
        buffer.append(") [Relop_EQ]");
        return buffer.toString();
    }
}
