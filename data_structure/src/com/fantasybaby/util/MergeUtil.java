package com.fantasybaby.util;

import com.fantasybaby.inter.ILinerList;
import com.fantasybaby.inter.impl.SimpleArrayImpl;

public class MergeUtil {
	private static ILinerList<Integer> linerList = null;
	/**
	 * A = A U B
	 */
	public static Integer[] mergeCollections(Integer[] a_list, Integer[] b_list){
		linerList = new SimpleArrayImpl();
		for (int i = 0; i < b_list.length; i++) {
			int locate = linerList.locate(a_list, b_list[i]);
			if (locate < 0) {
				int length = linerList.getLength(a_list);
				a_list = linerList.insert(a_list , length + 1 , b_list[i]);
			}
		}
		return a_list;
	}
	/**
	 * merge two linear increased 
	 */
	public static Integer[] mergelinear(Integer[] a_list, Integer[] b_list){
		linerList = new SimpleArrayImpl();
		Integer[] c_list = null;
		int i=0;
		int j=0;
		int k =0;
		while (a_list.length > i && b_list.length > j) {
			Integer aElementData = linerList.get(a_list, i);
			Integer bElementData = linerList.get(b_list, j);
			if (aElementData.intValue() < bElementData.intValue()) {
				c_list = linerList.insert(c_list, k + 1, aElementData);
				i++;
				k++;
			}else{
				c_list = linerList.insert(c_list, k + 1, bElementData);
				j++;
				k++;
			}
		}
		if(i < a_list.length){
			while (i <= a_list.length) {
				c_list = linerList.insert(c_list, k + 1, linerList.get(a_list, i));
				i++;
				k++;
			}
		}else if(j < b_list.length){
			while (j <= b_list.length) {
				c_list = linerList.insert(c_list, k + 1, linerList.get(b_list, j));
				j++;
				k++;
			}
		}
		
		return c_list;
	}

}
