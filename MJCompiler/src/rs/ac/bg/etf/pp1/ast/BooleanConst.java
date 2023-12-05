// generated with ast extension for cup
// version 0.8
// 5/11/2023 13:34:47


package rs.ac.bg.etf.pp1.ast;

public class BooleanConst extends ConstSingle {

    private String booleanConstName;
    private String booleanConstValue;

    public BooleanConst (String booleanConstName, String booleanConstValue) {
        this.booleanConstName=booleanConstName;
        this.booleanConstValue=booleanConstValue;
    }

    public String getBooleanConstName() {
        return booleanConstName;
    }

    public void setBooleanConstName(String booleanConstName) {
        this.booleanConstName=booleanConstName;
    }

    public String getBooleanConstValue() {
        return booleanConstValue;
    }

    public void setBooleanConstValue(String booleanConstValue) {
        this.booleanConstValue=booleanConstValue;
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
        buffer.append("BooleanConst(\n");

        buffer.append(" "+tab+booleanConstName);
        buffer.append("\n");

        buffer.append(" "+tab+booleanConstValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BooleanConst]");
        return buffer.toString();
    }
}
