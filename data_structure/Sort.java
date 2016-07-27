package com.jason.data_structure;

import java.util.Stack;

public class Sort {
	/**
	 * 遍历数组
	 * 将信息输出在控制台
	 * @param array 待遍历的数组
	 */
	public void showdata(int[] array){
		System.out.print("数组信息：");
		for(int i = 0 ; i < array.length ; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

	public void shellSort(int[] array){
		
	}
	
	public void RadixSort(int[] array){
		
	}
	
	/**
	 * 冒泡排序
	 * @param array 待排序的数组
	 */
	public void bubbleSort(int[] array){
		//flag标志用于判断当前轮是否进行过交换 如果没有则可结束排序
		int length = array.length;
		boolean flag = true;
		for(int indexOfRound = 0 ; indexOfRound < length && flag ; indexOfRound++){
			flag = false;
			for(int indexOfCompare = indexOfRound ; indexOfCompare < length - 1 ; indexOfCompare++){
				if(array[indexOfCompare] > array[indexOfCompare+1]){
					int temp = array[indexOfCompare+1];
					array[indexOfCompare+1] = array[indexOfCompare];
					array[indexOfCompare] = temp;
					flag = true;
				}
			}
		}
	}
	
	/**
	 * 快速排序-递归实现
	 * @param array 待排序的数组
	 * @param size 数组的长度
	 * @param left 左方下标
	 * @param right 右方下标
	 */
	public void quickSortRec(int[] array , int size , int left , int right){
		int i,j,tmp;
		int left_index;
		int right_index;
		
		//l.第一个键值为d[lf]
		if(left < right){
			left_index = left + 1;
			right_index = right; 
			//排序
			while(true){
				//2.由左向右找出一个键值大于d[lf]者
				for( i = left + 1 ; i <= right ; i++){
					if(array[i]>=array[left]){
						left_index = i;
						break;
					}
					left_index++;
				}
				//3.由右向左找出一个键值小于d[lf]者
				for( j = right ; j >= left + 1 ; j--){
					if(array[j] <= array[left]){
						right_index=j;
						break;
					}
					right_index--;
				}
				//4.若lf_idx < rg_index
				if(left_index < right_index){
					tmp = array[left_index];
					array[left_index] = array[right_index]; //则互换
					array[right_index] = tmp;
				}
				else{
					break;	
				}
			}
			//5.1 若lf_idx大于等于rg_index
			if(left_index >= right_index){
				tmp = array[left];
				array[left] = array[right_index];
				array[right_index] = tmp;
				//5.2并以rg_index为基准点分成左右两半
				quickSortRec(array,size,left,right_index-1);//递归排序
				quickSortRec(array,size,right_index+1,right);//直到完成
			}
		}
	}
	
	/**
	 * 快速排序-非递归实现
	 * @param array 待排序的数组
	 */
	public void quickSortNonrec(int[] array) {
        if (array == null || array.length == 1){
        	return;
        }
        //存放开始与结束索引
        Stack<Integer> s = new Stack<Integer>(); 
        //压栈       
        s.push(0); 
        s.push(array.length - 1); 
        //利用循环里实现
        while (!s.empty()) { 
            int right = s.pop(); 
            int left = s.pop(); 
            //如果最大索引小于等于左边索引，说明结束了
            if (right <= left) {
            	continue; 
            }
            int temp;
            int i=left,j=right;
            if(left<right){
                temp=array[i];
                //当i=j的时候，则说明扫描完成了
                while(i<j){
                    //从右边向左边扫描找到一个小于temp的元素
                    while(j>i&&array[j]>temp){
                    	j--;
                    }
    	            if(i<j){
    	                //将该元素赋值给temp
    	            	array[i]=array[j]; 
    	                //赋值后就应该将i+1指向下一个序号
    	                i++;
    	            }
                    //然后从左边向右边开始扫描，找到一个大于temp的元素
                    while(i<j&&temp>array[i]){
                    	i++;
                    }
                    if(i<j){
                        //将该元素赋值给temp
                    	array[j]=array[i];
                        //赋值后就应该将j-1指向前一个序号
                        j--;
                    }
                }
                //将轴数据放在i位置中
                array[i]=temp;
            }
            if (left < i - 1) {
                s.push(left);
                s.push(i - 1);
            } 
            if (i + 1 < right) {
                s.push(i+1);
                s.push(right);
            }
        } 
    }
    
	
	
	public static void main(String args[]){
		Sort qs = new Sort();		
		int[] data = { 1 , 3 , 5 , 43 , 32 , 25 , 11 , 66 , 54 , 84 , 72 , 99};	
		
//		qs.quickSortRec(data,data.length,0,data.length-1);
//		qs.showdata(data);
		
//		qs.quickSortNonrec(data);
//		qs.showdata(data);
		
		qs.bubbleSort(data);
		qs.showdata(data);
		
	}
}