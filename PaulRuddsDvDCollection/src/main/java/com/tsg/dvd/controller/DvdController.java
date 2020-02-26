/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.dvd.controller;

import com.tsg.dvd.DTO.DVD;
import com.tsg.dvd.UI.DvdView;
import com.tsg.dvd.UI.UserIO;
import com.tsg.dvd.dao.DvdDao;
import com.tsg.dvd.dao.DvdDaoException;
import java.util.List;

/**
 *
 * @author nick9
 */
public class DvdController {

    private UserIO io;
    private final DvdView view;
    private final DvdDao dao;
    private DVD dvd;

    public DvdController(DvdDao dao, DvdView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {

            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        updateDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        viewDVD();
                        break;
                    case 6:
                        
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();

                }

            }
            exitMsg();

        } catch (DvdDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DvdDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVDs() throws DvdDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
        view.displayDvdListEndBanner();
    }

    private void viewDVD() throws DvdDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDChoice();
        DVD dvd = dao.getDVD(title);
        view.displaySearchDVD(dvd);
        view.displayviewEndDVD();
    }

    private void removeDVD() throws DvdDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDChoice();
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }

    private void updateDVD() throws DvdDaoException {

        List<DVD> dvdList = dao.getAllDVDs();
        if (dvdList.size() > 0) {
            view.displayDVDList(dvdList);
            String title = view.getTitleToSearchFor();

            if (dvdList.contains(title)) {
                DVD editDvd = view.getNewDVDInfo();
                dao.removeDVD(title);
                dao.updateDVD(editDvd.getTitle(), editDvd);
                view.displayEditSuccessBanner();
            } else {
               view.displaynoDVDfound();

            }

        }
    }

    private void exitMsg() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommand();
    }

    private void searchDVD() throws DvdDaoException {
        view.displaySearchBanner();

        view.displaySearchEndDVD();
    }

}
