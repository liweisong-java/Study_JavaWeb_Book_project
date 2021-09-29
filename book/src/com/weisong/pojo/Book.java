package com.weisong.pojo;

import java.math.BigDecimal;

/**
 * @author 李伟松
 * @create 2021-09-29-14:25
 */
public class Book {
    private Integer id;
    private String mame;
    private String author;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String imgPath = "static/img/default.jpg";

    public Book() {
    }

    public Book(Integer id, String mame, String author, BigDecimal price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.mame = mame;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        //要求给定的图书封面图书路径不能为空
        if (imgPath != null && !"".equals(imgPath)){
            this.imgPath = imgPath;
        }
    }

    public Integer getId() {
        return id;
    }

    public String getMame() {
        return mame;
    }

    public String getAuthor() {
        return author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getSales() {
        return sales;
    }

    public Integer getStock() {
        return stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMame(String mame) {
        this.mame = mame;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setImgPath(String imgPath) {
        //要求给定的图书封面图书路径不能为空
        if (imgPath != null && !"".equals(imgPath)){
            this.imgPath = imgPath;
        }
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", mame='" + mame + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }


}
