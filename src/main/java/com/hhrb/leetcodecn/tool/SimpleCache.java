package com.hhrb.leetcodecn.tool;

/**
 * User: Z J Wu Date: 2020/2/14 Time: 1:49 Package: com.hhrb.leetcodecn.tool
 */
public interface SimpleCache<K, V> {

  V get(K key);

  void put(K key, V val);

  V remove(K key);

  int size();

}
