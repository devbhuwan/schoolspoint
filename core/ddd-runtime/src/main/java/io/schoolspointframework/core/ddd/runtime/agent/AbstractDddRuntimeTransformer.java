package io.schoolspointframework.core.ddd.runtime.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Objects;

import static javassist.bytecode.AnnotationsAttribute.visibleTag;

/**
 * @author Bhuwan Prasad Upadhyay
 */
abstract class AbstractDddRuntimeTransformer implements ClassFileTransformer {

    private static final String JAVA_ASSIST_CLASS_PACKAGE_SEPARATOR = ".";
    private final ClassPool classPool = ClassPool.getDefault();

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className == null)
            return null;
        final String classNameDots = className.replaceAll("/", JAVA_ASSIST_CLASS_PACKAGE_SEPARATOR);
        final CtClass ctClass = classPool.getOrNull(classNameDots);
        if (ctClass == null)
            return null;
        if (ctClass.isFrozen()) {
            ctClass.detach();
            return null;
        }
        try {
            boolean anythingInstrumented = false;
            if (hasDddAnnotation(ctClass)) {
                instrument(ctClass);
                anythingInstrumented = true;
            }
            if (anythingInstrumented)
                return ctClass.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ctClass.detach();
        }
        return null;
    }

    private boolean hasDddAnnotation(final CtClass ctClass) throws ClassNotFoundException {
        return Objects.nonNull(ctClass.getAnnotation(annotationClass()));
    }

    protected abstract void instrument(final CtClass ctClass);

    protected abstract Class<?> annotationClass();


    private AnnotationsAttribute annotationsAttribute(ConstPool constPool, Class<?> annotationClass) {
        AnnotationsAttribute attribute = new AnnotationsAttribute(constPool, visibleTag);
        Annotation annotation = new Annotation(annotationClass.getTypeName(), constPool);
        attribute.setAnnotation(annotation);
        return attribute;
    }


    protected void addClassLevelAnnotation(CtClass ctClass, Class<?> annotationClass) {
        ClassFile classFile = ctClass.getClassFile();
        ConstPool constPool = classFile.getConstPool();
        classFile.addAttribute(annotationsAttribute(constPool, annotationClass));
        classFile.setVersionToJava5();
    }
}
