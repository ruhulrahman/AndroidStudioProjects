package bd.com.hasan.app.dailyexpense;

public class Expense {
    private int id;
    private int expenseAmount;
    private String expenseDate;
    private String expenseTime;
    private String expenseType;
    private String expenseDocument;


    public Expense(int id, String expenseAmount, String expenseDate, String expenseTime, String expenseType) {
    }

    public Expense(int id, int expenseAmount, String expenseDate, String expenseTime, String expenseType) {
        this.id = id;
        this.expenseAmount = expenseAmount;
        this.expenseDate = expenseDate;
        this.expenseTime = expenseTime;
        this.expenseType = expenseType;
    }

    public Expense(int id, int expenseAmount, String expenseDate, String expenseTime, String expenseType, String expenseDocument) {
        this.id = id;
        this.expenseAmount = expenseAmount;
        this.expenseDate = expenseDate;
        this.expenseTime = expenseTime;
        this.expenseType = expenseType;
        this.expenseDocument = expenseDocument;
    }

    public int getId() {
        return id;
    }

    public int getExpenseAmount() {
        return expenseAmount;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public String getExpenseTime() {
        return expenseTime;
    }

    public String getExpenseDocument() {
        return expenseDocument;
    }

    public String getExpenseType() {
        return expenseType;
    }
}
