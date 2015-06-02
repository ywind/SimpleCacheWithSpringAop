package com.github.ywind.Test;

import java.util.ArrayList;
import java.util.List;

import com.github.ywind.GetCache;


public class Test {
	@GetCache(type = "tag")
	public Object get(String id) {
		List<String> list= new ArrayList<String>();
		list.add(id);
		return list;
	}

}
