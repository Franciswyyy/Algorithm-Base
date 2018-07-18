package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution017 {

    // 不用回溯写， 这种写的也没意义，主要看回溯
    public List<String> letterCombination2(String digits){

        LinkedList<String> res = new LinkedList<>();
        if(digits.isEmpty()) return res;

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for(int i = 0; i < digits.length(); i ++){
            int index = Character.getNumericValue(digits.charAt(i));
            while(res.peek().length() == i){
                String t = res.remove();
                for(char s : mapping[index].toCharArray()){
                    res.add(t+s);
                }
            }
        }
        return res;
    }



    // 写的规范一点
    private static final String[] KEYS = {"", " ","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombination(String digits){
        List<String> res = new ArrayList<>();
        if(digits.equals(""))return res;

        helper("", digits, 0, res);
        return res;
    }

    private void helper(String prefix, String digits, int index, List<String> res){

        if(index == digits.length()){
            res.add(prefix);
            return;
        }

        Character c = digits.charAt(index);
        String letter = KEYS[c-'0'];
        for(int i = 0; i < letter.length(); i ++){
            helper(prefix + letter.charAt(i), digits, index + 1, res);
        }
        return;
    }





    // 容易理解的递归
    // 看到返回结果，就想到递归要另开辟方法
    public List<String> letterCombinations1(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.equals("")) return res;

        findCombination1(digits, 0, "", res);
        return res;
    }

    // s保存的从digits[0...index-1]的字符串
    private void findCombination1(String digits, int index, String s, List<String> res){

        if(index == digits.length()){
            res.add(s);
            return;
        }

        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for(int i = 0; i < letters.length(); i ++){
            findCombination1(digits, index+1, s+letters.charAt(i), res);
        }
        return;
    }

    private String letterMap[] = {
            " ",   //0
            "",    //1
            "abc", //2
            "def", //3
            "ghi", //4
            "jkl", //5
            "mno", //6
            "pqrs", //7
            "tuv",  //8
            "wxyz", //9
    };







}
