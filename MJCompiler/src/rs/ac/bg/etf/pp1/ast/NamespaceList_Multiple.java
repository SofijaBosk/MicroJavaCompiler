// generated with ast extension for cup
// version 0.8
// 5/11/2023 13:23:37


package rs.ac.bg.etf.pp1.ast;

public class NamespaceList_Multiple extends NamespaceList {

    private Namespace Namespace;

    public NamespaceList_Multiple (Namespace Namespace) {
        this.Namespace=Namespace;
        if(Namespace!=null) Namespace.setParent(this);
    }

    public Namespace getNamespace() {
        return Namespace;
    }

    public void setNamespace(Namespace Namespace) {
        this.Namespace=Namespace;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Namespace!=null) Namespace.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Namespace!=null) Namespace.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Namespace!=null) Namespace.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NamespaceList_Multiple(\n");

        if(Namespace!=null)
            buffer.append(Namespace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NamespaceList_Multiple]");
        return buffer.toString();
    }
}
