import java.util.*;

public class ShoppingCart implements Cart {

   ArrayList<SelectedItem> ShoppingCart = new ArrayList<SelectedItem>();
   SelectedItem tempItem;
   double total; 	
   double tax;
   double shipping;
   double grandTotal;
 
   
    	public void addItem(SelectedItem newItem) {
    		
    		int newItemNumber = newItem.getItemNumber();
    		int newItemQuantity = newItem.getQuantity();
    		boolean deleteItem = false;
    		
    		for (int i=0; i<ShoppingCart.size(); i++) {
    			if (newItemNumber == ShoppingCart.get(i).getItemNumber()) {
    				int NewQuantity = ShoppingCart.get(i).getQuantity() + newItemQuantity;
    				ShoppingCart.get(i).setQuantity(NewQuantity);
    				deleteItem = true;
    				
    				}    
    				
    			
    			}
    		
    		
    		ShoppingCart.add(newItem);
    		if (deleteItem) {
    			ShoppingCart.remove(newItem);
    		}
    	}
    	
    	public void deleteItem(int deleteItemNumber) {
    		int remove = deleteItemNumber - 1;
    		ShoppingCart.remove(remove);
    	}
    	
    	public double calculateTotal() {
    		double total = 0;
    		for (int i=0; i<ShoppingCart.size(); i++) {
    			total = total + ShoppingCart.get(i).getUnitPrice() * ShoppingCart.get(i).getQuantity();
    			
    		}
    		this.total = total;
    		return total;
    	}
    	
    	public double getTotal() {
    		return total;
    	}
    	
    	public double calculateTax() {
    		double tax = 0.045;
    		tax = getTotal() * tax;
    		this.tax = tax;
    		return tax;
    		
    	}
    	
    	public double getTax() {
    		return tax;
    	}
    	
    	public double calculateShipping() {
    		double shipping;
    		if (getTotal() <= 10) {
    			shipping = 2.50;
    		} else {
    			shipping = getTotal() * 0.015; 
    		}
    		this.shipping = shipping;
    		return shipping;
    	}
    	
    	public double getShipping() {
    		return shipping;
    	}
    	public double calculateGrandTotal() {
    		double grandTotal;
    		grandTotal = getTotal() + getTax() + getShipping();
    		this.grandTotal = grandTotal;
    		return grandTotal;
    	}
    	
    	public double getGrandTotal() {
    		return grandTotal;
    	}
    	
    	public String toString() {
    		String string = "";
    		for (int i = 0; i < ShoppingCart.size(); i++) {
    			System.out.println("Item: " + ShoppingCart.get(i).getDescription());
    			System.out.println("Quantity: " + ShoppingCart.get(i).getQuantity());
    			System.out.println("Unit Price " + ShoppingCart.get(i).getUnitPrice());
    			System.out.println("Total Price: " + ShoppingCart.get(i).getUnitPrice() * ShoppingCart.get(i).getQuantity());
    			System.out.println("");
    		}
    		calculateTotal();
    		System.out.println("Total: " + getTotal());
    		calculateTax();
    		System.out.println("Tax: " + getTax());
    		calculateShipping();
    		System.out.println("Shipping: " + getShipping());
    		calculateGrandTotal();
    		System.out.println("GRAND TOTAL: " + getGrandTotal());
    		return string;
    	}
    	
    }


