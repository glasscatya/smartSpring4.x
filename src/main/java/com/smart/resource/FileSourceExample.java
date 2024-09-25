package com.smart.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileSourceExample {
    public static void main(String[] args) {
        try {
            String filePath =
                    "F:\\CodePractice\\Java\\smart\\src\\main\\resources\\conf\\file1.txt";
            //绝对路径
            WritableResource res1 = new PathResource(filePath);
            //相对路径
            Resource res2 = new ClassPathResource("conf/file1.txt");
            //用WritableResource接口写
            OutputStream stream1 = res1.getOutputStream();
            stream1.write("贪玩蓝月，是兄弟砍一刀".getBytes(StandardCharsets.UTF_8));
            stream1.close();

            //
            InputStream ins1 = res1.getInputStream();
            InputStream ins2 = res2.getInputStream();

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            int i;
            while((i = ins1.read()) != -1) {
                bytes.write(i);
            }

            System.out.println(bytes);

            System.out.println("res1:" +res1.getFilename());
            System.out.println("res2:" + res2.getFilename());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
