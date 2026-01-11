package Repo
import domain.model.PerformanceSubmission
interface PerformanceRepository {
    fun getAllPerformance(): List<PerformanceSubmission>
    fun getPerformanceByMenteeId(menteeId: String):List<PerformanceSubmission>
}