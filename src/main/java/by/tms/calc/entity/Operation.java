package by.tms.calc.entity;


import java.time.LocalDateTime;

/**
 * @author Andrei Lisouski (Andrlis)
 */
public class Operation {

    private long id;

    private double operand1;

    private double operand2;

    private OperationType operationType;
    private double result;

    private User author;

    private LocalDateTime createdAt;

    public Operation() {
    }

    public long getId() {
        return id;
    }

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public double getResult() {
        return result;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
