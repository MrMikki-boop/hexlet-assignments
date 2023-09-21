package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    public static List<String> validate(Object obj) {
        List<String> notValidFields = new ArrayList<>();

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == NotNull.class) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(obj);
                        if (value == null) {
                            notValidFields.add(field.getName());
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else if (annotation.annotationType() == MinLength.class) {
                    MinLength minLengthAnnotation = (MinLength) annotation;
                    try {
                        field.setAccessible(true);
                        Object value = field.get(obj);
                        if (value instanceof String) {
                            String stringValue = (String) value;
                            int minLength = minLengthAnnotation.minLength();
                            if (stringValue.length() < minLength) {
                                notValidFields.add(field.getName());
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> notValidFields = new HashMap<>();

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == NotNull.class) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(obj);
                        if (value == null) {
                            notValidFields.computeIfAbsent(field.getName(), k -> new ArrayList<>()).add("can not be null");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else if (annotation.annotationType() == MinLength.class) {
                    MinLength minLengthAnnotation = (MinLength) annotation;
                    try {
                        field.setAccessible(true);
                        Object value = field.get(obj);
                        if (value instanceof String) {
                            String stringValue = (String) value;
                            int minLength = minLengthAnnotation.minLength();
                            if (stringValue.length() < minLength) {
                                notValidFields.computeIfAbsent(field.getName(), k -> new ArrayList<>()).add("length less than " + minLength);
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return notValidFields;
    }
}
// END
