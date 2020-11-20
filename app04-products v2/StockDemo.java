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
    public static final int FIRST_ID = 101;
    public static final int LAST_ID = 110;
    
    // The stock manager.
    private StockManager manager;
    
    private Random randomGenerator;

    /**
     * Create a StockManager and populate it with
     * 10 sample products.
     */
    public StockDemo(StockManager manager)
    {
        randomGenerator = new Random();
        this.manager = manager;
        
        int id = FIRST_ID;
        manager.addProduct(new Product(id,"Apple iPhone 11"));
        
        id++;
        manager.addProduct(new Product(id,"Samsung Galaxy S10"));
        
        id++; 
        manager.addProduct(new Product(id,"Samsung Galaxy S20"));
        
        id++; 
        manager.addProduct(new Product(id,"Gogle Pixel 4A"));
        
        id++; 
        manager.addProduct(new Product(id,"Motorola G8 Power Lite"));
        
        id++; 
        manager.addProduct(new Product(id,"Motorola G8 Power"));
        
        id++; 
        manager.addProduct(new Product(id,"Huawei Mate 30 Pro"));
        
        id++; 
        manager.addProduct(new Product(id,"Huawei Mate Xs 5G"));
        
        id++; 
        manager.addProduct(new Product(id,"Sony Xperia 5"));
        
        id++; 
        manager.addProduct(new Product(id,"Apple iPhone 12"));
    }
    
    public void runDemo()
    {
       manager.printAllProducts();
       demoDeliverProducts();
       manager.printAllProducts();
       demoSellProducts();
       manager.printAllProducts();
       
       manager.removeProduct(102);
       
       manager.renameProduct(103, "Google Pixel 4A");
       
       manager.searchProducts("Apple");
    }
    
    private void demoDeliverProducts()
    {
       for(int id = FIRST_ID; id < LAST_ID; id++)
       {
           int quantity = randomGenerator.nextInt(6) + 1;
           manager.takeDelivery(id, quantity);
       }
    }
   
   
    /**
     * Demonstrate that the StockManager can sell all
     * different quantities of all of the products
     */
    private void demoSellProducts()
    {
        manager.printAllProducts();
        
        for(int id = FIRST_ID; id < LAST_ID; id++ )
        {
            int quantity = randomGenerator.nextInt(6) + 1;
            manager.sellProduct(id, quantity);
        }
        
        manager.printAllProducts();
    }
}
