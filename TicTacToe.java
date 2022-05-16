import java.util.*;

public class TicTacToe {

    static char board[][] = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };
    static char turn = 'X';
    static int r, c;
    static boolean draw = false;

    public static void display() {
        System.out.println("\t\tT I C   T A C   T O E\n\n\n");
        System.out.println("\tPlayer1 [X]\n\n\tPlayer2 [O]\n\n");

        //declare or rearrange board

        System.out.println("\t\t\t     |     |     ");
        System.out.println("\t\t\t  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2] + "  ");
        System.out.println("\t\t\t_____|_____|_____");
        System.out.println("\t\t\t     |     |     ");
        System.out.println("\t\t\t  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2] + "  ");
        System.out.println("\t\t\t_____|_____|_____");
        System.out.println("\t\t\t     |     |     ");
        System.out.println("\t\t\t  " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2] + "  ");
        System.out.println("\t\t\t     |     |     ");
    }

    //Player turns


    public static void playerTurn() {
        if (turn == 'X') {
            System.out.println("\n\tPlayer1 [X] turn: ");
        }
        if (turn == 'O') {
            System.out.println("\n\tPlayer2 [O] turn: ");
        }
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                r = 0;
                c = 0;
                break;
            case 2:
                r = 0;
                c = 1;
                break;
            case 3:
                r = 0;
                c = 2;
                break;
            case 4:
                r = 1;
                c = 0;
                break;
            case 5:
                r = 1;
                c = 1;
                break;
            case 6:
                r = 1;
                c = 2;
                break;
            case 7:
                r = 2;
                c = 0;
                break;
            case 8:
                r = 2;
                c = 1;
                break;
            case 9:
                r = 2;
                c = 2;
                break;

            default:
                System.out.println("Wrong choice!!");
        }
        if (turn == 'X' && board[r][c] != 'X' && board[r][c] != 'O') {
            board[r][c] = 'X';
            turn = 'O';
        } else if (turn == 'O' && board[r][c] != 'X' && board[r][c] != 'O') {
            board[r][c] = 'O';
            turn = 'X';
        } else {
            System.out.println("Invalid Number!.....Try Again!\n\n");
            playerTurn();
        }
        display();
    }

    //game over function

    public static boolean gameOver() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]
                    || board[0][i] == board[1][i] && board[0][i] == board[2][i])
                return false;
            if (board[0][0] == board[1][1] && board[0][0] == board[2][2]
                    || board[0][2] == board[1][1] && board[0][2] == board[2][0])
                return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O')
                    return true;
            }
        }
        draw = true;
        return false;
    }

    public static void main(String[] args) {
        while(gameOver()){
            display();
            playerTurn();
            gameOver();
        }
        if(turn=='X' && draw==false){
            System.out.println("Player2 [O] wins!!\n");
        }else if(turn=='O' && draw==false){
            System.out.println("Player1 [X] wins!!\n");
        }else{
            System.out.println("Match Draw\n");
        }
    }
}
