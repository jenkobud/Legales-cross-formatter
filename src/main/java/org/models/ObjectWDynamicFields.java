package org.models;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class ObjectWDynamicFields {

    public Object getAttributeValueByName(String attribute) throws NoSuchFieldException, IllegalAccessException {
        return this.getFieldValue(this.getClass().getDeclaredField(attribute));
    }

    public Map<String, Object> getAtributesAsMap() {
        Map<String, Object> atributesMap = new HashMap<>();
        for(Field field : this.getClass().getDeclaredFields()) {
            try {
                atributesMap.put(field.getName(), this.getFieldValue(field));
            } catch (IllegalAccessException e) {
                System.out.println("An error happened mapping the attribute: " + field.getName() + " error thrown: " + e.getMessage());
            }
        }
        return atributesMap;
    }

    private Object getFieldValue(Field field) throws IllegalAccessException {
        field.setAccessible(true);
        Object res = field.get(this);
        field.setAccessible(false);
        return res;
    }
}
