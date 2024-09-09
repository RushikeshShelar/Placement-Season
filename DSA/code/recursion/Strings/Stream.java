package recursion.Strings;

public class Stream {
    public static void main(String[] args) {
        skip("", "abcdacbdcabcabcbadbac", 'a');

        System.out.println(skip2("abcdacbdcabcabcbadbac", 'a'));

        System.out.println(skipString("I am a very good boy", "good"));
    }

    static void skip(String processed, String unProcessed, char skipChar) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char ch = unProcessed.charAt(0);
        if (ch == skipChar) {
            skip(processed, unProcessed.substring(1), skipChar);
        } else {
            skip(processed + ch, unProcessed.substring(1), skipChar);
        }
    }

    static String skip2(String unProcessed, char skipChar) {
        if (unProcessed.isEmpty()) {
            return "";
        }

        char ch = unProcessed.charAt(0);
        if (ch == skipChar) {
            return skip2(unProcessed.substring(1), skipChar);
        } else {
            return ch + skip2(unProcessed.substring(1), skipChar);
        }
    }

    static String skipString(String unProcessed, String toBeSkipped) {
        if (unProcessed.isEmpty()) {
            return "";
        }

        char ch = unProcessed.charAt(0);
        if (unProcessed.startsWith(toBeSkipped)) {
            return skipString(unProcessed.substring(toBeSkipped.length()), toBeSkipped);
        } else {
            return ch + skipString(unProcessed.substring(1), toBeSkipped);
        }
    }

}
