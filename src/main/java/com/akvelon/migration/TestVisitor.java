package com.akvelon.migration;

import com.akvelon.syntax.PlSqlParser;
import com.akvelon.syntax.PlSqlParserBaseVisitor;

public class TestVisitor extends PlSqlParserBaseVisitor {
    @Override
    public Object visitSelect_statement(PlSqlParser.Select_statementContext ctx) {
        System.out.println("here");
        return super.visitSelect_statement(ctx);
    }
}
