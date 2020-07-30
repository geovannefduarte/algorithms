package br.com.devgeek.hackerrank.warmup;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/diagonal-difference/problem
public class DiagonalDifference {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    private static int diagonalDifference(List<List<Integer>> arr){
        // Write your code here

        int primaryInitPos = 1, primaryDiagonal = 0,
            secondaryInitPos = arr.size(), secondaryDiagonal = 0;

        for (int i = 0, iSize = arr.size(); i < iSize; i++){
            for (int j = 0, jSize = arr.size(); j < jSize; j++){

                if (i+1 == primaryInitPos && j+1 == primaryInitPos) primaryDiagonal += arr.get(i).get(j);
                if (i+1 == primaryInitPos && j+1 == secondaryInitPos) secondaryDiagonal += arr.get(i).get(j);
            }
            primaryInitPos++; secondaryInitPos--;
        }

        return Math.abs(primaryDiagonal - secondaryDiagonal);
    }

    private static final Scanner scanner = new Scanner(creatingInputStreamWithMockedValues());

    public static void main(String[] args){

        final int n = Integer.parseInt(scanner.nextLine().trim());
        final List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++){

            final String[] arrRowTempItems = scanner.nextLine().replaceAll("\\s+$", "").split(" ");
            final List<Integer> arrRowItems = new LinkedList<>();

            for (int j = 0; j < n; j++) {
                final int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = diagonalDifference(arr);
        System.out.println( result );
    }

    private static InputStream creatingInputStreamWithMockedValues(){

        String fileContent = "3\n" +
                             "11 2 4\n" +
                             "4 5 6\n" +
                             "10 8 -12";

        return new ByteArrayInputStream(fileContent.getBytes(StandardCharsets.UTF_8));
    }
}