package com.romantupikov.lesson2.component.lifecycle;

import com.romantupikov.lesson2.component.Camera;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PhotocameraTestBeanPostProcessor implements BeanPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(PhotocameraTestBeanPostProcessor.class);

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        // в данном методе просто возвращаем бин
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        // находим бин класса фотокамеры
        if (bean instanceof Camera) {

            log.info("Делаю пробное фото!");
            // делаем пробное фото
            if (((Camera) bean).doPhotograph())
                log.info("Отлично!Работает!");
        }
        return bean;
    }
}
