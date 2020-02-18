package br.com.skywalker.plugboleto;

import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;

@Log

// A simple Service Locator pattern implementation
public abstract class Registry {

    private static final Map<String, Object> REGISTRY = new HashMap<>();

    public static <T> boolean set(String key, T value) {
        return null != REGISTRY.putIfAbsent(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key, Class<T> clazz) {
        log.fine("Getting key [" + key + "]");
        if (!REGISTRY.containsKey(key)) {
            throw new RuntimeException("Unregistered key '" + key + "'");
        }

        return (T) REGISTRY.get(key);
    }
}
