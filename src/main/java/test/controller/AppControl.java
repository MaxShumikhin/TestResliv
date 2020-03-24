package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import test.entity.Geography;
import test.service.AppService;

import java.util.List;

@Controller
public class AppControl {

    private AppService appService;

    @Autowired
    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping("/")
    public String mainPage() {
        return "mainPage";
    }

    @RequestMapping(value = "enter", method = RequestMethod.GET)
    public ModelAndView allInformation() {
        List<Geography> geographyList = appService.allInfo();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("information");
        modelAndView.addObject("geographyList",geographyList);
        return modelAndView;
    }
}
