/**
 * 
 */
package com.example.ecommerce.common;

import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.model.Product;

/**
 * @author pmonthei
 *
 */
public class GlobalData {
	public static List<Product> cart;
	
	static {
		cart = new ArrayList<Product>();
	}
}
