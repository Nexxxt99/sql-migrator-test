package com.akvelon.migration;

import com.akvelon.syntax.PlSqlLexer;
import com.akvelon.syntax.PlSqlParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Runner {
    public static void main(String[] args) {
        String sql = "SELECT NAME FROM SIMPLE_TABLE;" +
                "SELECT NAME FROM SIMPLE_TABLE;" +
                "SELECT NAME FROM SIMPLE_TABLE;";
        /*
         * make Lexer
         */
        Lexer lexer = new PlSqlLexer(CharStreams.fromString(sql));
        /*
         * get a TokenStream on the Lexer
         */
        TokenStream tokenStream = new CommonTokenStream(lexer);
        /*
         * make a Parser on the token stream
         */
        PlSqlParser parser = new PlSqlParser(tokenStream);

        ParseTree tree = parser.select_statement();

        ParseTreeWalker walker = new ParseTreeWalker();

        TestVisitor visitor = new TestVisitor();

        visitor.visit(tree);
    }


    public static void useListener(Lexer lexer){
        TokenStream tokenStream = new CommonTokenStream(lexer);
        /*
         * make a Parser on the token stream
         */
        PlSqlParser parser = new PlSqlParser(tokenStream);

        ParseTree tree = parser.select_statement();

        ParseTreeWalker walker = new ParseTreeWalker();

        TestListener listener = new TestListener();

        walker.walk(listener,tree);
    }

}
