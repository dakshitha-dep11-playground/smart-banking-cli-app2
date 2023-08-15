import java.util.Arrays;
import java.util.Scanner;


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

        final String DOTTED_LINE = String.format("%s%s%s", GREEN_COLOR, "-".repeat(75), RESET_COLOR);
        final String OPTION_LINE = String.format("%s%s%s", YELLO_COLOR, "%s", RESET_COLOR);
        final String ERROR_LINE = String.format("%s%s%s", RED_COLOR_BOLD, "%s", REST_BOLD_COLOR);
        final String APP_TITLE = String.format("%s%s%s", RED_BOLD, " ".repeat((75 - "%1$s".length() - 20) / 2) + "%1$s",
                REST_BOLD_COLOR);
        final String FINAL_APP_TITLE = String.format("%s\n%s\n%s", DOTTED_LINE, String.format(APP_TITLE, "%s"),
                DOTTED_LINE);
        final String SUCCESSFULL_MESSAGE = String.format("%s%s%s", GREEN_COLOR, "%s", RESET_COLOR);

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

        String add_Yes_No_Option;

        int[] idArrayMain = new int[0];
        String[] nameArrayMain = new String[0];
        double[] bankBalanceArrayMain = new double[0];
        loopMain: do {
            System.out.println(CLEAR);
            System.out.println(String.format(FINAL_APP_TITLE + "\n", screen));

            // System.out.println(Arrays.toString(idArrayMain));
            // System.out.println(Arrays.toString(nameArrayMain));
            // System.out.println(Arrays.toString(bankBalanceArrayMain));
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
                    idStringMain = branchCode + String.format("%05d", idArrayMain.length + 1);
                    System.out.println("ID : " + idStringMain);

                    // add name
                    loopAddName: do {
                        System.out.print("Enter Account holder's name : ");
                        nameStringMain = scanner.nextLine().strip();

                        if (nameStringMain.isBlank()) {
                            System.out.println(String.format(ERROR_LINE, "Name can't be empty!\n"));

                            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                            System.out.print("Do you want to enter again? (Y/N)");
                            add_Yes_No_Option = scanner.nextLine().strip().toUpperCase();

                            if (add_Yes_No_Option.equals("Y")) {
                                System.out.println();
                                System.out.println("ID : " + idStringMain);
                                continue loopAddName;
                            } else {
                                screen = DASHBOARD;
                                continue loopMain;
                            }

                            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        }

                        for (int i = 0; i < nameStringMain.length(); i++) {
                            if (!(Character.isLetter(nameStringMain.charAt(i)) || nameStringMain.charAt(i) == ' ')) {
                                System.out.println(String.format(ERROR_LINE, "Invalid Name!\n"));
                                System.out.println("ID : " + idStringMain);
                                continue loopAddName;
                            }
                        }

                        break;
                    } while (true);

                    // Add deposite
                    loopAddDeposite: do {
                        System.out.print("Enter Deposite ammount : ");
                        depositeMain = scanner.nextDouble();
                        scanner.nextLine();

                        if (depositeMain < 5000) {
                            System.out.println(
                                    String.format(ERROR_LINE, "Initial Deposite Should be greater than Rs.5000/= !\n"));
                            System.out.println("ID : " + idStringMain);
                            System.out.println("Name : " + nameStringMain);
                            continue loopAddDeposite;
                        }
                        break;
                    } while (true);


                    //Initialize temp arrays
                    int[] idArrayTemp = new int[idArrayMain.length + 1];
                    String[] nameArrayTemp = new String[nameArrayMain.length + 1];
                    double[] bankBalanceArrayTemp = new double[bankBalanceArrayMain.length + 1];

                    // Enter to new Arrays
                    for (int i = 0; i < idArrayMain.length; i++) {
                        idArrayTemp[i] = idArrayMain[i];
                        nameArrayTemp[i] = nameArrayMain[i];
                        bankBalanceArrayTemp[i] = bankBalanceArrayMain[i];
                    }
                    idArrayTemp[idArrayTemp.length - 1] = idArrayTemp.length;
                    nameArrayTemp[nameArrayTemp.length - 1] = nameStringMain;
                    bankBalanceArrayTemp[bankBalanceArrayTemp.length - 1] = depositeMain;

                    idArrayMain = idArrayTemp;
                    nameArrayMain = nameArrayTemp;
                    bankBalanceArrayMain = bankBalanceArrayTemp;

                    // Print successfull message
                    System.out.println();
                    System.out.print(String.format(SUCCESSFULL_MESSAGE,
                            idStringMain + " : " + nameStringMain + " added successfully.\n"));
                    System.out.print("Do you want to add a anothor account? (Y/N)");
                    add_Yes_No_Option = scanner.nextLine().strip().toUpperCase();

                    if (add_Yes_No_Option.equals("Y")) {
                        screen = ADD_ACCOUNT;
                        continue;
                    } else {
                        screen = DASHBOARD;
                        continue;
                    }
            }

        } while (true);

    }
}