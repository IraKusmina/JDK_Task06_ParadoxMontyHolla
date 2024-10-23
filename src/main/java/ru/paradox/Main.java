package ru.paradox;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> resultBoard = new HashMap<>();
        int i = 1;
        int QUANTITYTIMES = 1000;
        String[] doors = generateBoard();
        while (i <= QUANTITYTIMES) {
            resultBoard.put(i, startGame(doors));
            i++;
        }
        calculateStatistic(resultBoard, QUANTITYTIMES);
    }
    public static String startGame(String[]doors){
        int firstChoice = (int)(Math.random()*3);
        String result = "";
        if (doors[firstChoice].equals("car")){
            if (getChoiceContinue()){
                result = "loss";
            } else {
                result = "win";
            }
        } else {
            if (getChoiceContinue()){
                result = "win";
            } else {
                result = "loss";}
        }
        return result;
    }

    public static String[] generateBoard(){
        String[] board = {"goap","goap","goap"};
        board[(int)(Math.random()*3)] = "car";
        return board;
    }

    public static Boolean getChoiceContinue(){
        Boolean [] choiceContinue = {true, false};
        boolean choice = choiceContinue[(int)(Math.random()*2)];
        return choice;
    }

    public static void calculateStatistic(HashMap<Integer, String> results, int count){
        int countWin = 0;
        int countLoss = 0;
        for (String value: results.values()){
            if(value.equals("win")){
                countWin++;
            }    else countLoss++;
        }
        System.out.println("Согласно результатам, проведенных игр, которых состоялось " + count + " шт.");
        System.out.println("Победы: " + countWin*100/count + "%");
        System.out.println("Проигрыши: " + countLoss*100/count+ "%");
    }
}