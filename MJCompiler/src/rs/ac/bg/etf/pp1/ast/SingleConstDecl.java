// generated with ast extension for cup
// version 0.8
// 5/11/2023 14:26:2


package rs.ac.bg.etf.pp1.ast;

public class SingleConstDecl extends ConstList {

    private ConstSingle ConstSingle;

    public SingleConstDecl (ConstSingle ConstSingle) {
        this.ConstSingle=ConstSingle;
        if(ConstSingle!=null) ConstSingle.setParent(this);
    }

    public ConstSingle getConstSingle() {
        return ConstSingle;
    }

    public void setConstSingle(ConstSingle ConstSingle) {
        this.ConstSingle=ConstSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstSingle!=null) ConstSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstSingle!=null) ConstSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstSingle!=null) ConstSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleConstDecl(\n");

        if(ConstSingle!=null)
            buffer.append(ConstSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleConstDecl]");
        return buffer.toString();
    }
}
