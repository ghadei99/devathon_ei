package listeners;

import java.lang.reflect.Method;

import org.apache.tools.ant.taskdefs.Retry;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;
import org.yaml.snakeyaml.constructor.Constructor;

public class AnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer((Class<? extends IRetryAnalyzer>) Retry.class);
    }
}
