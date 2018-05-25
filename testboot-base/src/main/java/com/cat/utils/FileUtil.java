package com.cat.utils;

import com.google.common.collect.Maps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author wangxiaoqiang
 * @since 2018/03/08
 **/
public class FileUtil {

    public static final String dir = "/Users/wangxiaoqiang/study/";

    public static void myFileReader(String name) throws IOException {
        char [] buf = new char[512];
        StringBuilder sb = new StringBuilder();

        try (FileReader fileReader = new FileReader(dir + name + ".txt")) {
//            System.out.println(fileReader.read(buf));
//            System.out.println(fileReader.read(buf, 0,60));
            while (fileReader.read(buf) > 0) {
                sb.append(buf);
            }
            System.out.println(sb.toString().trim());
        }

        File file = new File(dir + name +"2.txt");
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            bw.write(sb.toString().trim());
        }

    }


    public static void myFileOutput(String name) throws IOException{
        File file = new File(dir + name + ".txt");
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            for (int i = 0; i< 10; i++) {
                bw.write("line" + i);
                bw.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException{
        myFileOutput("test");
        myFileReader("test");
        Maps.newHashMap();
    }
}
