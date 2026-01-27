package domain.usecase
import domain.model.Mentee
import domain.model.Team
class getMenteeNamesByTeamName  (
    private val mentees: List<Mentee>,
    private val teams: List<Team>

) {
    fun execute(teamName: String): List<String> {
        val teamId = teams
            .find { it.teamName == teamName }
            ?.teamId
            ?: return emptyList()
        return mentees
            .filter { it.teamId == teamId }
            .map { it.name }
    }
}


