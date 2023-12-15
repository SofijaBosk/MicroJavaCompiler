// generated with ast extension for cup
// version 0.8
// 15/11/2023 23:57:14


package rs.ac.bg.etf.pp1.ast;

public class NamespaceList_Single extends NamespaceList {

    private NamespaceList NamespaceList;
    private NamespaceNT NamespaceNT;

    public NamespaceList_Single (NamespaceList NamespaceList, NamespaceNT NamespaceNT) {
        this.NamespaceList=NamespaceList;
        if(NamespaceList!=null) NamespaceList.setParent(this);
        this.NamespaceNT=NamespaceNT;
        if(NamespaceNT!=null) NamespaceNT.setParent(this);
    }

    public NamespaceList getNamespaceList() {
        return NamespaceList;
    }

    public void setNamespaceList(NamespaceList NamespaceList) {
        this.NamespaceList=NamespaceList;
    }

    public NamespaceNT getNamespaceNT() {
        return NamespaceNT;
    }

    public void setNamespaceNT(NamespaceNT NamespaceNT) {
        this.NamespaceNT=NamespaceNT;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NamespaceList!=null) NamespaceList.accept(visitor);
        if(NamespaceNT!=null) NamespaceNT.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NamespaceList!=null) NamespaceList.traverseTopDown(visitor);
        if(NamespaceNT!=null) NamespaceNT.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NamespaceList!=null) NamespaceList.traverseBottomUp(visitor);
        if(NamespaceNT!=null) NamespaceNT.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NamespaceList_Single(\n");

        if(NamespaceList!=null)
            buffer.append(NamespaceList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NamespaceNT!=null)
            buffer.append(NamespaceNT.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NamespaceList_Single]");
        return buffer.toString();
    }
}
