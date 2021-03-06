package daily_practise.W4_202005;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * @author: fanyeuxiang
 * @createDate: 2020-05-25 12:47
 */
public class LRUCache_146 {

    private LinkedHashMap<Integer, Integer> cacheMap;

    private int capacity;

    public LRUCache_146(int capacity) {
        // accessOrder=true，顺序访问输出，通过重写LinkedHashMap的removeEldestEntry方法
        this.cacheMap = new LinkedHashMap<Integer, Integer>(capacity, (float) 0.75, true){
            private static final long serialVersionUID = 235810647857044238L;
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    public int get(int key) {
        return cacheMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cacheMap.put(key, value);
    }
}
