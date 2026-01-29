package domain.usecase
import Repository.MenteeRepository
import Repository.TeamRepository

class IsMenteeInTeam(
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
) {
    operator fun invoke(menteeId:String,teamName:String): Boolean{
        val mentee = menteeRepository.getAllMentees()
            .find { it.id == menteeId }
            ?: return false
          return teamRepository.getAllTeams()
              .find { it.teamId == mentee.teamId }
              ?.teamName == teamName
    }
}