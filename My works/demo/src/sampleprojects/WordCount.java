package sampleprojects;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    public static void main(String[] args) {
       String str = "hi hello hi ";
       Map<String,Integer> wordCount = new HashMap<>();
       String words[] =str.split("\\s+");
       for(String word : words){
           wordCount.put(word, wordCount.getOrDefault(word,0)+1);
       }
       for (Map.Entry<String,Integer> entry : wordCount.entrySet()){
           System.out.println(entry.getKey()+" : "+entry.getValue());
       }
    }
    }


