import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.*;


@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {
}


class HeavyCalculator {

    @CacheResult
    public int slowSquare(int num) {

        // simulating heavy work
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("calculating square for " + num);
        return num * num;
    }
}


class CacheEngine {

    // simple cache store
    private static Map<String, Object> cacheStore = new HashMap<>();

    public static Object executeWithCache(
            Object obj,
            String methodName,
            Object... args
    ) throws Exception {

        Class<?> cls = obj.getClass();

        // build cache key
        String key = methodName + "_" + args[0];

        Method method = cls.getMethod(methodName, int.class);

        // check annotation
        if (method.isAnnotationPresent(CacheResult.class)) {

            // return cached value if present
            if (cacheStore.containsKey(key)) {
                System.out.println("returning cached value");
                return cacheStore.get(key);
            }

            // compute and cache result
            Object result = method.invoke(obj, args);
            cacheStore.put(key, result);
            return result;
        }

        // normal execution if no annotation
        return method.invoke(obj, args);
    }
}


public class CacheResultDemo {

    public static void main(String[] args) throws Exception {

        HeavyCalculator calc = new HeavyCalculator();

        System.out.println("first call:");
        System.out.println(CacheEngine.executeWithCache(calc, "slowSquare", 5));

        System.out.println("second call (same input):");
        System.out.println(CacheEngine.executeWithCache(calc, "slowSquare", 5));

        System.out.println("third call (different input):");
        System.out.println(CacheEngine.executeWithCache(calc, "slowSquare", 6));
    }
}