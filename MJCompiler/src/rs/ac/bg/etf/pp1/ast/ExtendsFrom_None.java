// generated with ast extension for cup
// version 0.8
// 15/11/2023 23:57:14


package rs.ac.bg.etf.pp1.ast;

public class ExtendsFrom_None extends ExtendsFrom {

    public ExtendsFrom_None () {
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
        buffer.append("ExtendsFrom_None(\n");

        buffer.append(tab);
        buffer.append(") [ExtendsFrom_None]");
        return buffer.toString();
    }
}
