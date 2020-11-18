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
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with ten
     * products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        manager.addProduct(new Product(101, "Samsung Galaxy S20"));
        manager.addProduct(new Product(102, "Samsung Galaxy S10 5G"));
        manager.addProduct(new Product(103, "Google Pixel 5"));
        manager.addProduct(new Product(104, "Google Pixel 4A"));
        manager.addProduct(new Product(105, "OnePlus 1"));
        manager.addProduct(new Product(106, "Huawei Big Phone 3"));
        manager.addProduct(new Product(107, "Apple iPhone 12 Mini"));
        manager.addProduct(new Product(108, "Apple iPhone 12"));
        manager.addProduct(new Product(109, "Apple iPhone 12 Pro"));
        manager.addProduct(new Product(110, "Apple iPhone 12 Pro Max"));        
    }
        
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    private void demoDeliverProducts()
    {
        for(int id = 101; id < 110; id++)
        {
            manager.deliverProduct(id,10);
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
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }
    
    /**
     * Demo test creation
     * 
     */
    
    public void createDemo()
    {
        // Display details of all the products
        manager.printAllProducts();   
        
        System.out.println("DELIVER 10 PRODUCTS");
        System.out.println("-------------------");
        System.out.println();
        
        // Deliver 10 lines of products
        demoDeliverProducts();
        
        // Print all product details
        manager.printAllProducts();
        
        
    }
    
}