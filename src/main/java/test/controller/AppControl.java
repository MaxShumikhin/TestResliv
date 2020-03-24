package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ModelAndView allInformation() {
        List<Geography> geographyList = appService.allInfo();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("information");
        modelAndView.addObject("geographyList", geographyList);
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addNewCity() {
        return "addNewCity";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public void addNewCityToBD(@ModelAttribute("newCity") Geography geography) {
        if (appService.addNewCity(geography)) {
            mainPage();
        } else {
            addNewCity();
        }
    }

}
