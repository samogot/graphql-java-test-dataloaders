package com.howtographql.hackernews;

import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Level3DataLoader extends DataLoader<String, List<Level3>> {

    public Level3DataLoader() {
        this(new DataLoaderOptions().setCachingEnabled(false));
    }

    public Level3DataLoader(DataLoaderOptions options) {
        super(keys -> CompletableFuture.supplyAsync(() -> Level3.getAllByL2s(keys)), options);
    }

}
