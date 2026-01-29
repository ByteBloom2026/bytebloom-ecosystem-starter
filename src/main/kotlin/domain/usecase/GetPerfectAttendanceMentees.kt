package domain.usecase
import Repository.AttendanceRepository
import Repository.MenteeRepository
import domain.model.Mentee
class GetPerfectAttendanceMentees (
    private val attendanceRepository: AttendanceRepository,
    private val menteeRepository: MenteeRepository
)
{
    operator fun invoke(): List<Mentee> =
        menteeRepository.getAllMentees()
            .filter { mentee -> attendanceRepository.getAttendanceByMenteeId(mentee.id)
                    ?.weeks
                    ?.all { it.uppercase() == "PRESENT" }
                    ?: false
            }
}