/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cash.register.mini.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;


/**
 *
 * @author shah1932
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label candleLbl, pencilsLbl, iCLbl, bananaLbl, totalLbl, returnTotalLbl, givenLbl, moneyLbl, taxLbl, subtotalLbl, hundDolLbl, fiftyDolLbl, twentyDolLbl, tenDolLbl, fiveDolLbl, dollarLbl, pennyLbl, dimeLbl, nickelLbl, quarterLbl;
    private int candleNum, pencilNum, iceCreamNum, bananasNum;//These integers are used to keep track of how many of each product the customer wants to buy
    private double total, taxPerc, subTotal;//Used to keep track of the total bill, tax, and subtotal
    private double canTot,penTot,iCTot, banTot;//This is for the total of each product that can be added to the total
    private double canPrice, penPrice, iCPrice, banPrice;
    private double givenMon, returnMon; //These are used to handle money for the customer
    private static final double penVal = 0.01, nickVal = 0.05, dimeVal = 0.1, quartVal = 0.25;//This is the final values of all the coins
    private static final double dolVal = 1.00, fiveVal = 5.00, tenVal = 10.00, twentVal = 20.00, fiftyVal = 50.00, hundVal = 100.00;//These variables are constant to keep track of each bill value
    @FXML
    private void initialize(ActionEvent event) {
         //This method should initalize the prices
        canPrice= Math.round(Math.random()*3.50)+2.75;
        penPrice= Math.round(Math.random()*2.50)+2.25;
        iCPrice= Math.round(Math.random()*5.50)+1.35;
        banPrice= Math.round(Math.random()*2.50)+2.25;
//        System.out.println(canPrice);
        candleLbl.setText("$" + Double.toString(canPrice));
        pencilsLbl.setText("$" + Double.toString(penPrice));
        iCLbl.setText("$" + Double.toString(iCPrice));
        bananaLbl.setText("$" + Double.toString(banPrice));
    }
//    
    @FXML
    private void onclickCandle(ActionEvent event) {
         //This method should ask the customer how many candles they want to buy
        //That number should be multiplied by the price and added to the total
        candleNum = Integer.parseInt(JOptionPane.showInputDialog("How many candles do you want"));
        candlePrice();
        subtotalLbl.setText(Double.toString(subTotal));
    }
    public double candlePrice(){
        canTot = canPrice * candleNum;
        subTotal=subTotal + canTot;
        return subTotal;   
    }
    @FXML
    private void onclickPencils(ActionEvent event) {
        //This method should ask the customer how many pencils they want to buy
        //That number should be multiplied by the price and added to the total
        pencilNum = Integer.parseInt(JOptionPane.showInputDialog("How many pencils do you want"));
        pencilsPrice();
        subtotalLbl.setText(Double.toString(subTotal));
    }
    public double pencilsPrice(){
        penTot = penPrice * pencilNum;
        subTotal=subTotal+penTot;
        return subTotal;   
    }
    @FXML
    private void onclickIceCream(ActionEvent event) {
        //This method should ask the customer how much ice cream they want to buy
        //That number should be multiplied by the price and added to the total
        iceCreamNum = Integer.parseInt(JOptionPane.showInputDialog("How much Ice Cream do you want"));
        iCPrice();
        subtotalLbl.setText(Double.toString(subTotal));
    }
    public double iCPrice(){
        iCTot = iCPrice * iceCreamNum;
        subTotal=subTotal+iCTot;
        return subTotal;   
    }
    @FXML
    private void onclickBananas(ActionEvent event) {
        //This method should ask the customer how many bananas they want to buy
        //That number should be multiplied by the price and added to the total
        bananasNum = Integer.parseInt(JOptionPane.showInputDialog("How many bananas do you want"));
        bananasPrice();
        subtotalLbl.setText(Double.toString(subTotal));
    }
    public double bananasPrice(){
        banTot = banPrice * bananasNum;
        subTotal=subTotal+banTot;
        return subTotal;   
    }
    @FXML
    private void onclickCal(ActionEvent event) {
        //This method will calculate the tax and subtotal and print those out nicely in labels
        taxPerc = (Math.round(.0775 * subTotal)*100.0)/100.0;
        taxLbl.setText(Double.toString(taxPerc));
        total = taxPerc + subTotal;
        totalLbl.setText(Double.toString(total));
    }
    private int ones, fives, tens,twenties, fifties, hundreds, pennies, nickels, dimes, quarters;//These will handle how many of each is needed to pay babck the customer

    @FXML

    private void onclickPay(ActionEvent event) {
        //This method will ask the customer how much money they will be giving to pay for their bill
        //This method will call an accessor that will return how many ones,tens, twenties, etc. Need to be given back
        givenMon = Double.parseDouble(JOptionPane.showInputDialog("How much money are you paying with"));            
        if(givenMon < subTotal){
            moneyLbl.setText("You need to give more money");
        }else{
            moneyLbl.setText(" ");
        givenLbl.setText(Double.toString(givenMon));
        returnMon = (Math.round(givenMon - subTotal)*100)/100.0;
        returnTotalLbl.setText(Double.toString(returnMon));
        hundreds = (int)(returnMon/hundVal);
        returnMon = returnMon%hundVal;
        hundDolLbl.setText(Integer.toString(hundreds));
        fifties = (int)(returnMon/fiftyVal);
        returnMon = returnMon%fiftyVal;
        fiftyDolLbl.setText(Integer.toString(fifties));
        twenties = (int)(returnMon/twentVal);
        returnMon = returnMon%twentVal;
        twentyDolLbl.setText(Integer.toString(twenties));
        tens = (int)(returnMon/tenVal);
        returnMon = returnMon%tenVal;
        tenDolLbl.setText(Integer.toString(tens));
        fives = (int)(returnMon/fiveVal);
        returnMon = returnMon%fiveVal;
        fiveDolLbl.setText(Integer.toString(fives));
        ones = (int)(returnMon/dolVal);
        returnMon = returnMon%dolVal;
        dollarLbl.setText(Integer.toString(ones));
        quarters = (int)(returnMon/quartVal);
        returnMon = returnMon%quartVal;
        quarterLbl.setText(Integer.toString(quarters));
        dimes = (int)(returnMon/dimeVal);
        returnMon = returnMon%dimeVal;
        dimeLbl.setText(Integer.toString(dimes));
        nickels = (int)(returnMon/nickVal);
        returnMon = returnMon%nickVal;
        nickelLbl.setText(Integer.toString(nickels));
        pennies = (int)(returnMon/penVal);
        returnMon = returnMon%penVal;
        pennyLbl.setText(Integer.toString(pennies));
        }
    }
    @FXML
    private void onclickNewCust(ActionEvent event) {
        //This method will reset the total, tax, subtotal, and the amount of bills. 
        total=0;
        totalLbl.setText("");
        taxPerc=0;
        taxLbl.setText("");
        subTotal=0;
        subtotalLbl.setText("");
        givenMon=0;
        givenLbl.setText("");
        returnMon=0;
        returnTotalLbl.setText("");
        hundreds=0;
        fifties=0;
        twenties=0;
        tens=0;
        fives=0;
        ones=0;
        quarters=0;
        dimes=0;
        nickels=0;
        pennies=0;
        hundDolLbl.setText("");
        fiftyDolLbl.setText("");
        twentyDolLbl.setText("");
        tenDolLbl.setText("");
        fiveDolLbl.setText("");
        dollarLbl.setText("");
        quarterLbl.setText("");
        dimeLbl.setText("");
        nickelLbl.setText("");
        pennyLbl.setText("");
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
