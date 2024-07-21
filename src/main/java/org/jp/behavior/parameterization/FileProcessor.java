package org.jp.behavior.parameterization;

import java.io.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class FileProcessor {

    private  String fileName = "";

    public Supplier<String> getFileName= ()-> fileName;

    public FileProcessor(String fileName) {
        this.fileName = fileName;
    }

    public String readFile(Function<BufferedReader, String> readInstructions) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String apply = readInstructions.apply(bufferedReader);
        bufferedReader.close();
        is.close();
        return apply;

    }

}
