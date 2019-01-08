package com.github.collections;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 13:43
 * @Description:
 */
public interface Map<Key, Value> {
    /**
     * 往map里头放元素
     *
     * @param key
     * @param value
     */
    void put(Key key, Value value);

    /**
     * 获取指定key值元素的值
     *
     * @param key
     * @return
     */
    Value get(Key key);

    /**
     * 删除指定的key
     *
     * @param key
     */
    void delete(Key key);

    /**
     * 是否包含某个key
     *
     * @param key
     * @return
     */
    boolean contains(Key key);

    /**
     * 判断map是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * map里头key-value对数
     *
     * @return
     */
    int size();

    /**
     * key集合
     *
     * @return
     */
    Iterable<Key> keys();
}
