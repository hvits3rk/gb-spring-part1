package com.romantupikov.lesson2.component.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;


@Component
public class TestBFPP implements BeanFactoryPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(TestBFPP.class);

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        // получение имен BeanDefinitio всех бинов, объявленных пользователем
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        // перебор массива для получения доступа к каждому имени
        for (String name : beanDefinitionNames) {

            // получение BeanDefinition по имени(по другом никак!)
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);

            // Вывод информации о BeanDefinition
            log.debug(beanDefinition.toString());
        }
    }
}
