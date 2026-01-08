package repository

import Repo.TeamRepository
import dataSource.CsvEcosystemDatasource
import domain.model.Team

class TeamRepositoryImpl(
    private val teamDataSource: CsvEcosystemDatasource
) : TeamRepository{
    override fun getAllTeams(): List<Team> {
        return teamDataSource.getTeam().map { row ->
            Team(
                teamId = row.teamId,
                teamName = row.teamName,
                mentorLead = row.mentorLead
            )

        }
    }


    override fun getTeamById(teamId: String): Team? {
        return getAllTeams().find { it.teamId==teamId }
    }

    override fun getMentorLeadByTeamId(teamId: String): String? {
        return getTeamById(teamId)?.mentorLead
    }
}