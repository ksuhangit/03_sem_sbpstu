package laba2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodInvoker {
    public static void invokeAnnotatedMethods() {
        try {
            MyClass obj = new MyClass();
            Method[] methods = MyClass.class.getDeclaredMethods();

            for (Method method : methods) {
                // Пропуск public методов
                if (Modifier.isPublic(method.getModifiers())) {
                    continue;
                }

                if (method.isAnnotationPresent(Repeat.class)) {
                    Repeat annotation = method.getAnnotation(Repeat.class);
                    int repetitions = annotation.value();

                    // Метод становится доступным
                    method.setAccessible(true);

                    // Создание параметров для метода
                    Class<?>[] paramTypes = method.getParameterTypes();
                    Object[] params = new Object[paramTypes.length];

                    // Вызов метода указанное количество раз
                    for (int i = 0; i < repetitions; i++) {
                        for (int j = 0; j < params.length; j++) {
                            params[j] = generateParameterValue(paramTypes[j], i);
                        }

                        // Вызов метода с динамически сгенерированными параметрами
                        method.invoke(obj, params);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Динамическое создание значений параметров для метода
    private static Object generateParameterValue(Class<?> paramType, int iteration) {
        // Генерация фиксированных значений на основе итерации
        if (paramType == String.class) {
            return "Hello World! " + (iteration + 1);
        } else if (paramType == int.class) {
            return iteration + 1; 
        } else if (paramType == double.class) {
            return 100.0 + iteration; 
        } else if (paramType == boolean.class) {
            return iteration % 2 == 0; 
        } else if (paramType == long.class) {
            return 1000L + iteration; 
        } else if (paramType == float.class) {
            return 100.0f + iteration;
        } else if (paramType == byte.class) {
            return (byte) (iteration % 256); 
        } else if (paramType == short.class) {
            return (short) (iteration % (Short.MAX_VALUE + 1)); 
        } else {
            return null; // Значение по умолчанию для неподдерживаемых типов
        }
    }
}
