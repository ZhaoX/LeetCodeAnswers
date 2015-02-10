package com.xin.LeetCodeAnswers;

public class ReverseWordsInAString {
	
    public static String reverseWords(String s) {
    	if (s==null || s.length()==0){
            return "";
        }
        String[] words = s.trim().split("\\s+");	
        int wordCount = words.length; 
        StringBuilder sb = new StringBuilder();
        for(int i=wordCount-1; i>0; i--){
        	sb.append(words[i]+" ");
        }
        if(wordCount > 0){
        	sb.append(words[0]);
        }
        return sb.toString();        
    }
}