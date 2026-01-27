package domain.usecase
import domain.model.Mentee
import domain.model.Team
class IsMenteeInTeam(
    private val  mentee: List<Mentee>,
    private val teams : List<Team>
) {
    fun execute(menteeId:String,teamName:String): Boolean{
        val mentee = mentee.find { it.id == menteeId }
            ?: return false
          return teams.find { it.teamId == mentee.teamId }
              ?.teamName == teamName
    }
}