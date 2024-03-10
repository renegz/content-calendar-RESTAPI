package com.renegz.contentcalendar.controller;

import com.renegz.contentcalendar.config.ContentCalendarProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    private final ContentCalendarProperties properties;

    //Springboot se encarga de manejar todas las instancias de la aplicacion, por lo que realiza la inyeccion de dependencias automaticamente
    //@Autowired //Indica que esto es algo que quiero inyectado, sin embargo esta implicito
    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentCalendarProperties home(){
        return properties;
    }
}
