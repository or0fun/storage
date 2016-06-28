package com.baiwanlu.android.storage;

import android.content.Context;
import android.util.LruCache;

import com.baiwanlu.android.storage.util.SharedPreferencesManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储管理
 * Created by lufei on 6/24/16.
 */
public class FStorageManager {

    private static Context appContext;

    private static Map<String, LruCache<String, Object>> lruCacheMap;

    private static int sMaxSize = 10;

    public static void init(Context context, int maxSize) {
        appContext = context;
        SharedPreferencesManager.init(appContext);
        lruCacheMap = new HashMap<>();
        sMaxSize = maxSize;
    }

    public static void init(Context context) {
        appContext = context;
        SharedPreferencesManager.init(appContext);
        lruCacheMap = new HashMap<>();
    }

    /**
     * 清除缓存
     */
    public static void clearCache() {
        for (LruCache<String, Object> objectLruCache : lruCacheMap.values()) {
            objectLruCache.evictAll();
        }
    }

    /**
     * 清除某个模块的缓存
     */
    public static void clearCache(String module) {
        if (lruCacheMap.containsKey(module)) {
            lruCacheMap.get(module).evictAll();
        }
    }

    public static void removeFromCache(String module, String key) {
        if (lruCacheMap.containsKey(module)) {
            lruCacheMap.get(module).remove(key);
        }
    }

    public static void removeFromDisk(String module, String key) {
        SharedPreferencesManager.getInstance(module).remove(key);
    }

    /**
     * 存储
     * @param module
     * @param key
     * @param value
     */
    public static void putToCache(String module, String key, Object value) {
        if (!lruCacheMap.containsKey(module)) {
            if (null == lruCacheMap.get(module)) {
                lruCacheMap.put(module, new LruCache<String, Object>(sMaxSize));
            }
        }
        lruCacheMap.get(module).put(key, value);
    }

    /**
     * 存储
     * @param module
     * @param key
     * @param value
     */
    public static void putToCache(String module, String key, int value) {
        if (!lruCacheMap.containsKey(module)) {
            if (null == lruCacheMap.get(module)) {
                lruCacheMap.put(module, new LruCache<String, Object>(sMaxSize));
            }
        }
        lruCacheMap.get(module).put(key, value);

    }
    /**
     * 存储
     * @param module
     * @param key
     * @param value
     */
    public static void putToCache(String module, String key, long value) {
        if (!lruCacheMap.containsKey(module)) {
            if (null == lruCacheMap.get(module)) {
                lruCacheMap.put(module, new LruCache<String, Object>(sMaxSize));
            }
        }
        lruCacheMap.get(module).put(key, value);

    }
    /**
     * 存储
     * @param module
     * @param key
     * @param value
     */
    public static void putToCache(String module, String key, boolean value) {
        if (!lruCacheMap.containsKey(module)) {
            if (null == lruCacheMap.get(module)) {
                lruCacheMap.put(module, new LruCache<String, Object>(sMaxSize));
            }
        }
        lruCacheMap.get(module).put(key, value);

    }

    /**
     * 存储
     * @param module
     * @param key
     * @param value
     */
    public static void putToCache(String module, String key, float value) {
        if (!lruCacheMap.containsKey(module)) {
            if (null == lruCacheMap.get(module)) {
                lruCacheMap.put(module, new LruCache<String, Object>(sMaxSize));
            }
        }
        lruCacheMap.get(module).put(key, value);

    }

    //////Disk store


    /**
     * 存储
     * @param module
     * @param key
     * @param value
     */
    public static void putToDisk(String module, String key, String value) {
        SharedPreferencesManager.getInstance(module).put(key, value);
    }

    /**
     * 存储
     * @param module
     * @param key
     * @param value
     */
    public static void putToDisk(String module, String key, int value) {
        SharedPreferencesManager.getInstance(module).put(key, value);
    }
    /**
     * 存储
     * @param module
     * @param key
     * @param value
     */
    public static void putToDisk(String module, String key, long value) {
        SharedPreferencesManager.getInstance(module).put(key, value);
    }
    /**
     * 存储
     * @param module
     * @param key
     * @param value
     */
    public static void putToDisk(String module, String key, boolean value) {
        SharedPreferencesManager.getInstance(module).put(key, value);
    }

    /**
     * 存储
     * @param module
     * @param key
     * @param value
     */
    public static void putToDisk(String module, String key, float value) {
        SharedPreferencesManager.getInstance(module).put(key, value);
    }


    /////Get


    /**
     * 获取
     * @param module
     * @param key
     * @param defaultValue
     */
    public static String get(String module, String key, String defaultValue) {
        return SharedPreferencesManager.getInstance(module).getString(key, defaultValue);
    }

    /**
     * 获取
     * @param module
     * @param key
     * @param defaultValue
     */
    public static int get(String module, String key, int defaultValue) {
        return SharedPreferencesManager.getInstance(module).getInt(key, defaultValue);
    }
    /**
     * 存储
     * @param module
     * @param key
     * @param value
     */
    public static long get(String module, String key, long value) {
        return SharedPreferencesManager.getInstance(module).getLong(key, value);
    }
    /**
     * 获取
     * @param module
     * @param key
     * @param value
     */
    public static boolean get(String module, String key, boolean value) {
        return SharedPreferencesManager.getInstance(module).getBoolean(key, value);
    }

    /**
     * 获取
     * @param module
     * @param key
     * @param value
     */
    public static float get(String module, String key, float value) {
        return SharedPreferencesManager.getInstance(module).getFloat(key, value);
    }

}
