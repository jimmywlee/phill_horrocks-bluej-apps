/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Phill Horrocks
 * @version 0.8
 */
public class StockApp
{

    private InputReader reader;
    private StockManager manager;
    public final int ID_FIRST = 300; // Used for testing only
    private int nextID = ID_FIRST; // Used for testing only
    public final int MAX_SELL_AND_DELIVER = 100; // Upper limit for selling & delivery
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        manager = new StockManager();
        StockDemo demo = new StockDemo(manager); // lets add some products to test
    }

    /**
     *  Display a list of menu choices and get the user's
     *  choice. Enter 9 to exit
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            displayNumberedMenu();   
            String choice = reader.getString();
            runIntChoice(choice);
            if(choice.equals("9"))
            finished = true;
        }
    }
       
    // NOTE: would be better to select menu by numeric choice
    
    /**
     * Switch to go through the menu choices. Anything entered
     * outside these values will be ignored
     */
    private boolean runIntChoice(String choice)
    {
        switch(choice)
        {
            case "1": addProduct(); break;
            case "2": removeProduct(); break;
            case "3": manager.printAllProducts(); break;
            case "4": deliverProduct(); break;
            case "5": sellProduct(); break;
            case "6": searchProducts(); break;
            case "7": printLowStock(); break;
            case "8": restockProducts(); break;
            case "9": return true;
            
            default: System.out.println("Please selection your choice, 1-9");
        }
        return false;
    }
   
    /**
     * Add a product - first check that it does not already
     * exist
     */
    public void addProduct()
    {
        /*# Need to validate the ID does not exist */

        System.out.println("Add new product");
        System.out.println();
        
        System.out.println("Please enter the ID of the new product");
        String idNumber = reader.getString();
        int id = Integer.parseInt(idNumber);
        
        Product product = manager.findProductByID(id);

        if(product.getID() == id)
        {
            System.out.println("Error! Item already exists");
        }
        else
        {
            System.out.println("Adding new product");
            System.out.println("Please enter name of product");
            String name = reader.getString();
           
            Product newProduct = new Product(id, name);
            manager.addProduct(newProduct);
           
            System.out.println("\nYou added item ID " + newProduct + " with ID: " + id + "\n");
        }
    }
    
    /**
     * Remove a product - first check to see if it exists
     */
    private void removeProduct()
    {
        System.out.println(" Remove a product");
        System.out.println();      
        
        System.out.println("Please enter the ID of the product to remove");
        String idNumber = reader.getString();
        int id = Integer.parseInt(idNumber); // Convert string to int
        
        Product product = manager.findProductByID(id);
        if(product.getID() == id)
        {
             System.out.println("Item removed");
             manager.removeProduct(id);
        }
        else 
        {
             System.out.println("Item does not exist");
        }
                
    }
    
    /**
     * Deliver some qty of products and check to see if the
     * qty is within range. Also check to see if the product
     * exists or not
     */
    private void deliverProduct()
    {
        System.out.println(" Deliver products");
        System.out.println();
        
        System.out.println("Please enter the ID of the product to deliver");
        String idNumber = reader.getString();
        int id = Integer.parseInt(idNumber);
        
        Product product = manager.findProductByID(id);
        
        if(product.getID() == id)
        {
             System.out.println("Please enter the qty of the product to deliver");
             String receiveQty = reader.getString();
             int qty = Integer.parseInt(receiveQty);
        
             if (qty >= 1 && qty < MAX_SELL_AND_DELIVER)
             {
                 manager.receiveStock(id, qty);
             }
             else
             {
                 System.out.println("Sorry you cannot deliver that amount\n");
             }
                  
        }
        else 
        {
             System.out.println("Item does not exist");
        }
    }
    
   /**
    * Sell products and check to see if the qty is within range
    * and check to see if it exists
    */
    private void sellProduct()
    {
        System.out.println(" Sell products");
        System.out.println();
        
        System.out.println("Please enter the ID of the product to sell");
        String idNumber = reader.getString();
        int id = Integer.parseInt(idNumber);
        
        Product product = manager.findProductByID(id);
        
        if(product.getID() == id)
        {
             System.out.println("Please enter the qty of the product to sell");
             String sellQty = reader.getString();
             int qty = Integer.parseInt(sellQty);
        
             if (qty >= 1 && qty < MAX_SELL_AND_DELIVER)
             {
                 manager.sellProduct(id, qty);
             }
             else
             {
                 System.out.println("Sorry you cannot sell that amount\n");
             }
                  
        }
        else 
        {
             System.out.println("Item does not exist");
        }
        
    }
    
    /**
     * Search for products using name
     */
    private void searchProducts()
    {
        System.out.println(" Search products");
        System.out.println();
        System.out.println(" Please enter your search term: ");
        String search = reader.getString();
        
        System.out.println(" Displaying items matching " + search + "\n");
        manager.searchProducts(search);
        
    }
    
    /**
     * Print all items low in stock (2 qty)
     */
    private void printLowStock()
    {
        System.out.println(" Print low stock");
        System.out.println();
        
        manager.printLowStockProducts(2); // Low stock value set to zero        
    }
    
    /**
     * Try to replenish stock based on user entered qty
     */
    private void restockProducts()
    {
        System.out.println(" Restock Items");
        System.out.println();
        
        String prompt = ("Please enter a minumum to replenish stock: ");
        String stockQty = reader.getString();
        int qty = Integer.parseInt(stockQty);
        
        manager.restockLowProducts(qty);
    }
    
    /**
     * OPTIONAL:: Display menu of choices in numeric fashion
     */
    private void displayNumberedMenu()
    {
        System.out.println();
        System.out.println("1.   Add a new product");
        System.out.println("2.   Remove a product");
        System.out.println("3.   Print all producs");
        System.out.println("4.   Deliver products");
        System.out.println("5.   Sell products");
        System.out.println("6.   Search for a product");
        System.out.println("7.   Display items low in stock");
        System.out.println("8.   Restock products");
        System.out.println("9.   Quit the application");
        System.out.println();
    }
    
    /**
     * Command driven menu system
     */
    private void displayMenuItems()
    {
        System.out.println();
        System.out.println("    Add:        **  Add new product");
        System.out.println("    Remove:     **  Remove a product");
        System.out.println("    PrintAll    **  Print a list of products");
        System.out.println("    Deliver     **  Deliver products");
        System.out.println("    Sell        **  Sell products");
        System.out.println("    Search      **  Search for products");
        System.out.println("    LowStock    **  Show all products below minimum stock");
        System.out.println("    Restock     **  Restock low stock level items");
        System.out.println("    Quit        **  Quit the system");
        System.out.println();
    }
    
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        //System.out.println(CLEAR);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("  Stock Management Application ");
        System.out.println("    App05: by Phill Horrocks   ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
}
