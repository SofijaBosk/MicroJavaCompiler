// generated with ast extension for cup
// version 0.8
// 5/0/2024 10:56:20


package rs.ac.bg.etf.pp1.ast;

public class ReturnMethod_Void extends ReturnMethod {

    public ReturnMethod_Void () {
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
        buffer.append("ReturnMethod_Void(\n");

        buffer.append(tab);
        buffer.append(") [ReturnMethod_Void]");
        return buffer.toString();
    }
}
