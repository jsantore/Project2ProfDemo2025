import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Store {
    private StoreInventory currentInventory;
    private PointOfSale cashRegister;
    private InventoryEntrySystem stockingInterface;

    public static void main(String[] args) {
        var theStore = new Store();
        if (selectMode())
            theStore.runCashierInterface();
        else
            theStore.runStockerInterface();

    }

    public static boolean selectMode(){
        var reader = new Scanner(System.in);
        while(true) {
            System.out.println("Are You a Cashier or a Stocker?");
            System.out.println("[1] Cashier");
            System.out.println("[2] Stocker");
            var choice = reader.nextInt();
            if (choice == 1) {
                return true;
            }else if (choice == 2) {
                return false;
            }
            System.out.println("Please enter a valid option");
        }
    }


    public Store() {
        currentInventory = new StoreInventory();
        cashRegister = new PointOfSale();
        stockingInterface = new InventoryEntrySystem();
        loadExistingInventory();
    }

    private void loadExistingInventory() {
        try{
            var bookData = Files.readAllLines(Paths.get(InventoryEntrySystem.BOOK_INVENTORY));
            loadBookDataIntoInventory(bookData);
        }catch (IOException e){
            e.printStackTrace();
        }
        try{
            var snackData = Files.readAllLines(Paths.get(InventoryEntrySystem.FOOD_INVENTORY));
            loadFoodDataIntoInventory(snackData);
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            var miscInventoryData = Files.readAllLines(Paths.get(InventoryEntrySystem.MISC_INVENTORY));
            loadMiscInventoryData(miscInventoryData);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void loadMiscInventoryData(List<String> miscInventoryData) {
        for (String itemline : miscInventoryData) {
            String[] itemData = itemline.split(",");
            int upc = Integer.parseInt(itemData[0]);
            var name = itemData[1];
            var price = Float.parseFloat(itemData[2]);
            int quantity = Integer.parseInt(itemData[3]);
            var loadedItem = new OtherItem(upc, name, price, quantity);
            currentInventory.getMiscStock().add(loadedItem);
        }
    }

    private void loadFoodDataIntoInventory(List<String> snackData) {
        for (String Line : snackData) {
            String[] snackLine = Line.split(",");
            var name = snackLine[0];
            var price = Float.parseFloat(snackLine[1]);
            var quantity = Integer.parseInt(snackLine[2]);
            var loadedSnack = new Food(name,price,quantity);
            currentInventory.getFoodInStock().add(loadedSnack);
        }
    }

    private void loadBookDataIntoInventory(List<String> bookData) {
        for (String line : bookData) {
            String[] bookLine = line.split(",");
            var isbn = Integer.parseInt(bookLine[0]);
            var title = bookLine[1];
            var price = Float.parseFloat(bookLine[2]);
            var author = bookLine[3];
            var isTextbook = Boolean.parseBoolean(bookLine[4]);
            var quantity = Integer.parseInt(bookLine[5]);
            var loadedBook = new Book(isbn,title,price,author,isTextbook,quantity);
            currentInventory.getBooksInStock().add(loadedBook);
        }
    }

    public void runStockerInterface(){

        stockingInterface.runStockingProgram(currentInventory);
    }

    public void runCashierInterface(){
        cashRegister.runPointOfSale(currentInventory);
    }
}