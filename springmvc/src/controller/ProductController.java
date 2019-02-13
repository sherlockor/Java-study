package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Product;

@Controller
public class ProductController {
    @RequestMapping("/addProduct")
    public ModelAndView add(Product product) throws Exception{
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        
        ModelAndView modelAndView = new ModelAndView("pass");
        return modelAndView;
    }
    
    @RequestMapping("/jump")
    public ModelAndView jump() {
        System.out.println("function jump()");
        ModelAndView modelAndView = new ModelAndView("redirect:/index");
        return modelAndView;
    }
    
    @RequestMapping("/check")
    public ModelAndView check(HttpSession session) {
        Integer integer = (Integer)session.getAttribute("count");
        if(integer == null) {
            integer = 0;
        }
        integer++;
        session.setAttribute("count", integer);
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
