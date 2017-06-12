package in;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by wanggang on 10/20/16.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    
    String process(BufferedReader b) throws IOException;
}
