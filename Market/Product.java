import java.util.*;
class Product {
	int id;
	String name;
	int price;
	Product ( int id, String name, int price ) {
		this.id = id;
		this.name = name;
		if ( price > 0 )
			this.price = price;
		else this.price = 0;
	}
	static Product findMin ( ArrayList<Product> list ) {
		Product p = null;
		int minPrice = 10000000;
		for ( Product i : list ) {
			if ( i.price < minPrice ) {
				minPrice = i.price;
				p = i;
			}
		}
		return p;
	}
	public String toString () {
		String message = "Name : " + name + " Price "+ price;
		return message;
	}
	public static void main (	 String args[] ) {
		ArrayList <Product> list = new ArrayList<>();
		list.add(new Product(1, "Bread", 50));
		list.add(new Product(2, "Ice Cream", 100));
		list.add(new Product(3, "Honey", 150));
		System.out.println(list.get(0));
		System.out.println(findMin(list));		
	}
}