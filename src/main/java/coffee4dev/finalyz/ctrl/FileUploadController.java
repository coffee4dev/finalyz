package coffee4dev.finalyz.ctrl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import coffee4dev.finalyz.svc.ExpenseService;
import coffee4dev.finalyz.svc.UploadParserService;

@Controller
public class FileUploadController {
	
	@Autowired
	UploadParserService uploadParser;
	
	@Autowired
	ExpenseService expenseSvc;
	
	@RequestMapping(value = "/fup", method = RequestMethod.POST)
	public String uploadFile(@RequestParam MultipartFile file, Model model) throws IOException {
		
		String content = new String(file.getBytes(), StandardCharsets.UTF_8);
		uploadParser.parseCSV(content);
		
		model.addAttribute("fcontent", content);
		model.addAttribute("expenses", expenseSvc.findAll());
		return "upload";
	}

}
