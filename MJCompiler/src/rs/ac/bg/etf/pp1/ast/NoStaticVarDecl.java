// generated with ast extension for cup
// version 0.8
// 6/0/2024 17:19:38


package rs.ac.bg.etf.pp1.ast;

public class NoStaticVarDecl extends VarStaticDeclList {

    public NoStaticVarDecl () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoStaticVarDecl(\n");

        buffer.append(tab);
        buffer.append(") [NoStaticVarDecl]");
        return buffer.toString();
    }
}
