// generated with ast extension for cup
// version 0.8
// 19/11/2023 17:23:48


package rs.ac.bg.etf.pp1.ast;

public class FORStmt_NoDS extends Matched {

    private DesignatorStatementHelper DesignatorStatementHelper;
    private CondFactHelper CondFactHelper;
    private DesignatorStatementHelper DesignatorStatementHelper1;

    public FORStmt_NoDS (DesignatorStatementHelper DesignatorStatementHelper, CondFactHelper CondFactHelper, DesignatorStatementHelper DesignatorStatementHelper1) {
        this.DesignatorStatementHelper=DesignatorStatementHelper;
        if(DesignatorStatementHelper!=null) DesignatorStatementHelper.setParent(this);
        this.CondFactHelper=CondFactHelper;
        if(CondFactHelper!=null) CondFactHelper.setParent(this);
        this.DesignatorStatementHelper1=DesignatorStatementHelper1;
        if(DesignatorStatementHelper1!=null) DesignatorStatementHelper1.setParent(this);
    }

    public DesignatorStatementHelper getDesignatorStatementHelper() {
        return DesignatorStatementHelper;
    }

    public void setDesignatorStatementHelper(DesignatorStatementHelper DesignatorStatementHelper) {
        this.DesignatorStatementHelper=DesignatorStatementHelper;
    }

    public CondFactHelper getCondFactHelper() {
        return CondFactHelper;
    }

    public void setCondFactHelper(CondFactHelper CondFactHelper) {
        this.CondFactHelper=CondFactHelper;
    }

    public DesignatorStatementHelper getDesignatorStatementHelper1() {
        return DesignatorStatementHelper1;
    }

    public void setDesignatorStatementHelper1(DesignatorStatementHelper DesignatorStatementHelper1) {
        this.DesignatorStatementHelper1=DesignatorStatementHelper1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementHelper!=null) DesignatorStatementHelper.accept(visitor);
        if(CondFactHelper!=null) CondFactHelper.accept(visitor);
        if(DesignatorStatementHelper1!=null) DesignatorStatementHelper1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementHelper!=null) DesignatorStatementHelper.traverseTopDown(visitor);
        if(CondFactHelper!=null) CondFactHelper.traverseTopDown(visitor);
        if(DesignatorStatementHelper1!=null) DesignatorStatementHelper1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementHelper!=null) DesignatorStatementHelper.traverseBottomUp(visitor);
        if(CondFactHelper!=null) CondFactHelper.traverseBottomUp(visitor);
        if(DesignatorStatementHelper1!=null) DesignatorStatementHelper1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FORStmt_NoDS(\n");

        if(DesignatorStatementHelper!=null)
            buffer.append(DesignatorStatementHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFactHelper!=null)
            buffer.append(CondFactHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementHelper1!=null)
            buffer.append(DesignatorStatementHelper1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FORStmt_NoDS]");
        return buffer.toString();
    }
}
