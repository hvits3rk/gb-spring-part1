package com.romantupikov.lesson2.component.lifecycle;

import com.romantupikov.lesson2.annotation.UnproducableCameraRoll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class UnproducableCameraRollBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(UnproducableCameraRollBeanFactoryPostProcessor.class);

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        // получаем имена всех BeanDefinition, чтобы получить доступ к каждому из них
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        // перебираем все имена
        for (String name : beanDefinitionNames) {

            // получаем BeanDefinition по имени
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);

            /* получаем имя класса создавамого бина, чтобы проверить ,
             * содержит ли он аннотацию UnsupportedCameraRoll
             */
            String className = beanDefinition.getBeanClassName();

            try {
                // получаем класс по имени
                Class<?> beanClass = Class.forName(className);

                /* пытаемся получить объект аннотации и ее значение,
                 * если класс не содержит данную аннотацию, то метод вернет null
                 */
                UnproducableCameraRoll annotation = beanClass.getAnnotation(UnproducableCameraRoll.class);

                // проверяем, содержал ли класс эту аннотацию
                if (annotation != null) {

                    log.info("Нашли класс [{}] с аннотацией: [{}]", beanClass.getSimpleName(),
                            annotation.annotationType().getSimpleName());
                    // получаем значение указанное в параметрах аннотации(класс пленки, которую необходимо использовать)
                    Class usingCameraRollName = annotation.usingCameraRollClass();

                    // меняем класс будущего бина!
                    log.info("Подменяем класс [{}], на - [{}]", beanClass.getSimpleName(),
                            usingCameraRollName.getSimpleName());
                    beanDefinition.setBeanClassName(usingCameraRollName.getName());
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
