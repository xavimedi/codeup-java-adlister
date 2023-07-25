package com.codeup.adlister.dao;

import dao.Config;


public class DaoFactory {
    private static Ads adsDao;
    private static UsersDao usersDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static UsersDao getUsersDao(){
        if (usersDao == null){
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
