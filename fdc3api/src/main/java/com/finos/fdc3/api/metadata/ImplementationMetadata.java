/**
 * Copyright 2023 Wellington Management Company LLP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.finos.fdc3.api.metadata;

import java.util.Optional;

/**
 * Metadata relating to the FDC3 Desktop Agent implementation and its provider.
 */
public interface ImplementationMetadata {
  /** The version number of the FDC3 specification that the implementation provides.
   *  The string must be a numeric semver version, e.g. 1.2 or 1.2.1.
   */
  public String getfdc3Version();

  /** The name of the provider of the Desktop Agent implementation (e.g. Finsemble, Glue42, OpenFin etc.). */
  public String getProvider();

  /** The version of the provider of the Desktop Agent implementation (e.g. 5.3.0). */
  public Optional<String> getProviderVersion();

  /** Metadata indicating whether the Desktop Agent implements optional features of
   *  the Desktop Agent API.
   */
  public interface optionalFeatures {
    /** Used to indicate whether the exposure of 'origninating app metadata' for
     *  context and intent messages is supported by the Desktop Agent.*/
    public boolean OriginatingAppMetadata();

    /** Used to indicate whether the optional `fdc3.joinUserChannel`,
     *  `fdc3.getCurrentChannel` and `fdc3.leaveCurrentChannel` are implemented by
     *  the Desktop Agent.*/
    public boolean UserChannelMembershipAPIs();
  }

  /** The calling application instance's own metadata, according to the Desktop Agent (MUST include at least the `appId` and `instanceId`). */
  public AppMetadata getAppMetaData();
}
