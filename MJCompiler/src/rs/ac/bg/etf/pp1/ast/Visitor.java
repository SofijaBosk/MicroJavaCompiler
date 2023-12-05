// generated with ast extension for cup
// version 0.8
// 5/11/2023 14:7:35


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Unmatched Unmatched);
    public void visit(Matched Matched);
    public void visit(Namespace Namespace);
    public void visit(ProgDeclList ProgDeclList);
    public void visit(StaticInitializerList StaticInitializerList);
    public void visit(StatementList StatementList);
    public void visit(NamespaceList NamespaceList);
    public void visit(ClassDeclPom ClassDeclPom);
    public void visit(Factor Factor);
    public void visit(ConstList ConstList);
    public void visit(ProgDecl ProgDecl);
    public void visit(ConstSingle ConstSingle);
    public void visit(MethodDeclListBrace MethodDeclListBrace);
    public void visit(VarSingle VarSingle);
    public void visit(VarlList VarlList);
    public void visit(ActualParamList ActualParamList);
    public void visit(VarDeclList VarDeclList);
    public void visit(FormalParamList FormalParamList);
    public void visit(Expr Expr);
    public void visit(ActualPars ActualPars);
    public void visit(StaticPom StaticPom);
    public void visit(Statement Statement);
    public void visit(VarStaticDeclList VarStaticDeclList);
    public void visit(ClassDecl ClassDecl);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(ExtendsFrom ExtendsFrom);
    public void visit(FormPars FormPars);
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
    public void visit(StaticInitializer StaticInitializer);
    public void visit(NoVarDecl NoVarDecl);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(NoStaticVarDecl NoStaticVarDecl);
    public void visit(VarStaticDeclarations VarStaticDeclarations);
    public void visit(StaticInitializerList_Multiple StaticInitializerList_Multiple);
    public void visit(StaticInitializerList_Single StaticInitializerList_Single);
    public void visit(ExtendsFrom_None ExtendsFrom_None);
    public void visit(ExtendsFrom_Meth ExtendsFrom_Meth);
    public void visit(StaticPom_None StaticPom_None);
    public void visit(StaticPom_StaticInitializer StaticPom_StaticInitializer);
    public void visit(StaticPom_VarDecl StaticPom_VarDecl);
    public void visit(ClassDeclPom_NoMeth ClassDeclPom_NoMeth);
    public void visit(ClassDecl_Meth ClassDecl_Meth);
    public void visit(ClassDecl_NoMeth ClassDecl_NoMeth);
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
