package com.github.ywind;

public class Cache {
	private long time;
	private Object t;
	public Cache(Object t){
		this.t = t;
		this.time = System.currentTimeMillis();
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public Object getT() {
		return t;
	}
	public void setT(Object t) {
		this.t = t;
	}
	
	
}
