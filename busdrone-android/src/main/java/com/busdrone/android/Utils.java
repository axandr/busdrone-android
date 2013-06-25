package com.busdrone.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

import static android.content.Context.ACTIVITY_SERVICE;

// From Picasso

public class Utils {
    private static final int MIN_DISK_CACHE_SIZE = 5; // 5MB
    private static final int MAX_DISK_CACHE_SIZE = 50; // 50MB
    private static final int MAX_MEM_CACHE_SIZE = 20; // 20MB

    public static int calculateMemoryCacheSize(Context context) {
      ActivityManager am = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
      int memoryClass = Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB ? am.getMemoryClass() : am.getLargeMemoryClass();
      // Target 15% of the available RAM.
      int size = memoryClass / 7;
      // Bound to max size for mem cache.
      return Math.min(size, MAX_MEM_CACHE_SIZE);
    }
}
