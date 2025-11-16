package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import java.io.Serializable;

public class feedback implements Serializable {
    private String rating;
    private String yourComment;

    public feedback(String rating, String yourComment) {
        this.rating = rating;
        this.yourComment = yourComment;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYourComment() {
        return yourComment;
    }

    public void setYourComment(String yourComment) {
        this.yourComment = yourComment;
    }

    @Override
    public String toString() {
        return "feedback{" +
                "rating='" + rating + '\'' +
                ", yourComment='" + yourComment + '\'' +
                '}';
    }
}
