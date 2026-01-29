package domain.usecase

import Repository.AttendanceRepository
import Repository.MenteeRepository


class GenerateTeamAttendanceReport(
    private val attendanceRepository: AttendanceRepository,
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(teamId: String): Map<String, Int> =
        menteeRepository.getMenteesByTeamId(teamId)
            .associate { mentee ->
                val absences = attendanceRepository
                    .getAttendanceByMenteeId(mentee.id)
                    ?.weeks
                    ?.count { it.uppercase() != "PRESENT" }
                    ?: 0
                mentee.id to absences
            }
}