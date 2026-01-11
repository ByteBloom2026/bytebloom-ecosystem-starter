package repository
import domain.model.Team
import Repo.TeamRepository
import dataSource.EcoSystemDataSource
import domain.mappers.toDomain
class TeamRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : TeamRepository {
    override fun getAllTeams(): List<Team> =
        dataSource.getTeams().map { it.toDomain() }
    override fun getTeamById(teamId: String): Team? =
        getAllTeams().find { it.teamId == teamId }
    override fun getMentorLeadByTeamId(teamId: String): String? =
        getTeamById(teamId)?.mentorLead
}