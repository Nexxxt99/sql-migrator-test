package com.akvelon.migration;

import com.akvelon.syntax.PlSqlParser;
import com.akvelon.syntax.PlSqlParserBaseListener;

public class TestListener extends PlSqlParserBaseListener {
    @Override
    public void enterSelect_statement(PlSqlParser.Select_statementContext ctx) {
        System.out.println("entered");
    }

    @Override
    public void exitSelect_statement(PlSqlParser.Select_statementContext ctx) {
        System.out.println("exited");
    }
}
