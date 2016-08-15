package com.jason.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class RandomX {
	
	//图片取名字
	
	/**
	 * 获得一个根据当前日期计算得到范围为[1,10]的数 
	 * 以跳跃并轻微随机的方式遍历该范围
	 * @return 结果
	 */
	public static int getDailyLuckNumber()
	{
		int luckNumber=0;
		Calendar today = Calendar.getInstance();
		int dayOfMonth =today.get( Calendar.DAY_OF_MONTH);		//日
		int dayOfWeek = today.get(Calendar.DAY_OF_WEEK) - 1; //星期
		 
		luckNumber = ( dayOfMonth + dayOfWeek ) % 10 ;
		if(luckNumber == 0 ) 
		{
			luckNumber = 10;
		} 	
		return luckNumber;
	}
	
	public String getUniqueStr(){
		String result = "";
		
		return result;
	}
	
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
	 * 随机获取不均匀的满足和为m的n个数
	 * @param n 需要数的个数
	 * @param totalValue 数的总和
	 * @return 结果集
	 */
	public ArrayList<Integer> getRandomNumbers(int n , int totalValue){
		Random random = new Random();
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int lastValue = totalValue;
		int currentValue = 0;
		
		for(int i = 0 ; i < n ; i++){		
			//如果已经分完 则将剩余值均赋为0
			if(lastValue == 0)
			{
				resultList.add(0);
				continue;
			}
			else
			{
				currentValue = random.nextInt(lastValue+1);
				resultList.add(currentValue);
				lastValue = lastValue - currentValue ;
			} 
		}
		return resultList;
	}

	/**
	 * 随机获取均匀的满足和为m的n个数
	 * @param n 需要数的个数
	 * @param totalValue 数的总和
	 * @param containZero 是否包含0
	 * @return 结果集
	 */
	public ArrayList<Integer> getEvenRandomNumbers(int n , int totalValue , boolean containZero){
		Random random = new Random();
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int averageValue = totalValue / n;
		int balancePool  = totalValue - ( averageValue * n );
		
		for(int i = 0 ; i < n - 1 ; i++){
			int currentValue = 0 ;
			if(containZero == true){
				currentValue = random.nextInt(averageValue + balancePool + 1);
			}
			else{
				currentValue = random.nextInt(averageValue + balancePool) + 1;
			}
			
			resultList.add(currentValue);
			balancePool = averageValue + balancePool - currentValue ;
		}
		resultList.add(averageValue + balancePool);
		return resultList;
	}
	
	/**
	 * 判断是否发生
	 * @param probability 该事件发生的概率
	 * @return 是否发生
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