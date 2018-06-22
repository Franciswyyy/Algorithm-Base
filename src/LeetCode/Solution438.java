package LeetCode;

import java.util.*;

public class Solution438 {

    // 不要想着的重新遍历一遍p的个数，
    public static List<Integer> error(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256];
        char[] chars = s.toCharArray();
        char[] pstr = p.toCharArray();

        for(char c : pstr){
            hash[c] ++;
        }


        int left = 0;
        int l = 0, r = l;
        int len = p.length();
        int count = 0;
        int k = 0;
        while(l < chars.length){
            if(r < s.length() && hash[chars[r]]!=0){


                if(count == 0){
                    k = r;   // 记录初始值
                }
                count ++;
                r++;
            }else{
                // 重新归零
                for(char c : p.toCharArray()){
                    hash[c] ++;
                }

                count = 0;
                l++;
                r = l;
            }
            if(count == len){
                list.add(k);
            }
        }
        return list;
    }

    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256];
        char[] str = s.toCharArray();

        for(char c : p.toCharArray()){
            hash[c] ++;
        }


        int left = 0, right = 0, count = p.length();
        while(right < s.length()){

            if(hash[s.charAt(right)] >= 1){
                count--;
            }
            hash[s.charAt(right)]--;
            right ++;

            if(count == 0) list.add(left);

            if(right - left == p.length()){      // 保持这个窗口
                if(hash[s.charAt(left)] >= 0){   //因为之前访问过了如果不是p的话则是-1了。
                    count ++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }

        return list;
    }

    public static List<Integer> findAnagrams02(String s, String p){
        // 当然了，不仅仅可以用数组来装，用map也一样
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = p.length();
        int left = 0, right = 0;

        int len = Integer.MIN_VALUE;

        while(right < s.length()){

            char c = s.charAt(right);

            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) count --;
            }
            right ++;

            while(count == 0){
                char temp = s.charAt(left);
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) + 1);
                    if(map.get(temp) > 0) count++;
                }
                list.add(left);
                left ++;
            }
        }
        return list;

    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        String s1 = "abab";
        String p1 = "ba";

        List<Integer> list = findAnagrams(s, p);
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
    }
}
