// generated with ast extension for cup
// version 0.8
// 14/0/2024 12:51:54


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedIfElse extends Unmatched {

    private IfDummy IfDummy;
    private Condition Condition;
    private Matched Matched;
    private ElseDummy ElseDummy;
    private Unmatched Unmatched;

    public UnmatchedIfElse (IfDummy IfDummy, Condition Condition, Matched Matched, ElseDummy ElseDummy, Unmatched Unmatched) {
        this.IfDummy=IfDummy;
        if(IfDummy!=null) IfDummy.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
        this.ElseDummy=ElseDummy;
        if(ElseDummy!=null) ElseDummy.setParent(this);
        this.Unmatched=Unmatched;
        if(Unmatched!=null) Unmatched.setParent(this);
    }

    public IfDummy getIfDummy() {
        return IfDummy;
    }

    public void setIfDummy(IfDummy IfDummy) {
        this.IfDummy=IfDummy;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public ElseDummy getElseDummy() {
        return ElseDummy;
    }

    public void setElseDummy(ElseDummy ElseDummy) {
        this.ElseDummy=ElseDummy;
    }

    public Unmatched getUnmatched() {
        return Unmatched;
    }

    public void setUnmatched(Unmatched Unmatched) {
        this.Unmatched=Unmatched;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfDummy!=null) IfDummy.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
        if(ElseDummy!=null) ElseDummy.accept(visitor);
        if(Unmatched!=null) Unmatched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfDummy!=null) IfDummy.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
        if(ElseDummy!=null) ElseDummy.traverseTopDown(visitor);
        if(Unmatched!=null) Unmatched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfDummy!=null) IfDummy.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        if(ElseDummy!=null) ElseDummy.traverseBottomUp(visitor);
        if(Unmatched!=null) Unmatched.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedIfElse(\n");

        if(IfDummy!=null)
            buffer.append(IfDummy.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElseDummy!=null)
            buffer.append(ElseDummy.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Unmatched!=null)
            buffer.append(Unmatched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedIfElse]");
        return buffer.toString();
    }
}
