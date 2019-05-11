package com.spark.example;

public class SmallestSubStrWithMaxDistictChar {
    static final int no_of_chars = 256;

    // Function to find smallest window containing
    // all characters of 'pat'
    static String findSubString(String str, String pat)
    {

        int[] pat_arr=new int[no_of_chars];
        int[] str_arr=new int[no_of_chars];

        for (int i=0;i<pat.length();i++) {
            pat_arr[pat.charAt(i)]++;
        }

        int count=0,start=0,min_length=Integer.MAX_VALUE,start_index=-1;
        int patLength=pat.length();

        for(int j=0;j<str.length();j++){
            char ch=str.charAt(j);
            str_arr[ch]++;

            if(str_arr[ch]!=0 && str_arr[ch] <= pat_arr[ch]){
                count++;
            }

            if(count==patLength){

                //remove unnecessary characters from the beginning and

                while(str_arr[str.charAt(start)] > pat_arr[str.charAt(start)] || pat_arr[str.charAt(start)]==0){
                    if(str_arr[str.charAt(start)] > pat_arr[str.charAt(start)]){
                        str_arr[str.charAt(start)]--;
                    }

                    start++;

                }

                int length = j - start+1;
                if(min_length > length){
                    min_length =length;
                    start_index=start;
                }

            }


        }

        if(start_index==-1){
            return "No sub-string found";
        }





      return str.substring(start_index,start_index+min_length);
    }

    // Driver Method
    public static void main(String[] args)
    {
        String str = "this is a test string";
        String pat = "tist";


        System.out.print("Smallest window is :\n " +
                findSubString(str, pat));
    }
}
