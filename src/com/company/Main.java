package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Main {

    private static ArrayList<Counter> counters = new ArrayList<>();
    private static File highscores = new File("highscores.txt");

    public static void main(String[] args) {
        boolean end = false;
        createFile();
        while (!end){
            createArray();
            int points = 0;
            for (int i = 0; i < 10; i++){
                int userInput = menu(points);
                int colour = counters.get(i).getColour();
                if (userInput == colour){
                    System.out.println("correct");
                    points++;
                }
                else{
                    System.out.println("wrong colour");
                    if (colour == 1){
                        System.out.println("the colour was red");
                    }
                    else if (colour == 2){
                        System.out.println("the colour was blue");
                    }
                    else{
                        System.out.println("the colour was yellow");
                    }
                    points = points - 1;
                }
            }
            System.out.println("Your total points is: "+points);
            exportscore(points);
            System.out.println("play again? 1 = yes, 0 = no");
            int playAgain = userinput();
            if (playAgain == 0){
                end = true;
            }
            else if (playAgain != 2){
                end = true;
        }
        }
        getscores();
    }

    public static int randomInt(int max, int min){
        Random random = new Random();
        return random.nextInt((max-min)+1)+min;
    }

    public static void createArray(){
        for (int i = 0; i < 10; i++){
            int randInt = randomInt(3,1);
            Counter myCounter = new Counter(randInt);
            counters.add(myCounter);
        }
    }

    public static int userinput(){
        Scanner input = new Scanner(System.in);
        int out = 0;
        boolean valid = false;
        while (!valid){
            try{
                out = input.nextInt();
                valid = true;
            }
            catch (Exception e){
                System.out.println("Error "+e);
            }
        }
        return out;
    }

    public static int menu(int points){
        System.out.println("points = "+points);
        System.out.println("Guess the colour (enter number)");
        System.out.println("1 - red");
        System.out.println("2 - blue");
        System.out.println("3 - yellow");
        return userinput();
    }

    public static void createFile(){
        try {
            if (highscores.createNewFile()) {
                System.out.println("File created: " + highscores.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void exportscore(int points){
        try{
            FileWriter myWriter = new FileWriter(highscores.getName(),true);
            myWriter.write(points + "\n");
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("Error "+e);
        }
    }

    public static void getscores(){
        System.out.println("Scores:");
        try{
            Scanner myReader = new Scanner(highscores);
            while (myReader.hasNextLine()){
                System.out.println(myReader.nextLine());
            }
        }
        catch (IOException e){
            System.out.println("Error "+e);
        }
    }
}
