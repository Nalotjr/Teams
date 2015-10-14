package teams.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teams.dao.TeamDAO;
import teams.model.Team;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamDAO teamDAO;

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    @Transactional
    public void addTeam(Team t) {
        this.teamDAO.addTeam(t);
    }

    @Override
    @Transactional
    public void updateTeam(Team t) {
        this.teamDAO.updateTeam(t);
    }

    @Override
    @Transactional
    public List<Team> listTeams() {
        return this.teamDAO.listTeams();
    }

    @Override
    @Transactional
    public Team getTeamById(int id) {
        return this.teamDAO.getTeamById(id);
    }

    @Override
    @Transactional
    public void removeTeam(int id) {
        this.teamDAO.removeTeam(id);
    }
}
