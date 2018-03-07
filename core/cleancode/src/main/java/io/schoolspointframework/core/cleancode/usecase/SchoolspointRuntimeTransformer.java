package io.schoolspointframework.core.cleancode.usecase;

import javassist.ClassPool;
import javassist.CtClass;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public abstract class SchoolspointRuntimeTransformer implements ClassFileTransformer {

    private static final String JAVA_ASSIST_CLASS_PACKAGE_SEPARATOR = ".";
    private final ClassPool classPool = ClassPool.getDefault();

    protected static boolean hasInterface(CtClass ctClass, Class<?> interfaceType) throws Exception {
        return Stream.of(ctClass.getInterfaces()).anyMatch(c -> isEqualClass(interfaceType.getInterfaces()[0], c));
    }

    private static boolean isEqualClass(Class<?> excepted, CtClass source) {
        return Objects.equals(source.getClass().getName(), excepted.getName());
    }

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
                return ctClass.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ctClass.detach();
        }
        return null;
    }

    protected abstract boolean activateOnlyIf(CtClass ctClass) throws Exception;

    protected abstract void instrument(final CtClass ctClass) throws Exception;

}
