package domain.usecase
import data.repository.TeamRepository
import domain.model.Team
class GroupTeamsByMentorUseCase(private val teamRepository: TeamRepository){
    fun execute(): Map<String, List<Team>>{
        return teamRepository.getAllTeams().groupBy {it.mentorLead}
    }

}



