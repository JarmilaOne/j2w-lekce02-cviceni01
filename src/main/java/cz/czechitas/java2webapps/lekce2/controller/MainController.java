package cz.czechitas.java2webapps.lekce2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

@Controller
public class MainController {

    private final LocalDate datumLD;
    private final LocalTime casLT;
    private final DateTimeFormatter fullD;
    private final DateTimeFormatter mediumT;

    public MainController(){
        datumLD = LocalDate.now();
        casLT = LocalTime.now();
        fullD = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        mediumT = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);

    }
    @GetMapping("/datum")

    public ModelAndView getDate(){

        ModelAndView result = new ModelAndView("datum");
        result.addObject("datum", datumLD.format(fullD));

        return result;
    }

    @GetMapping("/cas")
    public ModelAndView getTime(){
        ModelAndView result2 = new ModelAndView("cas");
        result2.addObject("cas", casLT.format(mediumT));

        return result2;
    }
}
