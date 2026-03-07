package domain.usecase

import data.repository.TeamRepository
import domain.model.Team

class SearchTeamsByNameUseCase(
    private val teamRepository: TeamRepository
) {
    operator fun invoke(keyword: String): List<Team> {
        return teamRepository.getAllTeams()
            .filter { it.name.contains(query, ignoreCase = true) }
    }
}


