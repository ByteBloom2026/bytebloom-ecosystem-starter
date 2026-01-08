package repository

import dataSource.CsvEcosystemDatasource
import domain.model.Mentee
import Repo.MenteeRepository
import dataSource.EcoSystemDataSource

class MenteeRepositoryImpl(private val menteeDataSource: EcoSystemDataSource
): MenteeRepository {
    override fun getAllMentees():List<Mentee> {
        return menteeDataSource.getMentees().map { row ->
            Mentee(
                id = row.menteeId,
                name = row.name,
                teamId = row.teamId
            )

        }

    }

    override fun getMenteeById(id: String): Mentee? {
        return getAllMentees().find { it.id===id  }
    }

    override fun getMenteesByTeamId(teamId: String): List<Mentee> {
        return getAllMentees().filter { it.teamId==teamId }
    }
}