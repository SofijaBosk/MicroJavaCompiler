// generated with ast extension for cup
// version 0.8
// 5/11/2023 14:26:2


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclPom_NoMeth extends ClassDeclPom {

    private String I1;
    private ExtendsFrom ExtendsFrom;
    private StaticPom StaticPom;
    private VarDeclList VarDeclList;

    public ClassDeclPom_NoMeth (String I1, ExtendsFrom ExtendsFrom, StaticPom StaticPom, VarDeclList VarDeclList) {
        this.I1=I1;
        this.ExtendsFrom=ExtendsFrom;
        if(ExtendsFrom!=null) ExtendsFrom.setParent(this);
        this.StaticPom=StaticPom;
        if(StaticPom!=null) StaticPom.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ExtendsFrom getExtendsFrom() {
        return ExtendsFrom;
    }

    public void setExtendsFrom(ExtendsFrom ExtendsFrom) {
        this.ExtendsFrom=ExtendsFrom;
    }

    public StaticPom getStaticPom() {
        return StaticPom;
    }

    public void setStaticPom(StaticPom StaticPom) {
        this.StaticPom=StaticPom;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendsFrom!=null) ExtendsFrom.accept(visitor);
        if(StaticPom!=null) StaticPom.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsFrom!=null) ExtendsFrom.traverseTopDown(visitor);
        if(StaticPom!=null) StaticPom.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsFrom!=null) ExtendsFrom.traverseBottomUp(visitor);
        if(StaticPom!=null) StaticPom.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclPom_NoMeth(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ExtendsFrom!=null)
            buffer.append(ExtendsFrom.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StaticPom!=null)
            buffer.append(StaticPom.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclPom_NoMeth]");
        return buffer.toString();
    }
}
