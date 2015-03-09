package coffee4dev.finalyz.ctrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping(value = "/fup", method = RequestMethod.POST)
	public String uploadFile(@RequestParam MultipartFile file, Model model) throws IOException {
		
		String text = new String(file.getBytes(), StandardCharsets.UTF_8);
		BufferedReader r = new BufferedReader(new StringReader(text));
		String line = r.readLine();
		while ((line = r.readLine()) != null) {
			Arrays.asList(line.split(",")).forEach((String e) -> {
				e = e.trim();
				e = e.substring(1, e.length() - 1);
				
			});
		}
		
		model.addAttribute("fcontent", text);
		return "upload";
	}

}
