package data.repository
import domain.model.Mentee
import data.EcoSystemDataSource
import data.repository.mappers.toDomain
class MenteeRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : MenteeRepository {
    override fun getAllMentees(): Result<List<Mentee>> {
        return dataSource.getMentees().map { list ->
            list.map { it.toDomain() }
        }
    }
    override fun getMenteeById(id: String): Result<Mentee?> {
        return dataSource.getMenteeById(id).map { mentee ->
            mentee?.toDomain()
        }
    }
    override fun getMenteesByTeamId(teamId: String): Result<List<Mentee>> {
        return dataSource.getMenteesByTeamId(teamId).map { list ->
            list.map { it.toDomain() }
        }
    }
}


