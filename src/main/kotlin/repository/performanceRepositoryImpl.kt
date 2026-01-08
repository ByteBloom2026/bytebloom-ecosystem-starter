package repository

import Repo.performanceRepository
import dataSource.CsvEcosystemDatasource
import dataSource.EcoSystemDataSource
import domain.model.performanceSubmission

class performanceRepositoryImpl(
    private val performanceDataSource: EcoSystemDataSource
): performanceRepository {
    override fun getAllPreformance(): List<performanceSubmission> {
        return performanceDataSource.getpreformance().map { row ->
            performanceSubmission(
                menteeId = row.menteeId,
                submissionId = row.submissionId,
                submissionType = row.submissionType,
                score=row.score
            )

        }
    }

 override fun getPerfoormanceByMenteeId(menteeId: String): List<performanceSubmission> {
        return getAllPreformance().filter { it.menteeId==menteeId }
    }

}