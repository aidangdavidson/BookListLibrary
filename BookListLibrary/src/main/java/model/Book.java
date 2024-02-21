package model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/**
 * @author aidan - agdavidson
 * CIS175 - Spring 2024
 * Feb 15, 2024
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @ManyToOne
    private Library library;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
    
    public int getLibraryId() {
        if (library != null) {
            return library.getId();
        }
        return -1;
    }
}