package io.evrard;

public class MinMax {

    /*@ requires true;
      @ ensures (\result == max1 ||\result == max2) && \result>= max1 && \result>=max2;
      @*/
    public static int getMax(int max1, int max2)
    {
        int res;
        if (max1 > max2)
            res = max1;
        else
            res = max2;

        return res;
    }

    /*@ requires true;
      @  ensures (\result == min1 ||\result == min2) && \result<= min1 && \result<=min2;
      @*/
    public static int getMin(int min1, int min2)
    {
        int res;
        if (min1 < min2)
            res = min1;
        else
            res = min2;

        return res;
    }

    /*@
      @ normal_behavior
      @ requires array != null && array.length >= 1;
      @ requires low >= 0 && high < array.length;
      @ requires (low + high)/2 >=0;
      @ requires true;
      @ ensures \result == getMinMax(array, low,  (low + high)/2) && \result == getMinMax(array,  ((low + high)/2)+1, high);
      @ measured_by  (low + high)/2;
      @*/
    public static int[] getMinMax(int [] array, int low, int high)
    {
        int[] min1max1;
        int[] min2max2;

        if (low == high)
        {
            return new int[] { array[0], array[0] };
        }

        if(high == low+1)
        {
            if(array[low] > array[high])
            {
                return new int[] { array[low], array[high] };
            } else {
                return new int[] { array[high], array[low] };
            }
        }

        int mid = (low + high)/2;
        min1max1 = getMinMax(array, low, mid);
        min2max2 = getMinMax(array, mid+1, high);

        return new int[] { min1max1[0] > min2max2[0] ? min1max1[0] : min2max2[0], min1max1[1] > min2max2[1] ? min1max1[1] : min2max2[1] };
    }

    public static void main(String[] args) {
        int a1[] = { 3, 4, 2, 6, 8, 1, 9, 12, 15, 11 };
        int[] result = getMinMax(a1, 0, a1.length - 1);

        System.out.println("Min: " + result[1]);
        System.out.println("Max: " + result[0]);
    }

}

