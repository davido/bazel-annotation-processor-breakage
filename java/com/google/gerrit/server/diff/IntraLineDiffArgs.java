
package com.google.gerrit.server.diff;

import com.google.auto.value.AutoValue;
import com.google.gerrit.reviewdb.client.Project;

@AutoValue
public abstract class IntraLineDiffArgs {
  public static IntraLineDiffArgs create(Project.NameKey project, String path) {
    return new AutoValue_IntraLineDiffArgs(project, path);
  }

  public abstract Project.NameKey project();

  public abstract String path();
}
