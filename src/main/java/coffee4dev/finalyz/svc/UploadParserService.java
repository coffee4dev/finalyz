package coffee4dev.finalyz.svc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coffee4dev.finalyz.model.Expense;
import coffee4dev.finalyz.model.Tag;

@Service("upParserService")
public class UploadParserService {

	private static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	
	@Autowired
	private ExpenseService expenseSvc;
	
	@Autowired
	private TagService tagSvc;
	
	public void parseCSV(String content) throws IOException {
		Arrays.asList(content.split("\\r?\\n")).stream()
				.filter(line -> !line.trim().toLowerCase().contains("entry (tags)"))
				.forEach(line -> {
			
			List<String> terms = Arrays.asList(line.split("\",\"")).stream()
					.map(term -> term.trim().replaceAll("\"", ""))
					.collect(Collectors.toList());
			
			Expense exp = new Expense();
			
			try {
				exp.setDate(DATE_FORMAT.get().parse(terms.get(0)));
				exp.setAmount(Double.valueOf(terms.get(4).replaceAll(",", "")));
				exp.setCurrency(terms.get(5));
				exp.setDescription(terms.get(6));
				
				expenseSvc.saveExpense(exp);
				
				exp.setTags(getTags(terms.get(1)));
				expenseSvc.updateExpense(exp);
			} catch (ParseException | NumberFormatException e) {
				// TODO add logging
				return;
			}
		});
	}

	private Set<Tag> getTags(String str) {
		final Set<Tag> res = new HashSet<>();
		Arrays.asList(str.split(",")).stream().map(name -> name.trim()).forEach(name -> {
			Tag tag = tagSvc.findByName(name);
			if (tag == null) {
				tag = new Tag(name);
				tagSvc.saveTag(tag);
			}
			res.add(tag);
		});
		return res;
	}
	
}
