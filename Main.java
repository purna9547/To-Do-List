import java.util.*;

class Main {
    private static final ArrayList<String> toDoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Enter an integer value.");
                sc.nextLine();
                continue;
            }
            switch (choice) {
                case 1 -> addItem(sc);
                case 2 -> deleteItem(sc);
                case 3 -> displayItem();
                case 4 -> clearList();
                case 0 -> {
                    System.out.println("Thanks for using my application.");
                    sc.close();
                    return;
                }
                default -> System.out.println("Incorrect choice! Please try again.");
            }
        } while (true);
    }

    private static void printMenu() {
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Add item");
        System.out.println("2. Remove item");
        System.out.println("3. Display items");
        System.out.println("4. Clear list");
        System.out.println("0. Exit");
    }

    private static void addItem(Scanner sc) {
        System.out.print("Enter the item to add: ");
        String itemToAdd = sc.nextLine();
        toDoList.add(itemToAdd);
        System.out.println("Item added successfully.");
    }

    private static void deleteItem(Scanner sc) {
        if (toDoList.isEmpty()) {
            System.out.println("The to-do list is empty. No item to remove.");
            return;
        }
        System.out.print("Enter the index of the item to remove: ");
        int indexOfItem;
        try {
            indexOfItem = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice! Enter an integer value.");
            sc.nextLine();
            deleteItem(sc);
            return;
        }
        if (indexOfItem < 1 || indexOfItem > toDoList.size()) {
            System.out.println("Invalid index. No item deleted.");
            return;
        }
        String removedItem = toDoList.remove(indexOfItem - 1);
        System.out.println("Removed: " + removedItem);
    }

    private static void displayItem() {
        System.out.println("--- To-Do List ---");
        int i = 0;
        if (toDoList.isEmpty()) {
            System.out.println("The to-do list is empty.");
            return;
        }
        for (String currentItem : toDoList) {
            System.out.println(++i + ". " + currentItem);
        }
    }

    private static void clearList() {
        toDoList.clear();
        System.out.println("To-Do List cleared successfully.");
    }
}
