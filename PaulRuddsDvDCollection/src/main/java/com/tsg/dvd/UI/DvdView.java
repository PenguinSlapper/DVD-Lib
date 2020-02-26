package com.tsg.dvd.UI;

import com.tsg.dvd.DTO.DVD;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nick9
 */
public class DvdView {

    private final UserIO io;

    public DvdView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("**Main Menu**");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD Information");
        io.print("4. List DVD Collection");
        io.print("5. DVD Info");
        io.print("6. Search For DVD");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter DVD title").toUpperCase();
        String Director = io.readString("Please enter Name director name.");
        String studio = io.readString("Please enter studio name");
        String releaseDate = io.readString("Please enter release Date");
        String genre = io.readString("Please enter genre");
        String starring = io.readString("Please Enter Who stars in the film.");
        String mpaaRating = io.readString("Please enter mpaa Rating");
        String userRating = io.readString("Please enter user rating and comments.");

        DVD currentDVD = new DVD();
        currentDVD.setTitle(title.toUpperCase());
        currentDVD.setDirector(Director);
        currentDVD.setStuido(studio);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setGenre(genre);
        currentDVD.setStarring(starring);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setUserRating(userRating);

        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Successfully created.  Please hit enter to continue");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print(currentDVD.getTitle() + ": "
                    + currentDVD.getDirector() + ": "
                    + currentDVD.getStuido() + ": "
                    + currentDVD.getReleaseDate() + ": "
                    + currentDVD.getGenre() + ": "
                    + currentDVD.getStarring() + ": "
                    + currentDVD.getMpaaRating() + ": "
                    + currentDVD.getUserRating());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDVDChoice() {
        return io.readString("Please enter the DVD Title.").toUpperCase();
    }

    public void displaySearchDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getDirector());
            io.print(dvd.getStuido());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getGenre());
            io.print(dvd.getStarring());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getUserRating());

        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD was successfully removed. Please hit enter to continue.");
    }

    public void displayEditSuccessBanner() {
        io.readString("Edit successfully Added. Please hit enter to continue.");
    }

    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayExitBanner() {
        io.print("===Good Bye===");
    }

    public void displayUnknownCommand() {
        io.print("UNKNOWN COMMAND");
    }

    public void displaySearchBanner() {
        io.print("===DVD Search===");
    }

    public void displayviewEndDVD() {
        io.print("===End DVD Search===");
    }

    public void displayDvdListEndBanner() {
        io.print("===End DVD List===");
    }

    public void displaySearchEndDVD() {
        io.print("===End DVD Search===");
    }
     public void displaynoDVDfound() {
        io.print("===No DVD Found==");
    }

    public void displaySearchesDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getDirector());
            io.print(dvd.getStuido());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getGenre());
            io.print(dvd.getStarring());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getUserRating());

        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayErrorMessage(String message) {
        io.print("Sorry cant find it):");
    }
public String getTitleToSearchFor() {
       String title = io.readString("What title would you like to Search for?");
        return title;
}

    public void displayDvd(DVD DVDToLookAt) {
      String titleToSearch = DVDToLookAt.getTitle();
        
        
   
    }

  
    

}
