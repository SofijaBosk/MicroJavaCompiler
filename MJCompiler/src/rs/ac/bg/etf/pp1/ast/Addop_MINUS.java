// generated with ast extension for cup
// version 0.8
// 6/0/2024 13:29:57


package rs.ac.bg.etf.pp1.ast;

public class Addop_MINUS extends Addop {

    public Addop_MINUS () {
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
        buffer.append("Addop_MINUS(\n");

        buffer.append(tab);
        buffer.append(") [Addop_MINUS]");
        return buffer.toString();
    }
}
