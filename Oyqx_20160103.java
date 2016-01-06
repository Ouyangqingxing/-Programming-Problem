//Did not finish.
//尚未完成。

/**欧阳青星_20160103_《关于数字填空的编程题》 
题目：在横线上填写数字，使之符合要求。
  	0 1 2 3 4 5 6 7 8 9
  	_ _ _ _ _ _ _ _ _ _
	要求：对应的数字下填入的数，代表上面的数在下面出现的次数，比如3下面是1，代表3要在下面出现一次。

分析：这个题目乍看上去很简单，我第一想法是直接后面全部填0 然后0填8就可以了。
	但是仔细想想0下面填了8，那8不久出现了1次了吗？8下面就必须填1，这样0就不是8个了。
	这样会容易陷入死循环，不但难以找到正解，编程上更是无从下手。
	此时我想到了相似的游戏“数独”，我们知道数独是有一定规律的，即每一行每一列都只出现1-9数字一次。
	这个题一定有隐藏的规律，能让我们更方便的找到正解。
	
	规律1：下面这些数字之和一定等于10。
	规律2：上下数字乘积之和为10。
	解释1：下面一排有且仅能填10个数字，所以无论这10数字是0-9怎样的组合而来，出现的次数只和一定等于10，即下面数字和为10.
	解释2：由规律1推倒而来，假设下面数字为0001112223,他们和为10，我们计算的方式为0*3 + 1*3 + 2*3 + 3*1 + 4*0 +5*0……9*0 = 10 ,式子的前半段即可总结为规律2。

	明白了这两个规律之后，完成这个问题的求解就轻松了很多。
	但是，当我们让计算机去编程实现的时候又出现了一些新的问题。现在我们需要让计算机按照一个规律去遍历所有可能出现的情况，而且这并不是一个简单的
排列组合的问题，因为下面的10个数字和为10.起初我想从0000000001生成到9999999999,在生成时根据和为10来做判断是否继续，但是这样浪费了太多
的时间空间，既然是一个编程题，我认为尽量选取到比较优的解，不然草草了事没有意义。于是我想到，多做一些分析后在让计算机去尝试，按照非零数的个数来划分，
例如1个非零数时 只能为10 0 0 0 0 0 0 0 0 0，2个非零数为9 1 去占领10个空位的组合问题，一直到10个非零数。

答案：0 1 2 3 4 5 6 7 8 9
    6 2 1 0 0 0 1 0 0 0
          */

package com.jason.best;

public class Oyqx_20160103 
{
	public static void main(String[] args)
	{
	 
		 
	}
	
	public static int[] getArr()
	{
		//1、取到将要进行排列的数字
		
		//i为非零数的个数
		for(int i = 2 ; i < 9 ; i++)
		{
			
			
			
		} 
		//2、进行排列 并检测是否可行
		int[] arr = {10,0,0,0,0,0,0,0,0,0}; 
		
		return arr;
	}
	
	
	/**检查是否满足需求的函数
	 * @param arr
	 * @return
	 */
	public static boolean checkArr(int[] arr)
	{
		String Arr = arr[0]+""+arr[1]+""+arr[2]+""+arr[3]+""+arr[4]+""+arr[5]+""+arr[6]+""+arr[7]+""+arr[8]+""+arr[9];
		
		//正好使用到2015.12.31写的字符串中子串个数判断
		if(checkStr(Arr,"0")==arr[0] && checkStr(Arr,"1")==arr[1] && checkStr(Arr,"2")==arr[2] && checkStr(Arr,"3")==arr[3] && checkStr(Arr,"4")==arr[4] && checkStr(Arr,"5")==arr[5] && checkStr(Arr,"6")==arr[6] && checkStr(Arr,"7")==arr[7] && checkStr(Arr,"8")==arr[8] && checkStr(Arr,"9")==arr[9])
		{
			return true;
		}
		return false;
	}
	
	/**辅助功能函数 对一个数组从小到大冒泡排序
	 * @param arr 处理的数组
	 * @return 排序后的数组
	 */
	public static int[] sortIntStr(int[] arr)
	{
		for(int i = 0 ; i < arr.length ; i++)
		{ 
			for(int j = 0 ; j < arr.length - 1 ; j++)
			{ 
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			} 
		} 
		return arr;
	}
	
	/**辅助功能函数 检测主串Str中含有子串str的个数
	 * @param Str 主串
	 * @param str 子串
	 * @return 个数，-1为错误参数。
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
}
