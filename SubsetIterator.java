//I am the sole author of the work in this respository.

import structure5.*;

/**
 *This class creates an iterator that iterates through all the possible subsets of a Vector of element E
 */
public class SubsetIterator<E> extends AbstractIterator<Vector<E>>{
  //Vector that keeps track of input Vector
  private Vector<E> inputVector;
  //Vector that keeps track of elements in current subset
  private Vector<E> currentVector;
  //counter that keeps track of decimal version of counter
  private long decCounter;
  //holds the binary version of decCounter
  private long currentSubset;

  public SubsetIterator(Vector<E> vec){
    inputVector = vec;
    currentVector = new Vector<E>();
    decCounter = -1;
    currentSubset = 0;
  }

  //pre: none
  //post: resets decCounter to -1
  public void reset(){
    decCounter = -1;
  }

  //pre: none
  //post: returns true if decCounter+1 is less than total number of possible subsets and false if not
  public boolean hasNext(){
    if(decCounter+1 <= (1L<<inputVector.size())-1){
      return true;
    }
    else{
      return false;
    }
  }

  //pre: none
  //post: returns a vector holding values of current subset
  public Vector<E> get(){
    currentVector = new Vector<E>();
    //converts decimal number in decCounter to a string that holds binary version of the number
    String result = "";
    for(int i = 0; i < inputVector.size(); i++){
      if((decCounter&(1<<i)) == 0){
        result = 0 + result;
      }
      else{
        result = 1 + result;
      }
    }
    //loops through all place values in binary number and add its corresponding value in inputVector to currentVector
    for(int i = result.length()-1; i >= 0; i--){
      if(Character.toString(result.charAt(i)).equals("1")){
        currentVector.addFirst(inputVector.get(i));
      }
    }
    return currentVector;
  }

  //pre: hasNext() is true
  //post: returns a vector holding values of next subset
  public Vector<E> next(){
    Assert.pre(hasNext(), "No available next value.");
    get();
    decCounter++;
    return currentVector;
  }

  public static void main(String[] args){
    Vector<Integer> test = new Vector<Integer>();
    for(int i = 0; i < 8; i++){
      test.add(i);
    }
    System.out.println(test);
    SubsetIterator<Integer> sub = new SubsetIterator<Integer>(test);
    for(SubsetIterator<Integer> i = sub; i.hasNext(); i.next()){
      System.out.println(i.get());
    }
  }
}
