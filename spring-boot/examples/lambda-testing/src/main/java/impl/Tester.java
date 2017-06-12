package impl;

import in.BufferedReaderProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by wanggang on 10/20/16.
 */
public class Tester {

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("myfile"))) {
            return p.process(br);
        }
    }

    public static void main(String[] args) {
        try {
            processFile((BufferedReader br) -> br.readLine() + br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
