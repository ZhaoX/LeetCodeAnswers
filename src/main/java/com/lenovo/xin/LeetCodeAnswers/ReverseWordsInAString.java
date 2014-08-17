package com.lenovo.xin.LeetCodeAnswers;

public class ReverseWordsInAString {
	
    public String reverseWords(String s) {
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