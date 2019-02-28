package br.com.devgeek.hackerrank.warmup;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    private static void miniMaxSum(int[] arr){

        long sumOfValues = 0,
             minValue = Integer.MAX_VALUE,
             maxValue = Integer.MIN_VALUE;

        for (int anArr : arr){
            if (anArr > maxValue) maxValue = anArr;
            if (anArr < minValue) minValue = anArr;
            sumOfValues += anArr;
        }

        System.out.println((sumOfValues-maxValue)+" "+(sumOfValues-minValue));
    }

    private static final Scanner scanner = new Scanner(creatingFileWithMockedValues());

    public static void main(String[] args){

        int[] arr = new int[5];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++){
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }

    private static InputStream creatingFileWithMockedValues(){

        String line = "256741038 623958417 467905213 714532089 938071625";
        InputStream inputStream = new ByteArrayInputStream(line.getBytes(StandardCharsets.UTF_8));
        return inputStream;
    }
}