package utils;

import java.lang.reflect.Field;

/**
 * Created by sj.hu on 2019/4/1.
 */
public class ReflectUtils {

    /**
     * Get the Object's field value.
     * @param object
     * @param fieldType
     * @param <T>
     * @return
     */
    public static <T> T get(Object object, Class<T> fieldType) {
        Field[] fields = object.getClass().getDeclaredFields();
        Field field = null;
        for(Field item: fields) {
            if(item.getType() == fieldType) {
                field = item;
                break;
            }
        }

        if(field == null) {
            throw new RuntimeException("Can not find the field for type: " + fieldType);
        }

        field.setAccessible(true);
        try{
            Object value = field.get(object);
            if(value == null) {
                return null;
            } else {
                return (T) value;
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Can not access the field for type: " + fieldType, e);
        }
    }

    /**
     * Set the Object's field value.
     * @param object
     * @param fieldValue
     * @param fieldType
     * @param <T>
     */
    public static <T> void set(Object object, T fieldValue, Class<T> fieldType) {
        Field[] fields = object.getClass().getDeclaredFields();
        Field field = null;
        for(Field item: fields) {
            if(item.getType() == fieldType) {
                field = item;
                break;
            }
        }

        if(field == null) {
            throw new RuntimeException("Can not find the field for type: " + fieldType);
        }

        field.setAccessible(true);
        try {
            field.set(object, fieldValue);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Can not set the value of the field for type: " + fieldType, e);
        }
    }


}
