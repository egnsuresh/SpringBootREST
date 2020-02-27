package com.app.restapisample.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="products")
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long productsId;
    @Column(name="description")
    private  String description;
    @Column(name="issueId")
    private String issueId;

    public long getProductsId() {
        return productsId;
    }

    public void setProductsId(long productsId) {
        this.productsId = productsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return getProductsId() == that.getProductsId() &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getIssueId(), that.getIssueId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductsId(), getDescription(), getIssueId());
    }

    @Override
    public String toString() {
        return "Product{" +
                "productsId=" + productsId +
                ", description='" + description + '\'' +
                ", issueId='" + issueId + '\'' +
                '}';
    }
}
