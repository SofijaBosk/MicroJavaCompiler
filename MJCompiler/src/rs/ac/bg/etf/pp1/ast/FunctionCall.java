// generated with ast extension for cup
// version 0.8
// 6/0/2024 17:19:38


package rs.ac.bg.etf.pp1.ast;

public class FunctionCall implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private Designator Designator;
    private ActParsIE ActParsIE;

    public FunctionCall (Designator Designator, ActParsIE ActParsIE) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsIE=ActParsIE;
        if(ActParsIE!=null) ActParsIE.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsIE getActParsIE() {
        return ActParsIE;
    }

    public void setActParsIE(ActParsIE ActParsIE) {
        this.ActParsIE=ActParsIE;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsIE!=null) ActParsIE.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsIE!=null) ActParsIE.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsIE!=null) ActParsIE.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FunctionCall(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsIE!=null)
            buffer.append(ActParsIE.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FunctionCall]");
        return buffer.toString();
    }
}
