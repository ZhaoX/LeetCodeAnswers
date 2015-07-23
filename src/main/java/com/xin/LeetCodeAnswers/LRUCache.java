package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/lru-cache/
// Author : Xin Zhao
// Date   : 2015-07-22

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**********************************************************************************
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 *
 **********************************************************************************/

public class LRUCache {

    private int capacity;
    private Map<Integer, Long> timeMap;
    private NavigableMap<Long, Entry> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        timeMap = new HashMap<Integer, Long>(capacity);
        cacheMap = new TreeMap<Long, Entry>();
    }

    public int get(int key) {
        Long time = timeMap.get(key);
        if(null == time) {
            return -1;
        } else {
            Entry entry = cacheMap.remove(time);
            int val = entry.getVal();
            long curTime = System.nanoTime();
            cacheMap.put(curTime, new Entry(key, val));
            timeMap.put(key, curTime);

            //System.out.println("get " + key);
            //System.out.println(cacheMap.toString());
            //System.out.println(timeMap.toString());
            return val;
        }
    }

    public void set(int key, int value) {
        if(timeMap.containsKey(key)) {
            long time = timeMap.remove(key);
            cacheMap.remove(time);
        }

        if(capacity==timeMap.size()) {
            Map.Entry<Long, Entry> entry = cacheMap.pollFirstEntry();
            timeMap.remove(entry.getValue().getKey());
        }

        long curTime = System.nanoTime();
        cacheMap.put(curTime, new Entry(key, value));
        timeMap.put(key, curTime);

        //System.out.println("set " + key + "=" + value) ;
        //System.out.println(cacheMap.toString());
        //System.out.println(timeMap.toString());

    }

    public class Entry {
        private int key;
        private int val;

        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }

        public String toString() {
            return "{" + key + ", " + val + "}";
        }

    }

    public static void main(String[] args) throws Exception{
        LRUCache cache = new LRUCache(2);
        cache.set(2,1);

        cache.set(1,2);

        System.out.println(cache.get(2));

        cache.set(3,4);

        System.out.println(cache.get(2));
    }

}
