package com.labs1904;

import org.junit.Assert;

import java.util.Arrays;

public class WhiteBoard {

    public static void main(String[] args) {

        // if this is the largest number possible, then there isn't a next larger number, return -1
        // if the arrangement of input is the smallest possible, swap the 2 digits on the right. return the number

        // find the smallest number that has larger options.
        // starting from the right digit, compare it to the one to it's left until the one on the left is smaller. "left" digit
        // now, looking at all the digits to the right of "left" digit, find the next largest digit to "left" and swap it with the digit on the right
        // and swap it with...


        // find range

        Integer input = 52210;

        char[] chars = input.toString().toCharArray();



        Integer number = Integer.parseInt(new String(chars));

        int l = chars.length -2;
        int r = chars.length -1;
        int s = -10;
        int i = 0;
        int stop = 0;
        while(stop == 0) {
            System.out.println("i: " + i);
            if(chars[l] >= chars[r]){
                System.out.println(chars[l] + " is larger than: " + chars[r]);
                if(i == chars.length-2){
                    System.out.println(-1);
                    break;
                }
                l--;
                r--;
                i++;

                // swap digits


            } else if (chars[l] < chars[r]){
                String prefix = input.toString().substring(0,l);
                System.out.println("prefix: " + prefix);

                System.out.println("swap left: " + chars[l]);
                stop++;


                String subString = input.toString().substring(r);
                char[] subChar = subString.toCharArray();
                System.out.println("subString: " + subString);
                for(int j = 0; j<subChar.length;j++){
                    if(s == -10){
                        s = 0;
                    }
                    if (subChar[j] > chars[l] && subChar[j] < subChar[s]){
                        s = j;

                    }
                }
                prefix += subChar[s];
                System.out.println("right swap: " + subChar[s]);
                subChar[s] = chars[l];
                System.out.println("updated prefix: " + prefix);

                // sort remaining

                Arrays.sort(subChar);
                String suffix = new String(subChar);

                System.out.println("Suffix: " + suffix);
                String nextBigIntStr = prefix + suffix;
                Integer nextBigInt = Integer.parseInt(nextBigIntStr);
                System.out.println("Next Big Int: " + nextBigInt);

            }

        }



    }
}
