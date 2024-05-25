package plugin;

import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;

public class PluginLoader {
    // Metode untuk memuat dan memanggil metode yang mengembalikan String
    public static String loadAndInvoke(String jarPath) throws Exception {
        URL[] urls = { new URL("file:" + jarPath) };
        URLClassLoader classLoader = URLClassLoader.newInstance(urls);

        // Mengambil nama kelas dari path JAR
        String className = extractClassName(jarPath);

        // Memuat kelas berdasarkan nama yang diberikan
        Class<?> cls = classLoader.loadClass(className);

        Object instance = cls.getDeclaredConstructor().newInstance();

        Method method = findMethodReturningString(cls);
        if (method == null) {
            throw new Exception("No method returning String found in the class.");
        }

        return (String) method.invoke(instance);
    }

    // mengekstrak nama kelas dari path JAR
    private static String extractClassName(String jarPath) {
        // Menghilangkan .jar dan segala sesuatu sebelum nama file
        String className = jarPath.substring(jarPath.lastIndexOf("/") + 1, jarPath.length() - 4);
        return className;
    }

    // Menemukan metode pertama yang return tipe String
    private static Method findMethodReturningString(Class<?> cls) {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getReturnType().equals(String.class)) {
                return method;
            }
        }
        return null;
    }
}
