

/**
 * Class OtherItem
 */
public class OtherItem {

    //
    // Fields
    //

    private int UPCcode;
    private String Name;
    private float price;
    private int quantity;

    //
    // Constructors
    //
    public  OtherItem(int UPC, String itemName, float itemPrice, int numberInStock)
    {
        UPCcode = UPC;
        Name = itemName;
        price = itemPrice;
        quantity = numberInStock;
    }

    //
    // Accessor methods
    //


    /**
     * Get the value of UPCcode
     * @return the value of UPCcode
     */
    public int getUPC () {
        return UPCcode;
    }


    /**
     * Get the value of Name
     * @return the value of Name
     */
    public String getName () {
        return Name;
    }


    /**
     * Get the value of price
     * @return the value of price
     */
    public float getPrice () {
        return price;
    }


    /**
     * Get the value of quantity
     * @return the value of quantity
     */
    public int getQuantityInStock () {
        return quantity;
    }

    //
    // Other methods
    //

    /**
     * @param        quantityOfNewItems
     */
    public void addToStock(int quantityOfNewItems)
    {
    }


    /**
     * @param        numberSold
     */
    public void sellMisc(int numberSold)
    {
    }


}
