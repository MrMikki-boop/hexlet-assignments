package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        // Получаем класс Address
        Class<?> addressClass = address.getClass();

        // Получаем все методы класса
        Method[] methods = addressClass.getMethods();

        // Итерируем по методам
        for (Method method : methods) {
            // Проверяем, есть ли аннотация Inspect
            if (method.isAnnotationPresent(Inspect.class)) {
                // Выводим информацию о методе
                String methodName = method.getName();
                String returnType = method.getReturnType().getSimpleName();
                System.out.println("Method " + methodName + " returns a value of type " + returnType);
            }
        }
        // END
    }
}
