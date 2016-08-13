package com.jason.util;

import java.util.Random;

public class Test {
	public static void main(String args[]){
//		Sort qs = new Sort();		
//		int[] data = { 91 , 300 , 15 , 43 , 32 , 25 , 11 , 66 , 54 , 84 , 72 , 99 , 98 , 97 , 96 , 95 , 93 , 92};	
//		qs.showdata(data);
		
//		qs.quickSortRec(data,data.length,0,data.length-1);
//		qs.showdata(data);
		
//		qs.quickSortNonrec(data);
//		qs.showdata(data);
		
//		qs.bubbleSort(data);
//		qs.showdata(data);
		
//		qs.shellSort(data);
//		qs.showdata(data);
		
//		qs.RadixSort(data, 10, 3);
//		qs.showdata(data);
			
		RandomX rx = new RandomX();
		for( int i = 0 ; i < 20 ; i ++){
			System.out.print(rx.getRandomNumber(100, 105) + " ");
		}
	}
}