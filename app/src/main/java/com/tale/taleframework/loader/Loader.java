package com.tale.taleframework.loader;

/**
 * Created by tale on 3/10/15.
 */
public enum Loader {
    StringLoader(new DataLoader<String>());
    private final DataLoader loader;

    Loader(DataLoader loader) {
        this.loader = loader;
    }

    public <T> DataLoader<T> asDataLoader() {
        return loader;
    }
}
