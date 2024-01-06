// generated with ast extension for cup
// version 0.8
// 6/0/2024 13:29:57


package rs.ac.bg.etf.pp1.ast;

public class VarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private TypeDummy TypeDummy;
    private VarlList VarlList;

    public VarDecl (TypeDummy TypeDummy, VarlList VarlList) {
        this.TypeDummy=TypeDummy;
        if(TypeDummy!=null) TypeDummy.setParent(this);
        this.VarlList=VarlList;
        if(VarlList!=null) VarlList.setParent(this);
    }

    public TypeDummy getTypeDummy() {
        return TypeDummy;
    }

    public void setTypeDummy(TypeDummy TypeDummy) {
        this.TypeDummy=TypeDummy;
    }

    public VarlList getVarlList() {
        return VarlList;
    }

    public void setVarlList(VarlList VarlList) {
        this.VarlList=VarlList;
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
        if(TypeDummy!=null) TypeDummy.accept(visitor);
        if(VarlList!=null) VarlList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeDummy!=null) TypeDummy.traverseTopDown(visitor);
        if(VarlList!=null) VarlList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeDummy!=null) TypeDummy.traverseBottomUp(visitor);
        if(VarlList!=null) VarlList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecl(\n");

        if(TypeDummy!=null)
            buffer.append(TypeDummy.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarlList!=null)
            buffer.append(VarlList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecl]");
        return buffer.toString();
    }
}
