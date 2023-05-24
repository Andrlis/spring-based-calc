package by.tms.calc.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Andrei Lisouski (Andrlis) - 24/05/2023 - 17:00
 */
public class OperationCreationDTO {

    @NotBlank(message = "Not Black")
    @NotEmpty(message = "Not Empty")
    private double operand1;

    @NotBlank(message = "Not Black")
    @NotEmpty(message = "Not Empty")
    private double operand2;

    @NotBlank(message = "Not Black")
    @NotEmpty(message = "Not Empty")
    private String operationType;

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
