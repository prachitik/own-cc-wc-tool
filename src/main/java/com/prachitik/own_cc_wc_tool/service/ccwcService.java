package com.prachitik.own_cc_wc_tool.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class ccwcService {
    /**
     * Counts the number of bytes in input file
     * @param file
     * @return
     */
    public int getCountBytes(String file) {
        int byteCount = 0;
        try{
            File path = new File(file.trim());
            byte[] contents = Files.readAllBytes(path.toPath());

            byteCount = contents.length;

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return byteCount;
    }

    /**
     * Counts the number of lines in input file
     * @param filename
     * @return
     */
    public int getCountLines(String filename){
        int linecount = 0;
        try{
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(bufferedReader.readLine() != null){
                linecount++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch(IOException e){
            throw new RuntimeException(e);
        }

        return linecount;

    }

    /**
     * Counts the number of words in input file
     * @param filename
     * @return
     */
    public int getCountWords(String filename){
        int wordcount = 0;

        try{
            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            
            while((line = reader.readLine()) != null){
                String[] words = line.trim().split("\\s+");
                for(String word: words){
                    if(word.length() != 0 && !word.equals("\\s+")){
                        wordcount++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return wordcount;
    }

    /**
     * Counts the number of characters in input file
     * @param filename
     * @return
     */
    public int getCountChars(String filename){
        int charcount = 0;
        try{
            FileReader reader = new FileReader(filename);
            char character;
            while(reader.read()!= -1){
                charcount++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return charcount;
    }

    /**
     * Counts the number of lines in standard input from user
     * @param input
     * @return
     */
    public int getCountLinesStdInput(String input){
        int linecount = 0;
        try{

            String[] lines = input.split("\n");
            linecount = lines.length;

        }catch(Exception e){
            e.printStackTrace();
        }

        return linecount;
    }

    /**
     * Counts the number of words in standard input from user
     * @param input
     * @return
     */
    public int getCountWordsStdInput(String input) {
        int wordscount = 0;

        try{
            String[] words = input.trim().split("\\s+");
            wordscount = words.length;

        }catch(Exception e){
            e.printStackTrace();
        }

        return wordscount;
    }

    /**
     * Counts the number of bytes in standard input from user
     * @param input
     * @return
     */
    public int getCountBytesStdInput(String input) {
        int bytescount = 0;

        try{
            bytescount = input.getBytes(StandardCharsets.UTF_8).length;


        } catch(Exception e){
            e.printStackTrace();
        }

        return bytescount;
    }

    /**
     * Counts the number of characters in standard input from user
     * @param input
     * @return
     */
    public int getCountCharsStdInput(String input){
        int charcount = 0;
        try{
            String[] lines = input.split("\n");
            for (String line: lines){
                charcount += line.length();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return charcount;
    }
}
