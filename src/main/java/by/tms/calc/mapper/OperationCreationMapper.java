package by.tms.calc.mapper;

import by.tms.calc.dto.OperationCreationDTO;
import by.tms.calc.entity.Operation;
import by.tms.calc.entity.OperationType;

import java.time.LocalDateTime;

/**
 * @author Andrei Lisouski (Andrlis) 29/05/2023 - 15:16
 */
public class OperationCreationMapper {

    public static Operation toOperation(OperationCreationDTO operationCreationDTO){
        Operation operation = new Operation();
        operation.setOperand1(operationCreationDTO.getOperand1());
        operation.setOperand2(operationCreationDTO.getOperand2());
        operation.setOperationType(OperationType.valueOf(operationCreationDTO.getOperationType()));

        return operation;
    }
}
