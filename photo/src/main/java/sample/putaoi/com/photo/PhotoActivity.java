package sample.putaoi.com.photo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.cn.horizon.login.Book;
import com.cn.horizon.login.BookManager;
import com.cn.horizon.login.OnNewAddListner;

import java.util.ArrayList;
import java.util.List;

public class PhotoActivity extends AppCompatActivity {
    private final String ACTION_NAME = "com.cn.horizon.aidl";
    private BookManager bookManager;
    private MyOnNewListener newListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bookManager != null) {
                    Book book = new Book();
                    book.setName("Android 群英会");
                    book.setPrice(69);
                    book.setNo(1020089);
                    try {
                        bookManager.addBook(book);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        bindService();
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setAction(ACTION_NAME);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                bookManager = BookManager.Stub.asInterface(service);
                newListener = new MyOnNewListener();
                try {
                    bookManager.registListener(newListener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                List<Book> books = null;
                try {
                    books = bookManager.getBooks();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if (books != null && !books.isEmpty()) {
                    for (Book b : books) {
                        Log.d("AIDL", "onServiceConnected: " + b.getName());
                        Log.d("AIDL", Thread.currentThread() + "");
                    }
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);
    }

    private class MyOnNewListener extends OnNewAddListner.Stub {

        @Override
        public void onNewArrive(Book book) throws RemoteException {
            Log.d("AIDL", "onNewArrive: " + book.getName());
            Log.d("AIDL", Thread.currentThread() + "");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            bookManager.unRegistLister(newListener);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
