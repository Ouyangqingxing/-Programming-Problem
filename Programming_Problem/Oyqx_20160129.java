package com.jason.best;

/**欧阳青星_20160129_《旋转输出》 编程题
 * 题目：给定一个长和宽和起始数字，从左上角开始顺时针直到没有位置，输出如实例格式的数字。
 * 例如：长 5 宽 6 起始 1
 * 	 
 * 	   1  2  3  4  5    
 *     18 19 20 21 6	
 *     17 28 29	22 7	
 *     16 27 30	23 8
 *     15 26 25	24 9
 *     14 13 12	11 10
 *  				  
 * 分析：我大概想到两种方法。
 * 1、跟着数字走。定义一个二维数组int[i][j]，根据当前位置的变化修改i、j的值 将不断加一数字赋值进去，最后只要按着[0][0-j]...[i][j]输出即可。
 * 2、直接输出。不需要数组，根据一个算法直接取得每一个位置应该对于的值然后输出。(此方法由于算法太复杂摒弃 )
 * 
 * Ouyangqingxing_20160129_Program About "rotate output"
 * Question:We get the length and width and the initial number.And we should output the number like this.
 * Example: Look at the above number.
 * Analysis: I get two ideas.
 * 			1、Just follow the number.We define a int[i][j],and put the number in the array currently.Then output the array.
 * 			2、 Just output the number.We can find a algorithm to get the result in the different location by i and j.(Although it can save the space,I think it too difficult to code.)
 */
public class Oyqx_20160129 
{
	/**不考虑输出 需要用4个int 加二维数组[width][length]实现  时间复杂度O(width*length) / Without thinking output we need 4 int and int[width][length] and O(width*length) in space. 
	 * @param width 宽度
	 * @param length 长度
	 * @param initial 初始值
	 * @return
	 */
	public static int[][] getArr(int width,int length,int initial) 
	{
		//1、进行参数检查  /  check the parameter 
		if(width<1 || length<1)
		{
			System.out.println("参数有误，请检查！  / Please check the parameter!");
			return null;
		}
		
		//2、初始化二维数组array 坐标i,j 当前移动方向direction / define the array and the coordinate i,j and the direction.
		int[][] arr  = new int[length][width]; 	
		int i = 0;
		int j = 0;
		int direction = 1; //1右 2下 3左 4上		/  1right 2down 3left 4up
		
		//3、进行赋值   / assignment
		for(int k = 0 ; k < length*width ; )//k来记录赋值次数，赋值到长*宽后退出循环	/ Use k to record the number of loop.We get out of the loop after k = length * width.
		{     
			//如果这个位置可以进行赋值并且还没有被赋值，则赋值	/  If this position can be assignment and it hasn't be assignment,then assign.
			if( i < length && i > -1 && j < width && j > -1 && arr[i][j]==0 ) 
			{
				arr[i][j] = initial ;
				initial++;
				k++;
			}
			else	 //否则将该位置回溯，并调整方向	/ else we get the position flash back and modify the direction.
			{
				switch(direction)			 
				{
					case 1:{j--;break;}
					case 2:{i--;break;}
					case 3:{j++;break;}
					case 4:{i++;break;} 
				}  
				direction ++;  
				if(direction == 5){direction = 1;} 
			} 
			switch(direction)	//根据目前的方向来修改i、j的值达到移动	/ Modify the i,j by the direction.
			{
				case 1:{j++;break;}
				case 2:{i++;break;}
				case 3:{j--;break;}
				case 4:{i--;break;} 
			} 
		} 
		return arr;
	}
	
	/** 将已经按照指定规则排列好的数组输出	/ Output the array we have made
	 * @param arr 拿到需要遍历的数组
	 * @param width 宽度
	 * @param length 长度
	 */
	public static void getResult(int[][] arr ,int width ,int length)
	{
		if(arr != null)
		{
			int i = 0 ;
			int j = 0 ;
			for( ; i < length ; j++)
			{
				System.out.print(arr[i][j]+"   ");		//注意 在一行结束前不换行	notice not wrap.
				if(j == width - 1)
				{
					j = -1;
					i++;
					System.out.println();
				}
			}
		}
	} 
	public static void main(String[] args) 
	{
		getResult(getArr(5,6,1 ),5,6);
		System.out.println();
		getResult(getArr(9,9,10 ),9,9); 
	}
}