package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Contains Link sub-queries
 */
public class Level3Resolver implements GraphQLResolver<Level3> {
    Level4DataLoader dataLoader;

    public Level3Resolver(Level4DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

//    public List<Level4> l4(Level3 level3) {
//        return Level4.getByL3(level3.getId());
//    }

    public CompletableFuture<List<Level4>> l4(Level3 level3) {
        return dataLoader.load(level3.getId());
    }
}
