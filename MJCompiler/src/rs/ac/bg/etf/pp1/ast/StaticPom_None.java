// generated with ast extension for cup
// version 0.8
// 6/0/2024 17:19:38


package rs.ac.bg.etf.pp1.ast;

public class StaticPom_None extends StaticPom {

    public StaticPom_None () {
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
        buffer.append("StaticPom_None(\n");

        buffer.append(tab);
        buffer.append(") [StaticPom_None]");
        return buffer.toString();
    }
}
