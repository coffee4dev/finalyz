package coffee4dev.finalyz.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAG", indexes = {@Index(columnList = "name")})
public class Tag {

	private long id;
	private String name;
	private Set<Expense> expenses = new HashSet<>();
	
	public Tag() {
	}

	public Tag(String name) {
		this.name = name;
	}

	@Id
	@Column(name = "TAG_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
		expenses.stream().forEach(exp -> exp.addTag(this));
	}
	
	public void addExpense(Expense expense) {
		expenses.add(expense);
	}
	
}
