package Assignment_2;
import java.util.*;

public class BankingSystem {
    //LinkedList Барлық тіркелген шоттарды сақтауға арналған тізім
    static LinkedList<BankAccount> accounts = new LinkedList<>();

    //Stack "Кері қайтару" (Undo) функциясы үшін соңғы әрекеттерді сақтайды
    static Stack<String> transactionHistory = new Stack<>();

    //Queue Коммуналдық төлемдер кезегі
    static Queue<String> billQueue = new LinkedList<>();

    //Queue Жаңа шот ашуға өтініш білдіргендер кезегі (Admin үшін)
    static Queue<BankAccount> accountRequests = new LinkedList<>();

    public static void main(String[] args) {
        Scanner ziruza = new Scanner(System.in);

        // Массив (Array)
        BankAccount[] initialData = new BankAccount[3];
        initialData[0] = new BankAccount("111", "Ziruza", 19999);
        initialData[1] = new BankAccount("121", "Maqsat", 18888);
        initialData[2] = new BankAccount("131", "Alex", 10000);

        // Массивтегі деректерді негізгі LinkedList тізіміне көшіру
        for (BankAccount acc : initialData) {
            accounts.add(acc);
        }

        //Пайдаланушы "Exit" басқанша бағдарламаны тоқтатпайды
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Enter Bank (Services)\n2. Enter ATM\n3. Admin Area\n4. Exit");
            System.out.print("Choose: ");

            // Қате енгізуден қорғау: Егер сан емес нәрсе жазсаң, бағдарлама сөнбейді
            if (!ziruza.hasNextInt()) {
                System.out.println("Please enter a number!");
                ziruza.next(); continue;
            }

            int choice = ziruza.nextInt(); ziruza.nextLine();
            if (choice == 4) break;
            switch (choice) {
                case 1: // БАНК меню
                    System.out.println("1. Request Account\n2. Deposit\n3. Withdraw\n4. Pay Bill");
                    int bChoice = ziruza.nextInt(); ziruza.nextLine();

                    if (bChoice == 1) { // Кезекке өтініш жіберу
                        System.out.print("Enter name: ");
                        accountRequests.add(new BankAccount("Pending", ziruza.nextLine(), 0));
                    } else if (bChoice == 2) handleTransaction(ziruza, "Deposit"); // Ақша салу
                    else if (bChoice == 3) handleTransaction(ziruza, "Withdraw"); // Ақша алу
                    else if (bChoice == 4) { // Төлемді кезекке қосу
                        System.out.print("Bill name: ");
                        billQueue.add(ziruza.nextLine());
                    }
                    break;

                case 2: // ATM меню
                    System.out.println("1. Balance\n2. Search User\n3. Undo Last Action");
                    int atmChoice = ziruza.nextInt(); ziruza.nextLine();

                    if (atmChoice == 1) displayAccounts(); // Барлық балансты көру
                    else if (atmChoice == 2) searchAccount(ziruza); // Пайдаланушыны іздеу
                    else if (atmChoice == 3) { //Соңғы әрекетті Стэктен алып тастау
                        if (!transactionHistory.isEmpty())
                            System.out.println("Undoing: " + transactionHistory.pop());
                    }
                    break;

                case 3: // АДМИН меню
                    System.out.println("1. Process Opening\n2. Process Bills");
                    int adChoice = ziruza.nextInt(); ziruza.nextLine();

                    if (adChoice == 1 && !accountRequests.isEmpty()) { // Кезектегі бірінші адамды тізімге қосу
                        BankAccount newAcc = accountRequests.poll(); // Queue FIFO принципі
                        newAcc.accountNumber = "444" + (accounts.size() + 1);
                        accounts.add(newAcc); // LinkedList-ке қосу
                        System.out.println("Processed: " + newAcc.username);
                    } else if (adChoice == 2 && !billQueue.isEmpty()) {
                        System.out.println("Paid: " + billQueue.poll()); // Төлемді кезектен шығару
                    }
                    break;
            }
        }
    }

    // Транзакция функциясы LinkedList ішіндегі балансты тауып жаңартады
    static void handleTransaction(Scanner sc, String type) {
        System.out.print("Username: ");
        String name = sc.nextLine();
        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)) {
                System.out.print("Amount: ");
                double amt = sc.nextDouble();
                if (type.equals("Deposit")) acc.balance += amt;
                else acc.balance -= amt;

                // Әрекетті Стэкке сақтаймыз
                transactionHistory.push(type + " " + amt + " for " + name);
                System.out.println("Success! Balance: " + acc.balance);
                return;
            }
        }
        System.out.println("Not found!");
    }

    // Search функциясы пайдаланушыны аты бойынша іздейд
    static void searchAccount(Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(name)) {
                System.out.println("Found: " + acc); return;
            }
        }
        System.out.println("Not found.");
    }

    // Барлық затты экранға шығару
    static void displayAccounts() {
        for (BankAccount acc : accounts) System.out.println(acc);
    }
}