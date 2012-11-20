package gui;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import client.Client;
import client.ServerData;
import helpclasses.CommEnum;
import helpclasses.CommMessage;
import helpclasses.Owner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kyrre
 * @author Kenneth
 */
public class RegisterNewUser extends javax.swing.JFrame {
	
	//We need these variables when we are sending data to server.
	// These variables are global so that they can be reached from
	// ClientUnpacker.java
	public static boolean isUsernameTaken     = false;
	public static boolean isEmailAddressTaken = false;
	
	
    /**
     * Creates new form NewUser
     */
    public RegisterNewUser() {
        initComponents();
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newUserLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        editFirstName = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        editLastName = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        editUsername = new javax.swing.JTextField();
        telephoneNumberLabel = new javax.swing.JLabel();
        editTelephoneNumber = new javax.swing.JTextField();
        editFriendTelephoneNumber = new javax.swing.JTextField();
        friendTelephoneNumberLabel = new javax.swing.JLabel();
        editEmailAddress = new javax.swing.JTextField();
        emailAddressLabel = new javax.swing.JLabel();
        friendEmailAddressLabel = new javax.swing.JLabel();
        editFriendEmailAddress = new javax.swing.JTextField();
        passwordLabel1 = new javax.swing.JLabel();
        passwordLabel2 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        editPassword1 = new javax.swing.JPasswordField();
        editPassword2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        newUserLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        newUserLabel.setText("Register new user:");

        firstNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        firstNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstNameLabel.setText("First Name:");

        editFirstName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFirstNameActionPerformed(evt);
            }
        });

        lastNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastNameLabel.setText("Last Name:");

        editLastName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLastNameActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameLabel.setText("Username:");

        editUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUsernameActionPerformed(evt);
            }
        });

        telephoneNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        telephoneNumberLabel.setText("Telephone Number:");

        editTelephoneNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editTelephoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTelephoneNumberActionPerformed(evt);
            }
        });

        editFriendTelephoneNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editFriendTelephoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFriendTelephoneNumberActionPerformed(evt);
            }
        });

        friendTelephoneNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        friendTelephoneNumberLabel.setText("Friend's Telephone Number:");

        editEmailAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editEmailAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmailAddressActionPerformed(evt);
            }
        });

        emailAddressLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailAddressLabel.setText("Email Address:");

        friendEmailAddressLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        friendEmailAddressLabel.setText("Friend's Email Address:");

        editFriendEmailAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editFriendEmailAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFriendEmailAddressActionPerformed(evt);
            }
        });

        passwordLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordLabel1.setText("Password:");

        passwordLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordLabel2.setText("Retype Password:");

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerNewUserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText(" = required field");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

        editPassword1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        editPassword2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(newUserLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lastNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(editTelephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(editFriendTelephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(editUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(telephoneNumberLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4))
                                            .addComponent(friendTelephoneNumberLabel)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(usernameLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(passwordLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel1)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(editPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emailAddressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(friendEmailAddressLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passwordLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editFriendEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addComponent(submit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(newUserLabel)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneNumberLabel)
                    .addComponent(emailAddressLabel)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTelephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friendTelephoneNumberLabel)
                    .addComponent(friendEmailAddressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editFriendTelephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editFriendEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel1)
                    .addComponent(passwordLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-816)/2, (screenSize.height-638)/2, 816, 638);
    }// </editor-fold>//GEN-END:initComponents

    private void editFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editFirstNameActionPerformed

    private void editLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editLastNameActionPerformed

    private void editUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editUsernameActionPerformed

    private void editTelephoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTelephoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editTelephoneNumberActionPerformed

    private void editFriendTelephoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFriendTelephoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editFriendTelephoneNumberActionPerformed

    private void editEmailAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmailAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editEmailAddressActionPerformed

    private void editFriendEmailAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFriendEmailAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editFriendEmailAddressActionPerformed
    
    
    /**
     * This function handles the registering of a new user. We do multiple
     *  checks to see if the values are valid.
     * 
     * @author Kenneth
     * 
     * @param evt 
     */
    private void registerNewUserActionPerformed(
    		java.awt.event.ActionEvent evt)
    {   
        boolean isValuesValid        = true;
        String firstName             = editFirstName.getText();
        String lastName              = editLastName.getText();
        String telephoneNumber       = editTelephoneNumber.getText();
        String emailAddress          = editEmailAddress.getText();
        String friendTelephoneNumber = editFriendTelephoneNumber.getText();
        String friendEmailAddress    = editFriendEmailAddress.getText();
        String username              = editUsername.getText();
        String password1             = editPassword1.getText();
        String password2             = editPassword2.getText();
        
        
        //We checks to see if the user has entered valid values
        if(firstName.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Field for First Name is empty!",
                    "Not valid contact information",
                    JOptionPane.ERROR_MESSAGE);
            isValuesValid = false;
        }
        else if(lastName.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Field for Last Name is empty!",
                    "Not valid contact information",
                    JOptionPane.ERROR_MESSAGE);
            isValuesValid = false;
        }
        else if(telephoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Field for Telephone Number is empty!",
                    "Not valid contact information",
                    JOptionPane.ERROR_MESSAGE);
            isValuesValid = false;
        }
        else if(emailAddress.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Field for Email Address is empty!",
                    "Not valid contact information",
                    JOptionPane.ERROR_MESSAGE);
            isValuesValid = false;
        }
        else if(!emailAddress.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)" +
        		"*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
        	JOptionPane.showMessageDialog(null,
        			"The field for Email Address is not valid!",
        			"Not valid contact information",
        			JOptionPane.ERROR_MESSAGE);
        	isValuesValid = false;
        }
        else if(!friendEmailAddress.isEmpty()) {
        	if(!friendEmailAddress.matches("^[_A-Za-z0-9-\\+]+(\\." +
        			"[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*" +
        			"(\\.[A-Za-z]{2,})$")) {
            	JOptionPane.showMessageDialog(null,
            			"The field for Friend's Email Address is not valid!",
            			"Not valid contact information",
            			JOptionPane.ERROR_MESSAGE);
            	isValuesValid = false;
            }
        }    
        else if(username.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Field for Username is empty!",
                    "Not valid contact information",
                    JOptionPane.ERROR_MESSAGE);
            isValuesValid = false;
        }
        else if(password1.isEmpty() || password2.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Both password fields are required!",
                    "Not valid contact information",
                    JOptionPane.ERROR_MESSAGE);
            isValuesValid = false;
        }
        else if(!password1.equals(password2)) {
            JOptionPane.showMessageDialog(null,
                    "The fields for the passwords are not equal!",
                    "Not valid contact information",
                    JOptionPane.ERROR_MESSAGE);
            isValuesValid = false;
        }
        
        
        //We perform checks to see if the phone numbers are actually numbers
        // and that they contain 8 numbers. (Telephone numbers in Norway has 8
        // numbers)
        if(!telephoneNumber.isEmpty()) {
        	try {
        		int number = Integer.parseInt(telephoneNumber);
        		
        		
        		//If telephone number is a number but less than 10 000 000 or
        		// greater than 99 999 999 we indicate that it is not valid.
        		if(number < 10000000 || number > 99999999) {
        			JOptionPane.showMessageDialog(null,
        					"The field for Telephone Number is not valid!",
        					"Not valid contact information",
        					JOptionPane.ERROR_MESSAGE);
        			isValuesValid = false;
        		}
        	}
        	catch(Exception exception) {
        		JOptionPane.showMessageDialog(null,
        				"The field for Telephone Number is not valid!",
        				"Not valid contact information",
        				JOptionPane.ERROR_MESSAGE);
        		isValuesValid = false;
        	}
        }
        
                
        if(!friendTelephoneNumber.isEmpty()) {
        	try {
        		int number = Integer.parseInt(friendTelephoneNumber);
        		
        		
        		//If telephone number is a number but less than 10 000 000 or
        		// greater than 99 999 999 we indicate that it is not valid.
        		if(number < 10000000 || number > 99999999) {
        			JOptionPane.showMessageDialog(null,
        					"The field for Friend's Telephone Number is not " +
        					"valid!",
        					"Not valid contact information",
        					JOptionPane.ERROR_MESSAGE);
        			isValuesValid = false;
        		}
        	}
        	catch(Exception exception) {
        		JOptionPane.showMessageDialog(null,
        				"The field for Friend's Telephone Number is not valid!",
        				"Not valid contact information",
        				JOptionPane.ERROR_MESSAGE);
        		isValuesValid = false;
        	}
        }
        //The -1 indicate that the field for the telephone number is empty
        else {
        	friendTelephoneNumber = "-1";
        }
        
        
        if(isValuesValid) {
            ArrayList<Owner> owner = new ArrayList<Owner>();
            owner.add(new Owner(-1,
                    username, password1, firstName, lastName, 
                    Integer.parseInt(telephoneNumber), emailAddress,
                    Integer.parseInt(friendTelephoneNumber),
                    friendEmailAddress));
            
            
            //We now send a message that we want to register a new user
            Client.sockCli.sendMessage(new CommMessage<Owner>(
                    CommEnum.REGISTERNEWUSER, owner));
            
            
            //If the function isUsernameTaken called from ServerUnpacker.java
            // returns false, then it will eventuelly updata the global
            // variable isUsernameTaken
            if(isUsernameTaken == true)
            {
            	isUsernameTaken = false;
            	
            	JOptionPane.showMessageDialog(null,
            			"Username has already been taken!",
            			"Not valid contact information",
            			JOptionPane.ERROR_MESSAGE);           	
            }
            //If the function isEmailAddressTaken called from
            // ServerUnpacker.java, returns false, then it will eventually
            // update the global variable isEmailAddressTaken
            else if(isEmailAddressTaken == true)
            {
            	isEmailAddressTaken = false;
            	
            	JOptionPane.showMessageDialog(null,
            			"Email address has already been taken!",
            			"Not valid contact information",
            			JOptionPane.ERROR_MESSAGE);
            }
            else
            {
            	//Everything went fine so we set the visibility of this window
            	// to false. Then we make the login window visible so that the
            	// user can log in with his username and password
            	this.setVisible(false);
            	Client.login.setVisible(true);
            }
        }
    }//GEN-LAST:event_registerNewUserActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterNewUser().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField editEmailAddress;
    private javax.swing.JTextField editFirstName;
    private javax.swing.JTextField editFriendEmailAddress;
    private javax.swing.JTextField editFriendTelephoneNumber;
    private javax.swing.JTextField editLastName;
    private javax.swing.JPasswordField editPassword1;
    private javax.swing.JPasswordField editPassword2;
    private javax.swing.JTextField editTelephoneNumber;
    private javax.swing.JTextField editUsername;
    private javax.swing.JLabel emailAddressLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel friendEmailAddressLabel;
    private javax.swing.JLabel friendTelephoneNumberLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel newUserLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JLabel passwordLabel2;
    private javax.swing.JButton submit;
    private javax.swing.JLabel telephoneNumberLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

    private void setIcon(){
		BufferedImage image = null;
		try {
			image = ImageIO.read(
					this.getClass().getResource("/res/briller_hatt.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setIconImage(image);
	}
}
