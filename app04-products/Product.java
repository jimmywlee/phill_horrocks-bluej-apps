/**
 * Model some details of a product sold by a company.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * @Modified by Phill Horrocks
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @return The product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The quantity in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * @return The id, name and quantity in stock.
     */
    public String toString()
    {
        return id + ": " +  name + " stock level: " + quantity;
    }

    /**
     * Change item name
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void increaseQuantity(int qty)
    {
        if(qty > 0) 
        {
            quantity += qty;
        }
        else 
        {
            // System.out.println("Attempt to restock " + name + " with a non-positive amount: " + qty);
            System.out.println("Cannot re-stock with 0 qty");
        }
    }

    /**
     * Sell one of these products.
     * An error is reported if there appears to be no stock.
     */
    public boolean sellOne()
    {
        if(quantity > 0) 
        {
            quantity--;
            return true;
        }
        else 
        {
            System.out.println(
                "Attempting to sell an out of stock item: " + name);
                return false;
        }
    }
}
