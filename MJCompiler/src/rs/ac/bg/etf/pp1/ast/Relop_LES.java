// generated with ast extension for cup
// version 0.8
// 9/11/2023 11:53:46


package rs.ac.bg.etf.pp1.ast;

public class Relop_LES extends Relop {

    public Relop_LES () {
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
        buffer.append("Relop_LES(\n");

        buffer.append(tab);
        buffer.append(") [Relop_LES]");
        return buffer.toString();
    }
}
