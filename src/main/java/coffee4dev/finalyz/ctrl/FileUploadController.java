package coffee4dev.finalyz.ctrl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping(value = "/fup", method = RequestMethod.POST)
	public String uploadFile(@RequestParam String name, 
			@RequestParam MultipartFile file, Model model) throws IOException {
		
		String text = new String(file.getBytes(), StandardCharsets.UTF_8);
		
		model.addAttribute("fcontent", text);
		return "upload";
	}

}
