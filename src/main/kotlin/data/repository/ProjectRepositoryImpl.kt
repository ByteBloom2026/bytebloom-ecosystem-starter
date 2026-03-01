package data.repository
import data.EcoSystemDataSource
import data.repository.mappers.toDomain
import domain.model.Project
class ProjectRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : ProjectRepository {
    override fun getAllProjects(): Result<List<Project>> {
        return dataSource.getProjects().map { list ->
            list.map { it.toDomain() }
        }
    }
    override fun getProjectByTeamId(teamId: String): Result<Project?> {
        return dataSource.getProjectByTeamId(teamId).map { project ->
            project?.toDomain()
        }
    }
}
