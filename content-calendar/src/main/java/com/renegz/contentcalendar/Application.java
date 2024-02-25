package com.renegz.contentcalendar;

import com.renegz.contentcalendar.config.ContentCalendarProperties;
import com.renegz.contentcalendar.model.Content;
import com.renegz.contentcalendar.model.Status;
import com.renegz.contentcalendar.model.Type;
import com.renegz.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository){
		return args -> {
			//Insertando data programaticamente
			Content content = new Content(null, //si le doy el id dara error ya que la base lo hace automaticamente
					"Hola chatgpt",
					"un saludon",
					Status.IDEA,
					Type.VIDEO,
					LocalDateTime.now(),
					null,
					"");
			repository.save(content);
		};
	}

}
