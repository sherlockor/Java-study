package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController /* implements Controller */ {
    @RequestMapping("/indexJsp")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("function");
        ModelAndView modelAndView = new ModelAndView("indexJsp");
		modelAndView.addObject("message", "Hello Spring MVC");
		return modelAndView;
	}
    
    @RequestMapping("/index")
    public String handleRequest1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("function1");
        return "index";
    }
}
