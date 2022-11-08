package com.demo.java8;

import java.io.File;
import java.io.FileFilter;

public class FileFilterLambdaEx {
    public static void main(String[] args) {
        System.out.println("Print files ending with .java");
        File directoryFile = new File("C:\\Users\\Enzo\\Desktop\\Master\\IJProjectAdvancedJavaD1\\d1-advanced-java\\src\\main\\java\\com\\demo\\java8");
        JavaFileFilter javaFileFilter = new JavaFileFilter();
        File[] files = directoryFile.listFiles(javaFileFilter);
        for(File file : files) {
            System.out.println(file.getName());
        }
    }
}
// the traditional way of implementing an interface with a class
class JavaFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".txt");
    }
}