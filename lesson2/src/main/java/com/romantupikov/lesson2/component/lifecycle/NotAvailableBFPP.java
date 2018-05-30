package com.romantupikov.lesson2.component.lifecycle;

import com.romantupikov.lesson2.annotation.NotAvailable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class NotAvailableBFPP implements BeanFactoryPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(NotAvailableBFPP.class);

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for (String name : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String clazzName = beanDefinition.getBeanClassName();
            try {
                Class<?> beanClazz = Class.forName(clazzName);
                NotAvailable annotation = beanClazz.getAnnotation(NotAvailable.class);
                if (annotation != null) {
                    log.info("Нашли класс [{}] с аннотацией: [{}]", beanClazz.getSimpleName(),
                            annotation.annotationType().getSimpleName());

                    Class fallbackClazz = annotation.fallbackClass();

                    log.info("Подменяем класс [{}], на - [{}]", beanClazz.getSimpleName(),
                            fallbackClazz.getSimpleName());
                    beanDefinition.setBeanClassName(fallbackClazz.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
