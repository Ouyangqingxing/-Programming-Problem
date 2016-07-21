/**欧阳青星_20160124_《百钱买百鸡》 编程题
 * 题目：一只公鸡值５元，一只母鸡值３元，３只小鸡值１元，现用一百元要买一百只鸡，问有什么方案？ 
 * 分析：首先肯定的是要用解方程，然后考虑应该通过循环来解方程。
 *
 * Ouyangqingxing_20160124_Program About "100$ buy 100 chicken"
 * Question: Cock costs 5$/Hen costs 3$/3 Chicks cost 1$.Now how many solutions to buy 100 chicken(3 kinds of them) by 100$ 
 * Analysis: At first,we can know it must like solve equations.Then we consider finish it by loop.
 */

package com.jason.best;
 
public class Oyqx_20160124 
{
	/**完成这个问题消耗了4个int 16字节，时间上因为是特殊的题目固定的数所以暂不做考虑。 / It costs 16 Byte in space and I don't want to consider the time because this question have a fixed value.
	 * @return the result
	 */
	public static int getRusult()
	{
		//1、初始化各个参数 分别为公鸡 母鸡 小鸡的数量 以及最后算出来的结果。 / Initialize the parameter which represent the number of cock,hen,chick and the result of this question.
		int a = 0;			// 取值范围0-20  / a must between 0 to 20.
		int b = 0;			// 取值范围0-33  / b must between 0 to 33.
		int c = 100;			// 取值范围0-(100-a-b)  / c must between 1 to (100-a-b).
		int result = 0; 	 
		
		//2、进行循环判断是否满足 直到尝试完所有的组合   / To try all the conditions by loop.
		for( ; a < 20 ; )
		{
			if( 5*a + 3*b + c/3 == 100 && c%3 == 0)//注意判断时要加上c为整除的情况下，否则为增加一些错误情况。满足所需条件，结果加1。 / Notice this code,we should add c%3=0 or there would be some wrong answers.
			{
				result ++;
				System.out.println("a="+a+" b=" + b +" c="+c);
			}
			
			b++;
			c--;
			if(b == 34)//表明已经尝试过该a值下的 bc所有组合 此时a++ b=1 c=100-a-b / It means we have try every conditions at this value of a.Now we just let a++ b=1 c=100-a-b.
			{
				a++;
				b=1;
				c=100-a-b;
			}
		}
		return result;
	}
	
	public static void main(String[] args) 
	{
		int result = getRusult();
		System.out.println("The answer is "+result+".");
	}
} 