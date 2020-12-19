package com.example.HWLesson02.repository;

import com.example.HWLesson02.dto.BookWithAuthorName;
import com.example.HWLesson02.helper.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    DatabaseUtil databaseUtil = new DatabaseUtil();
    List<BookWithAuthorName> listBooks;

    public List<BookWithAuthorName> getAllBooks() throws SQLException {
        listBooks = new ArrayList<>();
        String sql = "select bookId, bookName, authorName from Author inner join Book on Book.authorId = Author.authorId;";
        ResultSet rs = databaseUtil.executeQuery(sql);
        while (rs.next()) {
            BookWithAuthorName bookWithAuthorName = new BookWithAuthorName();
            bookWithAuthorName.setBookId(rs.getInt("bookId"));
            bookWithAuthorName.setBookName(rs.getString("bookName"));
            bookWithAuthorName.setAuthorName(rs.getString("authorName"));
            listBooks.add(bookWithAuthorName);
        }
        return listBooks;
    }

    public boolean checkAuthorExist(String authorInput) throws SQLException {
        String sql = "select authorName from Author where authorName = '" + authorInput + "';";
        ResultSet response = databaseUtil.executeQuery(sql);
        if (response.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkBookNameExist(String nameInput) throws SQLException {
        String sql = "select bookName from Book where bookName = '" + nameInput + "';";
        ResultSet response = databaseUtil.executeQuery(sql);
        if (response.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkOldBookNameExist(String oldName) throws SQLException {
        String sql = "select bookName from Book where bookName = '" + oldName + "';";
        ResultSet response = databaseUtil.executeQuery(sql);
        if (response.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addBook(String nameInput, String authorInput) {
        try {
            int idAuthor = 0;
            String sqlFindId = "select authorId from Author where authorName = '" + authorInput + "';";
            ResultSet response = databaseUtil.executeQuery(sqlFindId);
            while (response.next()) {
                idAuthor = response.getInt("authorId");
            }
            String sql = "insert into Book (bookName, authorId) values ('" + nameInput + "', '" + idAuthor + "');";
            return databaseUtil.updateQuery(sql);
        } catch (Exception e) {
            System.out.println("Error occurred");
            return false;
        }
    }

    public boolean updateBook(String oldName, String nameInput) {
        try {
            int idBook = 0;
            String sqlFindId = "select bookId from Book where bookName = '" + oldName + "';";
            ResultSet response = databaseUtil.executeQuery(sqlFindId);
            while (response.next()) {
                idBook = response.getInt("bookId");
            }
            String sql = "update Book set bookName = '" + nameInput + "' where bookId = '" + idBook + "';";
            return databaseUtil.updateQuery(sql);
        } catch (Exception e) {
            System.out.println("Error occurred");
            return false;
        }
    }


    public boolean deleteBook(String nameInput) {
        try {
            String sql = "delete from Book where bookName = '" + nameInput + "';";
            System.out.println("Deleted");
            return databaseUtil.updateQuery(sql);
        } catch (Exception e) {
            System.out.println("Error occurred");
            return false;
        }
    }
}
