package com.github.ywind;

import java.util.LinkedHashMap;

public class LRUListHashMap<K,V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = -4078328473990490159L;
	private final int MAX_CACHE_SIZE;

	public LRUListHashMap(int size) {
		super((int) Math.ceil(size / 0.75) + 1, 0.75f, true);
		this.MAX_CACHE_SIZE = size;
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		// TODO Auto-generated method stub
		return size()>MAX_CACHE_SIZE;
	}

		
}
