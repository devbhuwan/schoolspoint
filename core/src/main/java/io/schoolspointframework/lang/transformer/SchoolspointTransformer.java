package io.schoolspointframework.lang.transformer;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

import static javassist.bytecode.AnnotationsAttribute.visibleTag;

/**
 * @author Bhuwan Prasad Upadhyay
 */
abstract class SchoolspointTransformer implements ClassFileTransformer {

    private static final String JAVA_ASSIST_CLASS_PACKAGE_SEPARATOR = ".";
    private final ClassPool classPool = ClassPool.getDefault();

    protected abstract boolean activateOnlyIf(CtClass ctClass) throws Exception;

    protected abstract void instrument(final CtClass ctClass) throws Exception;

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
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
            if (activateOnlyIf(ctClass)) {
                instrument(ctClass);
                anythingInstrumented = true;
            }
            if (anythingInstrumented)
                return afterInstrumented(ctClass, protectionDomain);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            ctClass.detach();
        }
        return null;
    }

    abstract byte[] afterInstrumented(CtClass ctClass, ProtectionDomain protectionDomain) throws Exception;


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
