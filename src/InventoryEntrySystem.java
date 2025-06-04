import java.util.Scanner;

public class InventoryEntrySystem {
    public static final String BOOK_INVENTORY = "BooksInStock.txt";
    public void runStockingProgram(StoreInventory currentInventory){
        var userInputReader = new Scanner(System.in);
        while(true){
            displayMenu();
            var choice = userInputReader.nextInt();
            if(choice == 1){
                addBook(currentInventory);
            }
            else if(choice == 2){
                addFoodItem(currentInventory);
            }
            else if(choice == 3){addMiscItem(currentInventory);}
            else if(choice == 4){
                break;
            }
            else{
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void addFoodItem(StoreInventory currentInventory){}


    public void addBook(StoreInventory currentInventory){
        var inputReader = new Scanner(System.in);
        System.out.println("Enter the ISBN of the book you want to add to the inventory.");
        var newISBN = inputReader.nextLine();

    }

    public void addMiscItem(StoreInventory currentInventory){}

    private void displayMenu(){
        System.out.println("Welcome to the Inventory Stocking System!");
        System.out.println("Please select one of the options below by number:");
        System.out.println("[1] Add Book");
        System.out.println("[2] Add Food Item");
        System.out.println("[3] Add any other Item such as games, puzzles, etc.");
        System.out.println("[4] to exit the program");
    }

}
