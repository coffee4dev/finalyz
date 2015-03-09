package coffee4dev.finalyz.svc;

import java.util.List;

import coffee4dev.finalyz.model.Expense;

public interface ExpenseService {
	
	void saveExpense(Expense expense);
	
	List<Expense> findAll();
	
	void updateExpense(Expense expense);

}
