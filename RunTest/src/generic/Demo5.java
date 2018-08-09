package generic;
/**
 * 自定义带泛型的方法
 * @author xufen
 *
 */
public class Demo5 {
	
	public void test1(){
		a("aaa");
	}
	
	//上面可以传a，下面的T就是String
	
	public <T> void a(T t){
		
	}
	
	public <T,E,K> void b (T t, E e, K k){
		
	}
	
	
	
	
}
