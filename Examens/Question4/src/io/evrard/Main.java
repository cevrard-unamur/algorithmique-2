package io.evrard;

public class Main {

    public static int maxInter(String s1, String s2, String s) {
        return maxInterweaving(s1, s2, s, 0, 0, 0);
    }

    public static int maxInterweaving(String s1, String s2, String s, int indexS1, int indexS2, int indexS) {
        if (indexS1 == s1.length() && indexS2 == s2.length()) {
            return 1;
        }

        int result = 0;

        if (indexS1 < s1.length() && s1.charAt(indexS1) == s.charAt(indexS)) {
            result += maxInterweaving(s1, s2, s, indexS1 + 1, indexS2, indexS + 1);
        }

        if (indexS2 < s2.length() && s2.charAt(indexS2) == s.charAt(indexS)) {
            result += maxInterweaving(s1, s2, s, indexS1, indexS2 + 1, indexS + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] s1 = new String[] {"ab", "aa", "axa", "aze", "uhun"};
        String[] s2 = new String[] {"xy", "aa", "aay", "aze", "uuhn"};
        String[] s  = new String[] {"abxy", "aaaa", "aaxaay", "azeaze", "uuhuhnun"};

        for (int i = 0; i < s.length; i++) {
            System.out.format("There is %d interweaving between \"%s\" and \"%s\" to have \"%s\"\n", maxInter(s1[i], s2[i],
                    s[i]), s1[i], s2[i], s[i]);
        }
    }
}
