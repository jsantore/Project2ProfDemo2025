
/**
 * Class Book
 */
public class Book {

    //
    // Fields
    //

    private int ISBN;
    private String Title;
    private float price;
    private String Author;
    private boolean isTextbook;
    private int quantity;

    //
    // Constructors
    //
    public  Book(int isbnNumber, String bookTitle, float sellPrice, String writer, boolean isTextBook, int numberInStock)
    {
        ISBN = isbnNumber;
        Title = bookTitle;
        price = sellPrice;
        Author = writer;
        quantity = numberInStock;
        isTextbook = isTextBook;
    }


    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Get the value of ISBN
     * @return the value of ISBN
     */
    public int getISBN () {
        return ISBN;
    }


    /**
     * Get the value of Title
     * @return the value of Title
     */
    public String getTitle () {
        return Title;
    }


    /**
     * Get the value of price
     * @return the value of price
     */
    public float getPrice () {
        return price;
    }


    /**
     * Get the value of Author
     * @return the value of Author
     */
    public String getAuthor () {
        return Author;
    }


    /**
     * Get the value of isTextbook
     * @return the value of isTextbook
     */
    public boolean getIsTextbook () {
        return isTextbook;
    }



    /**
     * Get the value of quantity
     * @return the value of quantity
     */
    public int getQuantity () {
        return quantity;
    }



    /**
     * @param        numberToAdd
     */
    public void addToStock(int numberToAdd)
    {
        if (numberToAdd < 0) {
            quantity += numberToAdd;
        }
    }


    /**
     * @return       double
     * @param        numberSold
     */
    public double sellBook(int numberSold)
    {
        if (numberSold <= 0) {
            return 0;
        }
        else if (numberSold > quantity) {
            return 0;
        }
        else {
            double totalCost = numberSold * price;
            if (!isTextbook){
                totalCost += totalCost * 0.0625;
            }
            quantity -= numberSold;
            return totalCost;
        }
    }





}
