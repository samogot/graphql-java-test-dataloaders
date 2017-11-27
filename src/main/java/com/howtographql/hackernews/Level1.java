package com.howtographql.hackernews;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Data-class representing a link
 */
public class Level1 {
    static final private Logger LOG = Logger.getLogger("Level1");
    private final String id;
    private final String name;

    public Level1(String id, String name) {
        this.id = id;
        this.name = name;
    }

    static public List<Level1> getAll() {
        LOG.info("Level1 getAll");
        return Arrays.asList(
                new Level1("1", "Level1 id: 1"),
                new Level1("2", "Level1 id: 2"),
                new Level1("3", "Level1 id: 3")
        );
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
