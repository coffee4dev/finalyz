package coffee4dev.finalyz.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	
	@RequestMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("message", "hello world!!");
		return "helloWorld";
	}

}
