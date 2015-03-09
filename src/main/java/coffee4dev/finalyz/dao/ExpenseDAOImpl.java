package coffee4dev.finalyz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import coffee4dev.finalyz.model.Expense;

@Repository("expenseDAO")
public class ExpenseDAOImpl extends AbstractDAO implements ExpenseDAO {

	@Override
	public void saveExpense(Expense expense) {
		persist(expense);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Expense> findAllExpenses() {
		Criteria c = getSession().createCriteria(Expense.class);
		return (List<Expense>) c.list();
	}

	@Override
	public void updateExpense(Expense expense) {
		getSession().update(expense);
	}

}
