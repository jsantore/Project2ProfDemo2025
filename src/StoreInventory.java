import java.util.ArrayList;
/**
 * Class StoreInventory
 */
public class StoreInventory {

    //
    // Fields
    //

    private ArrayList<Book> BooksInStock;
    private ArrayList<Food> snacksInStock;
    private ArrayList<OtherItem> miscStock;

    //
    // Constructors
    //
    public StoreInventory () {
        BooksInStock = new ArrayList<Book>();
        snacksInStock = new ArrayList<Food>();
        miscStock = new ArrayList<OtherItem>();
    };



    /**
     * Get the value of BooksInStock
     * @return the value of BooksInStock
     */
    public ArrayList<Book> getBooksInStock () {
        return BooksInStock;
    }


    /**
     * Get the value of miscStock
     * @return the value of miscStock
     */
    public ArrayList<OtherItem> getMiscStock () {
        return miscStock;
    }
    public ArrayList<Food> getFoodInStock () {
    return snacksInStock;}

}

