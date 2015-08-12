package com.trungp.test;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanDefinitionRegistryPostProcessorImpl implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {
	private Boolean isPlane;
	private ApplicationContext applicationContext;

	public void setPropertiesLocation(ClassPathResource location) throws IOException {
		
	}
	
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0){
		System.out.println("Do nothing at this stuff");
	}

	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
			throws BeansException {
		System.out.println(" Register dms context at this point ");
		Resource resource =  applicationContext.getResource("classpath:com/trungp/test/application.properties");
		Properties props = new Properties();
		try {
			props.load(resource.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.isPlane = Boolean.parseBoolean(props.getProperty("plane.enabled"));
		
		BeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		if(isPlane){
			reader.loadBeanDefinitions("classpath:**/plane-context.xml");
		}
		else{
			reader.loadBeanDefinitions("classpath:**/train-context.xml");
		}

	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		
	}

	

	

}
