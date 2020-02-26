/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.dvd.DTO;

import java.util.Objects;

/**
 *
 * @author nick9
 */
public class DVD {

    private String title;
    private String releaseDate;
    private String Director;
    private String mpaaRating;
    private String genre;
    private String Stuido;
    private String userRating;
    private String starring;

    public DVD() {

    }

    public DVD(String title) {
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStuido() {
        return Stuido;
    }

    public void setStuido(String Stuido) {
        this.Stuido = Stuido;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public boolean containsKey(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.releaseDate);
        hash = 53 * hash + Objects.hashCode(this.Director);
        hash = 53 * hash + Objects.hashCode(this.mpaaRating);
        hash = 53 * hash + Objects.hashCode(this.genre);
        hash = 53 * hash + Objects.hashCode(this.Stuido);
        hash = 53 * hash + Objects.hashCode(this.userRating);
        hash = 53 * hash + Objects.hashCode(this.starring);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.Director, other.Director)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.Stuido, other.Stuido)) {
            return false;
        }
        if (!Objects.equals(this.userRating, other.userRating)) {
            return false;
        }
        if (!Objects.equals(this.starring, other.starring)) {
            return false;
        }
        return true;
    }

 
}
