import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomerManager {

    // CopyOnWriteArrayList is used to protect the collection
	// private List<Customer> customers2 = new CopyOnWriteArrayList<Customer>();
	
	// Collectins.synchronizedList is used to protect the collection
	private List<Customer> customers = Collections.synchronizedList(new ArrayList<Customer>());
	private int nextId = 0;

	public void addCustomer(Customer customer) {
		synchronized (this) {
			customer.setId(nextId);
			nextId++;
		}
		// CopyOnWriteArrayList is used to protect the collection
		customers.add(customer);
	}

	public void howManyCustomers() {
		int size = 0;

	
		size = customers.size();
		System.out.println("" + new Date() + " : " + size + " customers created");
	}

	public void displayCustomers() {

		synchronized (this) {
			for (Customer c : customers) {
				System.out.println(c.toString());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
