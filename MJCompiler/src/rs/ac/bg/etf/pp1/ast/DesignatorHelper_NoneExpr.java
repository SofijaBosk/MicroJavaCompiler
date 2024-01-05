// generated with ast extension for cup
// version 0.8
// 29/11/2023 9:20:13


package rs.ac.bg.etf.pp1.ast;

public class DesignatorHelper_NoneExpr extends DesignatorHelper2 {

    public DesignatorHelper_NoneExpr () {
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
        buffer.append("DesignatorHelper_NoneExpr(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorHelper_NoneExpr]");
        return buffer.toString();
    }
}
