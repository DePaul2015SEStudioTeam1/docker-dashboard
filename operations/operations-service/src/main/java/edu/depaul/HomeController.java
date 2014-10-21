/**
 * 
 */
package edu.depaul;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ptrzyna
 *
 */
@Controller
@RequestMapping("/movie")
public class HomeController {

	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	public String getTest(@PathVariable String name, ModelMap model) {
		model.addAttribute("movie", name);
		return "list";
	}
 
	
}
