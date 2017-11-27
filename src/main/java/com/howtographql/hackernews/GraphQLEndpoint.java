package com.howtographql.hackernews;


import com.coxautodev.graphql.tools.SchemaParser;
import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentation;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import org.dataloader.DataLoaderRegistry;

import javax.servlet.annotation.WebServlet;

/**
 * The servlet acting as the GraphQL endpoint
 */
@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    private static Level2DataLoader level2DataLoader = new Level2DataLoader();
    private static Level3DataLoader level3DataLoader = new Level3DataLoader();
    private static Level4DataLoader level4DataLoader = new Level4DataLoader();

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                        new Query(),
                        new Level1Resolver(level2DataLoader),
                        new Level2Resolver(level3DataLoader),
                        new Level3Resolver(level4DataLoader))
                .build()
                .makeExecutableSchema();
    }

    @Override
    protected Instrumentation getInstrumentation() {
        DataLoaderRegistry registry = new DataLoaderRegistry();
        registry.register("l2", level2DataLoader);
        registry.register("l3", level3DataLoader);
        registry.register("l4", level4DataLoader);
        return new DataLoaderDispatcherInstrumentation(registry);
    }
}
