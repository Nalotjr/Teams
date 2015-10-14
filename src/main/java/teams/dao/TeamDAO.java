package teams.dao;

import teams.model.Team;

import java.util.List;

public interface TeamDAO {
    public void addTeam(Team t);
    public void updateTeam(Team t);
    public List<Team> listTeams();
    public Team getTeamById(int id);
    public void removeTeam(int id);
}
