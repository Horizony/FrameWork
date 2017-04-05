package com.cn.horizon.login;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by horizony on 2017/4/5.
 */

public class Book implements Parcelable {
    private String name;
    private int no;
    private int price;

    public Book() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void readFormParcel(Parcel dest) {
        name = dest.readString();
        no = dest.readInt();
        price = dest.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.no);
        dest.writeInt(this.price);
    }

    protected Book(Parcel in) {
        this.name = in.readString();
        this.no = in.readInt();
        this.price = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
