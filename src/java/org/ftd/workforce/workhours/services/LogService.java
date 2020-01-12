package org.ftd.workforce.workhours.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.builderforce.tasks.persistence.daos.LogDAO;
import org.builderforce.tasks.persistence.entities.Log;
import org.ftd.workforce.workhours.enums.APP;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0
 * @since 2020-01-11
 *
 */
public class LogService {

    private static final LogService INSTANCE;

    static {
        INSTANCE = new LogService();
    }

    public static LogService getInstance() {
        return INSTANCE;
    }

    public void simpleRecordUserActivity(Long userId, String name, String entity, String userAction) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(APP.PERSISTENCE_UNIT.getValue());
        LogDAO dao = new LogDAO(factory);
        Log o = new Log();
        o.setUserId(userId);
        o.setName(name);
        o.setEntityName(entity);
        o.setUserAction(userAction);
        dao.create(o);
    }
    
    public void fullRecordUserActivity() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private LogService() {
    }

}
