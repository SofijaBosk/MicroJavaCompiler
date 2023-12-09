// generated with ast extension for cup
// version 0.8
// 9/11/2023 14:9:50


package rs.ac.bg.etf.pp1.ast;

public class VarStaticDeclarations extends VarStaticDeclList {

    private VarStaticDeclList VarStaticDeclList;
    private VarDecl VarDecl;

    public VarStaticDeclarations (VarStaticDeclList VarStaticDeclList, VarDecl VarDecl) {
        this.VarStaticDeclList=VarStaticDeclList;
        if(VarStaticDeclList!=null) VarStaticDeclList.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public VarStaticDeclList getVarStaticDeclList() {
        return VarStaticDeclList;
    }

    public void setVarStaticDeclList(VarStaticDeclList VarStaticDeclList) {
        this.VarStaticDeclList=VarStaticDeclList;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarStaticDeclList!=null) VarStaticDeclList.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarStaticDeclList!=null) VarStaticDeclList.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarStaticDeclList!=null) VarStaticDeclList.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarStaticDeclarations(\n");

        if(VarStaticDeclList!=null)
            buffer.append(VarStaticDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarStaticDeclarations]");
        return buffer.toString();
    }
}
