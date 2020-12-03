import java.util.ArrayList;
import java.util.Date;

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
    private Date date = new Date();

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
    public void receiveStock(int id, int amount)
    {
        Product product = findProductByID(id);
        
        if(product == null)
        {
            System.out.println();
            System.out.println("Product ID " + id + " not found"); 
            System.out.println();
        }
        else
        {
            System.out.println();
            System.out.println("Current stock for: "+product);
            product.increaseQuantity(amount);
            System.out.println("=-= Re-Stocked by " + amount + " =-=");
            System.out.println("New stock for:" +product);
            System.out.println();
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
        Product product = findProductByID(id);
        
        if(product != null) 
        {
            //System.out.println("Selling Product: Order Quantity = " + quantity);
            printProduct(id);

            int numberSold = quantity;
            if(numberSold > product.getQty())
            {
                numberSold = product.getQty();
            }
            
            for(int count = 0; count < numberSold; count++)
            {
                product.sellItem();
            }
            
            System.out.println("### " + numberSold + " products sold");
            System.out.println();
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     * with a matching ID.
     */
    public Product findProductByID(int id)
    {
        int index = 0;
        Product product = null;
        boolean found = false;
        
        // while-loop better than for
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
    
    /**
     * Search for a product using text. Show items plus number of items found.
     */
    public void searchProducts(String searchText)
    {
        int counter = 0;
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Searching for " + searchText + "");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println();
        
        for(Product product : stock)
        {
            if(product.getName().contains(searchText))
            {
                System.out.println(product);
                counter++;
            }
        }
        
        System.out.println();
        System.out.println(counter + " products contain " + searchText + " in their title");
        System.out.println();
    }
    
    /**
     * Print details of all the products.
     */
    public void printAllProducts()
    {
       System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
       System.out.println("=-= The Horrocks Stock System =-=");
       System.out.println("=-=       *** BASIC ***       =-=");
       System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
       
        for(Product product : stock)
        {
            System.out.println(product);
        }
        
        System.out.println();
    }
    
    /**
    *  Display all products out of stock
    */
    public ArrayList<Product> printLowStockProducts(int minimum)
    {
        ArrayList<Product> lowStock = new ArrayList<Product>();
        int count = 0;
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("=-= All products low in stock =-=");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        
        for(Product product : stock)
        {
            if(product.getQty() <= minimum)
            {
                count++;
                
                lowStock.add(product);
                System.out.println(product);
            }
        }
        
        System.out.println();
        System.out.println("There are currently " + count + " items with less than " + minimum + " in stock\n");
        return lowStock;
    }
    
    /**
     * Increase the quantity of stock for all products in the lowStock
     * ArrayList.
     */
    public void restockLowProducts(int minimum)
    {
       ArrayList<Product> lowStock = printLowStockProducts(minimum);
       
       System.out.println();
       System.out.println("Restock to a minimum level of " + minimum);
       System.out.println();
                          
       for(Product product : lowStock)
       {
          product.increaseQuantity(minimum - product.getQty()); 
       }
    }
    
    /**
     * If the product exists that matches the id
     * remove that product from the list.
     */
    public void removeProduct(int id)
    {
        Product product = findProductByID(id);
        
        if(product == null)
        {
            System.out.println();
            System.out.println("### Product ID " + id + " not found - please try again");
            System.out.println();
        }
        else
        {
            stock.remove(product);
            System.out.println("### Product ID " + id + " removed");
            System.out.println();
        }
    }
    
    /**
     * Rename a product by ID and display error if ID not found
     */
    public void renameProduct(int id, String newName)
    {
        Product product = findProductByID(id);
        
        if(product == null)
        {
            System.out.println(" Product ID: " + id + " not found, please try again.");
        }
        else
        {
            System.out.println(product);
            product.setName(newName);
            System.out.println("=-= Item Renamed =-=");
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
        Product product = findProductByID(id);
        
        if(product != null) 
        {
            System.out.println(product);
        }
    }    
}
