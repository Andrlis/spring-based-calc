package by.tms.calc.service;

import by.tms.calc.dto.OperationCreationDTO;
import by.tms.calc.entity.*;
import by.tms.calc.mapper.OperationCreationMapper;
import by.tms.calc.mapper.SessionUserMapper;
import by.tms.calc.storage.OperationStorage;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
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
		Operation operation = OperationCreationMapper.toOperation(operationCreationDTO);

		switch (operation.getOperationType()) {
			case SUM:
				result = operation.getOperand1() + operation.getOperand2();
				operation.setResult(result);
				return Optional.of(operation);
			case SUB:
				result = operation.getOperand1() - operation.getOperand2();
				operation.setResult(result);
				return Optional.of(operation);
			case MUL:
				result = operation.getOperand1() * operation.getOperand2();
				operation.setResult(result);
				return Optional.of(operation);
			case DIV:
				result = operation.getOperand1() / operation.getOperand2();
				operation.setResult(result);
				return Optional.of(operation);
		}
		return Optional.empty();
	}

	public void save(Operation operation, SessionUser sessionUser) {
		operation.setCreatedAt(LocalDateTime.now());
		operation.setAuthor(SessionUserMapper.toUser(sessionUser));
		operationStorage.save(operation);
	}

	public OperationHistoryPage getHistoryPage(int pageNumber, SessionUser sessionUser){
		User user = SessionUserMapper.toUser(sessionUser);
		OperationHistoryPage historyPage = new OperationHistoryPage(pageNumber);
		List<Operation> operationList = operationStorage.getAllByUserWithOffset(user, OperationHistoryPage.OPERATIONS_PER_PAGE, pageNumber);
		historyPage.setOperations(operationList);
		historyPage.setCountOfAllPages((int) Math.ceil(operationStorage.getCountOfOperationsPerUser(user)/OperationHistoryPage.OPERATIONS_PER_PAGE));
		return historyPage;
	}
}
