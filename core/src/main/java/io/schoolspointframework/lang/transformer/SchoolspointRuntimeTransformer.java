package io.schoolspointframework.lang.transformer;

import javassist.CtClass;
import lombok.extern.slf4j.Slf4j;

import java.security.ProtectionDomain;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Slf4j
public abstract class SchoolspointRuntimeTransformer extends SchoolspointTransformer {

    @Override
    byte[] afterInstrumented(CtClass ctClass, ProtectionDomain protectionDomain) throws Exception {
        return ctClass.toBytecode();
    }

}
