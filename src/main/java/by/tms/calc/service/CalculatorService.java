package by.tms.calc.service;

import by.tms.calc.entity.Operation;
import by.tms.calc.entity.OperationType;
import by.tms.calc.storage.OperationStorage;

/**
 * @author Simon Pirko on 9.01.23
 */
public class CalculatorService {

	private OperationStorage operationStorage;

	public Operation calculate(Operation operation) {
		double result;
		switch (operation.getOperationType()) {
			case SUM:
				result = operation.getOperand1() + operation.getOperand2();
				operation.builder().setResult(result);
				return operation;
			case SUB:
				result = operation.getOperand1() - operation.getOperand2();
				operation.builder().setResult(result);
				return operation;
			case MUL:
				result = operation.getOperand1() * operation.getOperand2();
				operation.builder().setResult(result);
				return operation;
			case DIV:
				result = operation.getOperand1() / operation.getOperand2();
				operation.builder().setResult(result);
				return operation;
		}
		return operation;
	}
}
