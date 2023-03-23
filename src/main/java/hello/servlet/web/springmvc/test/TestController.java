package hello.servlet.web.springmvc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping
public class TestController {

    @RequestMapping("/springmvc/test/controller")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }

}
