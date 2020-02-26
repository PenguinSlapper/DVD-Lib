package com.tsg.dvd.dao;

import com.tsg.dvd.DTO.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nick9
 */
public class DvdDaoImpl implements DvdDao {

    private Map<String, DVD> dvds = new HashMap<>();

    public static final String DVD_FILE = "DVD.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String title, DVD dvd) throws DvdDaoException {
        loadDVD();
        DVD newDVD = dvds.put(title, dvd);
        writeDVD();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DvdDaoException {
        loadDVD();
        return new ArrayList<>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DvdDaoException {
        loadDVD();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DvdDaoException {
        loadDVD();
        DVD removedDVD = dvds.remove(title);
        writeDVD();
        return removedDVD;
    }

    @Override
    public DVD updateDVD(String title, DVD dvd) {
        DVD editedDvd = dvds.put(title, dvd);
        return editedDvd;
    }

    private DVD unmarshallDvd(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        DVD dvdFromFile = new DVD(title);
        dvdFromFile.setDirector(dvdTokens[1]);
        dvdFromFile.setStuido(dvdTokens[2]);
        dvdFromFile.setReleaseDate(dvdTokens[3]);
        dvdFromFile.setGenre(dvdTokens[4]);
        dvdFromFile.setStarring(dvdTokens[5]);
        dvdFromFile.setMpaaRating(dvdTokens[6]);
        dvdFromFile.setUserRating(dvdTokens[7]);
        return dvdFromFile;
    }

    private void loadDVD() throws DvdDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdDaoException("Could not load collection into memory. ", e);

        }
        String currentLine;

        DVD currentDVD;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentDVD = unmarshallDvd(currentLine);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }

    private String marshallDvd(DVD dvd) {
        String dvdAsText = dvd.getTitle() + DELIMITER;
        dvdAsText += dvd.getDirector() + DELIMITER;
        dvdAsText += dvd.getStuido() + DELIMITER;
        dvdAsText += dvd.getReleaseDate() + DELIMITER;
        dvdAsText += dvd.getGenre() + DELIMITER;
        dvdAsText += dvd.getStarring() + DELIMITER;
        dvdAsText += dvd.getMpaaRating() + DELIMITER;
        dvdAsText += dvd.getUserRating() + DELIMITER;
        return dvdAsText;
    }

    private void writeDVD() throws DvdDaoException {

        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DvdDaoException("Could not Save Data.", e);

        }
        String dvdAsText;
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            dvdAsText = marshallDvd(currentDVD);

            out.println(dvdAsText);

            out.flush();
        }
        out.close();
    }
}
