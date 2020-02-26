/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.dvd;

import com.tsg.dvd.UI.DvdView;
import com.tsg.dvd.UI.UserIO;
import com.tsg.dvd.UI.UserIoConsoleImpl;
import com.tsg.dvd.controller.DvdController;
import com.tsg.dvd.dao.DvdDao;
import com.tsg.dvd.dao.DvdDaoImpl;

/**
 *
 * @author nick96
 */
public class DvdApp {

    public static void main(String[] args) {
        UserIO myIo = new UserIoConsoleImpl();
        DvdView myView = new DvdView(myIo);
        DvdDao myDao = new DvdDaoImpl();
        DvdController controller
                = new DvdController(myDao, myView);
        controller.run();
    }

}

