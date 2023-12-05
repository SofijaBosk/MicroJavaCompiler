// generated with ast extension for cup
// version 0.8
// 5/11/2023 14:59:3


package rs.ac.bg.etf.pp1.ast;

public class StaticPom_StaticInitializer extends StaticPom {

    private StaticPom StaticPom;
    private StaticInitializer StaticInitializer;

    public StaticPom_StaticInitializer (StaticPom StaticPom, StaticInitializer StaticInitializer) {
        this.StaticPom=StaticPom;
        if(StaticPom!=null) StaticPom.setParent(this);
        this.StaticInitializer=StaticInitializer;
        if(StaticInitializer!=null) StaticInitializer.setParent(this);
    }

    public StaticPom getStaticPom() {
        return StaticPom;
    }

    public void setStaticPom(StaticPom StaticPom) {
        this.StaticPom=StaticPom;
    }

    public StaticInitializer getStaticInitializer() {
        return StaticInitializer;
    }

    public void setStaticInitializer(StaticInitializer StaticInitializer) {
        this.StaticInitializer=StaticInitializer;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StaticPom!=null) StaticPom.accept(visitor);
        if(StaticInitializer!=null) StaticInitializer.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StaticPom!=null) StaticPom.traverseTopDown(visitor);
        if(StaticInitializer!=null) StaticInitializer.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StaticPom!=null) StaticPom.traverseBottomUp(visitor);
        if(StaticInitializer!=null) StaticInitializer.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StaticPom_StaticInitializer(\n");

        if(StaticPom!=null)
            buffer.append(StaticPom.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StaticInitializer!=null)
            buffer.append(StaticInitializer.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StaticPom_StaticInitializer]");
        return buffer.toString();
    }
}
