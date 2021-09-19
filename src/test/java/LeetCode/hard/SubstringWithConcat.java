package LeetCode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * */

public class SubstringWithConcat {

    public static List<Integer> findSubstring(String s, String[] words) {
        if(s==null || s.length()==0 || words==null || words.length==0){
            return new ArrayList<>();
        }
        Map<String,Integer>frequency_map = new HashMap<>();
        for(String word : words){
            frequency_map.put(word,frequency_map.getOrDefault(word,0)+1);
        }

        List<Integer>concat_words = new ArrayList<>();
        int len = words[0].length();
        int word_count=words.length;

        for(int i=0;i<=s.length()-len*word_count;i++){
           Map<String,Integer>seen_words = new HashMap<>();
           for(int j=0;j<word_count;j++){
               int word_index = i+j*len;
               String word = s.substring(word_index,word_index+len);
               if(!frequency_map.containsKey(word)){
                   break;
               }
               seen_words.put(word,seen_words.getOrDefault(word,0)+1);
               if(seen_words.get(word)>frequency_map.getOrDefault(word,0)){
                   break;
               }

               if(j+1==word_count){
                   concat_words.add(i);
               }
           }
        }

        return concat_words;

    }


    public static void main(String[]args){

        String s = "barfoofoobarthefoobarman";
        String[]words = {"bar","foo","the"};

        System.out.println(findSubstring(s,words));

    }
}
