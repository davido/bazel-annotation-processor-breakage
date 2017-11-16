# bazel-annotation-processor-breakage

To reproduce the breakage on Windows, clone this project and issue:

```bash
bazel build java/com/google/gerrit/server/diff:diff 
INFO: Analysed target //java/com/google/gerrit/server/diff:diff (1 packages loaded).
INFO: Found 1 target...
ERROR: /home/davido/projects/bazel-annotation-processor-breakage/java/com/google/gerrit/server/diff/BUILD:3:1: Building java/com/google/gerrit/server/diff/libdiff.jar (1 source file) and running annotation processors (AutoAnnotationProcessor, AutoValueProcessor) failed (Exit 1)
bazel-out/k8-fastbuild/bin/java/com/google/gerrit/server/diff/_javac/diff/libdiff_sourcegenfiles/com/google/gerrit/server/diff/AutoValue_IntraLineDiffArgs.java:51: error: method equals in class NameKey cannot be applied to given types;
      return (this.project.equals(that.project()))
                          ^
  required: Object
  found: NameKey
  reason: argument mismatch; NameKey cannot be converted to Object
Target //java/com/google/gerrit/server/diff:diff failed to build
Use --verbose_failures to see the command lines of failed build steps.
INFO: Elapsed time: 0.418s, Critical Path: 0.22s
FAILED: Build did NOT complete successfully
```

Note, that all is fine on Linux:

```
$ bazel build java/com/google/gerrit/server/diff:diff 
INFO: Analysed target //java/com/google/gerrit/server/diff:diff (11 packages loaded).
INFO: Found 1 target...
Target //java/com/google/gerrit/server/diff:diff up-to-date:
  bazel-bin/java/com/google/gerrit/server/diff/libdiff.jar
INFO: Elapsed time: 1.597s, Critical Path: 1.12s
INFO: Build completed successfully, 9 total actions
```
