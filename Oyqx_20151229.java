/**Ouyangqingxing_20151229_"Program About Lamp"
Content: There are 100 lamps and their number is 1-100.Each lamp controlled by each switch (Numbers are the same).At first,all the lamps are closed.
		 Now turn on/off the switch by a kind of rule.
		 Firstly,turn on all the lamps.
		 Secondly,turn off all the lamps which number are multiple of 2.
		 Thirdly,turn on/off all the lamps which number are multiple of 3.
		 Turn on/off the lamps N times.
Question:After N times(2<=N<=100),how many lamps still on?
Use the program to realize it and N is parameter.*/

/**欧阳青星_20151229_《关于开关灯的编程题》
题目：大厅里有100盏灯，每盏灯都编了号码，分别为1-100。每盏灯由一个开关来控制（开关的编号与被控制的灯相同）。开始时，灯是全灭的。
	现在按照一定规则按动开关。
	第一次，将所有的灯点亮。
	第二次，将所有2的倍数的开关按一下。
            第三次，将所有3的倍数的开关按一下。
            以此类推直至第N次。
   问： 第N次（N大于等于2，且小于等于100）按完以后，大厅里还有几盏灯是亮的。
请编程实现上面的逻辑，以N为参数。*/
 
package com.jason.best;

public class Oyqx_20151229 
{
	/**It costs O(n) in time and 104 Byte in space.(If the number of lamps is parameter,we will cost O(n*n).And we regard the size of boolean as 1 Byte.)    / 时间上复杂度为O(n) 空间上消耗 104字节 (不过实际上如果灯数也由参数来提供那么时间复杂度就为O(n*n)了 ,同时boolean类型大小根据环境有争议此处视作1字节。 )  
	 * @param N The times we want / 进行的次数。
	 * @return If it returns -1,it means fail.And the other answers are the results which we want.  / -1表示参数有误处理失败 其余范围为所需结果。
	 */
	public static int checkLamp(int N)
	{
		//1、Check for the parameter.  / 对参数进行检查，合理方可进行处理，否则返回错误参数-1。
		if(2<=N && N<=100)
		{
			//2、To realize it.  / 实现功能。
			boolean[] lamps = new boolean[100];// Use the boolean type to save the space.  / 初始化一个数组，考虑到灯只有两种状态，用boolean类型最节省空间。  
			
			for(int i = 1 ; i < N+1 ; i++)//i is times , j is the number of lamp now.  /  i为当前次数  j为当前处理的灯号。
			{
				for(int j = 1 ; j < 101 ; j++) 
				{
					if( j % i == 0 )// If j is multiple of i,turn on/off the lamp.And notice the subscript.   / 如果满足j为i的倍数，交换当前开关状态，注意数组和下标隔1对应。
					{
						if(lamps[j-1]==false)
						{
							lamps[j-1]=true;
						}
						else
						{
							lamps[j-1]=false;
						}
					}
				}
			}
			
			//At last,check the result of the lamps'state and return the result.  / 最后检查目前灯的状态 返回结果
			int result = 0 ;
			for(int i = 0 ; i < 100 ; i++)
			{
				if(lamps[i]==true)
				{
					result++;
				}
			} 
			return result ;
		}
		else
		{
			return -1 ;
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.print("There are "+checkLamp(50)+" lamps still on./  ");  
		System.out.println("  仍亮着的灯有 "+checkLamp(60)+" 盏。");  
	}
} 