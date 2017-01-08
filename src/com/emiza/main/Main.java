package com.emiza.main;

import java.text.DecimalFormat;

import com.emiza.exception.DivideByZero;
import com.emiza.exception.IntegerOutOfLimit;
import com.emiza.exception.InvalidOperator;
import com.emiza.service.OperationFactory;
import com.emiza.service.Utility;

public class Main {

	public static void main(String[] args) {
		// inputs

		String[] inputArray, valueArray;
		String input = "1,2,p;4,3,s;5,6,m;60,25,d;7,8,n";
		DecimalFormat form = new DecimalFormat("0.0000");
		Utility u = new Utility();
		try {
			inputArray = u.toInputArray(input);
			System.out.println(inputArray.length);
			for (int i = 0; i < inputArray.length; i++) {
				System.out.println(inputArray[i]);
				valueArray = u.toValueArray(inputArray[i]);
				OperationFactory of = new OperationFactory(Integer.parseInt(valueArray[0]),
						Integer.parseInt(valueArray[1]), valueArray[2].charAt(0));
				System.out.println(of.getmOp().getmOperand1() + of.getmOp().getmSign() + of.getmOp().getmOperand2()
						+ " = " + form.format(of.calculate()));
			}
		} catch (IntegerOutOfLimit e) {
			e.printStackTrace();
		} catch (InvalidOperator e) {
			e.printStackTrace();
		} catch (DivideByZero e) {
			e.printStackTrace();
		}
	}
}