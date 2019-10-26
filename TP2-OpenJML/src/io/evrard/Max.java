package io.evrard;


public class Max {

	/*@ assignable \nothing;
	 @ requires a != null && a.length > 0;
	 @ ensures (\forall int i; i >= 0 && i < a.length; a[i] <= \result);
	 @ ensures (\exists int i; i >= 0 && i < a.length; a[i] == \result);
	 @*/

    public static int max(int [] a)
    {
        int i, m = a[0];

        /*@ loop_invariant (\forall int j; j >= 0 && j < i);
          @ decreases a.length - i;
          @*/

        for(i= 1; i < a.length; i++)
        {
            if( a[i] > m)
                m = a[i];
        }

        return m;
    }

    public static void main(String[] args) {
        int a[] = { 3, 4, 2, 6, 8, 1, 9, 12, 15, 11 };
        int result = max(a);

        System.out.println("Max: " + result);
    }

}
