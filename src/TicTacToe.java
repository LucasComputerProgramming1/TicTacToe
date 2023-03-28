import java.util.Scanner;

//Board Overview For Reference
//[0][0]    [0][1]  [0][2]
//[1][0]    [1][1]  [1][2]
//[2][0]    [2][1]  [2][2]

public class TicTacToe {

    //Declaring Class Level Variables
    private static int b00=0;
    private static int b01=0;
    private static int b02=0;
    private static int b10=0;
    private static int b11=0;
    private static int b12=0;
    private static int b20=0;
    private static int b21=0;
    private static int b22=0;
    private static int winner=-1;
    private static String topLeft="*";
    private static String topMid="*";
    private static String topRight="*";
    private static String midLeft="*";
    private static String midMid="*";
    private static String midRight="*";
    private static String botLeft="*";
    private static String botMid="*";
    private static String botRight="*";

    public static void main(String[] args) {
        //Declaring Variables Outside Loop
        Scanner in = new Scanner(System.in);
        boolean done = false;

        do {
        //Declaring Variables

        int move=0;
        //int winner=-1;
        int row = 0;
        int col = 0;
        int pNum=0;
        String playerMove = "";
        String Player = "";
        String Error="This Spot Is Already Taken! Please Try Again.";
        boolean cont=true;

        do {
            cont=true;
            //Player Move/Name
                if (pNum==0)
                {
                    playerMove="X";
                    Player="P1";
                }
                if (pNum==1)
                {
                    playerMove="O";
                    Player="P2";
                }

            //Prompt For Player Input
            row = SafeInput.getRangedInt(in, Player + ": Please Enter The Row Of Your Placement", 1, 3);
            col = SafeInput.getRangedInt(in, Player + ": Please Enter The Column Of Your Placement", 1, 3);

            //Calculating Player Input
            if (row == 1) {
                if (col == 1) {
                    //Valid Check
                    move = b00;
                    if (move == 1) {
                        System.out.println("");
                        System.out.println(Error);
                        System.out.println("");
                    } else {
                        topLeft = playerMove;
                        b00 = 1;
                    }
                } else if (col == 2) {
                    //Valid Check
                    move = b01;
                    if (move == 1) {
                        System.out.println("");
                        System.out.println(Error);
                        System.out.println("");
                    } else {
                        topMid = playerMove;
                        b01 = 1;
                    }
                } else {
                    //Valid Check
                    move = b02;
                    if (move == 1) {
                        System.out.println("");
                        System.out.println(Error);
                        System.out.println("");
                    } else {
                        topRight = playerMove;
                        b02 = 1;
                    }
                }
            } else if (row == 2) {
                if (col == 1) {
                    //Valid Check
                    move = b10;
                    if (move == 1) {
                        System.out.println("");
                        System.out.println(Error);
                        System.out.println("");
                    } else {
                        midLeft = playerMove;
                        b10 = 1;
                    }
                } else if (col == 2) {
                    //Valid Check
                    move = b11;
                    if (move == 1) {
                        System.out.println("");
                        System.out.println(Error);
                        System.out.println("");
                    } else {
                        midMid = playerMove;
                        b11 = 1;
                    }
                } else {
                    //Valid Check
                    move = b12;
                    if (move == 1) {
                        System.out.println("");
                        System.out.println(Error);
                        System.out.println("");
                    } else {
                        midRight = playerMove;
                        b12 = 1;
                    }
                }
            } else {
                if (col == 1) {
                    //Valid Check
                    move = b20;
                    if (move == 1) {
                        System.out.println("");
                        System.out.println(Error);
                        System.out.println("");
                    } else {
                        botLeft = playerMove;
                        b20 = 1;
                    }
                }
                if (col == 2) {
                    //Valid Check
                    move = b21;
                    if (move == 1) {
                        System.out.println("");
                        System.out.println(Error);
                        System.out.println("");
                    } else {
                        botMid = playerMove;
                        b21 = 1;
                    }
                }
                else {
                    //Valid Check
                    move = b22;
                    if (move == 1) {
                        System.out.println("");
                        System.out.println(Error);
                        System.out.println("");
                    } else {
                        botRight = playerMove;
                        b22 = 1;
                    }
                }
            }

            //Output Table
            display();

            //Change Players
            if (move==0)
            {
                if (pNum == 0) {
                    pNum = 1;
                } else {
                    pNum = 0;
                }
            }
            
            //Win Check
                isRowWinP1();
                isColWinP1();
                isDiagonalWinP1();
                isRowWinP2();
                isColWinP2();
                isDiagonalWinP2();
                isTie();
        }
        while(winner==-1);

        //Output For Winners
        if (winner==0)
        {
            System.out.println("Player 1 Wins!");
        }
        if (winner==1)
        {
            System.out.println("Player 2 Wins!");
        }
        if (winner==2)
        {
            System.out.println("It's a Tie!");
        }

        //YN Confirm
        done = SafeInput.getYNConfirm(in, "Would you like to play again? Please enter Y for yes and N for no");
        clearBoard();

        }
while(!done);
    }

