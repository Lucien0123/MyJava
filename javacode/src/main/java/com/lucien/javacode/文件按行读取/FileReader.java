package com.lucien.javacode.文件按行读取;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author huoershuai
 * @Date 2020/6/5
 */
public class FileReader {

    public static void main(String[] args) {

        String filePath = "/Users/huoershuai/demo.txt";
        System.out.println(statisticsViewCount(filePath));

    }

    private static Map<Long, Integer> statisticsViewCount(String filePath) {
        Map<Long, Integer> result = new HashMap<>();
        File rawFile = new File(filePath);
        try {
            BufferedReader reader = Files.newBufferedReader(rawFile.toPath());
            String line;
            while ((line = reader.readLine()) != null) {
                if (StringUtils.isNotBlank(line)) {
                    String[] r = line.split(" ");
                    if (r.length >= 4) {
                        Long userId = Long.valueOf(r[2]);
                        Integer count = result.remove(userId);
                        if (count != null && count >= 0) {
                            result.put(userId, count + 1);
                        } else {
                            result.put(userId, 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
