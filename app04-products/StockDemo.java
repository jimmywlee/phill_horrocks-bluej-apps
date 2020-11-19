// Use to setup the random number generator for the stock workings
import java.util.Random;

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * Modified by Phill Horrocks
 * Version 2020.11.06
 */
public class StockDemo
{
    // Setup the limits for the 10 demo products
    public static final int FIRST_ITEM_ID = 101;
    public static final int LAST_ITEM_ID = 110;
    
    // The stock manager.
    private StockManager manager;
    private Random random;

    /**
     * Create a StockManager and populate it with ten
     * products.
     * NOTE: Need to work on this to enable any number of products
     * use counter?
     * 
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        
        random = new Random();
        int id = FIRST_ITEM_ID;
        manager.addProduct(new Product(id, "Samsung Galaxy S20"));
        id++;
        manager.addProduct(new Product(id, "Samsung Galaxy S10 5G"));
        id++;
        manager.addProduct(new Product(id, "Google Pixel 5"));
        id++;
        manager.addProduct(new Product(id, "Google Pixel 4A"));
        id++;
        manager.addProduct(new Product(id, "OnePlus 1"));
        id++;
        manager.addProduct(new Product(id, "Huawei Big Phone 3"));
        id++;
        manager.addProduct(new Product(id, "Apple iPhone 12 Mini"));
        id++;
        manager.addProduct(new Product(id, "Apple iPhone 12"));
        id++;
        manager.addProduct(new Product(id, "Aple iPhone 12 Pro"));
        id++;
        manager.addProduct(new Product(id, "Apple iPhone 12 Pro Max"));        
    }   
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    private void demoDeliverProducts()
    {
        for(int id = FIRST_ITEM_ID; id <= LAST_ITEM_ID; id++)
        {
            int qty = random.nextInt(5) + 1;
            manager.receiveProduct(id, qty);
        }
    }
      
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        
        if(product == null) 
        {
            System.out.println("Product with ID: " + id + " is not recognised.");
        }
        return product;
    }
    
    /**
     * Sell multiple items
     */
    private void demoSellProducts()
    {
        manager.printAllProducts();
        for(int id = FIRST_ITEM_ID; id <=  LAST_ITEM_ID; id++)
        {
            int qty=random.nextInt(4) + 1;
            manager.sellMultipleItems(id, qty);
        }
        manager.printAllProducts();
    }
    
    /**
     * Demo test creation
     * 
     */
    
    public void createDemo()
    {
        // Display details of all the products
        manager.printAllProducts();
        
        // Deliver sample products and print
        demoDeliverProducts();
        manager.printAllProducts();
        
        // Sell multiple items
        demoSellProducts();
        
        // rename an incorrectly spelled product
        manager.renameProduct(108, "Apple iPhone 12 Pro");
        
        // Remove a product from the list
        manager.removeProduct(105);
        
        // Search for all products containing a keyword
        manager.findByKeyword("Google");
        
        // Print all product details
        manager.printAllProducts();
        
        // Show items low on stock
        manager.printLowStockProducts(2);
    }
    
}