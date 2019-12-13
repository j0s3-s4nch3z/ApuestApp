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
        String dia = c.get(Calendar.DAY_OF_MONTH) < 10 ? "0"+c.get(Calendar.DAY_OF_MONTH) : ""+c.get(Calendar.DAY_OF_MONTH) ;
        String mes = (c.get(Calendar.MONTH)+1) < 10 ? "0"+(c.get(Calendar.MONTH)+1) : ""+(c.get(Calendar.MONTH)+1) ;
        String anio = c.get(Calendar.YEAR)+"";
        String hora = c.get(Calendar.HOUR_OF_DAY) < 10 ? "0"+c.get(Calendar.HOUR_OF_DAY) : ""+c.get(Calendar.HOUR_OF_DAY) ;
        String minuto = c.get(Calendar.MINUTE) < 10 ? "0"+c.get(Calendar.MINUTE) : ""+c.get(Calendar.MINUTE) ;
        String segundo = c.get(Calendar.SECOND) < 10 ? "0"+c.get(Calendar.SECOND) : ""+c.get(Calendar.SECOND) ;
        String fecha = dia + "/" + mes + "/" + anio + " " + hora+ ":" + minuto + ":" + segundo;
        model.addAttribute("mensaje", "SERVIDOR DE APUESTAS!!!");
        model.addAttribute("fecha",fecha);
        return "index";
    }
}
