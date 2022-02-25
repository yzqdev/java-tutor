package com.yzq.javaio;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yanni
 * @date time 2021/10/14 11:32
 * @modified By:
 */
public class WriteFile {
    @Test
    public void write(){

        try {
            PrintWriter printWriter=new PrintWriter("txt//print-writer.txt", StandardCharsets.UTF_8);
            printWriter.println("first");
            printWriter.println("second");
            printWriter.println("first");
            printWriter.close();
            //create a binary file
            String file= "txt/printWriterBinary.txt";
            byte[] data = new byte[0];
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(data);
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void fileName() throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get("d://tmp"))) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining("; \n"));
            System.out.println("List: " + joined);
        }

    }
}
