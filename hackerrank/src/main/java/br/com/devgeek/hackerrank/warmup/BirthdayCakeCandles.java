package br.com.devgeek.hackerrank.warmup;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BirthdayCakeCandles {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar){

        int age = ar.length, totalCandles = 0;
        long tallestCandle = Integer.MIN_VALUE;

        for (int candleSize : ar){

            if (candleSize >= tallestCandle){

                if (candleSize > tallestCandle){
                    tallestCandle = candleSize;
                    totalCandles = 0;
                }

                totalCandles++;
            }
        }

        return totalCandles;
    }

    private static final Scanner scanner = new Scanner(creatingFileWithMockedValues());

    public static void main(String[] args) throws IOException {

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++){
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        System.out.println(String.valueOf(result));

        scanner.close();
    }

    private static InputStream creatingFileWithMockedValues(){

        String fileContent = "4\n" +
                             "3 2 1 3";

        InputStream inputStream = new ByteArrayInputStream(fileContent.getBytes(StandardCharsets.UTF_8));
        return inputStream;
    }
}