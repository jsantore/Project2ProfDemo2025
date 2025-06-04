

/**
 * Class Food
 */
public class Food {

    //
    // Fields
    //

    private String name;
    private float price;
    private int numberInStock;

    //
    // Constructors
    //
    public Food(String itemName, float cost, int inStockQuantitiy) {
        name = itemName;
        price = cost;
        numberInStock = inStockQuantitiy;
    }


    //
    // Accessor methods
    //


    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }


    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public float getPrice() {
        return price;
    }


    /**
     * Get the value of numberInStock
     *
     * @return the value of numberInStock
     */
    public int getNumInStock() {
        return numberInStock;
    }


    /**
     * @param quantityOfNewStock
     */
    public void addToStock(int quantityOfNewStock) {
    }


    /**
     * @param numberSold
     * @return double
     */
    public double sellFood(int numberSold) {
        return 0;
    }

}
