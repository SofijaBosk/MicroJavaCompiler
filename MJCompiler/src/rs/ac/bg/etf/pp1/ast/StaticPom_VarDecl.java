// generated with ast extension for cup
// version 0.8
// 6/0/2024 17:19:38


package rs.ac.bg.etf.pp1.ast;

public class StaticPom_VarDecl extends StaticPom {

    private StaticPom StaticPom;
    private VarDecl VarDecl;

    public StaticPom_VarDecl (StaticPom StaticPom, VarDecl VarDecl) {
        this.StaticPom=StaticPom;
        if(StaticPom!=null) StaticPom.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public StaticPom getStaticPom() {
        return StaticPom;
    }

    public void setStaticPom(StaticPom StaticPom) {
        this.StaticPom=StaticPom;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StaticPom!=null) StaticPom.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StaticPom!=null) StaticPom.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StaticPom!=null) StaticPom.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StaticPom_VarDecl(\n");

        if(StaticPom!=null)
            buffer.append(StaticPom.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StaticPom_VarDecl]");
        return buffer.toString();
    }
}
