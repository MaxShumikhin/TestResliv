package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import test.bot.Bot;
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
        Bot.main();
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
    public String addNewCityToBD(@ModelAttribute("newCity") Geography geography) {
                if (appService.addNewCity(geography)) {
            return "redirect:/all";
        } else {
            return "addNewCity";
        }
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public ModelAndView goToEditPage(@ModelAttribute("id") long id) {
        Geography geography = appService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("geography", geography);
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String editCity(@ModelAttribute("geography") Geography geography){
        appService.editNote(geography);
        return "redirect:/all";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String goToDeletePage() {
        return "deletePage";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String deletePage(int id) {
        Geography geography = appService.findById(id);
        appService.deleteNote(geography);
        return "redirect: /all";
    }


}
