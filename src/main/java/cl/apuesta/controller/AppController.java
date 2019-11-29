package cl.apuesta.controller;

import java.util.Calendar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AppController {
    
    @RequestMapping(method=RequestMethod.GET)
    public String index(ModelMap model){
        Calendar c = Calendar.getInstance();
        String fecha = c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) + "/" +
                c.get(Calendar.YEAR) + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + 
                ":" + c.get(Calendar.SECOND);
        model.addAttribute("mensaje", "SERVIDOR DE APUESTAS!!!");
        model.addAttribute("fecha",fecha);
        return "index";
    }
}
