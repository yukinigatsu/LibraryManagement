package Entities;
// Generated Aug 14, 2020 10:23:28 PM by Hibernate Tools 4.3.1


import DAO.BookTitleDAO;
import java.util.HashSet;
import java.util.Set;

/**
 * Book generated by hbm2java
 */
public class Book  implements java.io.Serializable {


     private int idBook;
     private BookTitle bookTitle;
     private String status;
     private Set borrowedBooks = new HashSet(0);

    public Book() {
    }

	
    public Book(int idBook, BookTitle bookTitle, String status) {
        this.idBook = idBook;
        this.bookTitle = bookTitle;
        this.status = status;
    }
    public Book(int idBook, BookTitle bookTitle, String status, Set borrowedBooks) {
       this.idBook = idBook;
       this.bookTitle = bookTitle;
       this.status = status;
       this.borrowedBooks = borrowedBooks;
    }
   
    public int getIdBook() {
        return this.idBook;
    }
    
    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }
    public BookTitle getBookTitle() {
        return this.bookTitle;
    }
    
    public void setBookTitle(BookTitle bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public Set getBorrowedBooks() {
        return this.borrowedBooks;
    }
    
    public void setBorrowedBooks(Set borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public String bookTitle(){
        BookTitleDAO btdao = new BookTitleDAO();
        BookTitle temp = new BookTitle();
        temp = btdao.findBookTitleById(bookTitle.getIdBookTitle());
        btdao.closeSessionDAO();
        if( temp != null){
            return temp.getName();
        } else{
            return "Lỗi: Không tìm thấy sách!";
        }
     
    }


}


