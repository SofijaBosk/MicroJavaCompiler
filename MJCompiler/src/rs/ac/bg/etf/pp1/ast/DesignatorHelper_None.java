// generated with ast extension for cup
// version 0.8
// 9/11/2023 14:14:26


package rs.ac.bg.etf.pp1.ast;

public class DesignatorHelper_None extends DesignatorHelper {

    private String I1;

    public DesignatorHelper_None (String I1) {
        this.I1=I1;
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
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
        buffer.append("DesignatorHelper_None(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorHelper_None]");
        return buffer.toString();
    }
}
