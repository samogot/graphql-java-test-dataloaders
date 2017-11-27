package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Contains Link sub-queries
 */
public class Level2Resolver implements GraphQLResolver<Level2> {
    Level3DataLoader dataLoader;

    public Level2Resolver(Level3DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

//    public List<Level3> l3(Level2 level2) {
//        return Level3.getByL2(level2.getId());
//    }

    public CompletableFuture<List<Level3>> l3(Level2 level2) {
        return dataLoader.load(level2.getId());
    }
}
