// generated with ast extension for cup
// version 0.8
// 9/11/2023 11:53:46


package rs.ac.bg.etf.pp1.ast;

public class StaticInitializerList_Single extends StaticInitializerList {

    public StaticInitializerList_Single () {
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
        buffer.append("StaticInitializerList_Single(\n");

        buffer.append(tab);
        buffer.append(") [StaticInitializerList_Single]");
        return buffer.toString();
    }
}
