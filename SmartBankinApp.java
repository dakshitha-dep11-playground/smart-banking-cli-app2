import java.util.Scanner;

import javax.xml.crypto.Data;

public class SmartBankinApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String GREEN_COLOR = "\033[32m";
        final String RESET_COLOR = "\033[0m";
        final String RED_BOLD = "\033[35;1m";
        final String REST_BOLD_COLOR = "\033[0;0m";
        final String YELLO_COLOR = "\033[33m";
        final String RED_COLOR_BOLD = "\033[31;1m";

        final String DOTTED_LINE = String.format("%s%s%s", GREEN_COLOR, "-".repeat(60), RESET_COLOR);
        final String OPTION_LINE = String.format("%s%s%s", YELLO_COLOR, "%s", RESET_COLOR);
        final String ERROR_LINE = String.format("%s%s%s", RED_COLOR_BOLD, "%s", REST_BOLD_COLOR);
        final String APP_TITLE = String.format("%s%s%s", RED_BOLD, " ".repeat((60 - "%1$s".length()-20) / 2) + "%1$s",
                REST_BOLD_COLOR);
        final String FINAL_APP_TITLE = String.format("%s\n%s\n%s", DOTTED_LINE, String.format(APP_TITLE, "%s"),
                DOTTED_LINE);

        
        final String DASHBOARD = "Welcome to SMART Banking";
        final String ADD_ACCOUNT = "Create new Account";
        final String DEPOSITE = "DEPOSITE";
        final String WITHDRAW = "WITHDRAW";
        final String TRANSFER = "TRANSFER";
        final String PRINT_STATEMENT = "PRINT_STATEMENT";
        final String DELETE_ACCOUNT = "DELETE_ACCOUNT";
        
        String screen = DASHBOARD;

        int[] idArrayMain = new int[0];
        String[] nameArrayMain = new String[0];
        double[] bankBalanceArrayMain = new double[0];



        do {
            System.out.println(CLEAR);
            System.out.println(String.format(FINAL_APP_TITLE, screen));


            switch(screen){
                case DASHBOARD:
                



            }





            break;
        } while (true);


    }
}