package com.proxybean.main.config;

import com.proxybean.main.proxy.AnimalAnnotationComponentRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AnimalAnnotationComponentRegistrar.class)
public class ApplicationConfiguration {

}