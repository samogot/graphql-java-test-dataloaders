package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Contains Link sub-queries
 */
public class Level1Resolver implements GraphQLResolver<Level1> {
    Level2DataLoader dataLoader;

    public Level1Resolver(Level2DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

//    public List<Level2> l2(Level1 level1) {
//        return Level2.getByL1(level1.getId());
//    }

    public CompletableFuture<List<Level2>> l2(Level1 level1) {
        return dataLoader.load(level1.getId());
    }
}
