/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.kubernetes.operator.crd.spec;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/** Flink job spec. */
@Data
@NoArgsConstructor
public class JobSpec {
    private String jarURI;
    private int parallelism;
    private String entryClass;
    private String[] args = new String[0];
    private JobState state = JobState.RUNNING;

    // The below fields are excluded from equals to avoid triggering job upgrades on changing these
    @EqualsAndHashCode.Exclude private String initialSavepointPath;
    @EqualsAndHashCode.Exclude private UpgradeMode upgradeMode = UpgradeMode.STATELESS;
}