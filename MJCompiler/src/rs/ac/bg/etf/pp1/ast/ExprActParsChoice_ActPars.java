// generated with ast extension for cup
// version 0.8
// 9/11/2023 14:9:50


package rs.ac.bg.etf.pp1.ast;

public class ExprActParsChoice_ActPars extends ExprActParsChoice {

    private ActParsList ActParsList;

    public ExprActParsChoice_ActPars (ActParsList ActParsList) {
        this.ActParsList=ActParsList;
        if(ActParsList!=null) ActParsList.setParent(this);
    }

    public ActParsList getActParsList() {
        return ActParsList;
    }

    public void setActParsList(ActParsList ActParsList) {
        this.ActParsList=ActParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsList!=null) ActParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsList!=null) ActParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsList!=null) ActParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprActParsChoice_ActPars(\n");

        if(ActParsList!=null)
            buffer.append(ActParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprActParsChoice_ActPars]");
        return buffer.toString();
    }
}
