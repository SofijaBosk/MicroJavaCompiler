// generated with ast extension for cup
// version 0.8
// 9/11/2023 20:7:53


package rs.ac.bg.etf.pp1.ast;

public class Designator_Ident extends Designator {

    private DesignatorHelper DesignatorHelper;
    private DesignatorHelper2 DesignatorHelper2;

    public Designator_Ident (DesignatorHelper DesignatorHelper, DesignatorHelper2 DesignatorHelper2) {
        this.DesignatorHelper=DesignatorHelper;
        if(DesignatorHelper!=null) DesignatorHelper.setParent(this);
        this.DesignatorHelper2=DesignatorHelper2;
        if(DesignatorHelper2!=null) DesignatorHelper2.setParent(this);
    }

    public DesignatorHelper getDesignatorHelper() {
        return DesignatorHelper;
    }

    public void setDesignatorHelper(DesignatorHelper DesignatorHelper) {
        this.DesignatorHelper=DesignatorHelper;
    }

    public DesignatorHelper2 getDesignatorHelper2() {
        return DesignatorHelper2;
    }

    public void setDesignatorHelper2(DesignatorHelper2 DesignatorHelper2) {
        this.DesignatorHelper2=DesignatorHelper2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorHelper!=null) DesignatorHelper.accept(visitor);
        if(DesignatorHelper2!=null) DesignatorHelper2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorHelper!=null) DesignatorHelper.traverseTopDown(visitor);
        if(DesignatorHelper2!=null) DesignatorHelper2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorHelper!=null) DesignatorHelper.traverseBottomUp(visitor);
        if(DesignatorHelper2!=null) DesignatorHelper2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator_Ident(\n");

        if(DesignatorHelper!=null)
            buffer.append(DesignatorHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorHelper2!=null)
            buffer.append(DesignatorHelper2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator_Ident]");
        return buffer.toString();
    }
}
