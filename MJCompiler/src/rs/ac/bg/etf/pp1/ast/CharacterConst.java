// generated with ast extension for cup
// version 0.8
// 5/11/2023 13:32:52


package rs.ac.bg.etf.pp1.ast;

public class CharacterConst extends ConstSingle {

    private String charConstName;
    private Character charConstValue;

    public CharacterConst (String charConstName, Character charConstValue) {
        this.charConstName=charConstName;
        this.charConstValue=charConstValue;
    }

    public String getCharConstName() {
        return charConstName;
    }

    public void setCharConstName(String charConstName) {
        this.charConstName=charConstName;
    }

    public Character getCharConstValue() {
        return charConstValue;
    }

    public void setCharConstValue(Character charConstValue) {
        this.charConstValue=charConstValue;
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
        buffer.append("CharacterConst(\n");

        buffer.append(" "+tab+charConstName);
        buffer.append("\n");

        buffer.append(" "+tab+charConstValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharacterConst]");
        return buffer.toString();
    }
}
