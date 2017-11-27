package com.howtographql.hackernews;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Data-class representing a link
 */
public class Level3 {
    static final private Logger LOG = Logger.getLogger("Level3");
    private final String id;
    private final String name;

    public Level3(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private static List<Level3> generateList(String parentId) {
        return Arrays.asList(
                new Level3(parentId + "1", "Level3 id: " + parentId + "1"),
                new Level3(parentId + "2", "Level3 id: " + parentId + "2"),
                new Level3(parentId + "3", "Level3 id: " + parentId + "3")
        );
    }

    static public List<Level3> getByL2(String id) {
        LOG.info("Level3 getByL2 " + id);
        return generateList(id);
    }

    static public List<List<Level3>> getAllByL2s(List<String> ids) {
        LOG.info("Level3 getAllByL2s " + ids);
        return ids.stream().map(Level3::generateList).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
