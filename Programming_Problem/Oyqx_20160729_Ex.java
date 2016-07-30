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
		//2.从后往前遍历 当前总和小的一组 分得当前数组最大值，大的一组分得次最大值
		int groupA = 0 , groupB = 0;
		for( int i = array.length - 1 ; i >= 0 ; i = i - 2){
			if(groupA >= groupB){
				groupB = groupB + array[i];
				groupA = groupA + array[i-1];
			}
			else{
				groupB = groupB + array[i-1];
				groupA = groupA + array[i];
			}
		}
		
		//3.计算结果并返回
		int result = groupA - groupB;
		if(result < 0){
			result = 0 - result ;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] data  = { 0 , 3 , 5 , 43 , 32 , 25 , 11 , 66 , 54 , 84 , 72 , 99};	
		int[] data1 = { 1 , 2 , 3 , 4 , 5 , 6};	
		int[] data2 = { 90 , 91 , 92 , 93 , 94 , 95 , 96 , 97 , 98 , 99};	
		int[] data3 = { -20, -10 ,-5 , -100,-80,0, 23 , 55 ,98 ,77, 10 , 20};	
		
		System.out.println(getResult(data3));
	}
}