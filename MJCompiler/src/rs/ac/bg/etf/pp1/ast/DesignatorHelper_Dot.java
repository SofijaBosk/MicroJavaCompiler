// generated with ast extension for cup
// version 0.8
// 21/11/2023 14:50:29


package rs.ac.bg.etf.pp1.ast;

public class DesignatorHelper_Dot extends DesignatorHelper2 {

    private DesignatorHelper2 DesignatorHelper2;
    private String I2;

    public DesignatorHelper_Dot (DesignatorHelper2 DesignatorHelper2, String I2) {
        this.DesignatorHelper2=DesignatorHelper2;
        if(DesignatorHelper2!=null) DesignatorHelper2.setParent(this);
        this.I2=I2;
    }

    public DesignatorHelper2 getDesignatorHelper2() {
        return DesignatorHelper2;
    }

    public void setDesignatorHelper2(DesignatorHelper2 DesignatorHelper2) {
        this.DesignatorHelper2=DesignatorHelper2;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorHelper2!=null) DesignatorHelper2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorHelper2!=null) DesignatorHelper2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorHelper2!=null) DesignatorHelper2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorHelper_Dot(\n");

        if(DesignatorHelper2!=null)
            buffer.append(DesignatorHelper2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorHelper_Dot]");
        return buffer.toString();
    }
}
