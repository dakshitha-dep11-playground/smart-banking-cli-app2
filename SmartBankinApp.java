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
        final String APP_TITLE = String.format("%s%s%s", RED_BOLD, " ".repeat((60 - "%1$s".length() - 20) / 2) + "%1$s",
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

        final String branchCode = "SDB-";
        String idStringMain;
        String nameStringMain;
        double depositeMain;

        int[] idArrayMain = new int[0];
        String[] nameArrayMain = new String[0];
        double[] bankBalanceArrayMain = new double[0];

        do {
            System.out.println(CLEAR);
            System.out.println(String.format(FINAL_APP_TITLE + "\n", screen));

            switch (screen) {
                case DASHBOARD:

                    System.out.println(String.format(OPTION_LINE, "[1] Create New Account"));
                    System.out.println(String.format(OPTION_LINE, "[2] Deposite"));
                    System.out.println(String.format(OPTION_LINE, "[3] Withdravals"));
                    System.out.println(String.format(OPTION_LINE, "[4] Transfer"));
                    System.out.println(String.format(OPTION_LINE, "[5] Print Statement"));
                    System.out.println(String.format(OPTION_LINE, "[6] Delete Account"));
                    System.out.println(String.format(OPTION_LINE, "[7] Exit"));

                    System.out.print("\nEnter the option : ");
                    String dashboardOption = scanner.nextLine().strip();
                    // scanner.nextLine();

                    if (dashboardOption.isBlank() || !Character.isDigit(dashboardOption.charAt(0))) {
                        System.out.println(String.format(ERROR_LINE, "Enter valid option!"));
                    }
                    int dashboardOptionInt = Integer.valueOf(dashboardOption);
                    if (dashboardOptionInt > 7 || dashboardOptionInt < 1) {
                        System.out.println(String.format(ERROR_LINE, "Enter valid option!"));
                    }

                    switch (dashboardOptionInt) {
                        case 1:
                            screen = ADD_ACCOUNT;
                            break;
                        case 2:
                            screen = DEPOSITE;
                            break;
                        case 3:
                            screen = WITHDRAW;
                            break;
                        case 4:
                            screen = TRANSFER;
                            break;
                        case 5:
                            screen = PRINT_STATEMENT;
                            break;
                        case 6:
                            screen = DELETE_ACCOUNT;
                            break;
                        case 7:
                            System.exit(0);
                    }
                    break;

                case ADD_ACCOUNT:
                    idStringMain = branchCode + String.format("%-05d", idArrayMain.length + 1);
                    System.out.println("ID : " + idStringMain);

                    loopAddName: do {
                        System.out.print("Enter Account holder's name : ");
                        nameStringMain = scanner.nextLine().strip();

                        if (nameStringMain.isBlank()) {
                            System.out.println(String.format(ERROR_LINE, "Name can't be empty!"));
                            continue loopAddName;
                        }
                        for (int i = 0; i < nameStringMain.length(); i++) {
                            if (!Character.isLetter(nameStringMain.charAt(i)) || nameStringMain.charAt(i) != ' ') {
                                System.out.println(String.format(ERROR_LINE, "Invalid Name!"));

                                continue loopAddName;
                            }
                        }
                        break;
                    } while (true);

                    loopAddDeposite:
                    do {
                        System.out.print("Enter Deposite ammount : ");
                        depositeMain = scanner.nextDouble();
                        scanner.nextLine();

                        if(depositeMain<5000){
                            System.out.println(String.format(ERROR_LINE, "Initial Deposite Should be greater than Rs.5000/= !"));
                            continue loopAddDeposite;
                        }
                        break;
                    } while (true);


                    int[] idArrayTemp = new int[idArrayMain.length+1];
                    String[] nameArrayTemp = new String[nameArrayMain.length+1];
                    double[] bankBalanceArrayTemp = new double[bankBalanceArrayMain.length+1];

                    for(int i = 0 ; i < idArrayMain.length;i++){
                        idArrayTemp[i] = idArrayMain[i];
                        nameArrayTemp[i] = nameArrayMain[i];
                        bankBalanceArrayTemp[i] = bankBalanceArrayMain[i];
                    }
                    idArrayTemp[idArrayTemp.length-1] = idArrayTemp.length-1;
                    nameArrayTemp[nameArrayTemp.length-1] = nameStringMain;
                    bankBalanceArrayTemp[bankBalanceArrayTemp.length-1] = depositeMain;

                    //System.out.print("");

            }

        } while (true);

    }
}