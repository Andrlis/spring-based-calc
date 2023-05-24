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

    public OperationBuilder builder() {
        return new Operation().new OperationBuilder();
    }

    public class OperationBuilder {
        private OperationBuilder() {
        }

        public OperationBuilder setId(long id){
            Operation.this.id = id;
            return this;
        }

        public OperationBuilder setOperand1(double operand1){
            Operation.this.operand1 = operand1;
            return this;
        }

        public OperationBuilder setOperand2(double operand2){
            Operation.this.operand2 = operand2;
            return this;
        }

        public OperationBuilder setOperationType(OperationType operationType){
            Operation.this.operationType = operationType;
            return this;
        }

        public OperationBuilder setResult(double result){
            Operation.this.result = result;
            return this;
        }

        public OperationBuilder setAuthor(User author){
            Operation.this.author = author;
            return this;
        }

        public OperationBuilder setCreatedAt(LocalDateTime createdAt){
            Operation.this.createdAt = createdAt;
            return this;
        }
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
}
