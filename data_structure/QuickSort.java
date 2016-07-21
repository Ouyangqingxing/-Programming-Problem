package com.jason.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class QuickSort {
	int process = 0;
	int size;
	int data[] = new int[100];
	
	public void inputarr(){
		//以随机数输入
		Random rand = new Random();
		int i;
		for(i = 0 ; i < size ; i++){
			data[i] = (Math.abs(rand.nextInt(99)))+1;
		}
	}
	public void showdata(){
		int i;
		for(i = 0 ; i < size ; i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	public void quick(int d[] , int size , int lf , int rg){
		int i,j,tmp;
		int lf_idx;
		int rg_idx;
		int t;
		
		//l.第一个键值为d[lf]
		if(lf<rg){
			lf_idx = lf + 1;
			rg_idx = rg;
			
			//排序
			while(true){
				System.out.print("[处理过程"+(process++)+"]=> ");
				for( t = 0 ; t < size ; t++){
					System.out.print("["+d[t]+"] ");
				}
				System.out.println();
				//2.由左向右找出一个键值大于d[lf]者
				for( i = lf + 1 ; i <= rg ; i++){
					if(d[i]>=d[lf]){
						lf_idx = i;
						break;
					}
					lf_idx++;
				}
				
				//3.由右向左找出一个键值小于d[lf]者
				for( j = rg ; j >= lf + 1 ; j--){
					if(d[j] <= d[lf]){
						rg_idx=j;
						break;
					}
					rg_idx--;
				}
				
				//4.若lf_idx < rg_idx
				if(lf_idx < rg_idx){
					tmp = d[lf_idx];
					d[lf_idx] = d[rg_idx]; //则互换
					d[rg_idx] = tmp;
				}
				else{
					break;	
				}
			}
			
			//5.1 若lf_idx大于等于rg_idx
			if(lf_idx >= rg_idx){
				tmp = d[lf];
				d[lf] = d[rg_idx];
				d[rg_idx] = tmp;
				
				//5.2并以rg_idx为基准点分成左右两半
				quick(d,size,lf,rg_idx-1);//递归排序
				quick(d,size,rg_idx+1,rg);//直到完成
			}
		}
	}
	
	public static void main(String args[]){
		QuickSort qs = new QuickSort();
		System.out.println("输入数组大小（100以内）");
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			qs.size = Integer.parseInt(br.readLine());
		}catch(Exception e){}
		
		qs.inputarr();
		System.out.print("原始数据是：");
		qs.showdata();
		
		qs.quick(qs.data,qs.size,0,qs.size-1);
		System.out.println("排序结果");
		qs.showdata();
		
	}
}