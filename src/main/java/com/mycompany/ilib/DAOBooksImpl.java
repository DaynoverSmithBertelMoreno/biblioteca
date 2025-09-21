package com.mycompany.ilib;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOBooks;
import com.mycompany.models.Books;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOBooksImpl extends Database implements DAOBooks {

    @Override
    public void registrar(Books book) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement(
                "INSERT INTO books(isbn,title,publication_date,author_id,category_id,publisher_id,language_id,pages,description,available_copies) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)"
            );
            st.setString(1, book.getId());                 // isbn
            st.setString(2, book.getTitle());
            st.setString(3, book.getDate());               // publication_date
            st.setInt(4, book.getAuthorId());              // nuevos getters/setters tipo int
            st.setInt(5, book.getCategoryId());
            st.setInt(6, book.getPublisherId());
            st.setInt(7, book.getLanguageId());
            st.setString(8, book.getPages());
            st.setString(9, book.getDescription());
            st.setInt(10, book.getAvailable());            // available_copies
            st.executeUpdate();
            st.close();
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Books book) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement(
                "UPDATE books SET title=?, publication_date=?, author_id=?, category_id=?, publisher_id=?, language_id=?, pages=?, description=?, available_copies=? " +
                "WHERE isbn=?"
            );
            st.setString(1, book.getTitle());
            st.setString(2, book.getDate());
            st.setInt(3, book.getAuthorId());
            st.setInt(4, book.getCategoryId());
            st.setInt(5, book.getPublisherId());
            st.setInt(6, book.getLanguageId());
            st.setString(7, book.getPages());
            st.setString(8, book.getDescription());
            st.setInt(9, book.getAvailable());
            st.setString(10, book.getId()); // isbn
            st.executeUpdate();
            st.close();
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(String isbn) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement(
                "DELETE FROM books WHERE isbn=?"
            );
            st.setString(1, isbn);
            st.executeUpdate();
            st.close();
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Books> listar(String title) throws Exception {
        List<Books> lista = null;
        try {
            this.Conectar();
            String Query = title.isEmpty() ? "SELECT * FROM V_BOOKS;" : "SELECT * FROM V_BOOKS WHERE title LIKE '%" + title + "%';";
            PreparedStatement st = this.conexion.prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Books book = new Books();
                book.setId(rs.getString("id"));
                book.setTitle(rs.getString("title"));
                book.setDate(rs.getString("date"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setEdit(rs.getString("edit"));
                book.setLang(rs.getString("lang"));
                book.setPages(rs.getString("pages"));
                book.setDescription(rs.getString("description"));
//                book.setEjemplares(rs.getString("ejemplares"));
//                book.setStock(rs.getInt("stock"));
                book.setAvailable(rs.getInt("available"));
                lista.add(book);
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Books getBookById(String isbn) throws Exception {
        Books b = null;
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement(
                "SELECT isbn,title,publication_date,author_id,category_id,publisher_id,language_id,pages,description,available_copies " +
                "FROM books WHERE isbn=? LIMIT 1"
            );
            st.setString(1, isbn);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                b = new Books();
                b.setId(rs.getString("isbn"));
                b.setTitle(rs.getString("title"));
                b.setDate(rs.getString("publication_date"));
                b.setAuthorId(rs.getInt("author_id"));
                b.setCategoryId(rs.getInt("category_id"));
                b.setPublisherId(rs.getInt("publisher_id"));
                b.setLanguageId(rs.getInt("language_id"));
                b.setPages(rs.getString("pages"));
                b.setDescription(rs.getString("description"));
                b.setAvailable(rs.getInt("available_copies"));
            }
            rs.close();
            st.close();
        } finally {
            this.Cerrar();
        }
        return b;
    }   
}