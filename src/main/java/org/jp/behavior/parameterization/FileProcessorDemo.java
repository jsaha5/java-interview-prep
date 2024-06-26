package org.jp.behavior.parameterization;

import java.io.IOException;

public class FileProcessorDemo {
    public static void main(String[] args) throws Exception {
        FileProcessor fileProcessor = new FileProcessor("test.txt");

    // Reading one line
        String output = fileProcessor.readFile(br-> {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(output);

        // Reading 2 line

         output = fileProcessor.readFile(br-> {
            try {
                return br.readLine() + " " + br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(output);

    }
}
