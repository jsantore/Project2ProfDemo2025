

/**
 * Class OtherItem
 */
public class OtherItem {

    //
    // Fields
    //

    private long UPCcode;
    private String Name;
    private float price;
    private int quantity;

    //
    // Constructors
    //
    public  OtherItem(long UPC, String itemName, float itemPrice, int numberInStock)
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
    public long getUPC () {
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
        if (quantityOfNewItems > 0) {
            quantity += quantityOfNewItems;
        }
    }


    /**
     * @param        numberSold
     */
    public double sellMisc(int numberSold)
    {
        if (numberSold <= 0) {
            return 0;
        }
        else if (numberSold > quantity) {
            return 0;
        }
        else {
            double totalCost = numberSold * price;
            totalCost += totalCost * 0.0625;
            quantity -= numberSold;
            return totalCost;
        }
    }


}
