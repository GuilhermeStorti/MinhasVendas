package com.curso.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by guilherme on 27/10/16.
 */
public class JpaUtil {

    private static EntityManagerFactory emf = null;

    public static void closeManager(EntityManager manager){
        try {
            manager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static EntityManager getManager(){
        try {
            return getEmf().createEntityManager();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static EntityManagerFactory getEmf() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("locacao");
        }
        return emf;
    }
}
