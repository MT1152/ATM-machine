/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Lenovo
 */
public class atm extends JFrame {
    private  JLabel Balancelabel;
    private double balance = 5000;
    private String accountNumber;
    private String accountHolderName;
    private String transactionHistory = "";

    public atm() {
        super ("ATM Machine ");
         Font titleFont = new Font("Arial", Font.BOLD, 50);
          getRootPane().setFont(titleFont);
        setLayout( new BorderLayout());
         accountNumber = JOptionPane.showInputDialog("Enter your account number:");
       if (accountNumber == null) {
        System.exit(0);
    }        
       accountHolderName = JOptionPane.showInputDialog("Enter your name:");
       if (accountHolderName == null) {
        System.exit(0);
    }  
       JOptionPane.showMessageDialog(this, "Welcome, " + accountHolderName + "! Your original balance is: " + balance);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        
        JLabel label = new JLabel("ATM machine ");
      label.setFont(new Font("Arial", Font.BOLD, 20));
       panel. add(label);
        JButton withdrawButton = new JButton("withdraw");
        withdrawButton.addActionListener(new WithdrawListener());
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 16)); 
        withdrawButton.setPreferredSize(new Dimension(20, 20));
        panel.add(withdrawButton);
        JButton depositeButton = new JButton("deposite");
        depositeButton.addActionListener(new DepositListener());
       depositeButton.setFont(new Font("Arial", Font.BOLD, 16));
        depositeButton.setPreferredSize(new Dimension(20, 20));
        panel.add(depositeButton);
        JButton checkkbalanceButton = new JButton("checkkbalance");
        checkkbalanceButton.addActionListener(new CheckBalanceListener ());
        checkkbalanceButton.setFont(new Font("Arial", Font.BOLD, 16));
         checkkbalanceButton.setPreferredSize(new Dimension(20, 20));
        panel.add(checkkbalanceButton);
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitListener());
         exitButton.setFont(new Font("Arial", Font.BOLD, 16));
          exitButton.setPreferredSize(new Dimension(20, 20));
        panel.add(exitButton);
         
       
        
        Balancelabel = new JLabel("Balnace : "+ balance );
        add(Balancelabel);
        
        add(panel, BorderLayout.CENTER);
         setSize(350, 150);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
        setVisible(true);

    }

   

     private class WithdrawListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String amount = JOptionPane.showInputDialog("Enter amount to withdraw:");
            try {
                 double amountDouble = Double.parseDouble(amount);
                if (amountDouble> balance) {
                    JOptionPane.showMessageDialog(atm.this, "The amount you want to withdraw is larger than the original amount");
                } else {
                    balance -= amountDouble;
                     Balancelabel.setText("Balance: " + balance);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(atm.this, "Invalid amount");
            }
        }
    }

    private class DepositListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
             String amount = JOptionPane.showInputDialog("Enter amount to deposit:");
            try {
                double amountDouble = Double.parseDouble(amount);
                balance += amountDouble;
                Balancelabel.setText("Balance: " + balance);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(atm.this, "Invalid amount");
            }
        }
    }

     private class CheckBalanceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(atm.this, "Your balance is: " + balance);
        }
    }

    private class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
             int response = JOptionPane.showConfirmDialog(atm.this, "Do you want to print a receipt?", "Print Receipt", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION ) {
                String receipt = "acoount number :"+accountNumber +"\n";
                receipt+="Name:"+accountHolderName+"\n";
                receipt+="Original Balance: " + 5000 + "\n";
                receipt += transactionHistory;
                receipt += "Final Balance: " + balance;
                JOptionPane.showMessageDialog(atm.this, receipt);
            }
            JOptionPane.showMessageDialog(atm.this, "Thank you");
            int response2 = JOptionPane.showConfirmDialog(atm.this, "Do you want to go back to the main menu?", "Go back to main menu", JOptionPane.YES_NO_OPTION);
            if (response2 == JOptionPane.YES_OPTION) {
               atm.this.dispose();
                new atm();
            }else 
            {
    

            System.exit(0);
            }
        }
    }
    
     public static void main(String[] args) {
        new atm();
    }
} 