    //Helper Methods
    private static void display() {
        System.out.println(topLeft + " | " + topMid + " | " + topRight);
        System.out.println(midLeft + " | " + midMid + " | " + midRight);
        System.out.println(botLeft + " | " + botMid + " | " + botRight);
        System.out.println("");
    }
    private static void clearBoard() {
        b00=0;
        b01=0;
        b02=0;
        b10=0;
        b11=0;
        b12=0;
        b20=0;
        b21=0;
        b22=0;
        winner=-1;
        topLeft="*";
        topMid="*";
        topRight="*";
        midLeft="*";
        midMid="*";
        midRight="*";
        botLeft="*";
        botMid="*";
        botRight="*";
    }

    //Helper Methods [WIN CHECKS]
    private static int isTie(){
        if (b00 == 1 && b01 == 1 && b02 == 1 && b10 == 1 && b11 == 1 && b12 == 1 && b20 == 1 && b21 == 1 && b22 == 1) {
            winner = 2;
        }
        return winner;
    }
    private static int isRowWinP1() {
        if (topLeft.equalsIgnoreCase("X") && topMid.equalsIgnoreCase("X") && topRight.equalsIgnoreCase("X") || midLeft.equalsIgnoreCase("X") && midMid.equalsIgnoreCase("X") && midRight.equalsIgnoreCase("X") || botLeft.equalsIgnoreCase("X") && botMid.equalsIgnoreCase("X") && botRight.equalsIgnoreCase("X")) {
            winner = 0;
        }
        return winner;
    }
    private static int isColWinP1() {
        if (topLeft.equalsIgnoreCase("X") && midLeft.equalsIgnoreCase("X") && botLeft.equalsIgnoreCase("X") || topMid.equalsIgnoreCase("X") && midMid.equalsIgnoreCase("X") && botMid.equalsIgnoreCase("X") || topRight.equalsIgnoreCase("X") && midRight.equalsIgnoreCase("X") && botRight.equalsIgnoreCase("X")) {
            winner = 0;
        }
        return winner;
    }
    private static int isDiagonalWinP1() {
        if (topLeft.equalsIgnoreCase("X") && midMid.equalsIgnoreCase("X") && botRight.equalsIgnoreCase("X") || botLeft.equalsIgnoreCase("X") && midMid.equalsIgnoreCase("X") && topRight.equalsIgnoreCase("X")) {
            return winner = 0;
        }
        return winner;
    }
    private static int isRowWinP2() {
        if (topLeft.equalsIgnoreCase("O") && topMid.equalsIgnoreCase("O") && topRight.equalsIgnoreCase("O") || midLeft.equalsIgnoreCase("O") && midMid.equalsIgnoreCase("O") && midRight.equalsIgnoreCase("O") || botLeft.equalsIgnoreCase("O") && botMid.equalsIgnoreCase("O") && botRight.equalsIgnoreCase("O")) {
            winner = 0;
        }
        return winner;
    }
    private static int isColWinP2() {
        if (topLeft.equalsIgnoreCase("O") && midLeft.equalsIgnoreCase("O") && botLeft.equalsIgnoreCase("O") || topMid.equalsIgnoreCase("O") && midMid.equalsIgnoreCase("O") && botMid.equalsIgnoreCase("O") || topRight.equalsIgnoreCase("O") && midRight.equalsIgnoreCase("O") && botRight.equalsIgnoreCase("O")) {
            winner = 0;
        }
        return winner;
    }
    private static int isDiagonalWinP2() {
        if (topLeft.equalsIgnoreCase("O") && midMid.equalsIgnoreCase("O") && botRight.equalsIgnoreCase("O") || botLeft.equalsIgnoreCase("O") && midMid.equalsIgnoreCase("O") && topRight.equalsIgnoreCase("O")) {
            return winner = 0;
        }
        return winner;
    }
}



