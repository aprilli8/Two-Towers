//I am the sole author of the work in this repository.

import java.util.Scanner;
import structure5.*;

/**
 * This class prints the best and second best solution to the Two Towers problem,
 * in which the sum of the values in the subset are closest to half the total height.
 */
public class TwoTowers{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    double input = scan.nextDouble();
    Vector<Double> vec = new Vector<Double>();
    double totalHeight = 0;
    //populates vec with square root values of each number less than input value
    for(int i = 1; i <= input; i++){
      vec.add(Math.sqrt(i));
      totalHeight = totalHeight + Math.sqrt(i);
    }
    double halfHeight = totalHeight/2;

    //creates a new SubsetIterator object for vec
    SubsetIterator<Double> subset = new SubsetIterator<Double>(vec);
    double best = 0;
    double secbest = 0;
    Vector<Double> bestSubset = new Vector<Double>();
    Vector<Double> secbestSubset = new Vector<Double>();
    //loops through all possible subsets of vec, sums up all numbers in the subset, and keeps track of the one closest to halfHeight
    for(Vector<Double> v : subset){
      double sum = 0;
      for(int i = 0; i < v.size(); i++){
        sum = sum + v.get(i);
      }
      if(sum <= halfHeight && Math.abs(halfHeight - sum) <= Math.abs(halfHeight - best)){
        secbest = best;
        secbestSubset = bestSubset;
        best = sum;
        bestSubset = v;
      }
    }

    //prints out values for halfHeight, the best subset, and second best subset
    System.out.println("Half height is: " + totalHeight/2);

    System.out.print("Best subset is: [");
    for(int i = 0; i < bestSubset.size()-1; i++){
      System.out.print((int)(bestSubset.get(i)*bestSubset.get(i)+0.5) + ", ");
    }
    System.out.println((int)(bestSubset.get(bestSubset.size()-1)*bestSubset.get(bestSubset.size()-1)+0.5) + "] = " + best);

    System.out.print("Second best subset is: [");
    for(int i = 0; i < secbestSubset.size()-1; i++){
      System.out.print((int)(secbestSubset.get(i)*secbestSubset.get(i)+0.5) + ", ");
    }
    System.out.println((int)(secbestSubset.get(secbestSubset.size()-1)*secbestSubset.get(secbestSubset.size()-1)+0.5) + "] = " + secbest);
  }
}
