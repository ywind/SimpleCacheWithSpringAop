package com.github.ywind;

import java.util.List;

public class Cache<E> {
	private long time;
	private List<E> t;
	public Cache(List<E> t){
		this.t = t;
		this.time = System.currentTimeMillis();
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public List<E> getT() {
		return t;
	}
	public void setT(List<E> t) {
		this.t = t;
	}
	
	
}
