package com.auribises.java8;

import java.util.Comparator;
import java.util.LinkedList;

class Product{
	
	String name;
	int price;
	
	Product(){
		
	}
	
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
}

class PriceComaparator implements Comparator<Product>{
	@Override
	public int compare(Product o1, Product o2) {
		if(o1.price == o2.price) {
			return 0;
		}else if(o1.price > o2.price) {
			return 1;
		}else {
			return -1;
		}
	}
}

public class LambdaComparator {

	public static void main(String[] args) {

		LinkedList<Product> products = new LinkedList<Product>();
		products.add(new Product("Samsung LED", 70000));
		products.add(new Product("VIVO Phone", 12000));
		products.add(new Product("Adidas Alphabounce", 6000));
		products.add(new Product("Apple iPhoneX", 60000));
		products.add(new Product("Hitachi Fridge", 54000));
		
		System.out.println("Original Product List");	
		products.forEach((product)->System.out.println(product));
		
		System.out.println();
		
		// Anonymous Class
		/*Comparator<Product> comparator = new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				if(o1.price == o2.price) {
					return 0;
				}else if(o1.price > o2.price) {
					return 1;
				}else {
					return -1;
				}
			}
		};*/
		
		// Lambda Expression
		
		/*Comparator<Product> comparator = (o1, o2) -> {
			if(o1.price == o2.price) {
				return 0;
			}else if(o1.price > o2.price) {
				return 1;
			}else {
				return -1;
			}
		};
				
				
		//products.sort(new PriceComaparator());
		products.sort(comparator);*/
		
		// Rather, we pass Lambda Expression directly into sort function
		products.sort(
				(o1, o2) -> {
					if(o1.price == o2.price) {
						return 0;
					}else if(o1.price > o2.price) {
						return 1;
					}else {
						return -1;
					}
				}
		);
		
		System.out.println("Sorted Product List");
		products.forEach((product)->System.out.println(product));
		
	}

}
