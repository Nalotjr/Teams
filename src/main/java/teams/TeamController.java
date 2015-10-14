package teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import teams.model.Team;
import teams.service.TeamService;

@Controller
@RequestMapping("/")
public class TeamController {

    private TeamService teamService;

    @Autowired(required = true)
    @Qualifier(value = "teamService")
    public void setTeamService(TeamService ts){
        this.teamService=ts;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTeams(Model model){
        model.addAttribute("team", new Team());
        model.addAttribute("listTeams", this.teamService.listTeams());
        return "team";
    }

    //For add and update team both
    @RequestMapping(value = "/team/add", method = RequestMethod.POST)
    public String addTeam(@ModelAttribute("team") Team t){
        System.out.println("in "+t);
        if(null == t.getId()){
            //new team, add it
            this.teamService.addTeam(t);
        }else{
            //existing team, call update
            this.teamService.updateTeam(t);
        }
        return "redirect:/";
    }

    @RequestMapping("/remove/{id}")
    public String removeTeam(@PathVariable("id") int id){
        this.teamService.removeTeam(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editTeam(@PathVariable("id") int id, Model model){
        model.addAttribute("team", this.teamService.getTeamById(id));
        model.addAttribute("listTeams", this.teamService.listTeams());
        return "team";
    }
}
