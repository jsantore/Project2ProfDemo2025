import java.util.Scanner;

public class PointOfSale {
    private double receipts;
    private double taxCollected;
    private double currentSaleTotal;
    private StoreInventory currentInventory;


    public PointOfSale(StoreInventory currentInventory) {
        receipts = 0;
        taxCollected = 0;
        this.currentInventory = currentInventory;
    }
    public void runPointOfSale(StoreInventory currentInventory) {
        var inputReader = new Scanner(System.in);
        while (true) {
            displayMenu();
            var choice = inputReader.nextInt();
            switch (choice) {
                case 1:
                    addBookToSale(inputReader);
                    break;
                case 2:
                    addFoodToSale(inputReader);
                    break;
                case 3:
                    AddMiscItemToSale(inputReader);
                    break;
                case 4:
                    System.out.println("The total sale is: "+currentSaleTotal);
                    currentSaleTotal = 0;
                    break;
                case 5:
                    runDailyReport();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    private void AddMiscItemToSale(Scanner inputReader) {
        System.out.print("Please enter the UPC code of the item you want to add to the sale: ");
        var upc = inputReader.nextLong();
        for(var item: currentInventory.getMiscStock()){
            if (item.getUPC() == upc){
                System.out.println("How many of "+item.getName()+" do you want?");
                var numberRequested = inputReader.nextInt();
                var saleTotal = item.sellMisc(numberRequested);
                if (saleTotal > 0) {
                    receipts += saleTotal;
                    var taxOnThisBook = saleTotal - saleTotal / 1.0625;
                    taxCollected += taxOnThisBook;
                    currentSaleTotal += saleTotal;
                    return;
                }
                else{
                    System.out.println("Sorry, we do not have that many of that item in stock.");
                    return;
                }
            }
        }
    }

    private void addFoodToSale(Scanner inputReader) {
        System.out.println("Please enter the name of the snack food you want to add to the sale:");
        var foodName = inputReader.nextLine();
        if (foodName.equals("")) {
            foodName = inputReader.nextLine();
        }
        var found = false;
        for (Food snack : currentInventory.getFoodInStock()) {
            if (snack.getName().equalsIgnoreCase(foodName)) {
                found = true;
                System.out.print("How many of "+snack.getName()+" do you want?");
                var quantity = inputReader.nextInt();
                        var saleTotal = snack.sellFood(quantity);
                        if (saleTotal > 0) {
                            receipts += saleTotal;
                            currentSaleTotal += saleTotal;
                            return;
                        }
                        else{
                            System.out.println("Sorry, we do not have that many of that item in stock.");
                            return;
                        }
                    }
            }
        System.out.println("Sorry, we do not have that item in stock.");
        }

    public float addBookToSale(Scanner inputReader){
        System.out.println("Please enter the ISBN of the book you want to add to the sale:");
        var isbn = inputReader.nextInt();
        var bookExists = false;
        for (Book book: currentInventory.getBooksInStock()){
            if(book.getISBN() == isbn){
                bookExists = true;
                System.out.print("How many copies of "+book.getTitle()+" do you want?");
                var quantity = inputReader.nextInt();
                var salesTotal = book.sellBook(quantity);
                if (salesTotal > 0) {
                    receipts += salesTotal;
                    currentSaleTotal += salesTotal;
                    if (!book.getIsTextbook()) {
                        var taxOnThisBook = salesTotal - salesTotal / 1.0625;
                        taxCollected += taxOnThisBook;
                    }
                    return (float) salesTotal;
                }
                else{
                    return 0;
                }
            }
        }
        System.out.println("Sorry, we do not have that book in stock.");
        return 0;
    }


    public void displayMenu(){
        System.out.println("Please select an option from the following menu:");
        System.out.println("[1] Add a book to the current sale");
        System.out.println("[2] Add a food item to the current sale");
        System.out.println("[3] Add a misc item to the current sale");
        System.out.println("[4] Finish/ring up the current sale");
        System.out.println("[5] Run the Daily Report and print it to the console");
        System.out.println("[6] Exit the program");
    }

    public void runDailyReport(){
        System.out.println("The daily report is as follows:");
        System.out.println("Receipts: "+receipts);
        System.out.println("Tax collected: "+taxCollected);
    }






}
