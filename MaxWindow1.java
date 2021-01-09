package com.xdjbw.getMaxWindow;

import java.util.ArrayList;
import java.util.List;

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
public class MaxWindow1{
	public static void main(String[] args) {
		int[] a ={4,3,5,4,3,3,6,7};		//���������
		int w = 4;						//�涨�Ĵ��ڵĴ�С
		List<Integer> list =getArray(a,w);
		
		for(int l :list){
			System.out.print(l+" ");
		}
	}
	public static List<Integer> getArray(int[] a,int w){		//������Ѱ汾
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
