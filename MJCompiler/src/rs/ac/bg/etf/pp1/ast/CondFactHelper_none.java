// generated with ast extension for cup
// version 0.8
// 5/11/2023 14:26:2


package rs.ac.bg.etf.pp1.ast;

public class CondFactHelper_none extends CondFactHelper {

    public CondFactHelper_none () {
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
        buffer.append("CondFactHelper_none(\n");

        buffer.append(tab);
        buffer.append(") [CondFactHelper_none]");
        return buffer.toString();
    }
}
