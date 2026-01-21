package repository

import domain.model.PerformanceSubmission
import Repository.PerformanceRepository
import data.dataSource.EcoSystemDataSource
import repository.mappers.toDomain
class PerformanceRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : PerformanceRepository {
    override fun getAllPerformance(): List<PerformanceSubmission> =
        dataSource.getPerformances().map { it.toDomain() }
    override fun getPerformanceByMenteeId(menteeId: String): List<PerformanceSubmission> =
        dataSource.getPerformanceByMenteeId(menteeId).map { it.toDomain() }
}
