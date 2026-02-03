package domain.usecase
import data.repository.TeamRepository
class CountTeamsByMentorUseCase (private val teamRepository: TeamRepository){
    fun execute(): Map<String, Int>{
        return teamRepository.getAllTeams()
            .groupBy{it.mentorLead}
            .mapValues { (_, teams) -> teams.size }
    }
}









