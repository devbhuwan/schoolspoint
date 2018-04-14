package io.github.devbhuwan.raml.codegen;

import org.apache.maven.project.MavenProject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;


class RamlToJavaCodeGeneratorPluginTest {

    RamlToJavaCodeGeneratorPlugin plugin;

    @BeforeEach
    void setUp() {
        plugin = new RamlToJavaCodeGeneratorPlugin();
        plugin.setProject(new MavenProject());
        plugin.setDefaultPackage("io.github.devbhuwan.contract");
        plugin.setRamlFile(new File("src/test/raml/student"));
        plugin.setOutputDirectory(new File("target/generated-sources/raml-codegen"));
    }

    @Test
    void givenGeneratePojoGoal_whenPluginExecute_ShouldGeneratePojoSourceCodeFromRamlDefinition() {
        plugin.execute();

    }
}