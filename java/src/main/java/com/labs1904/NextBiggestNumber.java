package com.labs1904;

import java.util.Arrays;

public class NextBiggestNumber {

    public static void main(String[] args) {
        Integer input = Integer.parseInt(args[0]);
        Integer nextBiggestNumber = getNextBiggestNumber(input);
        System.out.println("Input: " + input);
        System.out.println("Next biggest number: " + nextBiggestNumber);
    }

    public static int getNextBiggestNumber(Integer i) {
        Integer input = i;
        char[] chars = input.toString().toCharArray();

        if(i == null){
            return -1;
        }

        int l = chars.length -2;
        int r = chars.length -1;
        int s = -10;
        int stop = 0;
        int ii = 0;
        while(stop == 0) {
            if(chars[l] >= chars[r]){
                if(ii == chars.length-2){
                    System.out.println(-1);
                    break;
                }

                l--;
                r--;
                ii++;

            } else if (chars[l] < chars[r]){
                String prefix = input.toString().substring(0,l);
                stop++;

                String subString = input.toString().substring(r);
                char[] subChar = subString.toCharArray();

                for(int j = 0; j<subChar.length;j++){
                    if(s == -10){
                        s = 0;
                    }
                    if (subChar[j] > chars[l] && subChar[j] < subChar[s]){
                        s = j;
                    }
                }
                prefix += subChar[s];
                subChar[s] = chars[l];
                Arrays.sort(subChar);
                String suffix = new String(subChar);

                String nextBigIntStr = prefix + suffix;
                Integer nextBigNumber = Integer.parseInt(nextBigIntStr);

                if (nextBigNumber == i){
                    return -1;
                }
                if (nextBigNumber < i){
                    return -1;
                }
                return nextBigNumber;


            }

        }


        return -1;
    }
}
