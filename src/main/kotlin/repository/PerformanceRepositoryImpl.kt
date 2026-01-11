package repository

import domain.model.PerformanceSubmission
import Repo.PerformanceRepository
import dataSource.EcoSystemDataSource
import domain.mappers.toDomain
class PerformanceRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : PerformanceRepository {
    override fun getAllPerformance(): List<PerformanceSubmission> =
        dataSource.getPerformances().map { it.toDomain() }
    override fun getPerformanceByMenteeId(menteeId: String): List<PerformanceSubmission> =
        getAllPerformance().filter { it.menteeId == menteeId }
}
