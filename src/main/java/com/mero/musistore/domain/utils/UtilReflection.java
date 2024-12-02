package com.mero.musistore.domain.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class UtilReflection {
    public static <T> String[] getIgnoredProperties(T dto) {
        List<String> ignoredProperties = new ArrayList<>();

        for (Field field : dto.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.get(dto) == null) {
                    ignoredProperties.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return ignoredProperties.toArray(new String[ignoredProperties.size()]);
    }
}
