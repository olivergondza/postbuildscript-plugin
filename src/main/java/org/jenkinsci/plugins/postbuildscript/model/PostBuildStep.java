package org.jenkinsci.plugins.postbuildscript.model;

import hudson.tasks.BuildStep;
import org.kohsuke.stapler.DataBoundConstructor;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class PostBuildStep extends PostBuildItem {

    private List<BuildStep> buildSteps = new ArrayList<>();

    @DataBoundConstructor
    public PostBuildStep(@Nullable Collection<String> results, @Nullable Collection<BuildStep> buildSteps) {
        super(results);
        if (buildSteps != null) {
            this.buildSteps.addAll(buildSteps);
        }
    }

    public Iterable<BuildStep> getBuildSteps() {
        return Collections.unmodifiableCollection(buildSteps);
    }

    public Object readResolve() {
        super.readResolve();
        if (buildSteps == null) {
            buildSteps = new ArrayList<>();
        }
        return this;
    }


}
