package com.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.*;
import java.security.PrivilegedExceptionAction;

/**
 * Created by wanggang on 11/8/16.
 */
public class FirstTest {

    static final String HADOOP_USER_NAME = "hduser";

    public static void main(String[] args) throws IOException {
        try {
            UserGroupInformation userGroupInformation = UserGroupInformation.createRemoteUser(HADOOP_USER_NAME);
            userGroupInformation.doAs(new PrivilegedExceptionAction<Void>() {

                public Void run() throws Exception {
                    Configuration conf = new Configuration();
                    conf.set("fs.default.name", "hdfs://192.168.0.102:9000");
                    conf.set("hadoop.job.ugi", "hduser");

                    FileSystem fs= FileSystem.get(conf);

                    Path inFile = new Path("/test.xml");
                    Path outFile = new Path("/1test.xml");
                    fs.createNewFile(inFile);


                    InputStream in  = FirstTest.class.getClassLoader().getResourceAsStream("test.txt");
                    OutputStream out = fs.create(outFile);

//Copy file from local to HDFS
                    IOUtils.copyBytes(in, out, 4096, true);
                    if (!fs.exists(inFile))
                        System.out.println("Input file not found");
                    if (!fs.isFile(inFile))
                        System.out.println("Input should be a file");
                    if (fs.exists(outFile))
                        System.out.println("Output already exists");

                    return null;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
