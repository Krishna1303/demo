package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "surveys")
public class SurveyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="streetAddress")
    private String streetAddress;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="zip")
    private String zip;
    @Column(name="telephone")
    private String telephone;
    @Column(name="email")
    private String email;
    @Column(name="dateOfSurvey")
    private String dateOfSurvey;
    @Column(name="likedMost")
    private String likedMost;
    @Column(name="interestedBy")
    private String interestedBy;
    @Column(name="likelihood")
    private String likelihood;
    @Column(name="raffle")
    private String raffle;
    @Column(name="comments")
    private String comments;

    // Default constructor (required by JPA)
    public SurveyModel() {
    }

    // Getters and setters for all fields
    // You can generate these using your IDE or write them manually

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfSurvey() {
        return dateOfSurvey;
    }

    public void setDateOfSurvey(String dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public String getLikedMost() {
        return likedMost;
    }

    public void setLikedMost(String likedMost) {
        this.likedMost = likedMost;
    }

    public String getInterestedBy() {
        return interestedBy;
    }

    public void setInterestedBy(String interestedBy) {
        this.interestedBy = interestedBy;
    }

    public String getLikelihood() {
        return likelihood;
    }

    public void setLikelihood(String likelihood) {
        this.likelihood = likelihood;
    }

    public String getRaffle() {
        return raffle;
    }

    public void setRaffle(String raffle) {
        this.raffle = raffle;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}