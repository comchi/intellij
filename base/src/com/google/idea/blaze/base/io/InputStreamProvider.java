/*
 * Copyright 2016 The Bazel Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.idea.blaze.base.io;

import com.google.errorprone.annotations.MustBeClosed;
import com.google.idea.blaze.base.command.buildresult.OutputArtifact;
import com.intellij.openapi.components.ServiceManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/** Provides input streams for files and {@link OutputArtifact}s. */
public interface InputStreamProvider {

  static InputStreamProvider getInstance() {
    return ServiceManager.getService(InputStreamProvider.class);
  }

  InputStream forFile(File file) throws IOException;

  @MustBeClosed
  BufferedInputStream forOutputArtifact(OutputArtifact output) throws IOException;
}
