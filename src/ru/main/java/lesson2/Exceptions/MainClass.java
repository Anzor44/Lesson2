package ru.main.java.lesson2.Exceptions;

import static java.lang.Integer.valueOf;

public class MainClass {

    public static void  main(String[] args){

        String[][] stringsArray0 = new String[][]{
                {"5", "g", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "5", "6"},
                {"1", "2", "4", "8"}
        };
        String[][] stringsArray1 = new String[][]{
                {"5", "6", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "5", "6"},
                {"1", "2", "4", "8"}
        };
        String[][] stringsArray2 = new String[][]{
                {"5", "g", "3"},
                {"1", "2", "3", "4"},
                {"1", "2", "5", "6"},
                {"1", "2", "4", "8"}
        };
        String[][] stringsArray3 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "5", "6"},
                {"1", "2", "4", "8"}
        };

        try {
            System.out.println(" Сумма элементов массива равна " + transformAndSum(stringsArray0));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e);
        }
        try {
            System.out.println(" Сумма элементов массива равна " + transformAndSum(stringsArray1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
        try {
            System.out.println(" Сумма элементов массива равна " + transformAndSum(stringsArray2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
        try {
            System.out.println(" Сумма элементов массива равна " + transformAndSum(stringsArray3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    private static int transformAndSum (String[][] in) throws MyArraySizeException, MyArrayDataException{
        int arrDim = 4;
        int sum = 0;

        // Проверяем, что у массива 4 основных измерений
        if (in.length != 4){
            throw new MyArraySizeException(String.format(" Размерность массива должна быть %dx%d.", arrDim, arrDim));
        }
        // Так как размерность вложенных массивов может быть не всегда одинакова, то проверяем, что в каждом из 4-х основных измерений находится массив ровно из 4 элементов
        for (int i = 0; i < in.length; i++){
            if (in[i].length != 4){
                throw new MyArraySizeException(String.format(" Размерность массива должна быть %dx%d.", arrDim, arrDim));

            }
        }

        for (int i = 0; i < in.length; i++){
            for (int j = 0; j < in[i].length; j++){
                try {
                    sum += valueOf(in[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(String.format(" В позиции [%d][%d] исходного массива находится не целое число %s.", i, j, in[i][j]));
                }
            }
        }
        return sum;
    }
}
