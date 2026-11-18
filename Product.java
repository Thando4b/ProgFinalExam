/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thando
 */
public class Product implements IProduct {

    private String[] products = {
        "Cozy Night Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };

    private int[][] sales;

    public Product(int[][] sales) {
        this.sales = sales;
    }

    @Override
    public int GetTotalProductSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        return (double) GetTotalProductSold() / 9;
    }

    @Override
    public String GetMostPopularProduct() {
        int bestIndex = 0;
        int highest = 0;
        for (int i = 0; i < sales.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < sales[i].length; j++) {
                productTotal += sales[i][j];
            }
            if (productTotal > highest) {
                highest = productTotal;
                bestIndex = i;
            }
        }
        return products[bestIndex] + " (" + highest + ")";
    }
}
    

