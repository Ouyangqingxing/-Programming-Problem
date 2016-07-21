/**Ouyangqingxing_20151231_"Program About String"
Content: There are String S and String s.Now you should judge whether the S contains s.If S contains s,you should return the number that how many s does S contain.
★★★By the way:Today is the last day in 2015.At this important moment,I really wish everyone can make progress in study and happy everyday in 2016!★★★
*/

/**欧阳青星_20151231_《关于字符串的编程题》
题目： 给定一个字符串S和子串s，判断S中是否包含子串s，如果有，返回包含的个数。
★★★PS:今天是2015年的最后一天，在2015即将过去2016即将到来之际，祝大家（当然还有我 = =）在新的一年心想事成，学习进步。★★★
*/

package com.jason.best;
 
public class Oyqx_20151231
{
	/** It costs O(i*j) in time and 12 Byte in space.I did not use the KMP algorithm, I will modify it in the future. / 时间复杂度：O（i*j） 空间复杂度：12个字节 我使用的朴素匹配算法，没有用kmp算法，下次有机会将改进。
	 * @param Str String S / 主字符串S
	 * @param str String s / 子字符串s
	 * @return Return result except when it returns -1. / 除了错误码-1 其他均为结果。
	 */
	public static int checkStr(String Str,String str)
	{
		//1、Judge the parameter(maybe String would be null or "" and S.length() shorter than s.length())   / 判断参数是否合法(可能出现的错误 字符串为null、"" 主串小于子串长度)  
		if(Str == null || str == null){return -1;}
		else if(Str == "" || str == ""){return -1;}
		else if(Str.length() < str.length()){return -1;}
		 
		//2、Realize it / 执行功能
		int result = 0;
		int i = 0;
		int j = 0;
		while(true)
		{ 
			//2、1  比较  Str第i=0个字符 与 str第j=0个字符 
			//2、2  相同则i++ j++ / 不相同则 i++ 
			//2、3  如果j = str.length，则 result++,j赋为0，判断是否已超出字符串长度 退出或者执行2.1 /   如果i>Str.length - str.length则比较结束 。
			
			//2、1 Compare S(i) s(j)  
			//2、2 If they are the same,i++ and j++.Else i++.  
			//2.3 If j = str.length，then result++ ,j = 0，Judge whether it over the Str/str .length. break or continue at 2.1 / If i>Str.length - str.length ,break.
			
			if(Str.charAt(i) == str.charAt(j))
			{
				i++;
				j++; 
				if(j == str.length())
				{
					result ++ ;
					j=0;
				}
				
				if(i >= Str.length() ){break;}  
			}
			else
			{
				i++;
				j=0;
				if( i>Str.length() - str.length()){break;} 
			} 
		} 
		return result;
	}
	
	public static void main(String[] args) 
	{ 
		System.out.println(checkStr("ABC",""));
		System.out.println(checkStr("","ABC"));
		System.out.println(checkStr("",""));
		System.out.println(checkStr("ABC",null));
		System.out.println(checkStr(null,"ABC"));
		System.out.println(checkStr(null,null));
		System.out.println(checkStr(" "," "));
		System.out.println(checkStr("ABC","ABC"));
		System.out.println(checkStr("AB Cab cABCA BBA BAB","A B"));
		System.out.println(checkStr("我我我我我你我我我我"," 你"));
	}
}
