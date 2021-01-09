package com.xdjbw.getMaxWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * 	生成窗口最大值数组
 *	有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。
 * 	例如，数组为[4,3,5,4,3,3,6,7]，窗口大小为3时：
 *	[4 3 5] 4 3 3 6 7 窗口中最大值为5
 * 	4 [3 5 4] 3 3 6 7 窗口中最大值为5
 *	4 3 [5 4 3] 3 6 7 窗口中最大值为5
 *	4 3 5 [4 3 3] 6 7 窗口中最大值为4
 *	4 3 5 4 [3 3 6] 7 窗口中最大值为6
 *	4 3 5 4 3 [3 6 7] 窗口中最大值为7
 *	如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。
 *	请实现一个函数，给定一个数组arr，窗口大小w。
 *	返回一个长度为n-w+1的数组res,res[i]表示每一种窗口状态下的最大值。
 *	以本题为例，结果应该返回[5,5,5,4,6,7]。
 * @author Xiri-pc
 *
 */
public class MaxWindow1{
	public static void main(String[] args) {
		int[] a ={4,3,5,4,3,3,6,7};		//输入的数据
		int w = 4;						//规定的窗口的大小
		List<Integer> list =getArray(a,w);
		
		for(int l :list){
			System.out.print(l+" ");
		}
	}
	public static List<Integer> getArray(int[] a,int w){		//并非最佳版本
		List<Integer> list = new ArrayList<Integer>();
		int length =a.length;
		int i =w-1,j=0;
		int k=max(a,j,i);
		list.add(a[k]);
		
		for(i=w,j=1;i<length;i++,j++){
			if(a[i]>=a[k])
				list.add(a[i]);
			else if(j>k){
				k=max(a,j,i);
				list.add(a[k]);
			}else{
				list.add(a[k]);
			}
		}
		return list;
	}
	public static int max(int[] a, int j,int i){
		int temp=j;
		for(int m=j+1;m<=i;m++){
			if(a[m]>a[temp])
				temp=m;
		}
		return temp;
	}
}
