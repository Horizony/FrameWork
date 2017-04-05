package com.cn.horizon.login.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cn.horizon.login.Book;
import com.cn.horizon.login.BookManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by horizony on 2017/4/5.
 */

public class AIDLService extends Service {
    private List<Book> bookList = new ArrayList<>();

    private final BookManager.Stub bookManager = new BookManager.Stub() {
        @Override
        public void addBook(Book book) throws RemoteException {
            Log.d("AIDL", "addBook: " + book.getName());
            bookList.add(book);
        }

        @Override
        public List<Book> getBooks() throws RemoteException {
            return bookList;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Book book = new Book();
        book.setName("Android开发艺术探索");
        book.setPrice(28);
        book.setNo(1010023);
        bookList.add(book);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return bookManager;
    }
}
