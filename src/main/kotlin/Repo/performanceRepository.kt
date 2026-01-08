package Repo

import domain.model.performanceSubmission

interface performanceRepository {
    fun getAllPreformance(): List<performanceSubmission>
    fun getPerfoormanceByMenteeId(menteeId: String):List<performanceSubmission>

}