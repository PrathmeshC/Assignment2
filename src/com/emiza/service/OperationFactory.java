package com.emiza.service;

import com.emiza.exception.DivideByZero;
import com.emiza.exception.IntegerOutOfLimit;
import com.emiza.exception.InvalidOperator;
import com.emiza.mathOperation.Divide;
import com.emiza.mathOperation.MathsOp;
import com.emiza.mathOperation.Modulus;
import com.emiza.mathOperation.Multiply;
import com.emiza.mathOperation.Subtract;

public class OperationFactory {

	private MathsOp mOp;

	public MathsOp getmOp() {
		return mOp;
	}

	public OperationFactory(int pOperand1, int pOperand2, char pOperator) throws IntegerOutOfLimit, InvalidOperator {
		pOperator = Character.toUpperCase(pOperator);
		switch (pOperator) {
		case 'P':
			this.mOp = new MathsOp(pOperand1, pOperand2);
			break;

		case 'S':
			this.mOp = new Subtract(pOperand1, pOperand2);
			break;

		case 'M':
			this.mOp = new Multiply(pOperand1, pOperand2);
			break;

		case 'D':
			if (pOperand2 == 0) {
				throw new DivideByZero();
			}
			this.mOp = new Divide(pOperand1, pOperand2);
			break;

		case 'N':
			if (pOperand2 == 0) {
				throw new DivideByZero();
			}
			this.mOp = new Modulus(pOperand1, pOperand2);
			break;

		default:
			throw new InvalidOperator();

		}
	}

	public float calculate() throws InvalidOperator, IntegerOutOfLimit {
		return mOp.operate();
	}

	public String getmSign() {
		System.out.println(this.mOp.getmSign());
		return this.mOp.getmSign();
	}
}
