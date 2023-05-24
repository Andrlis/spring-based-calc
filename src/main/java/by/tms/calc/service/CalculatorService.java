package by.tms.calc.service;

import by.tms.calc.dto.OperationCreationDTO;
import by.tms.calc.entity.Operation;
import by.tms.calc.entity.OperationType;
import by.tms.calc.entity.User;
import by.tms.calc.storage.OperationStorage;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Simon Pirko on 9.01.23
 */
@Component
public class CalculatorService {

	private OperationStorage operationStorage;

	public CalculatorService(OperationStorage operationStorage) {
		this.operationStorage = operationStorage;
	}

	public Optional<Operation> calculate(OperationCreationDTO operationCreationDTO) {
		double result;
		Operation operation = Operation.builder()
				.setOperand1(operationCreationDTO.getOperand1())
				.setOperand2(operationCreationDTO.getOperand2())
				.setCreatedAt(LocalDateTime.now())
				.build();

		switch (operation.getOperationType()) {
			case SUM:
				result = operation.getOperand1() + operation.getOperand2();
				operation.builder().setResult(result).build();
				return Optional.of(operation);
			case SUB:
				result = operation.getOperand1() - operation.getOperand2();
				operation.builder().setResult(result).build();
				return Optional.of(operation);
			case MUL:
				result = operation.getOperand1() * operation.getOperand2();
				operation.builder().setResult(result).build();
				return Optional.of(operation);
			case DIV:
				result = operation.getOperand1() / operation.getOperand2();
				operation.builder().setResult(result).build();
				return Optional.of(operation);
		}
		return Optional.empty();
	}


}
