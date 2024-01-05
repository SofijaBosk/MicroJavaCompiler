// generated with ast extension for cup
// version 0.8
// 5/0/2024 10:56:20


package rs.ac.bg.etf.pp1.ast;

public class DesignatorHelper_Scope extends DesignatorHelper {

    private String I1;
    private String name;

    public DesignatorHelper_Scope (String I1, String name) {
        this.I1=I1;
        this.name=name;
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
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
        buffer.append("DesignatorHelper_Scope(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorHelper_Scope]");
        return buffer.toString();
    }
}
