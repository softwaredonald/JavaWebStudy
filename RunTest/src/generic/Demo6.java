package generic;

public class Demo6 <T,E,K>{
	
	/**
	 * 如果多个泛型，可以在类上声明泛型,但是只在非静态的成员中使用
	 */
	public void b(T t, E e, K k){}
	
	//这样是错的：public static void d<T t>{}
	
	public static <T> void c(T t){
		
	}
		
	
}
