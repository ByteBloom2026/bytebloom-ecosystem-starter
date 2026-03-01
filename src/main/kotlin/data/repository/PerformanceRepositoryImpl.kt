package data.repository
import domain.model.PerformanceSubmission
import data.EcoSystemDataSource
import data.repository.mappers.toDomain
class PerformanceRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : PerformanceRepository {
    override fun getAllPerformance(): Result<List<PerformanceSubmission>> {
        return dataSource.getPerformances().map { list ->
            list.map { it.toDomain() }
        }
    }
    override fun getPerformanceByMenteeId(menteeId: String): Result<List<PerformanceSubmission>> {
        return dataSource.getPerformanceByMenteeId(menteeId).map { list ->
            list.map { it.toDomain() }
        }
    }

}
