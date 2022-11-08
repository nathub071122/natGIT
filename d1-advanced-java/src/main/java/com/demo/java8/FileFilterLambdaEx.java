package com.demo.java8;
//RECAP OF
// ANAONYMOUS CLASSES
// RAW TYPES
// GENERICS ENSURE TYPE SAFE COLLECTIONS AT THE COMPILER LEVEL.
// FILE API
// SYNTAX SUGAR

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// LAMBDA EXPRESSIONS MAKE THE USE OF ANONYMOUS CLASSES REALLY EASY
public class FileFilterLambdaEx {
    public static void main(String[] args) {
//        usingClassImplementationOfFileFilter();
//        usingAnonymousImplementationOfFileFilter();
//        usingLambdaExpressionsWithRawTypes();
//        usingLambdaExpressionsWithGenerics();
//        usingLambdaExpressionsWithGenerics1();
//        usingLambdaExpressionsWithGenerics2();
        usingLambdaExpressionsWithGenerics3();
    }

    private static void usingClassImplementationOfFileFilter() {
        System.out.println("Print files ending with .java");
        File directoryFile = new File("C:\\Users\\Enzo\\Desktop\\Master\\IJProjectAdvancedJavaD1\\d1-advanced-java\\src\\main\\java\\com\\demo\\java8");
        JavaFileFilter javaFileFilter = new JavaFileFilter();
        File[] files = directoryFile.listFiles(javaFileFilter);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    private static void usingAnonymousImplementationOfFileFilter() {
        System.out.println("Print files ending with .java");
        File directoryFile = new File("C:\\Users\\Enzo\\Desktop\\Master\\IJProjectAdvancedJavaD1\\d1-advanced-java\\src\\main\\java\\com\\demo\\java8");
//        anonymous classes make your code more concise
//        declare and instantiate the class at the same time
//        treat them like local classes without a name
//        use them for the need of a local class only once.


//        FileFilter fileFilter = new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().endsWith(".java");
//            }
//        };
//        File[] files = directoryFile.listFiles(fileFilter);
//        for(File file : files) {
//            System.out.println(file.getName());
//        }

//        more concise
        File[] files = directoryFile.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        });
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    private static void usingLambdaExpressionsWithRawTypes() {
        System.out.println("Print files ending with .java");
        File directoryFile = new File("C:\\Users\\Enzo\\Desktop\\Master\\IJProjectAdvancedJavaD1\\d1-advanced-java\\src\\main\\java\\com\\demo\\java8");
//      APPROACH 1 : USING LAMBDAS WITH LEGACY CODE.
        FileFilter textFileFilterLambdaVariable = (File pathName) -> {
            return pathName.getName().endsWith(".java");
        };
        File[] files = directoryFile.listFiles(textFileFilterLambdaVariable);
//        Pre java 5 (raw types)
        List listOfFiles = Arrays.asList(files);
        listOfFiles.add(new Exception());
        listOfFiles.add(new File("filename placeholder"));
        listOfFiles.forEach((Object file) -> {
            File file1 = (File) file;
            System.out.println(file1.getName());
        });
    }

    private static void usingLambdaExpressionsWithGenerics() {
        System.out.println("Print files ending with .java");
        File directoryFile = new File("C:\\Users\\Enzo\\Desktop\\Master\\IJProjectAdvancedJavaD1\\d1-advanced-java\\src\\main\\java\\com\\demo\\java8");
//      APPROACH 1 : USING LAMBDAS WITH GENERICS
        FileFilter textFileFilterLambdaVariable = (File pathName) -> {
            return pathName.getName().endsWith(".java");
        };
        File[] files = directoryFile.listFiles(textFileFilterLambdaVariable);
//        USING GENERICS
        List<File> listOfFiles = Arrays.asList(files);
//        'add(java.io.File)' in 'java.util.List' cannot be applied to '(java.lang.Exception)'
//        listOfFiles.add(new Exception());
//        listOfFiles.add(new File("filename placeholder"));
        listOfFiles.forEach((File file) -> {
            System.out.println(file.getName());
        });
    }

    private static void usingLambdaExpressionsWithGenerics1() {
        System.out.println("Print files ending with .java");
        File directoryFile = new File("C:\\Users\\Enzo\\Desktop\\Master\\IJProjectAdvancedJavaD1\\d1-advanced-java\\src\\main\\java\\com\\demo\\java8");
//      APPROACH 2 : USING LAMBDAS WITH GENERICS
        File[] files = directoryFile.listFiles((File pathName) -> {
            return pathName.getName().endsWith(".java");
        });
        List<File> listOfFiles = Arrays.asList(files);

        listOfFiles.forEach((File file) -> {
            System.out.println(file.getName());
        });
    }

    private static void usingLambdaExpressionsWithGenerics2() {
        System.out.println("Print files ending with .java");
        File directoryFile = new File("C:\\Users\\Enzo\\Desktop\\Master\\IJProjectAdvancedJavaD1\\d1-advanced-java\\src\\main\\java\\com\\demo\\java8");
//      APPROACH 3 : USING LAMBDAS WITH GENERICS
        File[] files = directoryFile.listFiles(pathName -> pathName.getName().endsWith(".java"));
        List<File> listOfFiles = Arrays.asList(files);

        listOfFiles.forEach((File file) -> {
            System.out.println(file.getName());
        });
    }

    private static void usingLambdaExpressionsWithGenerics3() {
        System.out.println("Print files ending with .java");
        File directoryFile = new File("C:\\Users\\Enzo\\Desktop\\Master\\IJProjectAdvancedJavaD1\\d1-advanced-java\\src\\main\\java\\com\\demo\\java8");
//      APPROACH 3 : USING LAMBDAS WITH GENERICS
//      LAMBDA 1 (with legacy code): for accept(File pathname) of FileFilter interface
        File[] files = directoryFile.listFiles(pathName -> pathName.getName().endsWith(".java"));
//      LAMBDA 2 (with modern code) : for void accept(T t); of Consumer<T> in java.util.function package.
        List<File> listOfFiles1 = Arrays.asList(files);
        listOfFiles1.add(null);
        listOfFiles1.forEach(file -> System.out.println(file.getName()));
//        Arrays.asList(files).forEach(file -> System.out.println(file.getName()));
    }
}


// the traditional way of implementing an interface with a class
class JavaFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".txt");
    }
}