package com.hpperc;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCustomizer {
   @Bean  
   public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> configureServer(){
     return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {

       @Override
       public void customize(ConfigurableServletWebServerFactory factory) {
          factory.setContextPath("/HPPERC");
       }
     };
   }
}