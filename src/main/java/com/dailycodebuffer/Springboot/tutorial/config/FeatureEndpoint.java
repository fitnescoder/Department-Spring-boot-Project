package com.dailycodebuffer.Springboot.tutorial.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="features")
public class FeatureEndpoint {

    private final Map<String, Feature> featureMap =
            new ConcurrentHashMap();

    public FeatureEndpoint() {
        featureMap.put("Department", new Feature(true));
        featureMap.put("User Service", new Feature(false));
        featureMap.put("Auth", new Feature(false));
    }

    @ReadOperation
    private Map<String, Feature> featuresMap() {
        return featureMap;
    }

    @ReadOperation
    private Feature getFeature(@Selector String key) {
        return featureMap.get(key);
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }
}
