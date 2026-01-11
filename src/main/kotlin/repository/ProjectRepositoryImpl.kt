package repository
import Repo.ProjectRepository
import dataSource.EcoSystemDataSource
import domain.mappers.toDomain
import domain.model.Project
class ProjectRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : ProjectRepository {
    override fun getAllProjects(): List<Project> =
        dataSource.getProjects().map { it.toDomain() }
    override fun getProjectByTeamId(teamId: String): Project? =
        getAllProjects().find { it.teamId == teamId }
}