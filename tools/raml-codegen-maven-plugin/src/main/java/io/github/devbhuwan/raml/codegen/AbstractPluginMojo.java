package io.github.devbhuwan.raml.codegen;

import lombok.Getter;
import lombok.Setter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Getter
@Setter
abstract class AbstractPluginMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;
    @Parameter(property = "skip", defaultValue = "false")
    private boolean skip;

    @Override
    public void execute() {
        if (this.skip) {
            getLog().debug("skipping run as per configuration.");
            return;
        }
        doExecute();
    }

    protected abstract void doExecute();

}