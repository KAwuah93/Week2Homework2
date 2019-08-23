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
    private String id;

    public Animal() {
    }

    //visual assets
    private int cry = R.raw.beep;
    private int profilepic = R.drawable.defaultimg;

    public Animal(String name, String category, String diettype, String avatar, String description, String wiki, String id) {
        this.name = name;
        this.category = category;
        this.diettype = diettype;
        this.avatar = avatar;
        this.description = description;
        this.wiki = wiki;
        this.id = id;
    }

    protected Animal(Parcel in) {
        name = in.readString();
        category = in.readString();
        diettype = in.readString();
        avatar = in.readString();
        description = in.readString();
        wiki = in.readString();
        cry = in.readInt();
        profilepic = in.readInt();
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

    public void setCry(int cry){this.cry = cry;}
    public int getCry(){return this.cry;}

    public int getprofilepic(){return this.profilepic;}
    public void setprofilepic(int profilepic){this.profilepic = profilepic;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(int profilepic) {
        this.profilepic = profilepic;
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
        parcel.writeInt(cry);
        parcel.writeInt(profilepic);
        parcel.writeString(id);
    }
}
