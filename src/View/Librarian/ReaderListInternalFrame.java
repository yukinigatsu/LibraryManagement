/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Librarian;

import DAO.ReaderDAO;
import Entities.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yukino
 */
public class ReaderListInternalFrame extends javax.swing.JInternalFrame {
    private List<Reader> ReaderList = new ArrayList<Reader>();
    private ReaderDAO rdao = new ReaderDAO();
    
    public ReaderListInternalFrame() {
        initComponents();
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        loadDataListReader();
        loadDataTable();
    }
    
    private void loadDataListReader(){
       ReaderList.clear();
       ReaderList = rdao.selectAllReader();
    }
    
    private void loadDataTable(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã thẻ");
        dtm.addColumn("Họ và tên");
        dtm.addColumn("Loại");
        dtm.addColumn("Đơn vị");
        dtm.addColumn("Trạng thái");
        dtm.addColumn("Khoá thẻ");
        String status = new String();
        String isBlock = new String();
        String type = new String();
        for (Reader i : ReaderList) {
            if (i.getType().equals("student")) {
                type = "Học sinh";
            } else {
                type = "Giáo viên";
            }
            if (i.getIsExpired() == 0) {
                status = "Vô hiệu hoá";
            } else {
                status = "Hoạt động";
            }
            if (i.getIsBlocked() == 1) {
                isBlock = "Đã khoá";
            } else {
                isBlock = "";
            }

            dtm.addRow(new Object[]{i.getIdReader(), i.getName(), type, i.getUnit(), status, isBlock});
        }

        readersTable.setModel(dtm);
        this.readersTable.repaint();
        this.readersTable.revalidate();
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButtonGroup = new javax.swing.ButtonGroup();
        typeButtonGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        readersTable = new javax.swing.JTable();
        infoPanel = new javax.swing.JPanel();
        idTextField = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        studentRadioButton = new javax.swing.JRadioButton();
        phoneTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        femaleRadioButton = new javax.swing.JRadioButton();
        staffRadioButton = new javax.swing.JRadioButton();
        idLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        infoLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        birthdayLabel = new javax.swing.JLabel();
        unitLabel = new javax.swing.JLabel();
        unitTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        birthFormattedTextField = new javax.swing.JFormattedTextField();
        maleRadioButton = new javax.swing.JRadioButton();
        buttonPanel = new javax.swing.JPanel();
        unblockButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        extensionButton = new javax.swing.JButton();
        blockButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        searchReaderButton = new javax.swing.JButton();
        typeSearchComboBox = new javax.swing.JComboBox<>();
        clearButton = new javax.swing.JButton();
        typeSortComboBox = new javax.swing.JComboBox<>();
        sortButton = new javax.swing.JButton();
        keywordTextField = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Danh sách người đọc");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Người Đọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        readersTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        readersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thẻ", "Họ và tên", "Loại", "Đơn vị", "Trạng thái", "Vô hiệu hoá"
            }
        ));
        readersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(readersTable);

        idTextField.setEditable(false);
        idTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        genderLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        genderLabel.setText("Giới tính:");

        typeButtonGroup.add(studentRadioButton);
        studentRadioButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        studentRadioButton.setText("Học sinh");

        phoneTextField.setEditable(false);
        phoneTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        phoneLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        phoneLabel.setText("Số điện thoại:");

        genderButtonGroup.add(femaleRadioButton);
        femaleRadioButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        femaleRadioButton.setText("Nữ");

        typeButtonGroup.add(staffRadioButton);
        staffRadioButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        staffRadioButton.setText("Giáo viên");

        idLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        idLabel.setText("Mã thẻ:");

        nameTextField.setEditable(false);
        nameTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        infoLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel.setText("THÔNG TIN");

        typeLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        typeLabel.setText("Loại:");

        birthdayLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        birthdayLabel.setText("Ngày sinh:");

        unitLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        unitLabel.setText("Đơn vị:");

        unitTextField.setEditable(false);
        unitTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        nameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nameLabel.setText("Họ và tên:");

        birthFormattedTextField.setEditable(false);
        birthFormattedTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        genderButtonGroup.add(maleRadioButton);
        maleRadioButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        maleRadioButton.setText("Nam");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(birthdayLabel)
                            .addComponent(genderLabel)
                            .addComponent(phoneLabel)
                            .addComponent(typeLabel)
                            .addComponent(unitLabel))
                        .addGap(23, 23, 23)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(unitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(studentRadioButton)
                                .addGap(42, 42, 42)
                                .addComponent(staffRadioButton))
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(maleRadioButton)
                                .addGap(62, 62, 62)
                                .addComponent(femaleRadioButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(phoneTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(birthFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(48, 48, 48)
                        .addComponent(nameTextField))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addGap(67, 67, 67)
                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdayLabel)
                    .addComponent(birthFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genderLabel)
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maleRadioButton)
                        .addComponent(femaleRadioButton)))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(studentRadioButton)
                    .addComponent(staffRadioButton))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unitLabel)
                    .addComponent(unitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        unblockButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        unblockButton.setText("Gỡ Khoá");
        unblockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unblockButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cancelButton.setText("Huỷ");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        extensionButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        extensionButton.setText("Gia Hạn");
        extensionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extensionButtonActionPerformed(evt);
            }
        });

        blockButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        blockButton.setText("Khoá Thẻ");
        blockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        editButton.setText("Sửa");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveButton.setText("Lưu");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButton)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addGap(45, 45, 45)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unblockButton)
                    .addComponent(extensionButton)
                    .addComponent(blockButton))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(extensionButton))
                .addGap(24, 24, 24)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blockButton)
                    .addComponent(saveButton))
                .addGap(24, 24, 24)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unblockButton)
                    .addComponent(cancelButton))
                .addGap(59, 59, 59))
        );

        searchReaderButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        searchReaderButton.setText("Tìm");
        searchReaderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchReaderButtonActionPerformed(evt);
            }
        });

        typeSearchComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        typeSearchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã thẻ", "Tên" }));

        clearButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clearButton.setText("Xoá");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        typeSortComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        typeSortComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên: A->Z", "Tên: Z->A" }));

        sortButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        sortButton.setText("Sắp xếp");
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        keywordTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(typeSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(keywordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchReaderButton)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(typeSortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sortButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keywordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchReaderButton)
                    .addComponent(clearButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeSortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 122, Short.MAX_VALUE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        keywordTextField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int row = readersTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một người đọc trong danh sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            editButton.setVisible(false);
            saveButton.setVisible(true);
            cancelButton.setVisible(true);

            nameTextField.setEditable(true);
            birthFormattedTextField.setEditable(true);
            phoneTextField.setEditable(true);
            unitTextField.setEditable(true);
        }
    }//GEN-LAST:event_editButtonActionPerformed
    private void afterSaveOrCancel(){
        editButton.setVisible(true);
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        
        nameTextField.setEditable(false);
        birthFormattedTextField.setEditable(false);
        phoneTextField.setEditable(false);
        unitTextField.setEditable(false);
    }
    
    private boolean checkValidData(){
        if(nameTextField.getText().isEmpty() || birthFormattedTextField.getText().isEmpty() || unitTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(birthFormattedTextField.getText().length() != 10){
             JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ!\nVui lòng kiểm tra lại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
             return false;
        }
        return true;
    }
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        int row = readersTable.getSelectedRow();
        if (checkValidData()) {
            String name = new String();
            String phone = new String();
            String gender = new String();
            String typeReader = new String();
            String unit = new String();
            name = nameTextField.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date birth = new Date();
            try {
                birth = sdf.parse(birthFormattedTextField.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (maleRadioButton.isSelected()) {
                gender = "Nam";
            } else {
                gender = "Nữ";
            }
            if (studentRadioButton.isSelected()) {
                typeReader = "student";
            } else {
                typeReader = "staff";
            }
            unit = unitTextField.getText();
            //Reader iReader = new Reader(); 
            ReaderList.get(row);
            ReaderList.get(row).setName(name);
            ReaderList.get(row).setBirthday(birth);
            ReaderList.get(row).setGender(gender);
            ReaderList.get(row).setPhone(phone);
            ReaderList.get(row).setType(typeReader);
            ReaderList.get(row).setUnit(unit);
            ReaderList.get(row).setCreateTime(new Date());
            ReaderList.get(row).setLastMortifiedTime(new Date());
            ReaderList.get(row).setIsExpired((byte) 1);
            ReaderList.get(row).setIsBlocked((byte) 0);
            if(rdao.updateReader(ReaderList.get(row))){
                 JOptionPane.showMessageDialog(this, "Cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadDataTable();
            }else{
                 JOptionPane.showMessageDialog(this, "Cập nhật thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        afterSaveOrCancel();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int row = readersTable.getSelectedRow();
        Reader iReader = new Reader();
        iReader = ReaderList.get(row);
        idTextField.setText(String.valueOf(iReader.getIdReader()));
        nameTextField.setText(iReader.getName());
        birthFormattedTextField.setText(iReader.getStrBirthday());
        if (iReader.getGender().equals("Nam")) {
                maleRadioButton.setSelected(true);
            } else {
                femaleRadioButton.setSelected(true);
            }
            if (iReader.getType().equals("student")) {
                studentRadioButton.setSelected(true);
            } else {
                staffRadioButton.setSelected(true);
        }
        phoneTextField.setText(iReader.getPhone());
        unitTextField.setText(iReader.getUnit());
        afterSaveOrCancel();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void searchReaderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchReaderButtonActionPerformed
        if (!keywordTextField.getText().isEmpty()) {
            ReaderList.clear();
            if (typeSearchComboBox.getSelectedItem() == "Mã thẻ") {
                Reader iReader = new Reader();
                try {
                    iReader = rdao.findReaderById(Integer.parseInt(keywordTextField.getText()));
                    if (iReader != null) {
                        ReaderList.add(iReader);
                                    
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }
                loadDataTable();
            } else if (typeSearchComboBox.getSelectedItem() == "Tên") {
                List<Reader> resultList = new ArrayList<Reader>();
                resultList = rdao.findReaderByName(keywordTextField.getText());
                if (resultList != null) {
                    ReaderList.addAll(resultList);                  
                   resultList.clear();
                }
                loadDataTable();
            }
        }
        else{
            loadDataListReader();
            loadDataTable();
        }
    }//GEN-LAST:event_searchReaderButtonActionPerformed

    private void readersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readersTableMouseClicked
        int row = readersTable.getSelectedRow();
        Reader iReader = new Reader();
        iReader = ReaderList.get(row);
        idTextField.setText(String.valueOf(iReader.getIdReader()));
        nameTextField.setText(iReader.getName());
        birthFormattedTextField.setText(iReader.getStrBirthday());
        if (iReader.getGender().equals("Nam")) {
                maleRadioButton.setSelected(true);
            } else {
                femaleRadioButton.setSelected(true);
            }
            if (iReader.getType().equals("student")) {
                studentRadioButton.setSelected(true);
            } else {
                staffRadioButton.setSelected(true);
        }
        phoneTextField.setText(iReader.getPhone());
        unitTextField.setText(iReader.getUnit());
    }//GEN-LAST:event_readersTableMouseClicked

    private void extensionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extensionButtonActionPerformed
        int row = readersTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một người đọc trong danh sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            Reader iReader = new Reader();
            iReader = ReaderList.get(row);
            if (iReader.getIsBlocked() == 1) {
                JOptionPane.showMessageDialog(this, "Thẻ đã bị khoá", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else {
                if (iReader.getIsExpired() != 1) {
                    iReader.setIsExpired((byte) 1);
                    if (rdao.updateReader(iReader)) {
                        JOptionPane.showMessageDialog(this, "Đã gia hạn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        ReaderList.get(row).setIsExpired((byte) 1);
                        loadDataTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Gia hạn thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đã gia hạn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_extensionButtonActionPerformed

    private void blockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockButtonActionPerformed
        int row = readersTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một người đọc trong danh sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            Reader iReader = new Reader();
            iReader = ReaderList.get(row);
            if (iReader.getIsBlocked() != 1) {
                iReader.setIsBlocked((byte) 1);
                if (rdao.updateReader(iReader)) {
                    JOptionPane.showMessageDialog(this, "Đã khoá", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    ReaderList.get(row).setIsBlocked((byte) 1);
                    loadDataTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Khoá thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Đã khoá", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_blockButtonActionPerformed

    private void unblockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unblockButtonActionPerformed
        int row = readersTable.getSelectedRow();
       if(row == -1){
           JOptionPane.showMessageDialog(this, "Vui lòng chọn một người đọc trong danh sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
       } else {
        Reader iReader = new Reader();
        iReader = ReaderList.get(row);
        if(iReader.getIsBlocked() == 1){
            iReader.setIsBlocked((byte) 0);
            if(rdao.updateReader(iReader)){
                JOptionPane.showMessageDialog(this, "Đã gỡ khoá", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                ReaderList.get(row).setIsBlocked((byte) 0);
                loadDataTable();
            } else {
                JOptionPane.showMessageDialog(this, "Gỡ khoá thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }      
        } else {
             JOptionPane.showMessageDialog(this, "Đã gỡ khoá", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }         
       }
    }//GEN-LAST:event_unblockButtonActionPerformed

    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
        Collections.sort(ReaderList);
          if (typeSortComboBox.getSelectedItem() == "Tên: A->Z"){
              loadDataTable();
          } else{
              Collections.reverse(ReaderList);
              loadDataTable();
          }
    }//GEN-LAST:event_sortButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField birthFormattedTextField;
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JButton blockButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton extensionButton;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.ButtonGroup genderButtonGroup;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keywordTextField;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JTable readersTable;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchReaderButton;
    private javax.swing.JButton sortButton;
    private javax.swing.JRadioButton staffRadioButton;
    private javax.swing.JRadioButton studentRadioButton;
    private javax.swing.ButtonGroup typeButtonGroup;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JComboBox<String> typeSearchComboBox;
    private javax.swing.JComboBox<String> typeSortComboBox;
    private javax.swing.JButton unblockButton;
    private javax.swing.JLabel unitLabel;
    private javax.swing.JTextField unitTextField;
    // End of variables declaration//GEN-END:variables
}
