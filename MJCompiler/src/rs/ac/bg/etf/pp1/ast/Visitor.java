// generated with ast extension for cup
// version 0.8
// 5/11/2023 14:32:1


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Unmatched Unmatched);
    public void visit(Matched Matched);
    public void visit(Namespace Namespace);
    public void visit(NumConstList NumConstList);
    public void visit(FormalParamDecl FormalParamDecl);
    public void visit(ProgDeclList ProgDeclList);
    public void visit(StaticInitializerList StaticInitializerList);
    public void visit(CondFactHelper CondFactHelper);
    public void visit(StatementList StatementList);
    public void visit(NamespaceList NamespaceList);
    public void visit(ClassDeclPom ClassDeclPom);
    public void visit(Factor Factor);
    public void visit(ConstList ConstList);
    public void visit(ProgDecl ProgDecl);
    public void visit(Condition Condition);
    public void visit(ConstSingle ConstSingle);
    public void visit(MethodDeclListBrace MethodDeclListBrace);
    public void visit(DesignatorStatementList DesignatorStatementList);
    public void visit(VarSingle VarSingle);
    public void visit(VarlList VarlList);
    public void visit(ActualParamList ActualParamList);
    public void visit(VarDeclList VarDeclList);
    public void visit(FormalParamList FormalParamList);
    public void visit(Expr Expr);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ActualPars ActualPars);
    public void visit(StaticPom StaticPom);
    public void visit(ReturnMethod ReturnMethod);
    public void visit(Statement Statement);
    public void visit(DesignatorStatementHelper DesignatorStatementHelper);
    public void visit(VarStaticDeclList VarStaticDeclList);
    public void visit(ClassDecl ClassDecl);
    public void visit(CondFact CondFact);
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
    public void visit(DesignatorStatementList_Single DesignatorStatementList_Single);
    public void visit(DesignatorStatementList_List DesignatorStatementList_List);
    public void visit(NumConstList_None NumConstList_None);
    public void visit(NumConstList_ARGS NumConstList_ARGS);
    public void visit(CondFactHelper_none CondFactHelper_none);
    public void visit(CondFactHelper_One CondFactHelper_One);
    public void visit(DesignatorStatementHelper_NoDS DesignatorStatementHelper_NoDS);
    public void visit(DesignatorStatementHelper_DS DesignatorStatementHelper_DS);
    public void visit(MatchedStatement MatchedStatement);
    public void visit(FORStmt_NoDS FORStmt_NoDS);
    public void visit(StatementList_List StatementList_List);
    public void visit(BreakStmt BreakStmt);
    public void visit(ContinueStmt ContinueStmt);
    public void visit(ReturnNoExpr ReturnNoExpr);
    public void visit(ReturnExpr ReturnExpr);
    public void visit(ReadStmt ReadStmt);
    public void visit(PrintStmt PrintStmt);
    public void visit(ErrorStmt ErrorStmt);
    public void visit(DesignatorStatementStmt DesignatorStatementStmt);
    public void visit(UnmatchedIfElse UnmatchedIfElse);
    public void visit(UnmatchedIf UnmatchedIf);
    public void visit(UnmatchedStmt UnmatchedStmt);
    public void visit(MatchedStmt MatchedStmt);
    public void visit(NoStmt NoStmt);
    public void visit(Statements Statements);
    public void visit(FormParDecl_Array FormParDecl_Array);
    public void visit(FormParDecl_Single FormParDecl_Single);
    public void visit(SingleFormalParamDecl SingleFormalParamDecl);
    public void visit(FormalParamDecls FormalParamDecls);
    public void visit(NoFormParam NoFormParam);
    public void visit(FormParams FormParams);
    public void visit(ReturnMethod_Void ReturnMethod_Void);
    public void visit(ReturnMethod_Type ReturnMethod_Type);
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
