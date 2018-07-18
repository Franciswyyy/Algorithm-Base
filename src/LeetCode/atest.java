package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class atest {

    enum Type{
        A,B,C,D;


        static int value = 1;
        public static int getValue(){
            return value;
        }

        String type = "wang";
        public String getType(){
            return type;
        }
    }

    public static void main(String[] args) {

        System.out.println(Type.A.getType());

        System.out.println(Type.getValue());;

    }


}
