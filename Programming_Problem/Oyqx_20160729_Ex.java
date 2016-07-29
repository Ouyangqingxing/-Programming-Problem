package com.jason.best;

import com.jason.data_structure.Sort;

public class Oyqx_20160729_Ex {
	/**
	 * @param array 待处理的数组
	 * @return 两个小组的差值
	 */
	public static int getResult(int[] array){
		//对传入的参数进行检查 如果为null 或是长度小于2 或是长度非偶数 则返回错误参数-1 
		if(array == null || array.length < 2 || array.length % 2 != 0 ){
			return -1;
		}
		
		//1.对于数组进行排序
		Sort sort = new Sort();
		sort.quickSortNonrec(array);
		//2.计算数组总和的一半 并记为 关键值keyValue
		int total = 0 ;
		for( int i = 0 ; i < array.length ; i++){
			total = total + array[i];
		}
		int keyValue = total / 2;
		
		//3.从后往前遍历 如果关键值大于当前值 则 keyValue = keyValue - array[i] 直到遍历结束或关键值等于0 
		for(int i = array.length -1 ; i >= 0 ; i-- ){
			if( keyValue > array[i]){
				keyValue = keyValue - array[i];
			}
			if(keyValue == 0){
				break;
			}
		}
		int groupA = total / 2 - keyValue;
		int result = total - groupA -groupA;
		System.out.println("A:"+groupA+" B:"+(total - groupA)+" total:"+total);
		if(result < 0){
			result = 0 - result ;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] data = { 1 , 3 , 5 , 43 , 32 , 25 , 11 , 66 , 54 , 84 , 72 , 99};	
		int[] data1 = { 90 , 91 , 92 , 93 , 94 , 95 , 96 , 97 , 98 , 99};	
		
		System.out.println(getResult(data1));
	}
}