# SimpleCacheWithSpringAop

##SrpingAop

需要配合Spring Aop使用，功能还比较单一，只是在获取数据的时候先进行缓存的查找，找不到的话，在方法内取得数据然后放入缓存。

##Annotation

利用Annotation判断是否进行缓存，因为可能有多种类型数据需要缓存，所以根据Type()值进行判断。

##缓存时效

为了缓存的时效性，可以设置过期时间和List的长度。

##具体设置请看Test里面的测试
