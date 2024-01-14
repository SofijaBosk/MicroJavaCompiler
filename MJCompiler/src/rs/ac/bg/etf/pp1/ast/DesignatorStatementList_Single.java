// generated with ast extension for cup
// version 0.8
// 14/0/2024 12:18:27


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementList_Single extends DesignatorStatementList {

    public DesignatorStatementList_Single () {
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
        buffer.append("DesignatorStatementList_Single(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementList_Single]");
        return buffer.toString();
    }
}
