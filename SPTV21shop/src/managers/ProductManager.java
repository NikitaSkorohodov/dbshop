/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;
import java.util.Scanner;

import enyity.Product;
import java.util.List;

/**
 *
 * @author NikitaSkr
 */

public class ProductManager {
 private final Scanner scanner;
    public ProductManager() {
    scanner = new Scanner(System.in);       
    }
    
    public void printListProducts(List<Product> products){
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i+1+". "+products.get(i).getProdName()+". количество "+products.get(i).getQuantity()+". цена "+"$"+products.get(i).getPrice());
        }

    }
    public List<Product> changeProduct(List<Product> products) {
        int numProductForEdit = scanner.nextInt(); 
                products.get(numProductForEdit - 1).setQuantity(scanner.nextInt());
     return products;
        }

    
}

