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
        return Operation.builder()
                .setOperand1(operationCreationDTO.getOperand1())
                .setOperand2(operationCreationDTO.getOperand2())
                .setOperationType(OperationType.valueOf(operationCreationDTO.getOperationType()))
                .setCreatedAt(LocalDateTime.now())
                .build();
    }
}
