/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Librarian;

import DAO.BookDAO;
import DAO.BorrowedBookDAO;
import DAO.ReaderDAO;
import Entities.BorrowedBook;
import Entities.Reader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yukino
 */
public class ExtensionInternalFrame extends javax.swing.JInternalFrame {

    private List<Reader> readerList = new ArrayList<Reader>();
    private List<BorrowedBook> borrowedBookList = new ArrayList<>();
    private ReaderDAO rdao = new ReaderDAO();
    private BookDAO bdao = new BookDAO();
    private BorrowedBookDAO bbdao = new BorrowedBookDAO();
    
    public ExtensionInternalFrame() {
        initComponents();
        loadDataReaderList();
        loadDataReaderTable();
    }

         private void loadDataReaderList(){
       readerList.clear();
       readerList = rdao.selectAllReader();
    }
    
    private void loadDataReaderTable(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã thẻ");
        dtm.addColumn("Họ và tên");
        dtm.addColumn("Đơn vị");

        for (Reader i : readerList) {
            dtm.addRow(new Object[]{i.getIdReader(), i.getName(), i.getUnit()});
        }

        readersTable.setModel(dtm);
        this.readersTable.repaint();
        this.readersTable.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        serchButton = new javax.swing.JButton();
        typeSearchComboBox = new javax.swing.JComboBox<>();
        clearButton = new javax.swing.JButton();
        keywordTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        readersTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        borowedBookTable = new javax.swing.JTable();
        extensionButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Gia hạn mượn sách");

        serchButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        serchButton.setText("Tìm");
        serchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serchButtonActionPerformed(evt);
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

        keywordTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        readersTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        readersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã thẻ", "Họ và tên", "Đơn vị"
            }
        ));
        readersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(readersTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(typeSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(keywordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(serchButton)
                        .addGap(35, 35, 35)
                        .addComponent(clearButton)
                        .addGap(0, 208, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keywordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serchButton)
                    .addComponent(clearButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sách mượn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        borowedBookTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        borowedBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sách", "Thời gian mượn", "Thời gian trả"
            }
        ));
        jScrollPane2.setViewportView(borowedBookTable);

        extensionButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        extensionButton.setText("GIA HẠN");
        extensionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extensionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(extensionButton)
                        .addGap(132, 132, 132)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(extensionButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        keywordTextField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void serchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serchButtonActionPerformed
         if (!keywordTextField.getText().isEmpty()) {
            readerList.clear();
            if (typeSearchComboBox.getSelectedItem() == "Mã thẻ") {
                Reader iReader = new Reader();
                try {
                    iReader = rdao.findReaderById(Integer.parseInt(keywordTextField.getText()));
                    if (iReader != null) {
                        readerList.add(iReader);
                                    
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }
                loadDataReaderTable();
            } else if (typeSearchComboBox.getSelectedItem() == "Tên") {
                List<Reader> resultList = new ArrayList<Reader>();
                resultList = rdao.findReaderByName(keywordTextField.getText());
                if (resultList != null) {
                    readerList.addAll(resultList);                  
                   resultList.clear();
                }
                loadDataReaderTable();
            }
        }
        else{
            loadDataReaderList();
            loadDataReaderTable();
        }
    }//GEN-LAST:event_serchButtonActionPerformed

    private void loadDataBorrowedList(Reader iReader){
        borrowedBookList = bbdao.selectBooksNotReturn(iReader);
    }
    
    private void loadDataBorrowedBookTable(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã Sách");
        dtm.addColumn("Thời gian mượn");
        dtm.addColumn("Thời gian trả");
        
        int stt = 1;
        for (BorrowedBook i : borrowedBookList) {
            
            dtm.addRow(new Object[]{stt, i.getBook().getIdBook(), i.getId().getStrBorrowedDate(), i.getStrExpiredDate()});
            stt++;
        }

        borowedBookTable.setModel(dtm);
        this.borowedBookTable.repaint();
        this.borowedBookTable.revalidate();
    }
    
    private void readersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readersTableMouseClicked
        int row = readersTable.getSelectedRow();
        loadDataBorrowedList(readerList.get(row));
        loadDataBorrowedBookTable();
    }//GEN-LAST:event_readersTableMouseClicked

     private Date defineExpiredDate(Date iDate){
        Calendar c = Calendar.getInstance();
        c.setTime(iDate);
        c.add(Calendar.DAY_OF_YEAR, 7); // add 7 days
        return c.getTime();

    }
     
    private void extensionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extensionButtonActionPerformed
        int row = borowedBookTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần gia hạn!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            BorrowedBook iBorrowedBook = new BorrowedBook();
            iBorrowedBook = borrowedBookList.get(row);
            if(iBorrowedBook.isOverDue()){
                JOptionPane.showMessageDialog(this, "Sách đã quá hạn trả sách!\n Không được phép gia hạn.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else{
                iBorrowedBook.setExpiredDate(defineExpiredDate(iBorrowedBook.getExpiredDate()));
                if(bbdao.updateBorrowedBook(iBorrowedBook)){
                    Date temp = iBorrowedBook.getExpiredDate();
                    borrowedBookList.get(row).setExpiredDate(temp);
                    JOptionPane.showMessageDialog(this, "Đã gia hạn sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadDataBorrowedBookTable();
                }else {
                    JOptionPane.showMessageDialog(this, "Gia hạn sách thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }              
            }
        }
    }//GEN-LAST:event_extensionButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable borowedBookTable;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton extensionButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keywordTextField;
    private javax.swing.JTable readersTable;
    private javax.swing.JButton serchButton;
    private javax.swing.JComboBox<String> typeSearchComboBox;
    // End of variables declaration//GEN-END:variables
}
