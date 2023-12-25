// generated with ast extension for cup
// version 0.8
// 25/11/2023 12:35:38


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Unmatched Unmatched);
    public void visit(Mulop Mulop);
    public void visit(Matched Matched);
    public void visit(Relop Relop);
    public void visit(Assignop Assignop);
    public void visit(NumConstList NumConstList);
    public void visit(FormalParamDecl FormalParamDecl);
    public void visit(ExprActParsChoice ExprActParsChoice);
    public void visit(ProgDeclList ProgDeclList);
    public void visit(StaticInitializerList StaticInitializerList);
    public void visit(CondFactHelper CondFactHelper);
    public void visit(StatementList StatementList);
    public void visit(NamespaceList NamespaceList);
    public void visit(Addop Addop);
    public void visit(ClassDeclPom ClassDeclPom);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(Pom Pom);
    public void visit(DesignatorHelper DesignatorHelper);
    public void visit(ActParsIE ActParsIE);
    public void visit(ConstList ConstList);
    public void visit(Designator Designator);
    public void visit(ProgDecl ProgDecl);
    public void visit(Term Term);
    public void visit(Condition Condition);
    public void visit(ConstSingle ConstSingle);
    public void visit(ConstValue ConstValue);
    public void visit(MethodDeclListBrace MethodDeclListBrace);
    public void visit(ActParsList ActParsList);
    public void visit(VarSingle VarSingle);
    public void visit(DesignatorStatementList DesignatorStatementList);
    public void visit(VarlList VarlList);
    public void visit(ActualParamList ActualParamList);
    public void visit(VarDeclList VarDeclList);
    public void visit(FormalParamList FormalParamList);
    public void visit(Expr Expr);
    public void visit(ActPars ActPars);
    public void visit(NamespaceNT NamespaceNT);
    public void visit(DesignatorList DesignatorList);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ActualPars ActualPars);
    public void visit(StaticPom StaticPom);
    public void visit(ReturnMethod ReturnMethod);
    public void visit(Statement Statement);
    public void visit(Type Type);
    public void visit(DesignatorStatementHelper DesignatorStatementHelper);
    public void visit(VarStaticDeclList VarStaticDeclList);
    public void visit(ClassDecl ClassDecl);
    public void visit(CondFact CondFact);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(ExtendsFrom ExtendsFrom);
    public void visit(FormPars FormPars);
    public void visit(DesignatorHelper3 DesignatorHelper3);
    public void visit(DesignatorHelper2 DesignatorHelper2);
    public void visit(Mulop_MOD Mulop_MOD);
    public void visit(Mulop_DIV Mulop_DIV);
    public void visit(Mulop_MUL Mulop_MUL);
    public void visit(Addop_MINUS Addop_MINUS);
    public void visit(Addop_PLUS Addop_PLUS);
    public void visit(Relop_LEQ Relop_LEQ);
    public void visit(Relop_LES Relop_LES);
    public void visit(Relop_GEQ Relop_GEQ);
    public void visit(Relop_GRE Relop_GRE);
    public void visit(Relop_NEQ Relop_NEQ);
    public void visit(Relop_EQ Relop_EQ);
    public void visit(AssignopDerived1 AssignopDerived1);
    public void visit(DesignatorHelper_NoneExpr DesignatorHelper_NoneExpr);
    public void visit(DesignatorHelper_Expr DesignatorHelper_Expr);
    public void visit(DesignatorHelper_Dot DesignatorHelper_Dot);
    public void visit(DesignatorHelper_None DesignatorHelper_None);
    public void visit(DesignatorHelper_Scope DesignatorHelper_Scope);
    public void visit(Designator_Ident Designator_Ident);
    public void visit(ConstValue_Bool ConstValue_Bool);
    public void visit(ConstValue_Char ConstValue_Char);
    public void visit(ConstValue_Num ConstValue_Num);
    public void visit(ActParsList_None ActParsList_None);
    public void visit(ActParsList_Single ActParsList_Single);
    public void visit(ExprActParsChoice_ActPars ExprActParsChoice_ActPars);
    public void visit(ExprActParsChoice_Expr ExprActParsChoice_Expr);
    public void visit(ParenExprFactor ParenExprFactor);
    public void visit(NewFactor NewFactor);
    public void visit(ConstFactor ConstFactor);
    public void visit(FuncCall FuncCall);
    public void visit(VarFactor VarFactor);
    public void visit(Term_Mulop Term_Mulop);
    public void visit(Term_Factor Term_Factor);
    public void visit(TermExpr TermExpr);
    public void visit(TermExpr_Minus TermExpr_Minus);
    public void visit(AddExpr AddExpr);
    public void visit(CondFact_Relop CondFact_Relop);
    public void visit(CondFact_Expr CondFact_Expr);
    public void visit(CondTerm_Item CondTerm_Item);
    public void visit(CondTerm_Chain CondTerm_Chain);
    public void visit(Condition_Single Condition_Single);
    public void visit(Condition_List Condition_List);
    public void visit(ActPars_List ActPars_List);
    public void visit(ActPars_Single ActPars_Single);
    public void visit(DesignatorList_Single DesignatorList_Single);
    public void visit(DesignatorList_List DesignatorList_List);
    public void visit(ActParsIE_None ActParsIE_None);
    public void visit(ActParsIE_ActPars ActParsIE_ActPars);
    public void visit(FunctionCall FunctionCall);
    public void visit(DesigatorStatementError DesigatorStatementError);
    public void visit(DesignatorStatement_FunctionCall DesignatorStatement_FunctionCall);
    public void visit(DesignatorStatement_DEC DesignatorStatement_DEC);
    public void visit(DesignatorStatement_INC DesignatorStatement_INC);
    public void visit(Assignment Assignment);
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
    public void visit(MethodTypeName MethodTypeName);
    public void visit(FormParsDummy FormParsDummy);
    public void visit(MethodParams MethodParams);
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
    public void visit(TypeDummy TypeDummy);
    public void visit(VarDecl VarDecl);
    public void visit(Type_ID Type_ID);
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
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
