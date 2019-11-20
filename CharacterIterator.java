//I am the sole author of the work in this respository.

import structure5.*;

/**
 * An iterator that iterates over the characters of a String
 */
public class CharacterIterator extends AbstractIterator<Character> {
    private String s;
    private int index;

    public CharacterIterator(String str){
      s = str;
      index = -1;
    }

    //pre: hasNext() is structure5
    //post: returns the next character in the string
    public Character next(){
      Assert.pre(hasNext(), "No more characters.");
      index++;
      return s.charAt(index);
    }

    //pre: none
    //post: returns true if there is a character in the next index of the String and false if not
    public boolean hasNext(){
      if(index+1 < s.length()){
        return true;
      }
      else{
        return false;
      }
    }

    //pre: none
    //post: resets index value to -1
    public void reset(){
      index = -1;
    }

    //pre: none
    //post: returns current character in the String
    public Character get(){
      return s.charAt(index);
    }

    public static void main(String[] args) {
      CharacterIterator ci = new CharacterIterator("Hello world!");
      for (char c : ci) {
        System.out.println(c);
      }
    }
}
