// generated with ast extension for cup
// version 0.8
// 5/11/2023 13:34:47


package rs.ac.bg.etf.pp1.ast;

public class NamespaceProg extends Namespace {

    private String I1;
    private ProgDeclList ProgDeclList;
    private MethodDeclList MethodDeclList;

    public NamespaceProg (String I1, ProgDeclList ProgDeclList, MethodDeclList MethodDeclList) {
        this.I1=I1;
        this.ProgDeclList=ProgDeclList;
        if(ProgDeclList!=null) ProgDeclList.setParent(this);
        this.MethodDeclList=MethodDeclList;
        if(MethodDeclList!=null) MethodDeclList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
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
        if(ProgDeclList!=null) ProgDeclList.accept(visitor);
        if(MethodDeclList!=null) MethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgDeclList!=null) ProgDeclList.traverseTopDown(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgDeclList!=null) ProgDeclList.traverseBottomUp(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NamespaceProg(\n");

        buffer.append(" "+tab+I1);
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
