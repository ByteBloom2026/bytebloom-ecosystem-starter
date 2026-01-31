package domain.usecase


import data.repository.TeamRepository
import domain.model.Project

class GetProjectByTeamIdUesCase (private val teamRepository: TeamRepository) {
    fun excute(teamId: String): Project? {
        return teamRepository.getTeamById(teamId)?.projects

    }
}