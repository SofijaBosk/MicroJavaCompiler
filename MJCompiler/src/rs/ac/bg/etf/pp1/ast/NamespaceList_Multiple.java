// generated with ast extension for cup
// version 0.8
// 14/0/2024 12:18:27


package rs.ac.bg.etf.pp1.ast;

public class NamespaceList_Multiple extends NamespaceList {

    public NamespaceList_Multiple () {
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
        buffer.append("NamespaceList_Multiple(\n");

        buffer.append(tab);
        buffer.append(") [NamespaceList_Multiple]");
        return buffer.toString();
    }
}
