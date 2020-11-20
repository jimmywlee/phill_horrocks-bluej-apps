import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Phill Horrocks 
 * @version 0.1
 */
public class StockManager
{
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
    public void takeDelivery(int id, int amount)
    {
        Product product = findProduct(id);
        
        if(product == null)
        {
            System.out.println("\n Product ID" + id + " not found! \n"); 
        }
        else
        {
            System.out.println("\n" + product);
            product.increaseQuantity(amount);
            System.out.println("    ** Re-Stocked by " + amount + " ***");
            System.out.println(product + "\n");
        }
    }
    
    /**
     * Sell the given product with matching id quantity
     * times providing there are suficient numbers in stock.
     * Otherwise sell as many as possible.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id, int quantity)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println("Selling Product: Order Quantity = " + quantity);
            printProduct(id);

            int noSold = quantity;
            if(noSold > product.getQuantity())
            {
                noSold = product.getQuantity();
            }
            
            for(int count = 0; count < noSold; count++)
            {
                product.sellOne();
            }
            
            System.out.println("  " + noSold + " items sold!\n");
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        int index = 0;
        boolean found = false;
        Product product = null;
        
        while(!found && index < stock.size())
        {
           product = stock.get(index);
           if(product.getID() == id)
           {
               found = true;
           }
           else index++;
        }
        
        return product;
    }
    
    public void searchProducts(String targetPhrase)
    {
        int count = 0;
        System.out.println("\nSearching for " + targetPhrase + "\n");
        
        for(Product product : stock)
        {
            if(product.getName().contains(targetPhrase))
            {
                System.out.println(product);
                count++;
            }
        }
        
        System.out.println("\nThere are " + count + " products containing " + 
                            targetPhrase + " in their name!\n");
    }
    
    /**
     * Print details of all the products.
     */
    public void printAllProducts()
    {
       System.out.println("\n*******************************");
       System.out.println("  Products Management System");
       System.out.println("     by Derek Peacock ");
       System.out.println("*******************************\n");
       
        for(Product product : stock)
        {
            System.out.println(product);
        }
        
        System.out.println();
    }
    
    /**
    *  Print all product with zero quantity
    */
    public ArrayList<Product> printLowStockProducts(int minimum)
    {
        ArrayList<Product> lowStock = new ArrayList<Product>();
        int count = 0;
        
        System.out.println(" Printing all out of stock products");
        System.out.println();
        
        for(Product product : stock)
        {
            if(product.getQuantity() <= minimum)
            {
                count++;
                lowStock.add(product);
                System.out.println(product);
            }
        }
        
        System.out.println();
        System.out.println("There were " + count + 
                           " stock products with less than " + minimum +
                           " items\n");
        return lowStock;
    }
    
    /**
     * Increase the quantity of stock for all products in the lowStock
     * ArrayList.
     */
    public void restockLowProducts(int minimum)
    {
       ArrayList<Product> lowStock = printLowStockProducts(minimum);
       
       System.out.println("\nRe-Stocking to a minimum level of " + 
                          minimum + "\n");
                          
       for(Product product : lowStock)
       {
          product.increaseQuantity(minimum - product.getQuantity()); 
       }
    }
    
    /**
     * If the product exists that matches the id
     * remove that product from the list.
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product == null)
        {
            System.out.println("\n Product ID " + id + " NOT FOUND!\n");
        }
        else
        {
            stock.remove(product);
            System.out.println("\n Product ID " + id + " REMOVED!\n");            
        }
    }
    
    public void renameProduct(int id, String newName)
    {
        Product product = findProduct(id);
        
        if(product == null)
        {
            System.out.println(" Product id = " + id + " not found!");
        }
        else
        {
            System.out.println(product);
            product.setName(newName);
            System.out.println("***RENAMED***");
            System.out.println(product);
        }
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product);
        }
    }    
}
