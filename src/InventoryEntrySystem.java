import java.util.Scanner;
import java.io.FileWriter;
   import java.io.IOException;

public class InventoryEntrySystem {
    public static final String BOOK_INVENTORY = "BooksInStock.txt";
    public static final String FOOD_INVENTORY = "FoodInventory.txt";
    private Scanner inputReader;

    public InventoryEntrySystem() {
        inputReader = new Scanner(System.in);
    }
    public void runStockingProgram(StoreInventory currentInventory){

        while(true){
            displayMenu();
            var choice = inputReader.nextInt();
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

    public void addFoodItem(StoreInventory currentInventory){
        System.out.print("Enter the name of the snack food to add to the inventory:");
        String foodName = inputReader.next();
        for(var snack: currentInventory.getFoodInStock()){
            var found = false;
            if (snack.getName().equalsIgnoreCase(foodName)){
                updateFoodQuantity(snack);
                found = true;
            }
            if(!found){
                addFoodItem(currentInventory);
            }
            saveFoodInventory(currentInventory);
        }
    }

    private void saveFoodInventory(StoreInventory currentInventory) {
        try(var foodFileSaver = new FileWriter(FOOD_INVENTORY)){
            for (var snack : currentInventory.getFoodInStock()) {
                var csvString = ""+snack.getName()+","+snack.getPrice()+","
                        +snack.getNumInStock()+System.lineSeparator();
                foodFileSaver.write(csvString);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void updateFoodQuantity(Food snack) {
        System.out.print("We have some "+snack.getName());
        System.out.print("how many more should we add to the inventory:");
        int quantity = inputReader.nextInt();
        snack.addToStock(quantity);
    }


    public void addBook(StoreInventory currentInventory) {
        System.out.println("Enter the ISBN of the book you want to add to the inventory.");
        var newISBN = inputReader.nextInt();
        var foundIt = false;
        for (var book : currentInventory.getBooksInStock()) {
            if (book.getISBN() == newISBN) {
                updateBookQuantity(book);
                foundIt = true;
            }
        }
        if (!foundIt) {
            var newBook = addNewBook(newISBN);
            currentInventory.getBooksInStock().add(newBook);
        }
        saveBookInventory(currentInventory);
    }

    private void saveBookInventory(StoreInventory currentInventory) {
        //it is not that efficient to save the whole thing everytime
        //we edit anything, but it is easy to implement and it is 9pm and I have
        //to drive my older sons to their job at 7am
        try (var filesaver = new FileWriter(BOOK_INVENTORY)){
            for (var book : currentInventory.getBooksInStock()) {
                var csvLine = ""+book.getISBN()+","+book.getTitle()+","+book.getPrice()+
                        ","+book.getAuthor()+","+book.getIsTextbook()+","+book.getQuantity()
                        +System.lineSeparator();
                filesaver.write(csvLine);
            }

        }catch (IOException e){
            System.out.println("Error while saving Book inventory.");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.exit(1);
        }

    }

    private Book addNewBook(int newISBN) {
        System.out.print("Adding new book for ISBN " + newISBN);
        System.out.print("Enter the Book Author: ");
        var newAuthor = inputReader.nextLine();
        System.out.print("Enter the Book Title: ");
        var newTitle = inputReader.nextLine();
        System.out.print("is this a textBook true/false : ");
        var isTextbook = inputReader.nextBoolean();
        System.out.print("what is the price of this book? ");
        var price = inputReader.nextFloat();
        System.out.print("How many do we have: ");
        var quantity = inputReader.nextInt();
        var newBook = new Book(newISBN, newTitle, price, newAuthor, isTextbook, quantity);
        return newBook;
    }

    private void updateBookQuantity(Book book) {
        System.out.print("Found ISBN " + book.getISBN() + ", " + book.getTitle());
        System.out.print("Enter quantity of new stock: ");
        var quantity = inputReader.nextInt();
        book.addToStock(quantity);
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
