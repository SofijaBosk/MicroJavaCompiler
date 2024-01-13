// generated with ast extension for cup
// version 0.8
// 13/0/2024 14:0:52


package rs.ac.bg.etf.pp1.ast;

public class MethodTypeName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ReturnMethod ReturnMethod;
    private String methName;

    public MethodTypeName (ReturnMethod ReturnMethod, String methName) {
        this.ReturnMethod=ReturnMethod;
        if(ReturnMethod!=null) ReturnMethod.setParent(this);
        this.methName=methName;
    }

    public ReturnMethod getReturnMethod() {
        return ReturnMethod;
    }

    public void setReturnMethod(ReturnMethod ReturnMethod) {
        this.ReturnMethod=ReturnMethod;
    }

    public String getMethName() {
        return methName;
    }

    public void setMethName(String methName) {
        this.methName=methName;
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
        if(ReturnMethod!=null) ReturnMethod.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnMethod!=null) ReturnMethod.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnMethod!=null) ReturnMethod.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodTypeName(\n");

        if(ReturnMethod!=null)
            buffer.append(ReturnMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+methName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodTypeName]");
        return buffer.toString();
    }
}
