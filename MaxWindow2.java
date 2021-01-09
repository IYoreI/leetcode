package com.xdjbw.getMaxWindow;

import java.util.LinkedList;

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
public class MaxWindow2 {
	public static void main(String[] args) {
		int[] a ={4,3,5,4,3,3,6,7};
		int w = 4;
		int[] res =getMaxWindow(a,w);
		
		for(int l :res){
			System.out.print(l+" ");
		}
	}
	public static int[] getMaxWindow(int[] arr,int w){
		if(arr == null || w<1 || arr.length<w)
			return null;
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length-w+1];
		int index = 0;
		for(int i=0;i<arr.length;i++){
			while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]){
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst()==i-w){
				qmax.pollFirst();
			}
			if(i>=w-1){
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
}
