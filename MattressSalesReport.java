/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mattresssalesreport;
import java.util.Scanner;


public class MattressSalesReport {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] productNames = {
            "Cozy Night Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int[][] sales = new int[3][3];

        // 1. INPUT
        for (int i = 0; i < productNames.length; i++) {
            System.out.println("Enter number of sales for " + productNames[i] + " mattress:");
            for (int j = 0; j < 3; j++) {
                System.out.print("For month " + (j + 1) + ": ");
                sales[i][j] = input.nextInt();
            }
            System.out.println();
        }

        // 2. USE PRODUCT CLASS
        Product product = new Product(sales);

        // 3. DISPLAY
        System.out.println("Product sale report - 2026");
        System.out.println("--------------------------");
        System.out.println("Total product sales: " + product.GetTotalProductSold());
        System.out.println("Average product sales: " + (int) product.GetAverageProductSold());
        System.out.println("Most popular product: " + product.GetMostPopularProduct());

        input.close();
    }
}
