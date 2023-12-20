package com.javarush.Alymov.Command;

import com.javarush.Alymov.constant.Alphabet;
import com.javarush.Alymov.constant.Const;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encode {

     static String sourcePath;
     static String destinationPath;
     static int stepEncode;
     public static void encoder (String sourcePath, String destinationPath, int step){

         int shift = step;
         try(
                 BufferedReader bufferedReader = Files.newBufferedReader(Path.of(sourcePath));
                 BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(destinationPath));
         ){
             int valueOfChar;
             int alphabetLength = Alphabet.index.size();
             while ((valueOfChar=bufferedReader.read())>-1){
                 char charecter = (char)valueOfChar;
                 charecter = Character.toLowerCase(charecter);
                 if (Alphabet.index.containsKey(charecter)){
                     int index = Alphabet.index.get(charecter);
                     int newIndex = (index+shift)>=alphabetLength? (index+shift)-(alphabetLength*((index+shift)/alphabetLength)):index+shift;
                     bufferedWriter.write(Alphabet.CHARS[newIndex]);
                 }
                 else if (charecter=='\n') {
                     bufferedWriter.write(charecter);
                 }

             }

         }
         catch (Exception e){
             System.out.println(Const.ERROR_MESSAGE+e);
         }


         System.out.println("encoder work");
         System.out.println(sourcePath);
         System.out.println(destinationPath);
    }
}
