package com.ekapiww.testrunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import cucumber.api.junit.Cucumber;

public class ExtendedCucumberRunner extends Runner {
	
	private Class<?> clazz;
	private Cucumber cucumber;
	
	public ExtendedCucumberRunner(Class<?> extendedClazz) throws Exception {
		clazz = extendedClazz;
		cucumber = new Cucumber(clazz);
	}

	@Override
	public Description getDescription() {
		return cucumber.getDescription();
	}

	@Override
	public void run(RunNotifier notifier) {
		try {
			runPredefinedMethods(BeforeTestSuite.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		cucumber.run(notifier);
		
		try {
			runPredefinedMethods(AfterTestSuite.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void runPredefinedMethods(Class<?> annotation) throws Exception {
		if(!annotation.isAnnotation()) {
			return;
		}
		Method[] methodList = this.clazz.getMethods();
		for (Method method : methodList) {
			Annotation[] annotationList = method.getAnnotations();
			for (Annotation item : annotationList) {
				if(item.annotationType().equals(annotation)) {
					method.invoke(null);
					break;
				}
			}
		}
	}
}
