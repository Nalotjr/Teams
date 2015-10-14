package teams.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import teams.model.Team;

import java.util.List;

@Repository
public class TeamDAOImpl implements TeamDAO {

    private static final Logger logger = LoggerFactory.getLogger(TeamDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addTeam(Team t) {
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println(t);
        session.persist(t);
        logger.info("Team saved successfully, Team Details="+t);
    }

    @Override
    public void updateTeam(Team t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(t);
        logger.info("Team updated successfully, Team Details="+t);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Team> listTeams() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Team> teamsList = session.createQuery("from Team").list();
        for(Team p : teamsList){
            logger.info("Teams List::"+p);
        }
        return teamsList;
    }

    @Override
    public Team getTeamById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Team t = (Team) session.load(Team.class, new Integer(id));
        logger.info("Team loaded successfully, Team details="+t);
        return t;
    }

    @Override
    public void removeTeam(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Team t = (Team) session.load(Team.class, new Integer(id));
        if(null != t){
            session.delete(t);
        }
        logger.info("Team deleted successfully, Team details="+t);
    }
}
