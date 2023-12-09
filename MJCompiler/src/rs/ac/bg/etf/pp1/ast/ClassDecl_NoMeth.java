// generated with ast extension for cup
// version 0.8
// 9/11/2023 11:53:46


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl_NoMeth extends ClassDecl {

    private ClassDeclPom ClassDeclPom;

    public ClassDecl_NoMeth (ClassDeclPom ClassDeclPom) {
        this.ClassDeclPom=ClassDeclPom;
        if(ClassDeclPom!=null) ClassDeclPom.setParent(this);
    }

    public ClassDeclPom getClassDeclPom() {
        return ClassDeclPom;
    }

    public void setClassDeclPom(ClassDeclPom ClassDeclPom) {
        this.ClassDeclPom=ClassDeclPom;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassDeclPom!=null) ClassDeclPom.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclPom!=null) ClassDeclPom.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclPom!=null) ClassDeclPom.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl_NoMeth(\n");

        if(ClassDeclPom!=null)
            buffer.append(ClassDeclPom.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl_NoMeth]");
        return buffer.toString();
    }
}
