package com.auribises.java8;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Product{
	
	int productCode;
	String name;
	int price;
	
	public Product() {
		
	}
	
	public Product(int productCode, String name, int price) {
		this.productCode = productCode;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", name=" + name + ", price=" + price + "]";
	}
	
}

public class StreamAPIOOPS {

	public static void main(String[] args) {
		
		Product p1 = new Product(101, "iPhone XII", 90000);
		Product p2 = new Product(201, "Samsung LED", 70000);
		Product p3 = new Product(301, "Bosch Washing Machine", 30000);
		Product p4 = new Product(401, "Hitachi Refrigirator", 80000);
		Product p5 = new Product(501, "IFB Microwave", 9000);
		
		LinkedList<Product> products = new LinkedList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		
		/*List<Product> filteredProducts = products.stream().filter(p->p.price>30000).collect(Collectors.toList());
		System.out.println("We Got "+filteredProducts.size()+" Products");
		for(Product product : filteredProducts) {
			System.out.println(product);
		}*/
		
		products.stream().filter(p->p.price>30000).forEach(product->System.out.println(product));
		
		//int totalPrice = products.stream().collect(Collectors.summingInt(p->p.price));
		//System.out.println("Total Price for All the Products: "+totalPrice);
		
		int totalPrice = products.stream().map(p->p.price).reduce(0, (sum, price) -> sum+price);
		System.out.println("Total Price for All the Products: "+totalPrice);
		
	}

}
