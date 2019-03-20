package com.example.kisa_market;


import android.os.Parcel;
import android.os.Parcelable;

public class Notice implements Parcelable {


    String itemname;
    int price;
    int amount;
    public Notice( String itemname,int price,int amount) {
        this.itemname = itemname;
        this.price = price;
        this.amount = amount;
    }
    public Notice(Parcel in) {
        this.itemname = in.readString();
        this.price = in.readInt();
        this.amount = in.readInt();
    }

    public static final Creator<Notice> CREATOR = new Creator<Notice>() {
        @Override
        public Notice createFromParcel(Parcel in) {
            return new Notice(in);
        }

        @Override
        public Notice[] newArray(int size) {
            return new Notice[size];
        }
    };

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getPrice(){  return price;}

    public void setPrice(int price){ this.price=price;}

    public int getAmount(){ return amount;}

    public void setAmount(int amount){ this.amount=amount;}
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.itemname);
        parcel.writeInt(this.price);
        parcel.writeInt(this.amount);
    }
}
