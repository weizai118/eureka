/*
 * Copyright 2014 Netflix, Inc.
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

package com.netflix.eureka.registry;

import java.util.ArrayList;
import java.util.List;

import com.netflix.eureka.interests.ApplicationInterest;
import com.netflix.eureka.interests.Interest;
import com.netflix.eureka.interests.VipsInterest;

/**
 * @author Tomasz Bak
 */
public enum SampleInterest {

    ZuulVip() {
        @Override
        public Interest<InstanceInfo> build() {
            return new VipsInterest("zuul.addr:7001");
        }
    },
    DiscoveryApp() {
        @Override
        public Interest<InstanceInfo> build() {
            return new ApplicationInterest("discovery001");
        }
    };

    public abstract Interest<InstanceInfo> build();

    public static List<Interest<InstanceInfo>> interestCollectionOf(SampleInterest... interests) {
        List<Interest<InstanceInfo>> result = new ArrayList<Interest<InstanceInfo>>(interests.length);
        for (SampleInterest intr : interests) {
            result.add(intr.build());
        }
        return result;
    }
}
