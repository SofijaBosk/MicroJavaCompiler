// generated with ast extension for cup
// version 0.8
// 15/11/2023 23:57:14


package rs.ac.bg.etf.pp1.ast;

public class NewFactor extends Factor {

    private Type Type;
    private ExprActParsChoice ExprActParsChoice;

    public NewFactor (Type Type, ExprActParsChoice ExprActParsChoice) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ExprActParsChoice=ExprActParsChoice;
        if(ExprActParsChoice!=null) ExprActParsChoice.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ExprActParsChoice getExprActParsChoice() {
        return ExprActParsChoice;
    }

    public void setExprActParsChoice(ExprActParsChoice ExprActParsChoice) {
        this.ExprActParsChoice=ExprActParsChoice;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ExprActParsChoice!=null) ExprActParsChoice.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ExprActParsChoice!=null) ExprActParsChoice.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ExprActParsChoice!=null) ExprActParsChoice.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NewFactor(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprActParsChoice!=null)
            buffer.append(ExprActParsChoice.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NewFactor]");
        return buffer.toString();
    }
}
