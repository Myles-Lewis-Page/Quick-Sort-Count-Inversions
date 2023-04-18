/*
Myles Page
Homework 2
CS 4720
Due 2/10/2023
*/

import java.util.Arrays;


public class countInv {
    
    public static int mergeAndCount(int[] array, int arrayStart, int arrayMid, int arrayEnd){
        
        
        /*
        I tried to make my own copy of range fuction it kept failing
        
        int place = 0;
        int[] arrayLeft;
        int[] arrayRight;
        
        while(place < arrayMid){
            int x = array[place];
            System.out.println(x);
            arrayLeft.add(x);
            place++;
        }
    
        
        while(place > arrayMid && place < arrayEnd){
            int x = array[place];
            System.out.println(x);
            arrayRight.add(x);
            place++;
        }
        */
        
        int[] arrayLeft = Arrays.copyOfRange(array, arrayStart, arrayMid + 1);
        int[] arrayRight = Arrays.copyOfRange(array, arrayMid + 1, arrayEnd + 1);
        
        int i = 0;
        int j = 0;
        int k = arrayStart;
        int numInv = 0;
        
        while (i < arrayLeft.length && j < arrayRight.length) {
            
            if (arrayLeft[i] <= arrayRight[j]){
                array[k++] = arrayLeft[i++];
            }
            else {
                array[k++] = arrayRight[j++];
                numInv = numInv + (arrayMid + 1) - (arrayStart + i);
            }
        }
        
        while (i < arrayLeft.length){
            array[k++] = arrayLeft[i++];
        }
        
        while (j < arrayRight.length){
            array[k++] = arrayRight[j++];
        }
        
        return numInv;
    }
    
    
   public static int mergeSortAndCount(int[] array, int arrayStart, int arrayEnd){
       
       int numInv = 0;
       
       if(arrayStart < arrayEnd){
           
           int arrayMid = (arrayStart + arrayEnd) / 2;
           
           numInv = numInv + mergeSortAndCount(array, arrayStart, arrayMid);
           
           numInv = numInv + mergeSortAndCount(array, arrayMid+1, arrayEnd);
           
           numInv = numInv + mergeAndCount(array, arrayStart, arrayMid, arrayEnd);
           
       }
       return numInv;
   } 


    public static void main(String[] args) {
        int[] array = {54044,14108,79294,29649,25260,60660,2995,53777,49689,9083};
        
        
        int numInv = mergeSortAndCount(array, 0, array.length-1);
        
        
        System.out.println("The number of inverses : " + numInv);
    }
}