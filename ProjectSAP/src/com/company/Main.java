package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String invalidCommandMessage = "You entered an invalid command, try again!";
    private static String path;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("The inputs can be both uppercase and lowercase.");
        String input = getInput();

        while (!input.toLowerCase().equals("exit")){

            try{
            switch (input.toLowerCase()){
                case "load":
                        loadFile();
                        break;
                default:
                    System.out.println(invalidCommandMessage);
                    break;
            }}catch (FileNotFoundException e) {
                System.out.println("The file was not found!");
            }catch (IOException e) {
                System.out.println("There was a problem reading or writing the file, try again.");
            }catch (IndexOutOfBoundsException e){
                System.out.println("The indexes were out of bounds!");
            }catch (SameLineIndexException e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("The indexes were not in the right format. They should be integers!");
            }

            input = getInput();
        }
    }

    private static void loadFile() throws FileNotFoundException, IndexOutOfBoundsException, SameLineIndexException, IOException {

        //If the path is defined and there is actually a file there, then we ask the user whether he wants to use the previous path
        if (path != null && fileExists()) {
            System.out.print("Do you want to use the previous path? (Yes|No)  ");
            String input = scan.nextLine();
            if (input.toLowerCase().equals("no")) {
                getPath();
            }
        }else{
            getPath();
        }

        //Check if file exists and if it doesn't then we throw an exception
        if (!fileExists()){
            throw new FileNotFoundException();
        }

        System.out.println("The file was found! What do you want to change: Lines | Words");
        String option = scan.nextLine();

        switch (option.toLowerCase()){
            case "lines": switchLines(path); break;
            case "words": switchWords(path); break;
            default:
                System.out.println(invalidCommandMessage);
                break;
        }
    }

    private static void switchWords(String path) throws IOException, SameLineIndexException {
        System.out.println("Enter line indexes in the following format:\'<first line index> <word index> <second line index> <word index>\'.");
        String[] lineIndexes = scan.nextLine().split(" ");

        //We reduce 1, because the lines in a normal document start from 1, but here in the list they start from 0
        int lineIndexOne = Integer.parseInt(lineIndexes[0]) - 1;
        int wordIndexOne = Integer.parseInt(lineIndexes[1]) - 1;
        int lineIndexTwo = Integer.parseInt(lineIndexes[2]) - 1;
        int wordIndexTwo = Integer.parseInt(lineIndexes[3]) - 1;

        if (lineIndexOne == lineIndexTwo){
            throw new SameLineIndexException("The words cannot be on the same line!");
        }

        //Get the file content
        List<String> fileContent = getFileContent(path);

        //Getting the value of the two lines
        String lineOne = fileContent.get(lineIndexOne);
        String lineTwo = fileContent.get(lineIndexTwo);

        String splitRegex = "[ \\t]+";

        //Get the words from the lines
        List<String> wordsLineOne = Arrays.asList(lineOne.split(splitRegex));
        List<String> wordsLineTwo = Arrays.asList(lineTwo.split(splitRegex));

        //Get the words from the lines
        String wordOne = wordsLineOne.get(wordIndexOne);
        String wordTwo = wordsLineTwo.get(wordIndexTwo);

        //Set the words to the new ones
        wordsLineOne.set(wordIndexOne, wordTwo);
        wordsLineTwo.set(wordIndexTwo, wordOne);

        //Replace the current fileContent's content with the edited one
        fileContent.set(lineIndexOne, String.join(" ", wordsLineOne));
        fileContent.set(lineIndexTwo, String.join(" ", wordsLineTwo));

        //Write it to the file
        writeToFile(path, fileContent);

        System.out.printf("Successfully changed the positions of: %s and %s.\n", wordOne, wordTwo);
    }



    private static void switchLines(String path) throws IOException, IndexOutOfBoundsException {
        System.out.println("Enter line indexes in the following format:\'<index1> <index2>\'.");
        String[] lineIndexes = scan.nextLine().split(" ");

        //We reduce 1, because the lines in a normal document start from 1, but here in the list they start from 0
        int indexOne = Integer.parseInt(lineIndexes[0]) - 1;
        int indexTwo = Integer.parseInt(lineIndexes[1]) - 1;

        //Get the file content
        List<String> fileContent = getFileContent(path);

        //Getting the value of the two lines
        String lineOne = fileContent.get(indexOne);
        String lineTwo = fileContent.get(indexTwo);

        //Switching the values of the lines
        fileContent.set(indexOne, lineTwo);
        fileContent.set(indexTwo, lineOne);

        //Writing in the file
        writeToFile(path, fileContent);

        System.out.printf("Successfully switched lines %d and %d.\n", indexOne+1, indexTwo+1);
    }

    private static List<String> getFileContent(String path) throws IOException {
        //Creating a BufferReader to read all the lines in the file
        BufferedReader buffReader = new BufferedReader(new FileReader(path));
        List<String> fileContent = new ArrayList();

        //Saving all the lines in a list
        String currentLine;
        while((currentLine = buffReader.readLine()) != null){
            fileContent.add(currentLine);
        }
        buffReader.close();
        return fileContent;
    }

    private static void writeToFile(String path, List<String> fileContent) throws IOException {
        //Creating a inputBuffer(string), so we can write it to the file
        StringBuffer inputBuffer = new StringBuffer();
        inputBuffer.append(String.join("\n", fileContent));

        //Writing in the file
        FileOutputStream fileOut = new FileOutputStream(path);
        fileOut.write(inputBuffer.toString().getBytes());
        fileOut.close();
    }

    private static String getInput(){
        System.out.println("Enter a command: Load | Exit");
        return scan.nextLine();
    }

    private static void getPath(){
        System.out.print("Enter the file path: ");
        path = scan.nextLine();
    }

    private static boolean fileExists(){
        File f = new File(path);
        if (!f.exists()){
            return false;
        }
        return true;
    }
}
