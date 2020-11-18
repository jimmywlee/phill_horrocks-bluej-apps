import java.util.ArrayList;
import java.util.Date;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Derek Peacock 
 * @version 06/11/2020
 * @modified by Phill Horrocks
 */
public class StockManager
{
    Date date = new Date(); // This object contains the current date value
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void deliverProduct(int id, int qty)
    {
        Product product = findProduct(id);
        if(product !=null)
        {
            product.increaseQuantity(qty);
            System.out.println("Delivered: " + product);
        }
        else
        {
            System.out.println("** PRODUCT ID: " + id +" NOT FOUND **");
        }
        
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for (Product product : stock)
        {
            if(product.getID() == id)
            {
                return product;
            }
        }
        System.out.println("Product not found");
        return null;
    }
    
    /**
     * Try to find a prouct by its name
     */
    public Product findByKeyword(String productName)
    {
        for (Product product : stock)
        {
            if (product.getName().contains(productName))
            {
                return product;
            }
            else
            {
                System.out.println("** PRODUCT NOT FOUND **");
            }
        }
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void demoSellProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println("Current stock: ");
            printProduct(id);
            product.sellOne();
            System.out.println("New stock: ");
            printProduct(id);
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void printAllProducts()
    {
        System.out.println();
        System.out.println("Current Stock - correct as at: " + date);
        System.out.println();
        System.out.println("Phill Horrocks' Stock List");
        System.out.println("=*==*==*==*==*==*==*==*==*");
        System.out.println();
        
        for(Product product : stock)
        {
            System.out.println(product.toString());
        }
        System.out.println();
    }
}
