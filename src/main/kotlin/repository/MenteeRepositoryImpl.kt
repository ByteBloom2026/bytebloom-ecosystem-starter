package repository
import domain.model.Mentee
import Repo.MenteeRepository
import dataSource.EcoSystemDataSource
import domain.mappers.toDomain
class MenteeRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : MenteeRepository {
    override fun getAllMentees(): List<Mentee> =
        dataSource.getMentees().map { it.toDomain() }
    override fun getMenteeById(id: String): Mentee? =
        getAllMentees().find { it.id == id }
    override fun getMenteesByTeamId(teamId: String): List<Mentee> =
        getAllMentees().filter { it.teamId == teamId }
}