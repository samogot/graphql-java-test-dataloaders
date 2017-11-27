package com.howtographql.hackernews;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Data-class representing a link
 */
public class Level2 {
    static final private Logger LOG = Logger.getLogger("Level2");
    private final String id;
    private final String name;

    public Level2(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private static List<Level2> generateList(String parentId) {
        return Arrays.asList(
                new Level2(parentId + "1", "Level2 id: " + parentId + "1"),
                new Level2(parentId + "2", "Level2 id: " + parentId + "2"),
                new Level2(parentId + "3", "Level2 id: " + parentId + "3")
        );
    }

    static public List<Level2> getByL1(String id) {
        LOG.info("Level2 getByL1 " + id);
        return generateList(id);
    }

    static public List<List<Level2>> getAllByL1s(List<String> ids) {
        LOG.info("Level2 getAllByL1s " + ids);
        return ids.stream().map(Level2::generateList).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
