package data.repository

import domain.model.Team
import data.EcoSystemDataSource
import data.repository.mappers.toDomain

class TeamRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : TeamRepository {
    override fun getAllTeams(): Result<List<Team>> {
        return dataSource.getTeams().map { list ->
            list.map { it.toDomain() }
        }
    }
    override fun getTeamById(teamId: String): Result<Team?> {
        return dataSource.getTeamById(teamId).map { team ->
            team?.toDomain()
        }
    }
    override fun getMentorLeadByTeamId(teamId: String): Result<String?> {
        return dataSource.getTeamById(teamId).map { team ->
            team?.mentorLead
        }
    }
}