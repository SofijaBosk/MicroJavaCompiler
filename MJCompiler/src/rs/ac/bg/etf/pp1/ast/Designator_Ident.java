// generated with ast extension for cup
// version 0.8
// 7/0/2024 14:15:46


package rs.ac.bg.etf.pp1.ast;

public class Designator_Ident extends Designator {

    private DesignatorHelper DesignatorHelper;

    public Designator_Ident (DesignatorHelper DesignatorHelper) {
        this.DesignatorHelper=DesignatorHelper;
        if(DesignatorHelper!=null) DesignatorHelper.setParent(this);
    }

    public DesignatorHelper getDesignatorHelper() {
        return DesignatorHelper;
    }

    public void setDesignatorHelper(DesignatorHelper DesignatorHelper) {
        this.DesignatorHelper=DesignatorHelper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorHelper!=null) DesignatorHelper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorHelper!=null) DesignatorHelper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorHelper!=null) DesignatorHelper.traverseBottomUp(visitor);
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

        buffer.append(tab);
        buffer.append(") [Designator_Ident]");
        return buffer.toString();
    }
}
