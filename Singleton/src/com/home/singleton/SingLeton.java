package com.home.singleton;

public class SingLeton {
	
	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
	private static SingLeton instance =null;
	
	/*私有构造方法*/
	private SingLeton() {
	}
	
	/*静态工程方法，创建实例*/
	//1.在多线程的环境下会出很多问题
//	public static SingLeton getInstance() {
//		if(instance ==null)
//		{
//			instance=new SingLeton();
//		}
//		return instance;
//
//	}
	
	//synchronized 关键字锁住的是这个对象，这样的方法，
	//在性能上会有所下降，每次调用getinstance()都会对对象上锁
/*	public static synchronized SingLeton getInstance() {
		if(instance ==null)
		{
			instance=new SingLeton();
		}
		return instance;

	}
*/
	
	private static class SingletonFactory{
		private static SingLeton instance =new SingLeton();
	}
	
	public static SingLeton getInstance() {
		return SingletonFactory.instance;
	}
	
	/*如果该对象被用于序列化，可以保证在序列化前后保持一致*/
	public Object readResolve() {		
		return instance;
	}

	
}
