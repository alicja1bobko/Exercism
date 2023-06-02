package exercism;

import java.util.*;
public class ReverseString {
    public String reverse(String inputString) {
        Stack<Character> stack = new Stack<>();
        System.out.println(inputString.toCharArray());
        for(char c:inputString.toCharArray() ){
            stack.push(c);
        }
        String temp = "";

        while(!stack.isEmpty()){
            temp+=stack.pop();
        }
        return temp;
    }

}