package com.jason.data_structure;

import java.util.Stack;

public class Sort {
	/**
	 * 冒泡排序
	 */
	public void bubbleSort(){
		
	}
	
	/**
	 * 快速排序-递归实现
	 * @param array 待排序的数组
	 * @param size 数组的长度
	 * @param lf 左方下标
	 * @param rg 右方下标
	 */
	public void quickSortRec(int array[] , int size , int lf , int rg){
		int i,j,tmp;
		int lf_index;
		int rg_index;
		
		//l.第一个键值为d[lf]
		if(lf<rg){
			lf_index = lf + 1;
			rg_index = rg; 
			//排序
			while(true){
				//2.由左向右找出一个键值大于d[lf]者
				for( i = lf + 1 ; i <= rg ; i++){
					if(array[i]>=array[lf]){
						lf_index = i;
						break;
					}
					lf_index++;
				}
				//3.由右向左找出一个键值小于d[lf]者
				for( j = rg ; j >= lf + 1 ; j--){
					if(array[j] <= array[lf]){
						rg_index=j;
						break;
					}
					rg_index--;
				}
				//4.若lf_idx < rg_index
				if(lf_index < rg_index){
					tmp = array[lf_index];
					array[lf_index] = array[rg_index]; //则互换
					array[rg_index] = tmp;
				}
				else{
					break;	
				}
			}
			//5.1 若lf_idx大于等于rg_index
			if(lf_index >= rg_index){
				tmp = array[lf];
				array[lf] = array[rg_index];
				array[rg_index] = tmp;
				//5.2并以rg_index为基准点分成左右两半
				quickSortRec(array,size,lf,rg_index-1);//递归排序
				quickSortRec(array,size,rg_index+1,rg);//直到完成
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
		
		qs.quickSortNonrec(data);
		qs.showdata(data);
		
	}
	
	/**
	 * 遍历数组
	 * @param array
	 */
	public void showdata(int[] data){
		System.out.print("");
		for(int i = 0 ; i < data.length ; i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}