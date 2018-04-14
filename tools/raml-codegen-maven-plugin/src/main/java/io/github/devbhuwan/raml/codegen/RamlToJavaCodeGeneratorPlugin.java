package io.github.devbhuwan.raml.codegen;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.raml.v2.api.RamlModelBuilder;
import org.raml.v2.api.RamlModelResult;
import org.raml.v2.api.model.common.ValidationResult;
import org.raml.v2.api.model.v10.api.Api;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.apache.maven.plugins.annotations.LifecyclePhase.GENERATE_SOURCES;
import static org.apache.maven.plugins.annotations.ResolutionScope.COMPILE;

@Mojo(name = RamlToJavaCodeGeneratorPlugin.GOAL, defaultPhase = GENERATE_SOURCES, requiresDependencyResolution = COMPILE, threadSafe = true)
@Setter
@Getter
public class RamlToJavaCodeGeneratorPlugin extends AbstractPluginMojo {

    static final String GOAL = "gen-raml";
    @Parameter(property = "ramlFile", defaultValue = "${project.basedir}/src/main/raml")
    private File ramlFile;
    @Parameter(property = "outputDirectory", defaultValue = "${project.build.directory}/generated-sources/raml-codegen")
    private File outputDirectory;
    @Parameter(property = "defaultPackage", defaultValue = "ram.codegen")
    private String defaultPackage;

    @Override
    @SneakyThrows(IOException.class)
    protected void doExecute() {
        Set<File> files = RamlUtils.detectRamlFiles(ramlFile);
        assert files != null;
        if (files.isEmpty()) {
            getLog().info("No raml files in [ " + ramlFile.getPath() + " ]");
            return;
        }
        FileUtils.forceMkdir(outputDirectory);
        Set<RamlModelResult> results = files.stream().map(RamlUtils::ramlModel).collect(toSet());
        RamlUtils.selectErrors(results).forEach(this::logError);
        RamlUtils.selectWithoutErrors(results).forEach(this::generate);
        getProject().addCompileSourceRoot(outputDirectory.getPath());
    }

    private void generate(RamlModelResult result) {
        final Api api = result.getApiV10();
        RamlCodeFactory.codeFactories()
                .forEach(f -> f.generate(api, defaultPackage, outputDirectory));
    }

    @SneakyThrows(MojoExecutionException.class)
    private void logError(ValidationResult result) {
        getLog().error("Raml Error [ path=" + result.getPath() + " , message=" + result.getMessage() + " ]");
        throw new MojoExecutionException("Invalid raml " + result.getPath());
    }

    private static class RamlUtils {

        static RamlModelResult ramlModel(File ramlFile) {
            return new RamlModelBuilder().buildApi(ramlFile);
        }

        static Set<File> detectRamlFiles(File basedir) {
            File[] files = basedir.listFiles((FileFilter) new WildcardFileFilter("*.raml"));
            assert files != null;
            return Set.of(files);
        }

        static Stream<ValidationResult> selectErrors(Set<RamlModelResult> results) {
            return results.stream()
                    .filter(RamlModelResult::hasErrors)
                    .map(RamlModelResult::getValidationResults)
                    .flatMap(List::stream);
        }

        static Stream<RamlModelResult> selectWithoutErrors(Set<RamlModelResult> results) {
            return results.stream().filter(r -> !r.hasErrors());
        }
    }

}
