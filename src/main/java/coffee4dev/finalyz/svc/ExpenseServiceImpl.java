package coffee4dev.finalyz.svc;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coffee4dev.finalyz.dao.ExpenseDAO;
import coffee4dev.finalyz.dao.TagDAO;
import coffee4dev.finalyz.model.Expense;
import coffee4dev.finalyz.model.Tag;

@Service("expenseService")
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseDAO dao;
	
	@Autowired
	private TagDAO tagDAO;
	
	@Override
	public Expense createExpense(Date date, Double amount, String currency, String[] tagNames, String description) {
		Expense exp = new Expense();
		exp.setDate(date);
		exp.setAmount(amount);
		exp.setCurrency(currency);
		exp.setDescription(description);
		
		dao.saveExpense(exp);
		
		exp.setTags(getTags(tagNames));
		dao.updateExpense(exp);
		
		return exp;
	}
	
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
	
	private Set<Tag> getTags(String[] tagNames) {
		final Set<Tag> res = new HashSet<>();
		Arrays.asList(tagNames).stream().map(name -> name.trim()).forEach(name -> {
			Tag tag = tagDAO.findByName(name);
			if (tag == null) {
				tag = new Tag(name);
				tagDAO.saveTag(tag);
			}
			res.add(tag);
		});
		return res;
	}

}
