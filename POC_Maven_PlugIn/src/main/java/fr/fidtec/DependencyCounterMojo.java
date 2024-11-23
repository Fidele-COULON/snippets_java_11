package fr.fidtec;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

// https://www.baeldung.com/maven-plugin
// https://maven.apache.org/guides/plugin/guide-java-plugin-development.html
// Mojo is a Java class that represents a goal that the plugin will execute.
// A plugin contains one or more mojos.
// "dependency-counter" is the name of the goal.
// it's attached to the compile phase by default so it isn't necessarily have to specify a phase when using this goal.
@Mojo(name = "dependency-counter", defaultPhase = LifecyclePhase.COMPILE)
public class DependencyCounterMojo extends AbstractMojo {

    // To have access to the project information.
    // This object will be injected by Maven when the context is created.
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    // a parameter where users can specify the scope of the dependencies that we want to count.
    @Parameter(property = "scope")
    String scope;

    public void execute() throws MojoExecutionException, MojoFailureException {
        List<Dependency> dependencies = project.getDependencies();
        long numDependencies = dependencies.stream()
                .filter(d -> (scope == null || scope.isEmpty()) || scope.equals(d.getScope()))
                .count();
        getLog().info("Number of dependencies: " + numDependencies);
    }
}
