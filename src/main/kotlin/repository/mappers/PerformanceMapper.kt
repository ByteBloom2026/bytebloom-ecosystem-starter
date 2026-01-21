package repository.mappers
import data.dataSource.model.PerformanceRow
import domain.model.PerformanceSubmission
fun PerformanceRow.toDomain(): PerformanceSubmission =
    PerformanceSubmission(
        menteeId = menteeId,
        submissionId = submissionId,
        submissionType = submissionType,
        score = score
    )
