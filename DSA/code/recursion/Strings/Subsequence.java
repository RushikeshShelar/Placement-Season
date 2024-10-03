package recursion.Strings;

import java.util.ArrayList;

public class Subsequence {
    public static void main(String[] args) {
//        subSeq("", "abc");

//        ArrayList<String> seq = subSeqArrayList("", "abc");
//        System.out.println(seq);

//        subSeqASCII("", "abc");

//        ArrayList<String> seq = subSeqAsciiReturn("", "abc");
//        System.out.println(seq);

        System.out.println(repeatedSubstringPattern("aba"));

    }

    static void subSeq(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed); //Empty Subset is Also Printed (Check for its Case during Solving Question)
            return;
        }

        char ch = unProcessed.charAt(0);

        subSeq(processed + ch, unProcessed.substring(1));
        subSeq(processed, unProcessed.substring(1));
    }

    static ArrayList<String> subSeqArrayList(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed); //Empty Subset is Also Added (Check for its Case during Solving Question)
            return list;
        }

        char ch = unProcessed.charAt(0);

        ArrayList<String> left = subSeqArrayList(processed + ch, unProcessed.substring(1));
        ArrayList<String> right = subSeqArrayList(processed, unProcessed.substring(1));

        left.addAll(right);
        return left;
    }

    static void subSeqASCII(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed); //Empty Subset is Also Printed (Check for its Case during Solving Question)
            return;
        }

        char ch = unProcessed.charAt(0);

        subSeqASCII(processed + ch, unProcessed.substring(1));
        subSeqASCII(processed + (ch + 0), unProcessed.substring(1));
        subSeqASCII(processed, unProcessed.substring(1));
    }

    static ArrayList<String> subSeqAsciiReturn(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed); //Empty Subset is Also Added (Check for its Case during Solving Question)
            return list;
        }

        char ch = unProcessed.charAt(0);

        ArrayList<String> first = subSeqAsciiReturn(processed + ch, unProcessed.substring(1));
        ArrayList<String> second = subSeqAsciiReturn(processed, unProcessed.substring(1));
        ArrayList<String> third = subSeqAsciiReturn(processed + (ch + 0), unProcessed.substring(1));

        first.addAll(second);
        first.addAll(third);
        return first;
    }


//    Leetcode Temp
public static boolean repeatedSubstringPattern(String s) {
    ArrayList<String> sub = subSequence("", s);
    for(int i = 0; i < sub.size(); i++){
        String newStr = sub.get(i);
        while(newStr.length() <= s.length()){
            if(s.compareTo(newStr) == 0){
                return true;
            }
            System.out.print(newStr);
            newStr += newStr;
        }
        System.out.println();
    }
    return false;
}

    static ArrayList<String> subSequence(String p, String u){
        if(u.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            if(p != " "){
                list.add(p);
            }
            return list;
        }

        char ch = u.charAt(0);
        ArrayList<String> left = subSequence(p + ch, u.substring(1));
        ArrayList<String> right = subSequence(p, u.substring(1));

        left.addAll(right);
        return left;
    }

}
