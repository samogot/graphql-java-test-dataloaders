package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

/**
 * Query root. Contains top-level queries.
 */
class Query implements GraphQLQueryResolver {

    public List<Level1> l1() {
        return Level1.getAll();
    }
}
