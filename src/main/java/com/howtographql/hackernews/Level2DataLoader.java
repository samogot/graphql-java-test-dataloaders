package com.howtographql.hackernews;

import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Level2DataLoader extends DataLoader<String, List<Level2>> {

    public Level2DataLoader() {
        this(new DataLoaderOptions().setCachingEnabled(false));
    }

    public Level2DataLoader(DataLoaderOptions options) {
        super(keys -> CompletableFuture.supplyAsync(() -> Level2.getAllByL1s(keys)), options);
    }

}
