package Entities;
// Generated Aug 14, 2020 10:23:28 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * BorrowedBook generated by hbm2java
 */
public class BorrowedBook  implements java.io.Serializable {


     private BorrowedBookId id;
     private Book book;
     private Reader reader;
     private Date expiredDate;
     private byte isReturn;

    public BorrowedBook() {
    }

    public BorrowedBook(BorrowedBookId id, Book book, Reader reader, Date expiredDate, byte isReturn) {
       this.id = id;
       this.book = book;
       this.reader = reader;
       this.expiredDate = expiredDate;
       this.isReturn = isReturn;
    }
   
    public BorrowedBookId getId() {
        return this.id;
    }
    
    public void setId(BorrowedBookId id) {
        this.id = id;
    }
    public Book getBook() {
        return this.book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    public Reader getReader() {
        return this.reader;
    }
    
    public void setReader(Reader reader) {
        this.reader = reader;
    }
    public Date getExpiredDate() {
        return this.expiredDate;
    }
    
    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
    public byte getIsReturn() {
        return this.isReturn;
    }
    
    public void setIsReturn(byte isReturn) {
        this.isReturn = isReturn;
    }




}


