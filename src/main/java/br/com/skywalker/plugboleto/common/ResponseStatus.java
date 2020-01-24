package br.com.skywalker.plugboleto.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ResponseStatus {
    SUCCESS();

    private static Map<String, ResponseStatus> SERIALIZATION_MAP = new HashMap<>();

    static {
        SERIALIZATION_MAP.put("sucesso", SUCCESS);
    }

    @JsonCreator
    static ResponseStatus forValue(String value) {
        return SERIALIZATION_MAP.get(value);
    }

    @JsonValue
    String toValue() {
        for (Map.Entry<String, ResponseStatus> entry : SERIALIZATION_MAP.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }
        return null;
    }
}
