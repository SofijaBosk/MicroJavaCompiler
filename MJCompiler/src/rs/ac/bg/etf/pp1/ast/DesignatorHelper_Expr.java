// generated with ast extension for cup
// version 0.8
// 9/11/2023 20:7:53


package rs.ac.bg.etf.pp1.ast;

public class DesignatorHelper_Expr extends DesignatorHelper2 {

    private DesignatorHelper2 DesignatorHelper2;
    private Expr Expr;

    public DesignatorHelper_Expr (DesignatorHelper2 DesignatorHelper2, Expr Expr) {
        this.DesignatorHelper2=DesignatorHelper2;
        if(DesignatorHelper2!=null) DesignatorHelper2.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesignatorHelper2 getDesignatorHelper2() {
        return DesignatorHelper2;
    }

    public void setDesignatorHelper2(DesignatorHelper2 DesignatorHelper2) {
        this.DesignatorHelper2=DesignatorHelper2;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorHelper2!=null) DesignatorHelper2.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorHelper2!=null) DesignatorHelper2.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorHelper2!=null) DesignatorHelper2.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorHelper_Expr(\n");

        if(DesignatorHelper2!=null)
            buffer.append(DesignatorHelper2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorHelper_Expr]");
        return buffer.toString();
    }
}
