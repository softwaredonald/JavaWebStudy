package generic;

import org.junit.Test;

/**
 * 
 * @author xufen
 *
 *
 * ����������Ŀ��
 * 1. ��дһ�����ͷ�����ʵ��ָ��λ���ϵ�����Ԫ�صĽ���
 * 2. ��дһ�����ͷ���������һ���������飬���ߵ������е�����Ԫ�ء�
 * 3. ��ӡͼ����Ŀ
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
	 * ������Ҫһ�������������ܽ�һ���������
	 */
	
	//��Ŀ��
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
