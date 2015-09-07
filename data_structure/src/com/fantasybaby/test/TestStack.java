package com.fantasybaby.test;

import static org.junit.Assert.*;

import java.beans.Expression;

import org.junit.Test;

import com.fantasybaby.constant.ExpressionOper;
import com.fantasybaby.inter.AbstractStack;
import com.fantasybaby.inter.impl.SimpleSQLStack;
import com.fantasybaby.util.StackApplyUtil;

public class TestStack {

	@Test
	public void test() {
		AbstractStack<Integer> as = new SimpleSQLStack<Integer>(5);
		long currentTimeMillis = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			as.push(i);
		}
		System.out.println(System.currentTimeMillis() - currentTimeMillis);
//		while(!as.empty()){
////			System.out.println(as.pop());
//			
//		}
		
	}
	@Test
	public void testEnum() {
		 System.out.println(ExpressionOper.NUMBERSIGN);
		 System.out.println(StackApplyUtil.getValueByChar('#'));
		 String str = "+3+8*2-(2+1)";
		 StackApplyUtil.evaluateExpression(str);
	}

}