package com.xdjbw.getMaxWindow;

import java.util.LinkedList;

/**
 * 	���ɴ������ֵ����
 *	��һ����������arr��һ����СΪw�Ĵ��ڴ����������߻������ұߣ�����ÿ�����ұ߻�һ��λ�á�
 * 	���磬����Ϊ[4,3,5,4,3,3,6,7]�����ڴ�СΪ3ʱ��
 *	[4 3 5] 4 3 3 6 7 ���������ֵΪ5
 * 	4 [3 5 4] 3 3 6 7 ���������ֵΪ5
 *	4 3 [5 4 3] 3 6 7 ���������ֵΪ5
 *	4 3 5 [4 3 3] 6 7 ���������ֵΪ4
 *	4 3 5 4 [3 3 6] 7 ���������ֵΪ6
 *	4 3 5 4 3 [3 6 7] ���������ֵΪ7
 *	������鳤��Ϊn�����ڴ�СΪw����һ������n-w+1�����ڵ����ֵ��
 *	��ʵ��һ������������һ������arr�����ڴ�Сw��
 *	����һ������Ϊn-w+1������res,res[i]��ʾÿһ�ִ���״̬�µ����ֵ��
 *	�Ա���Ϊ�������Ӧ�÷���[5,5,5,4,6,7]��
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
