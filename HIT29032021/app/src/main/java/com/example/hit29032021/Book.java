package com.example.hit29032021;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable{
    private String titleProduct, authorProduct, publisherProduct, imageLink, imagePublicId, descriptionProduct, categotyProduct;
    private int releaseYear, priceProduct, numberOfReview, numberOfPage, rateStar;

    public Book(String imageLink, String imagePublicId, String titleProduct, String authorProduct, String publisherProduct,int releaseYear,int numberOfReview, int priceProduct, String descriptionProduct, String categotyProduct, int rateStar, int numberOfPage) {
        this.titleProduct = titleProduct;
        this.authorProduct = authorProduct;
        this.publisherProduct = publisherProduct;
        this.imageLink = imageLink;
        this.imagePublicId = imagePublicId;
        this.descriptionProduct = descriptionProduct;
        this.categotyProduct = categotyProduct;
        this.releaseYear = releaseYear;
        this.priceProduct = priceProduct;
        this.numberOfReview = numberOfReview;
        this.numberOfPage = numberOfPage;
        this.rateStar = rateStar;
    }
    public Book(String imageLink, String titleProduct, String authorProduct, int numberOfReview, int priceProduct, String descriptionProduct, String categotyProduct, int rateStar, int numberOfPage) {
        this.titleProduct = titleProduct;
        this.authorProduct = authorProduct;
        this.imageLink = imageLink;
        this.descriptionProduct = descriptionProduct;
        this.categotyProduct = categotyProduct;
        this.priceProduct = priceProduct;
        this.numberOfReview = numberOfReview;
        this.numberOfPage = numberOfPage;
        this.rateStar = rateStar;
    }
    public Book(String imageLink, String titleProduct, String authorProduct, int priceProduct, String descriptionProduct, int rateStar) {
        this.titleProduct = titleProduct;
        this.authorProduct = authorProduct;

        this.imageLink = imageLink;

        this.descriptionProduct = descriptionProduct;

        this.priceProduct = priceProduct;

        this.rateStar = rateStar;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getTitleProduct() {
        return titleProduct;
    }

    public void setTitleProduct(String titleProduct) {
        this.titleProduct = titleProduct;
    }

    public String getAuthorProduct() {
        return authorProduct;
    }

    public void setAuthorProduct(String authorProduct) {
        this.authorProduct = authorProduct;
    }

    public String getPublisherProduct() {
        return publisherProduct;
    }

    public void setPublisherProduct(String publisherProduct) {
        this.publisherProduct = publisherProduct;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImagePublicId() {
        return imagePublicId;
    }

    public void setImagePublicId(String imagePublicId) {
        this.imagePublicId = imagePublicId;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public String getCategotyProduct() {
        return categotyProduct;
    }

    public void setCategotyProduct(String categotyProduct) {
        this.categotyProduct = categotyProduct;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getNumberOfReview() {
        return numberOfReview;
    }

    public void setNumberOfReview(int numberOfReview) {
        this.numberOfReview = numberOfReview;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public int getRateStar() {
        return rateStar;
    }

    public void setRateStar(int rateStar) {
        this.rateStar = rateStar;
    }


    protected  Book(Parcel in) {
        titleProduct = in.readString();
        authorProduct = in.readString();
        publisherProduct = in.readString();
        imageLink = in.readString();
        imagePublicId = in.readString();
        descriptionProduct = in.readString();
        categotyProduct = in.readString();
        releaseYear = in.readInt();
        priceProduct = in.readInt();
        numberOfReview = in.readInt();
        numberOfPage = in.readInt();
        rateStar = in.readInt();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titleProduct);
        dest.writeString(authorProduct);
        dest.writeString(publisherProduct);
        dest.writeString(imageLink);
        dest.writeString(imagePublicId);
        dest.writeString(descriptionProduct);
        dest.writeString(categotyProduct);
        dest.writeInt(releaseYear);
        dest.writeInt(priceProduct);
        dest.writeInt(numberOfReview);
        dest.writeInt(numberOfPage);
        dest.writeInt(rateStar);
    }


}
