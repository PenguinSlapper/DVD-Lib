package com.tsg.dvd.dao;

import com.tsg.dvd.DTO.DVD;
import java.util.List;

/**
 *
 * @author nick9
 */
public interface DvdDao {

    DVD addDVD(String title, DVD dvd) throws DvdDaoException;

    List<DVD> getAllDVDs()throws DvdDaoException;

    DVD getDVD(String title)throws DvdDaoException;

    DVD removeDVD(String title)throws DvdDaoException;

    DVD updateDVD(String title, DVD dvd)throws DvdDaoException;
    
   
}
