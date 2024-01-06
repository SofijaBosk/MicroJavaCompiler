// generated with ast extension for cup
// version 0.8
// 6/0/2024 17:19:38


package rs.ac.bg.etf.pp1.ast;

public class NamespaceProg extends NamespaceNT {

    private NamespaceName NamespaceName;
    private ProgDeclList ProgDeclList;
    private MethodDeclList MethodDeclList;

    public NamespaceProg (NamespaceName NamespaceName, ProgDeclList ProgDeclList, MethodDeclList MethodDeclList) {
        this.NamespaceName=NamespaceName;
        if(NamespaceName!=null) NamespaceName.setParent(this);
        this.ProgDeclList=ProgDeclList;
        if(ProgDeclList!=null) ProgDeclList.setParent(this);
        this.MethodDeclList=MethodDeclList;
        if(MethodDeclList!=null) MethodDeclList.setParent(this);
    }

    public NamespaceName getNamespaceName() {
        return NamespaceName;
    }

    public void setNamespaceName(NamespaceName NamespaceName) {
        this.NamespaceName=NamespaceName;
    }

    public ProgDeclList getProgDeclList() {
        return ProgDeclList;
    }

    public void setProgDeclList(ProgDeclList ProgDeclList) {
        this.ProgDeclList=ProgDeclList;
    }

    public MethodDeclList getMethodDeclList() {
        return MethodDeclList;
    }

    public void setMethodDeclList(MethodDeclList MethodDeclList) {
        this.MethodDeclList=MethodDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NamespaceName!=null) NamespaceName.accept(visitor);
        if(ProgDeclList!=null) ProgDeclList.accept(visitor);
        if(MethodDeclList!=null) MethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NamespaceName!=null) NamespaceName.traverseTopDown(visitor);
        if(ProgDeclList!=null) ProgDeclList.traverseTopDown(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NamespaceName!=null) NamespaceName.traverseBottomUp(visitor);
        if(ProgDeclList!=null) ProgDeclList.traverseBottomUp(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NamespaceProg(\n");

        if(NamespaceName!=null)
            buffer.append(NamespaceName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ProgDeclList!=null)
            buffer.append(ProgDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclList!=null)
            buffer.append(MethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NamespaceProg]");
        return buffer.toString();
    }
}
