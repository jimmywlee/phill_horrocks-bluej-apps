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
    
    // Array list of all the products
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
     * Remove a product
     * NOTE: check to see if the item exists first!
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        if(product == null)
        {
            System.out.println("ID: "+id+" not found");
        }
        else
        {
            stock.remove(product);
            System.out.println("ID: "+id+" found and removed");
        }
        
    }
    
    /**
     * Rename a product
     * Check it exsists first, if not, throw an error
     */
    public void renameProduct(int id, String newItemName)
    {
        Product product = findProduct(id);
        if(product == null)
        {
            System.out.println("ID: "+id+" not found, please try again");
        }
        else
        {
            System.out.println(product);
            System.out.println("Item renamed ");
            product.setName(newItemName);
            
            System.out.println(newItemName);
            System.out.println(product);
        }

    }
    
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * Check product exists- if yes then deliver, else throw error.
     */
    public void receiveProduct(int id, int qty)
    {
        Product product = findProduct(id);
        if(product !=null)
        {
            System.out.println("\n" + product);
            product.increaseQuantity(qty);
            System.out.println("\t## DELIVERED " + qty + "##");
            System.out.println(product + "\n");
        }
        else
        {
            System.out.println("** PRODUCT ID: " + id +" NOT FOUND **");
        }
        
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     * with a matching ID.
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
     * Try to find a prouct by its name or part of its name.
     * Loop through all items in the array.
     */
    public void findByKeyword(String searchText)
    {
        int counter = 0;
        System.out.println();
        System.out.println("Finding " + searchText + " in product list...");
        
        for (Product product : stock)
        {
            if (product.getName().contains(searchText))
            {
                System.out.println(product);
                counter++;
            }
        }
        
        System.out.println();
        System.out.println("Number of items found: "+ counter + " with '"+searchText+"' in the product name");
        System.out.println();
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
     * Sell multiple products
     */
    public void sellMultipleItems(int id, int qty)
    {
        Product product = findProduct(id);
        if(product != null)
        {
            System.out.println("Sold qty: "+qty);
            printProduct(id);
            int qtySold = qty;
            if(qtySold > product.getQuantity())
            {
                qtySold=product.getQuantity();
            }
            for(int counter = 0; counter < qtySold; counter++)
            {
                product.sellOne();
            }
            //System.out.println("Number sold: " + qtySold);
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void printAllProducts()
    {
        System.out.println();
        System.out.println("Current Stock");
        System.out.println(date);
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
    
    /**
     * Show item details
     */
    
    public void printProcuct(int id)
    {
        Product product = findProduct(id);
        if(product != null)
        {
            System.out.println(product);
        }
        else 
        {
            System.out.println("Error");
        }
        
    }
    
        /**
    *  Print all product with low quantity
    */
    public ArrayList<Product> printLowStockProducts(int minimum)
    {
        ArrayList<Product> lowStock = new ArrayList<Product>();
        int count = 0;
        
        System.out.println(" Printing all low stock products");
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
        System.out.println("There were " + count + " stock products with less than " + minimum + " items\n");
        return lowStock;
    }
    
}
