package by.tms.calc.entity;

import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis) - 29/05/2023 - 1:02
 */
public class OperationHistoryPage {

    public static final int OPERATIONS_PER_PAGE = 20;

    private List<Operation> operations;
    private int pageNumber;
    private int countOfAllPages;

    public OperationHistoryPage(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getCountOfAllPages() {
        return countOfAllPages;
    }

    public void setCountOfAllPages(int countOfAllPages) {
        this.countOfAllPages = countOfAllPages;
    }
}
