package com.jason.data_structure;

public class Sort {
	public void quickSort(int d[] , int size , int lf , int rg){
		int i,j,tmp;
		int lf_index;
		int rg_index;
		int t;
		
		//l.第一个键值为d[lf]
		if(lf<rg){
			lf_index = lf + 1;
			rg_index = rg;
			//排序
			while(true){
				//2.由左向右找出一个键值大于d[lf]者
				for( i = lf + 1 ; i <= rg ; i++){
					if(d[i]>=d[lf]){
						lf_index = i;
						break;
					}
					lf_index++;
				}
				//3.由右向左找出一个键值小于d[lf]者
				for( j = rg ; j >= lf + 1 ; j--){
					if(d[j] <= d[lf]){
						rg_index=j;
						break;
					}
					rg_index--;
				}
				//4.若lf_idx < rg_index
				if(lf_index < rg_index){
					tmp = d[lf_index];
					d[lf_index] = d[rg_index]; //则互换
					d[rg_index] = tmp;
				}
				else{
					break;	
				}
			}
			//5.1 若lf_idx大于等于rg_index
			if(lf_index >= rg_index){
				tmp = d[lf];
				d[lf] = d[rg_index];
				d[rg_index] = tmp;
				//5.2并以rg_index为基准点分成左右两半
				quickSort(d,size,lf,rg_index-1);//递归排序
				quickSort(d,size,rg_index+1,rg);//直到完成
			}
		}
	}
	public static void main(String args[]){
		Sort qs = new Sort();		
		int[] data = { 1 , 3 , 5 , 43 , 32 , 25 , 11 , 66 , 54 , 84 , 72 , 99};	
		
		qs.quickSort(data,data.length,0,data.length-1);
		qs.showdata(data);
		
	}
	public void showdata(int[] data){
		int i;
		for(i = 0 ; i < data.length ; i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}