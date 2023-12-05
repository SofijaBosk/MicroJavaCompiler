// generated with ast extension for cup
// version 0.8
// 5/11/2023 14:32:1


package rs.ac.bg.etf.pp1.ast;

public abstract class VisitorAdaptor implements Visitor { 

    public void visit(Unmatched Unmatched) { }
    public void visit(Matched Matched) { }
    public void visit(Namespace Namespace) { }
    public void visit(NumConstList NumConstList) { }
    public void visit(FormalParamDecl FormalParamDecl) { }
    public void visit(ProgDeclList ProgDeclList) { }
    public void visit(StaticInitializerList StaticInitializerList) { }
    public void visit(CondFactHelper CondFactHelper) { }
    public void visit(StatementList StatementList) { }
    public void visit(NamespaceList NamespaceList) { }
    public void visit(ClassDeclPom ClassDeclPom) { }
    public void visit(Factor Factor) { }
    public void visit(ConstList ConstList) { }
    public void visit(ProgDecl ProgDecl) { }
    public void visit(Condition Condition) { }
    public void visit(ConstSingle ConstSingle) { }
    public void visit(MethodDeclListBrace MethodDeclListBrace) { }
    public void visit(DesignatorStatementList DesignatorStatementList) { }
    public void visit(VarSingle VarSingle) { }
    public void visit(VarlList VarlList) { }
    public void visit(ActualParamList ActualParamList) { }
    public void visit(VarDeclList VarDeclList) { }
    public void visit(FormalParamList FormalParamList) { }
    public void visit(Expr Expr) { }
    public void visit(MethodTypeName MethodTypeName) { }
    public void visit(DesignatorStatement DesignatorStatement) { }
    public void visit(ActualPars ActualPars) { }
    public void visit(StaticPom StaticPom) { }
    public void visit(ReturnMethod ReturnMethod) { }
    public void visit(Statement Statement) { }
    public void visit(DesignatorStatementHelper DesignatorStatementHelper) { }
    public void visit(VarStaticDeclList VarStaticDeclList) { }
    public void visit(ClassDecl ClassDecl) { }
    public void visit(CondFact CondFact) { }
    public void visit(MethodDeclList MethodDeclList) { }
    public void visit(ExtendsFrom ExtendsFrom) { }
    public void visit(FormPars FormPars) { }
    public void visit(Addop Addop) { visit(); }
    public void visit(Designator Designator) { visit(); }
    public void visit(ActualParam ActualParam) { visit(); }
    public void visit(ActualParams ActualParams) { visit(); }
    public void visit(NoActuals NoActuals) { visit(); }
    public void visit(Actuals Actuals) { visit(); }
    public void visit(FuncCall FuncCall) { visit(); }
    public void visit(Var Var) { visit(); }
    public void visit(Const Const) { visit(); }
    public void visit(Term Term) { visit(); }
    public void visit(TermExpr TermExpr) { visit(); }
    public void visit(AddExpr AddExpr) { visit(); }
    public void visit(DesignatorStatementList_Single DesignatorStatementList_Single) { visit(); }
    public void visit(DesignatorStatementList_List DesignatorStatementList_List) { visit(); }
    public void visit(NumConstList_None NumConstList_None) { visit(); }
    public void visit(NumConstList_ARGS NumConstList_ARGS) { visit(); }
    public void visit(CondFactHelper_none CondFactHelper_none) { visit(); }
    public void visit(CondFactHelper_One CondFactHelper_One) { visit(); }
    public void visit(DesignatorStatementHelper_NoDS DesignatorStatementHelper_NoDS) { visit(); }
    public void visit(DesignatorStatementHelper_DS DesignatorStatementHelper_DS) { visit(); }
    public void visit(MatchedStatement MatchedStatement) { visit(); }
    public void visit(FORStmt_NoDS FORStmt_NoDS) { visit(); }
    public void visit(StatementList_List StatementList_List) { visit(); }
    public void visit(BreakStmt BreakStmt) { visit(); }
    public void visit(ContinueStmt ContinueStmt) { visit(); }
    public void visit(ReturnNoExpr ReturnNoExpr) { visit(); }
    public void visit(ReturnExpr ReturnExpr) { visit(); }
    public void visit(ReadStmt ReadStmt) { visit(); }
    public void visit(PrintStmt PrintStmt) { visit(); }
    public void visit(ErrorStmt ErrorStmt) { visit(); }
    public void visit(DesignatorStatementStmt DesignatorStatementStmt) { visit(); }
    public void visit(UnmatchedIfElse UnmatchedIfElse) { visit(); }
    public void visit(UnmatchedIf UnmatchedIf) { visit(); }
    public void visit(UnmatchedStmt UnmatchedStmt) { visit(); }
    public void visit(MatchedStmt MatchedStmt) { visit(); }
    public void visit(NoStmt NoStmt) { visit(); }
    public void visit(Statements Statements) { visit(); }
    public void visit(FormParDecl_Array FormParDecl_Array) { visit(); }
    public void visit(FormParDecl_Single FormParDecl_Single) { visit(); }
    public void visit(SingleFormalParamDecl SingleFormalParamDecl) { visit(); }
    public void visit(FormalParamDecls FormalParamDecls) { visit(); }
    public void visit(NoFormParam NoFormParam) { visit(); }
    public void visit(FormParams FormParams) { visit(); }
    public void visit(ReturnMethod_Void ReturnMethod_Void) { visit(); }
    public void visit(ReturnMethod_Type ReturnMethod_Type) { visit(); }
    public void visit(MethodDecl MethodDecl) { visit(); }
    public void visit(NoMethodDecl NoMethodDecl) { visit(); }
    public void visit(MethodDeclarations MethodDeclarations) { visit(); }
    public void visit(StaticInitializer StaticInitializer) { visit(); }
    public void visit(NoVarDecl NoVarDecl) { visit(); }
    public void visit(VarDeclarations VarDeclarations) { visit(); }
    public void visit(NoStaticVarDecl NoStaticVarDecl) { visit(); }
    public void visit(VarStaticDeclarations VarStaticDeclarations) { visit(); }
    public void visit(StaticInitializerList_Multiple StaticInitializerList_Multiple) { visit(); }
    public void visit(StaticInitializerList_Single StaticInitializerList_Single) { visit(); }
    public void visit(ExtendsFrom_None ExtendsFrom_None) { visit(); }
    public void visit(ExtendsFrom_Meth ExtendsFrom_Meth) { visit(); }
    public void visit(StaticPom_None StaticPom_None) { visit(); }
    public void visit(StaticPom_StaticInitializer StaticPom_StaticInitializer) { visit(); }
    public void visit(StaticPom_VarDecl StaticPom_VarDecl) { visit(); }
    public void visit(ClassDeclPom_NoMeth ClassDeclPom_NoMeth) { visit(); }
    public void visit(ClassDecl_Meth ClassDecl_Meth) { visit(); }
    public void visit(ClassDecl_NoMeth ClassDecl_NoMeth) { visit(); }
    public void visit(VarDecl_SQ VarDecl_SQ) { visit(); }
    public void visit(VarDecl_ID VarDecl_ID) { visit(); }
    public void visit(MultipleVarDecl MultipleVarDecl) { visit(); }
    public void visit(SingleVarDecl SingleVarDecl) { visit(); }
    public void visit(VarDecl VarDecl) { visit(); }
    public void visit(Type Type) { visit(); }
    public void visit(CharacterConst CharacterConst) { visit(); }
    public void visit(IntegerConst IntegerConst) { visit(); }
    public void visit(BooleanConst BooleanConst) { visit(); }
    public void visit(MultipleConstDecl MultipleConstDecl) { visit(); }
    public void visit(SingleConstDecl SingleConstDecl) { visit(); }
    public void visit(ConstDecl ConstDecl) { visit(); }
    public void visit(NamespaceProg NamespaceProg) { visit(); }
    public void visit(ProgClassDescarations ProgClassDescarations) { visit(); }
    public void visit(ProgVarDescarations ProgVarDescarations) { visit(); }
    public void visit(ProgConstDescarations ProgConstDescarations) { visit(); }
    public void visit(ProgDeclListNone ProgDeclListNone) { visit(); }
    public void visit(ProgDeclListObj ProgDeclListObj) { visit(); }
    public void visit(NamespaceList_Multiple NamespaceList_Multiple) { visit(); }
    public void visit(NamespaceList_Single NamespaceList_Single) { visit(); }
    public void visit(Program Program) { visit(); }


    public void visit() { }
}
