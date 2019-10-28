package io.evrard;

public class Main {


    /*@ normal_behavior
      @ assignable \nothing;
      @ ensures (a > b && \result == a) || (a <= b && \result == b);
      @*/
    double max(double a, double b) {
        return a > b ? a : b;
    }

    /*@ normal_behavior
      @ assignable \nothing;
      @ ensures a != null;
      @ ensures \result == (\exists int j;
      @		j >= 0 && j < a.length;
      @		x == a[j]);
      @*/
    boolean contient(double[] a, double x)
    {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
