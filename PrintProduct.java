/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thando
 */
  public class PrintProduct {

    private Product product;

    // Constructor - give it the Product object to print from
    public PrintProduct(Product product) {
        this.product = product;
    }

    public void PrintTotalProductSold() {
        System.out.println("Total product sales: " + product.GetTotalProductSold());
    }

    public void PrintAverageProductSold() {
        System.out.println("Average product sales: " + (int) product.GetAverageProductSold());
    }

    public void PrintMostPopularProduct() {
        System.out.println("Most popular product: " + product.GetMostPopularProduct());
    }

    // Helper to print the whole report at once
    public void PrintReport() {
        System.out.println("Product sale report - 2026");
        System.out.println("--------------------------");
        PrintTotalProductSold();
        PrintAverageProductSold();
        PrintMostPopularProduct();
    }
}  

