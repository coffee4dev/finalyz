package coffee4dev.finalyz.svc;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			
			List<String> terms = Arrays.asList(line.split("\",\"")).stream().parallel()
					.map(term -> term.trim().replaceAll("\"", ""))
					.collect(Collectors.toList());
			
			try {
				Date date = DATE_FORMAT.get().parse(terms.get(0));
				Double amount = Double.valueOf(terms.get(4).replaceAll(",", ""));
				String currency = terms.get(5);
				String descr = terms.get(6);
				String[] tags = terms.get(1).split(",");
				expenseSvc.createExpense(date, amount, currency, tags, descr);
			} catch (ParseException | NumberFormatException e) {
				// TODO add logging
				return;
			}
		});
	}

}
