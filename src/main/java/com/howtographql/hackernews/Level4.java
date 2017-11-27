package com.howtographql.hackernews;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Data-class representing a link
 */
public class Level4 {
    static final private Logger LOG = Logger.getLogger("Level4");
    private final String id;
    private final String name;

    public Level4(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private static List<Level4> generateList(String parentId) {
        return Arrays.asList(
                new Level4(parentId + "1", "Level4 id: " + parentId + "1"),
                new Level4(parentId + "2", "Level4 id: " + parentId + "2"),
                new Level4(parentId + "3", "Level4 id: " + parentId + "3")
        );
    }

    static public List<Level4> getByL3(String id) {
        LOG.info("Level4 getByL3 " + id);
        return generateList(id);
    }

    static public List<List<Level4>> getAllByL3s(List<String> ids) {
        LOG.info("Level4 getAllByL3s " + ids);
        return ids.stream().map(Level4::generateList).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
