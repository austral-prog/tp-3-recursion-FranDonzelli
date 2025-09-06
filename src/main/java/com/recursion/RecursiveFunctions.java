package com.recursion;

import java.util.List;

public class RecursiveFunctions {

    public static int recursiveIndexOf(List<String> list, String target) {
        List<String> copia = list;
        int index = 0;
        return recursiveIndexOf(copia, target, index);
    }

    public static int recursiveIndexOf(List<String> list, String target, int index) {
        //Si me paso del limite
        if (index > list.size() - 1) {
            return -1;
        }
        //Si encuentro el target
        else if (target.equals(list.get(index))) {
            return index;
        }
        //Si no encuentro el target
        else {
            index++;
            return recursiveIndexOf(list, target, index);
        }
    }

    public static int recursiveIndexOfByIndex(List<String> list, String target, int index) {
        //recurividad con el anterior que hace lo mismo
        return recursiveIndexOf(list, target, index);
    }

    public static int recursiveIndexOfEmpty(List<String> list) {
        int index = 0;
        //recurividad con el IndexOf mio con el target = ""
        return recursiveIndexOf(list, "", index);
    }

    public static int recursivePut(String target, List<String> list) {
        int index = 0;
        int search = recursiveIndexOf(list, "", index);
        if (search != -1) {
            list.set(search, target);
            return recursiveIndexOf(list, target);
        }
        return -1;
    }

    public static int recursiveRemove(List<String> list, String target, int eliminaciones) {
        int search = recursiveIndexOf(list, target);
        if (search > -1) {
            list.remove(target);
            ++eliminaciones;
            return recursiveRemove(list, target, eliminaciones);
        }
        return eliminaciones;
    }

    public static int recursiveSum(List<Integer> list) {
        return recursiveSumHelper(list, 0);
    }
    private static int recursiveSumHelper(List<Integer> list, int index) {
        if (index >= list.size()) {
            return 0;
        }
        return list.get(index) + recursiveSumHelper(list, index + 1);
    }


    public static int recursiveFactorial(int n) {
        int factorial = 1;
        return recursiveFactorialHelper(n, factorial);
    }
    public static int recursiveFactorialHelper(int n, int factorial) {
        if (n > 1) {
            factorial *= n;
            return recursiveFactorialHelper(n - 1, factorial);
        }
        return factorial;
    }

    public static int recursivePow(int base, int exponent) {
        int rta = base;
        return recursivePowHelper(base, exponent, rta);
    }
    public static int recursivePowHelper(int base, int exponent, int rta) {
        if (exponent > 1) {
            rta *= base;
            --exponent;
            return recursivePowHelper(base, exponent, rta);
        }
        return rta;
    }

    public static int recursiveFibonacci(int n) {
        int actual = 1;
        int anterior = 0;
        return recursiveFibonacciHelper(n, actual, anterior);
    }
    public static int recursiveFibonacciHelper(int n, int actual,int anterior) {
        if (n > 1) {
            int keeper = actual;
            actual += anterior;
            --n;
            anterior = keeper;
            return recursiveFibonacciHelper(n, actual, anterior);
        }
        return actual;
    }

    public static boolean recursivePalindrome(String word) {
        if (word.length() <= 1){
            return true;
        }
        else if (word.charAt(0) != word.charAt(word.length()-1)) {
            return false;
        }
        return recursivePalindrome(word.substring(1, word.length() - 1));
    }
}
