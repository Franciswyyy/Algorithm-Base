package WantOffer;

public class Solution04 {

    public static String replaceSpace(StringBuffer str) {

        int num = 0;
        int oldLen = str.length()-1;
        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) == ' ') num ++;
        }

        int len = str.length() + num * 2;
        char[] chars = new char[len];
        for(int i = len-1; i >= 0; i --){
            char c = str.charAt(oldLen--);
            if(c != ' '){
                chars[i] = c;
            } else {
                chars[i--] = '0';
                chars[i--] = '2';
                chars[i] = '%';
            }
        }
        return String.valueOf(chars);
    }

    // OOM问题，不是很懂
    public static String replaceSpace01(StringBuffer str){
        int num = 0;
        int oldLen = str.length()-1;
        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) == ' ') str.append("   ");
        }

        int newLen = str.length()-1;
        while(oldLen > 0){
            char c = str.charAt(oldLen--);
            if(c != ' ')str.setCharAt(newLen--, c);
            else{
                str.setCharAt(newLen--, '0');
                str.setCharAt(newLen--, '2');
                str.setCharAt(newLen, '%');
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringBuffer("we are happy").toString());
    }

}
