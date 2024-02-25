package com.renegz.contentcalendar.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//Con esto podemos cargar data al iniciar la aplicacion
//@Profile("dev") //Quiero que se inicie cuando este en el perfil dev
//@Profile("!dev") //Quiero que se inicie cuando este no este en dev
//@Component //Con esta anotacion hacemos que tome la clase como un componente de la aplicacion
public class DataLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello 👌");
    }
}
