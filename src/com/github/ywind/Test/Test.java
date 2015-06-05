package com.github.ywind.Test;

import com.github.ywind.GetCache;


public class Test {
	@GetCache(type = "tag")
	public Object get(String id) {
		String teString="test";
		return teString;
	}

}
