package main.leetcode;

import java.util.LinkedHashMap;

/**
 * @Author zhulang
 * @Date 2023-06-01
 **/
public class LeetCode0146_LRUCache {
    class LRUCache {
        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            // 将 key 变为最近使用
            makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int val) {
            if (cache.containsKey(key)) {
                // 修改 key 的值
                cache.put(key, val);
                // 将 key 变为最近使用
                makeRecently(key);
                return;
            }

            if (cache.size() >= this.cap) {
                // 链表头部就是最久未使用的 key
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            // 将新的 key 添加链表尾部
            cache.put(key, val);
        }

        private void makeRecently(int key) {
            int val = cache.get(key);
            // 删除 key，重新插入到队尾
            cache.remove(key);
            cache.put(key, val);
        }
    }

    class LRUCache2 {

        private LinkedHashMap<Integer, Integer> cache;
        private final int capacity;

        public LRUCache2(int capacity) {
            cache = new LinkedHashMap(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!cache.containsKey(key)){
                return -1;
            }
            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                // 修改 key 的值
                cache.put(key, value);
                return;
            }
            if (cache.size() >= this.capacity) {
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key, value);
        }

    }
}
