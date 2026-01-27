package domain.usecase
import domain.model.Mentee
import domain.model.Team

class getTeamByMenteeName (
    private val mentees: List<Mentee>,
    private val teams: List<Team>
){
    fun execute(menteeName: String): String? {
        val mentee = mentees.find { it.name == menteeName }
        val team = teams.find { it.teamId == mentee?.teamId }
        return team?.teamName
    }
}