package WantOffer;

import java.util.Arrays;
import java.util.Comparator;

public class Solution38 {

    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] strings = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i ++){
            strings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1+o2;
                String c2 = o2+o1;
                return c1.compareTo(c2);
            }
        });

        for(int i = 0; i < strings.length; i ++){
            sb.append(strings[i]);
        }
        return sb.toString();
    }
}
