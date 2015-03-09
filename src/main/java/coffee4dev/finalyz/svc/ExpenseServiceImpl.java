package coffee4dev.finalyz.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coffee4dev.finalyz.dao.ExpenseDAO;
import coffee4dev.finalyz.model.Expense;

@Service("expenseService")
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseDAO dao;
	
	@Override
	public void saveExpense(Expense expense) {
		dao.saveExpense(expense);
	}

	@Override
	public List<Expense> findAll() {
		return dao.findAllExpenses();
	}

	@Override
	public void updateExpense(Expense expense) {
		dao.updateExpense(expense);
	}

}
