// generated with ast extension for cup
// version 0.8
// 9/11/2023 14:9:50


package rs.ac.bg.etf.pp1.ast;

public class IntegerConst extends ConstSingle {

    private String intConstName;
    private Integer intConstValue;

    public IntegerConst (String intConstName, Integer intConstValue) {
        this.intConstName=intConstName;
        this.intConstValue=intConstValue;
    }

    public String getIntConstName() {
        return intConstName;
    }

    public void setIntConstName(String intConstName) {
        this.intConstName=intConstName;
    }

    public Integer getIntConstValue() {
        return intConstValue;
    }

    public void setIntConstValue(Integer intConstValue) {
        this.intConstValue=intConstValue;
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
        buffer.append("IntegerConst(\n");

        buffer.append(" "+tab+intConstName);
        buffer.append("\n");

        buffer.append(" "+tab+intConstValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IntegerConst]");
        return buffer.toString();
    }
}
