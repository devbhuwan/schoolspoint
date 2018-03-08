package io.schoolspointframework.lang.transformer;

import javassist.CtClass;
import lombok.extern.slf4j.Slf4j;

import java.security.ProtectionDomain;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@Slf4j
public abstract class SchoolspointCompileTimeTransformer extends SchoolspointTransformer {

    @Override
    byte[] afterInstrumented(CtClass ctClass, ProtectionDomain protectionDomain) throws Exception {
        String sourceRootPath = protectionDomain.getCodeSource().getLocation().getPath();
        ctClass.writeFile(sourceRootPath);
        return null;
    }

}
