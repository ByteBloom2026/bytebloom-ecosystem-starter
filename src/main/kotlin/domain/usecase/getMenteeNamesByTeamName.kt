package domain.usecase

import Repository.MenteeRepository
import Repository.TeamRepository

class getMenteeNamesByTeamName(
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
) {
    operator fun invoke(teamName: String): List<String> {
        val teamId = teamRepository.getTeamById(teamId = String())
            ?.teamId
            ?: return emptyList()
        return menteeRepository.getAllMentees()
            .filter { it.teamId == teamId }
            .map { it.name }
    }
}


