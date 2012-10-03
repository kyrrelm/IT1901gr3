/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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
        removeSheep = new javax.swing.JPanel();
        removeSheepTitleLabel = new javax.swing.JLabel();
        removeSheepID = new javax.swing.JTextField();
        removeSheepIDLabel = new javax.swing.JLabel();
        removeSheepRemove = new javax.swing.JButton();
        topMenu = new javax.swing.JMenuBar();
        topMenuSheep = new javax.swing.JMenu();
        topMenuAddSheep = new javax.swing.JMenuItem();
        topMenuRemoveSheep = new javax.swing.JMenuItem();

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

        addSheepNameOptionalLabel.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        addSheepNameOptionalLabel.setText("(Optional)");

        addSheepAdd.setText("Add Sheep");

        javax.swing.GroupLayout addSheepLayout = new javax.swing.GroupLayout(addSheep);
        addSheep.setLayout(addSheepLayout);
        addSheepLayout.setHorizontalGroup(
            addSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSheepLayout.createSequentialGroup()
                .addGroup(addSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addSheepLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
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
                    .addGroup(addSheepLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(addSheepTitleLabel)))
                .addContainerGap(519, Short.MAX_VALUE))
        );
        addSheepLayout.setVerticalGroup(
            addSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSheepLayout.createSequentialGroup()
                .addGap(31, 31, 31)
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
                .addContainerGap(277, Short.MAX_VALUE))
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
                .addGap(81, 81, 81)
                .addGroup(removeSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, removeSheepLayout.createSequentialGroup()
                        .addComponent(removeSheepIDLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(removeSheepLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(removeSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeSheepRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeSheepID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(removeSheepLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(removeSheepTitleLabel)
                .addContainerGap(600, Short.MAX_VALUE))
        );
        removeSheepLayout.setVerticalGroup(
            removeSheepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeSheepLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(removeSheepTitleLabel)
                .addGap(51, 51, 51)
                .addComponent(removeSheepIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeSheepID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeSheepRemove)
                .addContainerGap(383, Short.MAX_VALUE))
        );

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

        topMenu.add(topMenuSheep);

        setJMenuBar(topMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(addSheep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(removeSheep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(15, 15, 15)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addSheep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(removeSheep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>

    private void topMenuAddSheepActionPerformed(java.awt.event.ActionEvent evt) {                                                
        clearPanels();
        addSheep.setVisible(true);
    }                                               

    private void addSheepNameActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void addSheepFarmActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void removeSheepIDActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void topMenuRemoveSheepActionPerformed(java.awt.event.ActionEvent evt) {
        clearPanels();
        removeSheep.setVisible(true);
    }

    // Variables declaration - do not modify
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
    private javax.swing.JPanel removeSheep;
    private javax.swing.JTextField removeSheepID;
    private javax.swing.JLabel removeSheepIDLabel;
    private javax.swing.JButton removeSheepRemove;
    private javax.swing.JLabel removeSheepTitleLabel;
    private javax.swing.JMenuBar topMenu;
    private javax.swing.JMenuItem topMenuAddSheep;
    private javax.swing.JMenuItem topMenuRemoveSheep;
    private javax.swing.JMenu topMenuSheep;
    // End of variables declaration

    //fucka l�sning p� at JPanels blir init. med visible = true i NetBeans sin initComponents();
    void clearPanels(){
        addSheep.setVisible(false);
        removeSheep.setVisible(false);
    }
    
    private String getFarms(){
        return "TestFarm";
    }
}

