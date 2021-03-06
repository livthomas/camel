/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.etcd.springboot.cloud;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.component.etcd.EtcdConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "camel.cloud.etcd")
public class EtcdCloudConfiguration {
    private boolean enabled = true;
    private ServiceDiscoveryConfiguration serviceDiscovery = new ServiceDiscoveryConfiguration();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ServiceDiscoveryConfiguration getServiceDiscovery() {
        return serviceDiscovery;
    }

    // *************************************************************************
    //
    // *************************************************************************

    public class ServiceDiscoveryConfiguration extends EtcdConfiguration {
        private final Map<String, EtcdConfiguration> configurations = new HashMap<>();

        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Map<String, EtcdConfiguration> getConfigurations() {
            return configurations;
        }
    }
}
