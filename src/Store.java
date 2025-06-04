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
    }

    public void runStockerInterface(){

        stockingInterface.runStockingProgram(currentInventory);
    }

    public void runCashierInterface(){
        cashRegister.runPointOfSale(currentInventory);
    }
}