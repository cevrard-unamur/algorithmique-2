package io.evrard;

public class Question1 {
    // 1. Tous les éléments sont égaux à 0
    /*@ invariant (\forall int i;
      @             i >= 0 && i < j;
      @             arrayZero[i] == 0);
      @*/
    int[] arrayZero = { 0, 0, 0 };

    // 2. Tous les élémets de a sont distincts
    /*@ invariant (\forall int i;
      @             i >= 0 && i < arrayDistinct.length;
      @             (\forall int j; j >= 0 && j < arrayDistinct.length && i != j; arrayDistinct[j] != arrayDistinct[i]));
      @*/
    int[] arrayDistinct = { 1, 2, 3, 4 };

    // 3. Tous les élémets de a sont pairs
    /*@ invariant (\forall int i;
      @             i >= 0 && i < arrayOdd.length;
      @             arrayOdd[i] % 2 == 0);
      @*/
    int[] arrayOdd = { 0, 2, 6, 4 };

    // 4. Tous les élémets de a sont inférieurs ou égaux à 2
    /*@ invariant (\forall int i;
      @             i >= 0 && i < arrayMax2.length;
      @             arrayMax2[i] <= 2);
      @*/
    int[] arrayMax2 = { 0, 2, 1, 2 };

    // 5. Tous les nombres pairs sont inférieurs à 10
    /*@ invariant (\forall int i;
      @             i >= 0 && i < arrayOdd10.length;
      @             (arrayOdd10[i] % 2 == 0 && arrayOdd10[i] < 10) || arrayOdd10[i] % 2 != 0);
      @*/
    int[] arrayOdd10 = { 0, 2, 1, 2, 15, 11, 8 };

    // 6. Il existe une valeur zéro dans le tableau.
    /*@ invariant (\exists int i;
      @             i >= 0 && i < arrayOdd10.length;
      @             arrayWithZero[i] == 0);
      @*/
    int[] arrayWithZero = { 0, 2, 1, 2, 15, 11, 8 };

    // 7. Les éléments de a sont triés par ordre croissant.
    /*@ invariant (\forall int i;
      @             i >= 0 && i < arrayOrdered.length - 1;
      @             arrayOrdered[i] <= arrayOrdered[i + 1]);
      @*/
    int[] arrayOrdered = { 0, 1, 3, 10, 11, 18 };
}
