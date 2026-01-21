package repository
import Repository.ProjectRepository
import data.dataSource.EcoSystemDataSource
import repository.mappers.toDomain
import domain.model.Project
class ProjectRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : ProjectRepository {
    override fun getAllProjects(): List<Project> =
        dataSource.getProjects().map { it.toDomain() }
    override fun getProjectByTeamId(teamId: String): Project? =
        dataSource.getProjectByTeamId(teamId)?.toDomain()
}