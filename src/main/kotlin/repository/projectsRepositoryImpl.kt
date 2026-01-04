package repository

import Repo.projectsRepository
import dataSource.CsvEcosystemDatasource
import domain.model.projects

class projectsRepositoryImpl
    (private val projectDataSource: CsvEcosystemDatasource)
    : projectsRepository {
    override fun getAllProject(): List<projects> {
        return projectDataSource.getproject().map {row ->
            projects(
            projectId=row.projectId,
            projectName=row.projectName,
            teamId=row.teamId)

        }
    }

    override fun getProjectByTeamId(teamId: String): projects? {
        return getAllProject().find{ it.teamId==teamId }
    }
}