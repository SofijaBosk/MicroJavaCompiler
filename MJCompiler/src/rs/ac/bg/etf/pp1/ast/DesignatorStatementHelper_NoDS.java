// generated with ast extension for cup
// version 0.8
// 25/11/2023 13:14:53


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementHelper_NoDS extends DesignatorStatementHelper {

    public DesignatorStatementHelper_NoDS () {
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
        buffer.append("DesignatorStatementHelper_NoDS(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementHelper_NoDS]");
        return buffer.toString();
    }
}
