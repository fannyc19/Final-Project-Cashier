import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;

public class Calculate {
    double total = 0;
    double milkPrice = 4.4;
    double breadPrice = 2.5;
    double waterPrice = 1.5;
    double shampooPrice = 6.69;
    double ramenPrice = 1.50;
    public void calculateCost(TextField milk, TextField bread, TextField water,
                              TextField shampoo, TextField ramen, Labeled totalCol,
                              double[] newTotal) {
        int milkAmt = Integer.parseInt(milk.getText());
        total += milkAmt * milkPrice;
        int breadAmt = Integer.parseInt(bread.getText());
        total += breadAmt * breadPrice;
        int waterAmt = Integer.parseInt(water.getText());
        total += waterAmt * waterPrice;
        int shampooAmt = Integer.parseInt(shampoo.getText());
        total += shampooAmt * shampooPrice;
        int ramenAmt = Integer.parseInt(ramen.getText());
        total += ramenAmt * ramenPrice;
        total = Math.round(total * 100.0) / 100.0;
        newTotal[0] = total;
        String price = newTotal[0] + "";
        totalCol.setText("Total: $" + price);
    }
}
