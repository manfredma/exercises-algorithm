package manfred.end;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * 演示递归遍历目录树的文件列举技巧，使用 {@link java.io.File} API
 * 通过深度优先递归将指定目录下所有文件收集到集合中。
 */
public class FileListing {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        File file = new File(".");
        Set<File> files = listFiles(file);
        files.stream().forEach(System.out::println);
    }

    public static Set<File> listFiles(File dir) {
        Set<File> files = new HashSet<>();
        if (dir == null || !dir.exists()) {
            return files;
        }
        if (dir.isFile()) {
            files.add(dir);
            return files;
        }
        File[] subFiles = dir.listFiles();
        for (File file : subFiles) {
            files.addAll(listFiles(file));
        }
        return files;
    }
}