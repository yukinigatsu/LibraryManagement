/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Librarian;

import DAO.BookDAO;
import DAO.BorrowedBookDAO;
import DAO.ReaderDAO;
import Entities.Book;
import Entities.BorrowedBook;
import Entities.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yukino
 */
public class OverDueBookListInternalFrame extends javax.swing.JInternalFrame {

    ReaderDAO rdao = new ReaderDAO();
    BookDAO bdao = new BookDAO();
    BorrowedBookDAO bbdao = new BorrowedBookDAO();
    List<BorrowedBook> overDuaList = new ArrayList<BorrowedBook>();
            
    public OverDueBookListInternalFrame() {
        initComponents();
        loadOverDuaList();
        loadOverDueTable();
    }

    private void loadOverDuaList(){
        overDuaList = bbdao.overDueList();
    }
    
     private void loadOverDueTable(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã thẻ");
        dtm.addColumn("Họ và tên");
        dtm.addColumn("Đơn vị");
        dtm.addColumn("Tên sách");
        dtm.addColumn("Ngày trả");
        int stt = 1;
        for (BorrowedBook i : overDuaList) {
            Reader iReader = new Reader();
            iReader = rdao.findReaderById(i.getReader().getIdReader());
            Book iBook = new Book();
            iBook = bdao.findBookById(i.getBook().getIdBook());
            dtm.addRow(new Object[]{stt,iReader.getIdReader(),iReader.getName(),iReader.getUnit(), iBook.bookTitle(), i.getStrExpiredDate()});
            stt++;
        }

        overDueTable.setModel(dtm);

        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        overDueTable = new javax.swing.JTable();

        setClosable(true);
        setTitle("Danh sách sách quá hạn trả");

        overDueTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        overDueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã thẻ", "Họ và tên", "Đơn vị", "Tên sách", "Ngày trả"
            }
        ));
        jScrollPane1.setViewportView(overDueTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable overDueTable;
    // End of variables declaration//GEN-END:variables
}
