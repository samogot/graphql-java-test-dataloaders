package com.howtographql.hackernews;

import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Level4DataLoader extends DataLoader<String, List<Level4>> {

    public Level4DataLoader() {
        this(new DataLoaderOptions().setCachingEnabled(false));
    }

    public Level4DataLoader(DataLoaderOptions options) {
        super(keys -> CompletableFuture.supplyAsync(() -> Level4.getAllByL3s(keys)), options);
    }

}
