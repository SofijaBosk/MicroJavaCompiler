// generated with ast extension for cup
// version 0.8
// 14/0/2024 12:51:54


package rs.ac.bg.etf.pp1.ast;

public class MultipleConstDecl extends ConstList {

    private ConstList ConstList;
    private ConstSingle ConstSingle;

    public MultipleConstDecl (ConstList ConstList, ConstSingle ConstSingle) {
        this.ConstList=ConstList;
        if(ConstList!=null) ConstList.setParent(this);
        this.ConstSingle=ConstSingle;
        if(ConstSingle!=null) ConstSingle.setParent(this);
    }

    public ConstList getConstList() {
        return ConstList;
    }

    public void setConstList(ConstList ConstList) {
        this.ConstList=ConstList;
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
        if(ConstList!=null) ConstList.accept(visitor);
        if(ConstSingle!=null) ConstSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstList!=null) ConstList.traverseTopDown(visitor);
        if(ConstSingle!=null) ConstSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstList!=null) ConstList.traverseBottomUp(visitor);
        if(ConstSingle!=null) ConstSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleConstDecl(\n");

        if(ConstList!=null)
            buffer.append(ConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstSingle!=null)
            buffer.append(ConstSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleConstDecl]");
        return buffer.toString();
    }
}
