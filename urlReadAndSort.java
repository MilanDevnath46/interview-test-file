- 

Imp codes


URL reading


package javaapplication270;

import java.net.*;

import java.io.*;



public class urlRead 

{

    public static void main(String[] args) throws MalformedURLException, IOException 

    {

          URL oracle = new URL("https://alvinalexander.com/blog/post/java/java-how-read-from-url-string-text");

        URLConnection yc = oracle.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(

                                yc.getInputStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null) 

            System.out.println(inputLine);

        in.close();

    }

    


}



import java.net.*; import java.io.*; public class URLConnectionReader { public static void main(String[] args) throws Exception { URL oracle = new URL("http://www.oracle.com/"); URLConnection yc = oracle.openConnection(); BufferedReader in = new BufferedReader(new InputStreamReader( yc.getInputStream())); String inputLine; while ((inputLine = in.readLine()) != null) System.out.println(inputLine); in.close(); } }


2. Rest of the code


package javaapplication270;


import java.io.BufferedReader;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.StringTokenizer;


/**

 *

 * @author Student

 */

public class JavaApplication270 {


    /**

     * @param args the command line arguments

     */

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // TODO code application logic here

         FileReader fr=new FileReader("D:\\vijay1.txt");    

          BufferedReader br=new BufferedReader(fr);    

  

          int i;    

          while((i=br.read())!=-1){  

          System.out.print((char)i);  

          }  

          br.close();    

          fr.close();  

          

         ArrayList<String> fn=new ArrayList<>();

         ArrayList<String> ln=new ArrayList<>();

         ArrayList<Integer> sc=new ArrayList<>();

         ArrayList<String> nfn=new ArrayList<>();

         ArrayList<String> nln=new ArrayList<>();

         ArrayList<Integer> nsc=new ArrayList<>();

         String sentence="Sachin tendulkar 200*";

         StringTokenizer t=new StringTokenizer(sentence);

         String word="";

       

       while(t.hasMoreTokens())

        {

            word=t.nextToken();

           fn.add(word);

             word=t.nextToken();

            ln.add(word);

             word=t.nextToken();

            if(word.contains("*"))

            {

             

              String word2=word.substring(0, word.length() - 1);

              int score=Integer.parseInt(word2);

            nsc.add(score);

            }

            else{

                word=t.nextToken();

                int score=Integer.parseInt(word);

                sc.add(score);

            }

        }

       Iterator itr=nsc.iterator();

       while(itr.hasNext())

       {

           System.out.println(itr.next());

       }

    }

    

}




// cricket program start


import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;


public class Main {


    public static void main(String[] args) throws Exception {

        // Create file object

        File file = new File("/Users/bhave/sandbox/personal/practice/java/rc_problems/src/score.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));


        // Read all lines and merge into a single string

        String st, temp = "";

        while ((st = bufferedReader.readLine()) != null) {

            temp = temp + st;

        }


        // Convert into array by comma separated items

        String[] scores = temp.split("\\s*,\\s*");

        Player[] players = new Player[scores.length];


        for (int i = 0; i < scores.length; i++) {

            players[i] = new Player(scores[i]);

        }

        sort(players);

    }


    public static void sort(Player[] arr) {

        int n = arr.length;


        // One by one move boundary of unsorted subarray

        for (int i = 0; i < n-1; i++) {

            // Find the minimum element in unsorted array

            int min_idx = i;

            for (int j = i+1; j < n; j++) {

                if (arr[j].runs < arr[min_idx].runs) {

                    min_idx = j;

                }


            }


            // Swap the found minimum element with the first

            // element

            Player temp = arr[min_idx];

            arr[min_idx] = arr[i];

            arr[i] = temp;

        }


        boolean isHighestOutPlayerFound = false;

        boolean isHighestNotOutPlayerFound = false;


        for (int k = arr.length-1; k >= 0 ; k--) {

            if (!isHighestOutPlayerFound && arr[k].isNotOut == false) {

                System.out.println("Highest out player:" + arr[k].name + "| " + arr[k].runs);

                isHighestOutPlayerFound = true;

            }

            if (!isHighestNotOutPlayerFound && arr[k].isNotOut == true) {

                System.out.println("Highest not out player:" + arr[k].name + "| " + arr[k].runs + "*");

                isHighestNotOutPlayerFound = true;

            }

        }

    }

}


public class Player {

    String[] user;


    String name;

    short runs;

    boolean isNotOut;


    Player(String str) {

        user = str.split("(?<=\\D)(?=\\d)");


        name = user[0];


        isNotOut = user[1].indexOf("*") != -1 ? true : false;


        String[] num = user[1].split("\\*");

        runs = Short.parseShort(num[0]);

    }

}


//cricket program end


// encoding decoding program start

package javaprac;


import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;

import java.util.Base64;

import java.util.StringTokenizer;


public class encDec 

{

    public static void main(String[] args) throws MalformedURLException, IOException 

    {

        // url reading

       /* URL oracle = new URL("https://alvinalexander.com/blog/post/java/java-how-read-from-url-string-text");

        URLConnection yc = oracle.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(

                                yc.getInputStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null) 

            System.out.println(inputLine);

        in.close(); */

        

        

        //encoding (String encodeText = String inputLine)

        final String textDate = "Hello everyone how are you";

        String encodeText = Base64.getEncoder().encodeToString(textDate.getBytes("UTF-8"));

        System.out.println(encodeText);

        

        //decoding

        byte[] decodedArr = Base64.getDecoder().decode(encodeText);

        String decodeText = new String(decodedArr,"UTF-8");

        

        System.out.println(decodeText);

        

        // pipe seperated into simple text

        String Delimiter = "|";

        

        StringTokenizer st = new StringTokenizer(decodeText, Delimiter);

        

        while(st.hasMoreTokens())

        {

            System.out.println(st.nextToken());

        }


    }

}


// encoding decoding program end
