/**欧阳青星_20160124Ex_《m钱买n鸡》 编程题
 * 题目：一只公鸡值５元，一只母鸡值３元，３只小鸡值１元，现用m元要买n只鸡，问有什么方案？ 
 * 分析：首先肯定的是要用解方程，然后考虑应该通过循环来解方程。
 *
 * Ouyangqingxing_20160124Ex_Program About " m $ buy n chicken"
 * Question: Cock costs 5$/Hen costs 3$/3 Chicks cost 1$.Now how many solutions to buy n chicken(3 kinds of them) by m $ 
 * Analysis: At first,we can know it must like solve equations.Then we consider finish it by loop.
 */

package com.jason.best;
 
public class Oyqx_20160124_Ex 
{
	/**完成这个问题消耗了4个int 16字节，时间上复杂度O(m*n)。 / It costs 16 Byte in space and O(m*n) in time.
	 * @return the result
	 */
	public static int getRusult(int m ,int n)
	{
		//1、对参数进行检查,如果有错误返回错误参数-1。这里仅讨论m,n均为大于3的正整数的情况（其余情况不符合现实情况或可以直接得出结论）。 / The most important step for a function,I think,to check the parameter.We only accept the situation when m>=3 and n>=3,or we return the false parameter -1. 
		if( m<3 || n<3 )
		{
			return -1;
		}
		
		//2、初始化各个参数 分别为公鸡 母鸡 小鸡的数量 以及最后算出来的结果。 / Initialize the parameter which represent the number of cock,hen,chick and the result of this question.
		int a = 0;			// 取值范围0-(m/5) 可以肯定如果a=0没有解   / a must between 0 to (m/5).
		int b = 0;			// 取值范围0-(m/3) 可以肯定如果b=0没有解   / b must between 0 to (m/3).
		int c = n;			// 取值范围0-(n-a-b)  / c must between 0 to (n-a-b).
		int result = 0; 	 
		
		//3、进行循环判断是否满足 直到尝试完所有的组合   / To try all the conditions by loop.
		for( ; a < (m/5)+1 ; )
		{
			if( 5*a + 3*b + c/3 == m && c%3 == 0)//注意判断时要加上c为整除的情况下，否则为增加一些错误情况。满足所需条件，结果加1。 / Notice this code,we should add c%3=0 or there would be some wrong answers.
			{
				result ++;
				System.out.println("a="+a+" b=" + b +" c="+c);
			}
			
			b++;
			c--;
			if(b == (m/3+1) )//表明已经尝试过该a值下的 bc所有组合 此时a++ b=1 c=100-a-b / It means we have try every conditions at this value of a.Now we just let a++ b=1 c=100-a-b.
			{
				a++;
				b=1;
				c=n-a-b;
			}
		}
		return result;
	}
	
	public static void main(String[] args) 
	{
		int result = getRusult(30,30);
		System.out.println("For this situation,the answer is "+result+".");
	}
} 