/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;

import client.ServerData;
import helpclasses.CommEnum;
import helpclasses.CommMessage;
import helpclasses.Farm;
import helpclasses.Owner;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Kyrre
 */
public class Hub extends javax.swing.JFrame {

    /**
     * Creates new form Hub
     */
    public Hub() {
        initComponents();
        //initJPanels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addSheep = new javax.swing.JPanel();
        addSheepTitleLabel = new javax.swing.JLabel();
        addSheepName = new javax.swing.JTextField();
        addSheepNameLabel = new javax.swing.JLabel();
        addSheepBirthYearLabel = new javax.swing.JLabel();
        addSheepFarm = new javax.swing.JComboBox();
        addSheepFarmLabel = new javax.swing.JLabel();
        addSheepBirthYear = new javax.swing.JComboBox();
        addSheepNameOptionalLabel = new javax.swing.JLabel();
        addSheepAdd = new javax.swing.JButton();
        addFarm = new javax.swing.JPanel();
        addFarmTitleLabel = new javax.swing.JLabel();
        addFarmName = new javax.swing.JTextField();
        addFarmNameLabel = new javax.swing.JLabel();
        addFarmAdd = new javax.swing.JButton();
        removeSheep = new javax.swing.JPanel();
        removeSheepTitleLabel = new javax.swing.JLabel();
        removeSheepID = new javax.swing.JTextField();
        removeSheepIDLabel = new javax.swing.JLabel();
        removeSheepRemove = new javax.swing.JButton();
        removeFarm = new javax.swing.JPanel();
        removeFarmTitleLabel = new javax.swing.JLabel();
        removeFarmNameLabel = new javax.swing.JLabel();
        removeFarmAdd = new javax.swing.JButton();
        removeFarmComboFarm = new javax.swing.JComboBox();
        topMenu = new javax.swing.JMenuBar();
        topMenuHome = new javax.swing.JMenu();
        topMenuOption = new javax.swing.JMenu();
        topMenuSheep = new javax.swing.JMenu();
        topMenuAddSheep = new javax.swing.JMenuItem();
        topMenuRemoveSheep = new javax.swing.JMenuItem();
        topMenuFarm = new javax.swing.JMenu();
        topMenuAddFarm = new javax.swing.JMenuItem();
        topMenuRemoveFarm = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addSheepTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addSheepTitleLabel.setText("Add Sheep:");

        addSheepName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addSheepName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSheepNameActionPerformed(evt);
            }
        });

        addSheepNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addSheepNameLabel.setText("Name:");

        addSheepBirthYearLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addSheepBirthYearLabel.setText("Birth year:");

        addSheepFarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSheepFarmActionPerformed(evt);
            }
        });

        addSheepFarmLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addSheepFarmLabel.setText("Farm:");

        addSheepBirthYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));
        addSheepBirthYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSheepBirthYearActionPerformed(evt);
            }
        });

        addSheepNameOptionalLabel.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        addSheepNameOptionalLabel.setText("(Optional)");

        addSheepAdd.setText("Add Sheep");

        javax.swing.GroupLayout addSheepLayout = new javax.swing.GroupLayout(addSheep);
        addSheep.setLayout(addSheepLayout);
        addSheepLayout.setHorizontalGroup(
            addSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSheepLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(addSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addSheepTitleLabel)
                    .addGroup(addSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(addSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addSheepBirthYearLabel)
                            .addComponent(addSheepFarmLabel)
                            .addGroup(addSheepLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(addSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addSheepBirthYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addSheepFarm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addSheepAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                        .addGroup(addSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addSheepLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(addSheepName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addSheepLayout.createSequentialGroup()
                                .addComponent(addSheepNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addSheepNameOptionalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        addSheepLayout.setVerticalGroup(
            addSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSheepLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(addSheepTitleLabel)
                .addGap(51, 51, 51)
                .addGroup(addSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSheepNameLabel)
                    .addComponent(addSheepNameOptionalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addSheepName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addSheepBirthYearLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addSheepBirthYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(addSheepFarmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addSheepFarm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addSheepAdd)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        addFarmTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addFarmTitleLabel.setText("Add Farm:");

        addFarmName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addFarmName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFarmNameActionPerformed(evt);
            }
        });

        addFarmNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addFarmNameLabel.setText("Farm Name:");

        addFarmAdd.setText("Add Farm");
        addFarmAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFarmAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addFarmLayout = new javax.swing.GroupLayout(addFarm);
        addFarm.setLayout(addFarmLayout);
        addFarmLayout.setHorizontalGroup(
            addFarmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFarmLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(addFarmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addFarmLayout.createSequentialGroup()
                        .addComponent(addFarmNameLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(addFarmLayout.createSequentialGroup()
                        .addGroup(addFarmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addFarmTitleLabel)
                            .addGroup(addFarmLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(addFarmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addFarmAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addFarmName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 360, Short.MAX_VALUE))))
        );
        addFarmLayout.setVerticalGroup(
            addFarmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFarmLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(addFarmTitleLabel)
                .addGap(52, 52, 52)
                .addComponent(addFarmNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addFarmName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addFarmAdd)
                .addContainerGap(314, Short.MAX_VALUE))
        );

        removeSheepTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        removeSheepTitleLabel.setText("Remove Sheep:");

        removeSheepID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        removeSheepID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSheepIDActionPerformed(evt);
            }
        });

        removeSheepIDLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        removeSheepIDLabel.setText("Sheep ID:");

        removeSheepRemove.setText("Remove Sheep");

        javax.swing.GroupLayout removeSheepLayout = new javax.swing.GroupLayout(removeSheep);
        removeSheep.setLayout(removeSheepLayout);
        removeSheepLayout.setHorizontalGroup(
            removeSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeSheepLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(removeSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, removeSheepLayout.createSequentialGroup()
                        .addComponent(removeSheepIDLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(removeSheepLayout.createSequentialGroup()
                        .addGroup(removeSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeSheepTitleLabel)
                            .addGroup(removeSheepLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(removeSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(removeSheepRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(removeSheepID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 340, Short.MAX_VALUE))))
        );
        removeSheepLayout.setVerticalGroup(
            removeSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeSheepLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(removeSheepTitleLabel)
                .addGap(50, 50, 50)
                .addComponent(removeSheepIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeSheepID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeSheepRemove)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        removeFarmTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        removeFarmTitleLabel.setText("Remove Farm:");

        removeFarmNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        removeFarmNameLabel.setText("Farm ID:");

        removeFarmAdd.setText("Remove Farm");
        removeFarmAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFarmAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout removeFarmLayout = new javax.swing.GroupLayout(removeFarm);
        removeFarm.setLayout(removeFarmLayout);
        removeFarmLayout.setHorizontalGroup(
            removeFarmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeFarmLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(removeFarmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, removeFarmLayout.createSequentialGroup()
                        .addComponent(removeFarmNameLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(removeFarmLayout.createSequentialGroup()
                        .addGroup(removeFarmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeFarmTitleLabel)
                            .addGroup(removeFarmLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(removeFarmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(removeFarmAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(removeFarmComboFarm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 340, Short.MAX_VALUE))))
        );
        removeFarmLayout.setVerticalGroup(
            removeFarmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeFarmLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(removeFarmTitleLabel)
                .addGap(50, 50, 50)
                .addComponent(removeFarmNameLabel)
                .addGap(14, 14, 14)
                .addComponent(removeFarmComboFarm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeFarmAdd)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        topMenuHome.setText("Home");
        topMenu.add(topMenuHome);

        topMenuOption.setText("Option");

        topMenuSheep.setText("Sheep");

        topMenuAddSheep.setText("Add Sheep");
        topMenuAddSheep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topMenuAddSheepActionPerformed(evt);
            }
        });
        topMenuSheep.add(topMenuAddSheep);

        topMenuRemoveSheep.setText("Remove Sheep");
        topMenuRemoveSheep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topMenuRemoveSheepActionPerformed(evt);
            }
        });
        topMenuSheep.add(topMenuRemoveSheep);

        topMenuOption.add(topMenuSheep);

        topMenuFarm.setText("Farm");

        topMenuAddFarm.setText("Add Farm");
        topMenuAddFarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topMenuAddFarmActionPerformed(evt);
            }
        });
        topMenuFarm.add(topMenuAddFarm);

        topMenuRemoveFarm.setText("Remove Farm");
        topMenuRemoveFarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topMenuRemoveFarmActionPerformed(evt);
            }
        });
        topMenuFarm.add(topMenuRemoveFarm);

        topMenuOption.add(topMenuFarm);

        topMenu.add(topMenuOption);

        setJMenuBar(topMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addSheep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(addFarm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(15, 15, 15)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(removeSheep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(25, 25, 25)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(removeFarm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(25, 25, 25)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addSheep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(addFarm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(removeSheep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(22, 22, 22)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(removeFarm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(22, 22, 22)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void topMenuAddSheepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topMenuAddSheepActionPerformed
        initAddSheep();
    }//GEN-LAST:event_topMenuAddSheepActionPerformed

    private void addSheepNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSheepNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSheepNameActionPerformed

    private void addSheepFarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSheepFarmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSheepFarmActionPerformed

    private void addFarmNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFarmNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addFarmNameActionPerformed

    private void topMenuRemoveSheepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topMenuRemoveSheepActionPerformed
        initRemoveSheep();
    }//GEN-LAST:event_topMenuRemoveSheepActionPerformed

    private void removeSheepIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSheepIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeSheepIDActionPerformed

    private void addFarmAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFarmAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addFarmAddActionPerformed

    private void removeFarmAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFarmAddActionPerformed
        String farmToRemove = (String) this.removeFarmComboFarm.getSelectedItem();
        System.out.print(farmToRemove);
        ArrayList<Farm> metadata = new ArrayList<Farm>();
        metadata.add(ServerData.getFarmByNameAndRemove(farmToRemove));
        GUI.sockCli.sendMessage(new CommMessage<Farm>(CommEnum.REMOVEFARM, metadata));
        initRemoveFarm();
    }//GEN-LAST:event_removeFarmAddActionPerformed

    private void topMenuAddFarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topMenuAddFarmActionPerformed
        initAddFarm();
    }//GEN-LAST:event_topMenuAddFarmActionPerformed

    private void topMenuRemoveFarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topMenuRemoveFarmActionPerformed
        initRemoveFarm();
    }//GEN-LAST:event_topMenuRemoveFarmActionPerformed

    private void addSheepBirthYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSheepBirthYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSheepBirthYearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addFarm;
    private javax.swing.JButton addFarmAdd;
    private javax.swing.JTextField addFarmName;
    private javax.swing.JLabel addFarmNameLabel;
    private javax.swing.JLabel addFarmTitleLabel;
    private javax.swing.JPanel addSheep;
    private javax.swing.JButton addSheepAdd;
    private javax.swing.JComboBox addSheepBirthYear;
    private javax.swing.JLabel addSheepBirthYearLabel;
    private javax.swing.JComboBox addSheepFarm;
    private javax.swing.JLabel addSheepFarmLabel;
    private javax.swing.JTextField addSheepName;
    private javax.swing.JLabel addSheepNameLabel;
    private javax.swing.JLabel addSheepNameOptionalLabel;
    private javax.swing.JLabel addSheepTitleLabel;
    private javax.swing.JPanel removeFarm;
    private javax.swing.JButton removeFarmAdd;
    private javax.swing.JComboBox removeFarmComboFarm;
    private javax.swing.JLabel removeFarmNameLabel;
    private javax.swing.JLabel removeFarmTitleLabel;
    private javax.swing.JPanel removeSheep;
    private javax.swing.JTextField removeSheepID;
    private javax.swing.JLabel removeSheepIDLabel;
    private javax.swing.JButton removeSheepRemove;
    private javax.swing.JLabel removeSheepTitleLabel;
    private javax.swing.JMenuBar topMenu;
    private javax.swing.JMenuItem topMenuAddFarm;
    private javax.swing.JMenuItem topMenuAddSheep;
    private javax.swing.JMenu topMenuFarm;
    private javax.swing.JMenu topMenuHome;
    private javax.swing.JMenu topMenuOption;
    private javax.swing.JMenuItem topMenuRemoveFarm;
    private javax.swing.JMenuItem topMenuRemoveSheep;
    private javax.swing.JMenu topMenuSheep;
    // End of variables declaration//GEN-END:variables
    
    
    //fucka løsning på at JPanels blir init. med visible = true i NetBeans sin initComponents();
    void clearPanels(){
        addSheep.setVisible(false);
        removeSheep.setVisible(false);
        addFarm.setVisible(false);
        removeFarm.setVisible(false);
    }
    
    private String[] getFarmNames(){
    	if(ServerData.farms.isEmpty())
    		return new String[] {"You have no farm's"};
        String[] tmp = new String[ServerData.farms.size()];
        for (int i = 0; i < tmp.length; i++) {
			tmp[i] = ServerData.farms.get(i).getName();
		}
        return tmp;
    }

    private void initAddSheep(){
        clearPanels();
    	addSheepFarm.setModel(new DefaultComboBoxModel(getFarmNames()));
        addSheep.setVisible(true);
    }
    
    private void initRemoveSheep() {
        clearPanels();
        removeSheep.setVisible(true);
    }

    private void initAddFarm() {
        clearPanels();
        addFarm.setVisible(true);
    }

    private void initRemoveFarm() {
        clearPanels();
        removeFarmComboFarm.setModel(new DefaultComboBoxModel(getFarmNames()));
        removeFarm.setVisible(true);
    }
}
