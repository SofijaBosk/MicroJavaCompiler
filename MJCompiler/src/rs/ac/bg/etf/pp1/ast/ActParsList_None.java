// generated with ast extension for cup
// version 0.8
// 7/0/2024 14:15:46


package rs.ac.bg.etf.pp1.ast;

public class ActParsList_None extends ActParsList {

    public ActParsList_None () {
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
        buffer.append("ActParsList_None(\n");

        buffer.append(tab);
        buffer.append(") [ActParsList_None]");
        return buffer.toString();
    }
}
