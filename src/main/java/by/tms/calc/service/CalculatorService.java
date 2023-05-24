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
		switch (OperationType.valueOf(operation.getOperationType())) {
			case SUM:
				operation.setResult(operation.getOperand1() + operation.getOperand2());
				return operation;
			case SUB:
				operation.setResult(operation.getOperand1() - operation.getOperand2());
				return operation;
			case MUL:
				operation.setResult(operation.getOperand1() * operation.getOperand2());
				return operation;
			case DIV:
				operation.setResult(operation.getOperand1() / operation.getOperand2());
				return operation;
		}
		return operation;
	}
}
