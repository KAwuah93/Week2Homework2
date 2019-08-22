package com.example.week2homework2zoo;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    //creating the member variables
    private String name;
    private String category;
    private String diettype;
    //look at this later, we might do Image items
    private String avatar;
    private String description;
    private String wiki;


    public Animal(String name, String category, String diettype, String avatar, String description, String wiki) {
        this.name = name;
        this.category = category;
        this.diettype = diettype;
        this.avatar = avatar;
        this.description = description;
        this.wiki = wiki;
    }

    protected Animal(Parcel in) {
        name = in.readString();
        category = in.readString();
        diettype = in.readString();
        avatar = in.readString();
        description = in.readString();
        wiki = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String catagory) {
        this.category = catagory;
    }

    public String getDiettype() {
        return diettype;
    }

    public void setDiettype(String diettype) {
        this.diettype = diettype;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(category);
        parcel.writeString(diettype);
        parcel.writeString(avatar);
        parcel.writeString(description);
        parcel.writeString(wiki);
    }
}
