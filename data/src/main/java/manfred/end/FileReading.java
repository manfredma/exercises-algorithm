package manfred.end;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 演示两种文件读取方式：NIO {@link java.nio.file.Files#lines} 逐行流式读取
 * 以及 Apache Commons IO {@code FileUtils.readFileToString} 一次性读取全文。
 */
public class FileReading {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("./framework/spring/spring-boot/pom.xml")).forEach(System.out::println);

        String text = FileUtils.readFileToString(new File("./framework/spring/spring-boot/pom.xml"), "UTF-8");
        System.out.println(text);
    }
}
