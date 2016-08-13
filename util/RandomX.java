package com.jason.util;

import java.util.Random;

public class RandomX {
	/**
	 * 获得指定区域[upLimit,lowLimit)的随机数
	 * @param upLimit 上限
	 * @param lowLimit 下限
	 * @return 随机值
	 */
	public int getRandomNumber(int lowLimit , int upLimit){
		Random random = new Random();
		int randomNum = random.nextInt(upLimit - lowLimit) + lowLimit ;
		return randomNum ; 
	}
	
	/**
	 * 随机获取满足某条件的多个数
	 */
	public void getRandomNumbers(){
		
	}
	
	
	/**
	 * 判断是否发生
	 * @param probability 该事件发生的概率
	 */
	public boolean checkHappen(int probability){
		boolean result = false;
		Random random = new Random();
		int b = random.nextInt(100);	
		if(b < probability)
		{
			result=true;
		}
		return result;
	}
}