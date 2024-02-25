package com.renegz.contentcalendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//se debe incluir la libreria configuration processor
@ConfigurationProperties(value = "cc") //prefijo (cc=contentcalendar)
public record ContentCalendarProperties(
        String welcomeMessage,
        String about
) {
}
