package coffee4dev.finalyz.svc;

import java.util.Date;
import java.util.List;

import coffee4dev.finalyz.model.Expense;

public interface ExpenseService {
	
	Expense createExpense(Date date, Double amount, String currency, String[] tagNames, String description);
	
	void saveExpense(Expense expense);
	
	List<Expense> findAll();
	
	void updateExpense(Expense expense);

}
