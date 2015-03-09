package coffee4dev.finalyz.dao;

import java.util.List;

import coffee4dev.finalyz.model.Expense;

public interface ExpenseDAO {

	void saveExpense(Expense expense);
	
	List<Expense> findAllExpenses();
	
	void updateExpense(Expense expense);
	
}
