package org.example;
import java.util.Scanner;

public class MineSweeper {
    int size, row, col;
    int[][] map, board;
    Scanner scanner = new Scanner(System.in);
    public MineSweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new int[this.row][this.col];
        this.map = new int[this.row][this.col];
        this.size = (this.row*this.col)/4;
    }
    public void run(){
        prepareGame();
        System.out.println("===MAYINLARIN KONUMU===");
        print(map);
        System.out.println("Oyun başladı!");
        print(board);
        while (true){
            System.out.print("Satır numarası giriniz: ");
            int satir = scanner.nextInt();
            System.out.print("Sütun numarası giriniz: ");
            int sutun = scanner.nextInt();
            if (this.map[satir][sutun] != -1){
                this.board[satir][sutun] = 1;
                print(board);
            } else if (this.map[satir][sutun] == -1) {
                System.out.println("Mayına bastınız...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Game Over!");
                break;
            }else {
                System.out.println("Lütfen tekrar deneyiniz!!!");
            }
        }
    }
    public void prepareGame(){
        int randRow, randCol, count =0;
        while (count != size){
            randRow = (int)(Math.random()*this.map.length);
            randCol = (int)(Math.random()*this.map[0].length);
            if (this.map[randRow][randCol] != -1){
                this.map[randRow][randCol] = -1;
                count++;
            }
        }
    }
    public void print(int[][] arr){
        for (int i=0; i< arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}









