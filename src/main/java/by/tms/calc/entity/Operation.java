package by.tms.calc.entity;


/**
 * @author Andrei Lisouski (Andrlis)
 */
public class Operation {

    private long id;

    private double operand1;

    private double operand2;

    private String operationType;
    private double result;

    private User author;

    public Operation(double operand1, double operand2, String operationType) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operationType = operationType;
    }

    public Operation(double operand1, double operand2, String operationType, double result, User author) {
        this(operand1, operand2, operationType);
        this.result = result;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getOperand1() {
        return this.operand1;
    }

    public double getOperand2() {
        return this.operand2;
    }

    public String getOperationType() {
        return this.operationType;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operand1=" + this.operand1 +
                ", operand2=" + this.operand2 +
                ", type='" + this.operationType + '\'' +
                ", result=" + this.result +
                '}';
    }
}
