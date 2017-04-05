package com.cn.horizon.login.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cn.horizon.login.Book;
import com.cn.horizon.login.BookManager;
import com.cn.horizon.login.OnNewAddListner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by horizony on 2017/4/5.
 */

public class AIDLService extends Service {
    private RemoteCallbackList<OnNewAddListner> callbackList = new RemoteCallbackList<>();
    private List<Book> bookList = new ArrayList<>();

    private final BookManager.Stub bookManager = new BookManager.Stub() {
        @Override
        public void addBook(Book book) throws RemoteException {
            Log.d("AIDL", "addBook: " + book.getName());
            Log.d("AIDL", Thread.currentThread() + "");
            bookList.add(book);

            int total = callbackList.beginBroadcast();
            if (total > 0) {
                for (int i = 0; i < total; i++) {
                    OnNewAddListner listner = callbackList.getBroadcastItem(i);
                    listner.onNewArrive(book);
                }
            }
            callbackList.finishBroadcast();

        }

        @Override
        public List<Book> getBooks() throws RemoteException {
            return bookList;
        }

        @Override
        public void registListener(OnNewAddListner listener) throws RemoteException {
            callbackList.register(listener);
        }

        @Override
        public void unRegistLister(OnNewAddListner listener) throws RemoteException {
            callbackList.unregister(listener);
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
