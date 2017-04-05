// BookManager.aidl
package com.cn.horizon.login;

// Declare any non-default types here with import statements
import com.cn.horizon.login.Book;
import com.cn.horizon.login.OnNewAddListner;

interface BookManager {
    void addBook(in Book book);
    List<Book> getBooks();
    void registListener(OnNewAddListner listener);
    void unRegistLister(OnNewAddListner listener);
}
