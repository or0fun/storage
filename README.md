# 存储模块

提供内存的缓存和磁盘存储

     compile 'com.baiwanlu.android:storage:1.0.0'


## 使用介绍

    //在application的onCreate里初始化
    FStorageManager.init(this);
    //FStorageManager.init(this, 10);


    //清除缓存
    FStorageManager.clearCache();
    //public static void removeFromCache(String module, String key)
    // public static void removeFromDisk(String module, String key)


    //存储内存缓存
    FStorageManager.putToCache("detail", "334332324", "{}");


    //存储到磁盘的数据
    FStorageManager.putToDisk("setting", "theme", 0);

    //获取数据
    int theme = FStorageManager.get("setting", "theme", 0);