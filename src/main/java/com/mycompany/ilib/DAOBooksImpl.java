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
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO books(id,title, date, author, category, edit, lang, pages, description, ejemplares, stock, available) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);");
            st.setString(1, book.getId());
            st.setString(2, book.getTitle());
            st.setString(3, book.getDate());
            st.setString(4, book.getAuthor());
            st.setString(5, book.getCategory());
            st.setString(6, book.getEdit());
            st.setString(7, book.getLang());
            st.setString(8, book.getPages());
            st.setString(9, book.getDescription());
            st.setString(10, book.getEjemplares());
            st.setInt(11, book.getStock());
            st.setInt(12, book.getAvailable());
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Books book) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE books SET title = ?, date = ?, author = ?, category = ?, edit = ?, lang = ?, pages = ?, description = ?, ejemplares = ?, stock = ?, available = ? WHERE id = ?");
            st.setString(1, book.getTitle());
            st.setString(2, book.getDate());
            st.setString(3, book.getAuthor());
            st.setString(4, book.getCategory());
            st.setString(5, book.getEdit());
            st.setString(6, book.getLang());
            st.setString(7, book.getPages());
            st.setString(8, book.getDescription());
            st.setString(9, book.getEjemplares());
            st.setInt(10, book.getStock());
            st.setInt(11, book.getAvailable());
            st.setString(12, book.getId());
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(String bookId) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM books WHERE id = ?;");
            st.setString(1, bookId);
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
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
    public Books getBookById(String bookId) throws Exception {
        Books book = null;
        
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM books WHERE id = ? LIMIT 1;");
            st.setString(1, bookId);
            
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                book = new Books();
                book.setId(rs.getString("id"));
                book.setTitle(rs.getString("title"));
                book.setDate(rs.getString("date"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setEdit(rs.getString("edit"));
                book.setLang(rs.getString("lang"));
                book.setPages(rs.getString("pages"));
                book.setDescription(rs.getString("description"));
                book.setEjemplares(rs.getString("ejemplares"));
                book.setStock(rs.getInt("stock"));
                book.setAvailable(rs.getInt("available"));
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return book;
    }   
}