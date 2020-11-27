import java.util.Random;

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * 
 * @modifed by Derek Peacock
 * 22/Sep/2020
 * 
 * Modified by Phill Horrocks
 * Version 0.1
 */
public class StockDemo
{
    public static final int FIRST_ITEM_ID = 101;
    public static final int LAST_ITEM_ID = 110;
    
    // The stock manager.
    private StockManager manager;
    
    // Setup the random numbers for selling and delivery
    private Random rnd;

    /**
     * Create a StockManager with 10 products.
     */
    public StockDemo(StockManager manager)
    {
        rnd = new Random(); // esnure we have access to random numbers for selling and delivery
        
        this.manager = manager;
        
        int id = FIRST_ITEM_ID; // 101
        manager.addProduct(new Product(id,"Samsung Galaxy S10 5G"));
        
        id++; // 102
        manager.addProduct(new Product(id,"Samsung Galaxy NOTE 20"));
        
        id++; // 103
        manager.addProduct(new Product(id,"Samsung Galaxy S20"));
        
        id++; // 104
        manager.addProduct(new Product(id,"Gogle Pixel 5"));
        
        id++; // 105
        manager.addProduct(new Product(id,"Xiami Redmi 9A"));
        
        id++; // 106
        manager.addProduct(new Product(id,"Xiaomi Mi 10 Lite"));
        
        id++; // 107
        manager.addProduct(new Product(id,"Poco F2 Pro"));
        
        id++; // 108
        manager.addProduct(new Product(id,"Poco M3"));
        
        id++; // 109
        manager.addProduct(new Product(id,"Apple iPhone 11 Pro Max"));
        
        id++; // 110
        manager.addProduct(new Product(id,"Apple iPhone SE"));
    }
    
    /**
     * Run all the methods necessary to show the program works, in sequence.
     */
    public void executeDemo()
    {
       // Print all current products and stock
       manager.printAllProducts();
       
       // Deliver random qty of stock
       demoDeliverProducts();
       
       // Display all the stock after delivery
       manager.printAllProducts();
       
       // Sell random qty of products
       demoSellProducts();
       
       // Display all the stock after selling
       manager.printAllProducts();
       
       // Remove a product from the array
       manager.removeProduct(109);
       
       // Correct mis-spelled stock item
       manager.renameProduct(105, "Xiaomi Redmi 9A");
       
       // Search the product list by text matching 'Samsung'
       manager.searchProducts("Samsung");
    }
    
    /**
     * Show the StockManager can accept random delivery quantities
     */
    private void demoDeliverProducts()
    {
       for(int id = FIRST_ITEM_ID; id < LAST_ITEM_ID; id++)
       {
           int quantity = rnd.nextInt(10) + 1; // random qty between 1 & 10 -- ensure at least 1
           manager.receiveStock(id, quantity);
       }
    }
   
    /**
     * Show that the StockManager can sell random quantities of all of the products
     * 
     */
    private void demoSellProducts()
    {
        // manager.printAllProducts();
        
        for(int id = FIRST_ITEM_ID; id < LAST_ITEM_ID; id++ )
        {
            int quantity = rnd.nextInt(6) + 1;
            manager.sellProduct(id, quantity);
        }
        
        manager.printAllProducts();
    }
}
