/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Thando
 */

public class ProductTest {

    // Same valid data from Q1.1 / Q1.2 / Q1.3
    // Cozy: 25, 18, 20 = 63
    // Restonic: 15, 10, 12 = 37
    // Sealy: 18, 15, 20 = 53
    // Total = 153, Average = 153 / 9 = 17
    private int[][] validSales = {
        {25, 18, 20},
        {15, 10, 12},
        {18, 15, 20}
    };

    @Test
    public void GetTotalProductSaleWithValidData_ReturnsCorrectValue() {
        // Arrange
        Product product = new Product(validSales);
        int expected = 153;

        // Act
        int actual = product.GetTotalProductSold();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        // Arrange
        Product product = new Product(validSales);
        double expected = 17.0;

        // Act
        double actual = product.GetAverageProductSold();

        // Assert
        assertEquals(expected, actual, 0.001);
    }
}