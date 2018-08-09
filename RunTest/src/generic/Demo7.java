package generic;

import org.junit.Test;

/**
 * 
 * @author xufen
 *
 *
 * 两道面试题目：
 * 1. 编写一个泛型方法，实现指定位置上的数组元素的交换
 * 2. 编写一个泛型方法，接收一个任意数组，并颠倒数组中的所有元素。
 * 3. 打印图形题目
 *   3   7
 *  2 4 6 8
 * 1   5   9
 * 
 * 
 */

public class Demo7 {

	public <T> void swap(T arr[], int post1, int post2){
		T temp = arr[post1];
		arr[post1] = arr[post2];
		arr[post2]= temp;
	}
	
	
	public <T> void reverse(T arr[]){
		
		int start = 0;
		int end = arr.length-1;
		
		
		while(start<= end){
		
		T temp = arr[start];
		arr[start] = arr[end];
		arr[end]= temp;
		
		start++;
		end--;
		}
	}
	
	/**
	 * 泛型需要一定开发基础才能进一步深入理解
	 */
	
	//题目三
	@Test
	public void test3(){
		int num = 9;
		int arr[][] = new int [3][9];
		int x = 2;
		int y = 0;
		boolean order = false;
		for (int i= 1; i<=9; i++){
			arr[x][y] =i;
			y++;
			if (order==false){x--;}
			if (order==true){x++;}
			if (x<0){
				order = true;
				x =x+2;
			}
			if (x>2){
				order = false;
				x = x-2;
			}
			
		}
		for (int i = 0; i<arr.length; i++){
			for (int j=0; j<arr[i].length;j++){
				if (arr[i][j]==0){
					System.out.print(" ");
				}else{
					System.out.print(arr[i][j]);
				}
			}
			System.out.println();
		}
	}
	
}
