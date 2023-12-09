// generated with ast extension for cup
// version 0.8
// 9/11/2023 20:7:52


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl_Meth extends ClassDecl {

    private ClassDeclPom ClassDeclPom;
    private MethodDeclList MethodDeclList;

    public ClassDecl_Meth (ClassDeclPom ClassDeclPom, MethodDeclList MethodDeclList) {
        this.ClassDeclPom=ClassDeclPom;
        if(ClassDeclPom!=null) ClassDeclPom.setParent(this);
        this.MethodDeclList=MethodDeclList;
        if(MethodDeclList!=null) MethodDeclList.setParent(this);
    }

    public ClassDeclPom getClassDeclPom() {
        return ClassDeclPom;
    }

    public void setClassDeclPom(ClassDeclPom ClassDeclPom) {
        this.ClassDeclPom=ClassDeclPom;
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
        if(ClassDeclPom!=null) ClassDeclPom.accept(visitor);
        if(MethodDeclList!=null) MethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclPom!=null) ClassDeclPom.traverseTopDown(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclPom!=null) ClassDeclPom.traverseBottomUp(visitor);
        if(MethodDeclList!=null) MethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl_Meth(\n");

        if(ClassDeclPom!=null)
            buffer.append(ClassDeclPom.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclList!=null)
            buffer.append(MethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl_Meth]");
        return buffer.toString();
    }
}
