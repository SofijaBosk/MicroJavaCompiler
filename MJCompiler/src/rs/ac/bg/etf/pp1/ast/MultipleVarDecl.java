// generated with ast extension for cup
// version 0.8
// 21/11/2023 16:22:8


package rs.ac.bg.etf.pp1.ast;

public class MultipleVarDecl extends VarlList {

    private VarlList VarlList;
    private VarSingle VarSingle;

    public MultipleVarDecl (VarlList VarlList, VarSingle VarSingle) {
        this.VarlList=VarlList;
        if(VarlList!=null) VarlList.setParent(this);
        this.VarSingle=VarSingle;
        if(VarSingle!=null) VarSingle.setParent(this);
    }

    public VarlList getVarlList() {
        return VarlList;
    }

    public void setVarlList(VarlList VarlList) {
        this.VarlList=VarlList;
    }

    public VarSingle getVarSingle() {
        return VarSingle;
    }

    public void setVarSingle(VarSingle VarSingle) {
        this.VarSingle=VarSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarlList!=null) VarlList.accept(visitor);
        if(VarSingle!=null) VarSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarlList!=null) VarlList.traverseTopDown(visitor);
        if(VarSingle!=null) VarSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarlList!=null) VarlList.traverseBottomUp(visitor);
        if(VarSingle!=null) VarSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleVarDecl(\n");

        if(VarlList!=null)
            buffer.append(VarlList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarSingle!=null)
            buffer.append(VarSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleVarDecl]");
        return buffer.toString();
    }
}
