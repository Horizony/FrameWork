// BookManager.aidl
package com.cn.horizon.login;

// Declare any non-default types here with import statements
import com.cn.horizon.login.Book;
interface BookManager {
    void addBook(in Book book);
    List<Book> getBooks();
}
