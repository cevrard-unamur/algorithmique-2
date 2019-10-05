package io.evrard;

public class Main {
    /*@ invariant (\forall int i;
      @             i >= 0 && i < arrayZero.length;
      @             arrayZero[i] == 0);
      @*/
    int[] arrayZero = { 0, 0, 0 };

    /*@ invariant (\forall int i;
      @             i >= 0 && i < arrayDistinct.length;
      @             (\forall int j; j >= 0 && j < arrayDistinct.length && i != j; arrayDistinct[j] != arrayDistinct[i]));
      @*/
    int[] arrayDistinct = { 1, 2, 3, 4 };

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
