package com.proxybean.main.proxy;

import com.proxybean.main.proxy.annotation.Animal;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.util.Set;

public class AnimalAnnotationComponentRegistrar implements ImportBeanDefinitionRegistrar {

    private final static String BASE_PACKAGE = "";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        Class<? extends Annotation> annotationClass = Animal.class;
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(BASE_PACKAGE))
                .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner()));
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(annotationClass);
        for (Class<?> cls : annotatedClasses) {
            String beanName = ClassUtils.getShortName(cls);
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition((Class) cls, () -> AnimalAnnotationProxy.createProxy(cls));
            BeanDefinition beanDefinition = builder.getBeanDefinition();
            registry.registerBeanDefinition(beanName, beanDefinition);
        }
    }
}