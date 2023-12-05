// generated with ast extension for cup
// version 0.8
// 5/11/2023 13:34:47


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Factor Factor);
    public void visit(ProgDecl ProgDecl);
    public void visit(NamespaceList NamespaceList);
    public void visit(ActualParamList ActualParamList);
    public void visit(VarSingle VarSingle);
    public void visit(ConstSingle ConstSingle);
    public void visit(Expr Expr);
    public void visit(VarlList VarlList);
    public void visit(ClassDecl ClassDecl);
    public void visit(FormalParamList FormalParamList);
    public void visit(ProgDeclList ProgDeclList);
    public void visit(FormPars FormPars);
    public void visit(VarDeclList VarDeclList);
    public void visit(Namespace Namespace);
    public void visit(Unmatched Unmatched);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(Statement Statement);
    public void visit(ConstList ConstList);
    public void visit(StatementList StatementList);
    public void visit(Matched Matched);
    public void visit(ActualPars ActualPars);
    public void visit(Addop Addop);
    public void visit(Designator Designator);
    public void visit(ActualParam ActualParam);
    public void visit(ActualParams ActualParams);
    public void visit(NoActuals NoActuals);
    public void visit(Actuals Actuals);
    public void visit(FuncCall FuncCall);
    public void visit(Var Var);
    public void visit(Const Const);
    public void visit(Term Term);
    public void visit(TermExpr TermExpr);
    public void visit(AddExpr AddExpr);
    public void visit(ProcCall ProcCall);
    public void visit(MatchedIf MatchedIf);
    public void visit(ReturnNoExpr ReturnNoExpr);
    public void visit(ReturnExpr ReturnExpr);
    public void visit(PrintStmt PrintStmt);
    public void visit(ErrAssignment ErrAssignment);
    public void visit(Assignment Assignment);
    public void visit(UnmatchedIfElse UnmatchedIfElse);
    public void visit(UnmatchedIf UnmatchedIf);
    public void visit(UnmachedStmt UnmachedStmt);
    public void visit(MatchedStmt MatchedStmt);
    public void visit(NoStmt NoStmt);
    public void visit(Statements Statements);
    public void visit(FormalParamDecl FormalParamDecl);
    public void visit(SingleFormalParamDecl SingleFormalParamDecl);
    public void visit(FormalParamDecls FormalParamDecls);
    public void visit(NoFormParam NoFormParam);
    public void visit(FormParams FormParams);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMethodDecl NoMethodDecl);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(VarDecl_SQ VarDecl_SQ);
    public void visit(VarDecl_ID VarDecl_ID);
    public void visit(MultipleVarDecl MultipleVarDecl);
    public void visit(SingleVarDecl SingleVarDecl);
    public void visit(VarDecl VarDecl);
    public void visit(Type Type);
    public void visit(CharacterConst CharacterConst);
    public void visit(IntegerConst IntegerConst);
    public void visit(BooleanConst BooleanConst);
    public void visit(MultipleConstDecl MultipleConstDecl);
    public void visit(SingleConstDecl SingleConstDecl);
    public void visit(ConstDecl ConstDecl);
    public void visit(NamespaceProg NamespaceProg);
    public void visit(ProgClassDescarations ProgClassDescarations);
    public void visit(ProgVarDescarations ProgVarDescarations);
    public void visit(ProgConstDescarations ProgConstDescarations);
    public void visit(ProgDeclListNone ProgDeclListNone);
    public void visit(ProgDeclListObj ProgDeclListObj);
    public void visit(NamespaceList_Multiple NamespaceList_Multiple);
    public void visit(NamespaceList_Single NamespaceList_Single);
    public void visit(Program Program);

}
