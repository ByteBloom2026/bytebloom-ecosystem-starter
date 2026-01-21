package domain
import Repository.AttendanceRepository
import Repository.MenteeRepository
import Repository.TeamRepository
import Repository.PerformanceRepository
import Repository.ProjectRepository
import domain.model.Mentee
import domain.model.Team
import domain.model.Project
class EcosystemService(
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
    private val performanceRepository: PerformanceRepository,
    private val projectRepository: ProjectRepository,
    private val attendanceRepository: AttendanceRepository
) {
    fun findTeamsWithNoProject(): List<Team> =
        teamRepository.getAllTeams().filter { it.project == null }
    fun findProjectAssignedToTeam(teamId: String): Project? =
        projectRepository.getProjectByTeamId(teamId)
    fun findLeadMentorForMentee(menteeId: String): String? {
        val mentee = menteeRepository.getMenteeById(menteeId)
        return mentee?.let { teamRepository.getMentorLeadByTeamId(it.teamId) }
    }
    fun getOverallPerformanceAverageForTeam(teamId: String): Double {
        val mentees = menteeRepository.getMenteesByTeamId(teamId)
        val allScores = mentees.flatMap { m ->
            performanceRepository.getPerformanceByMenteeId(m.id)
                .map { it.score.toDoubleOrNull() ?: 0.0 }
        }
        return allScores.averageOrZero()
    }
    fun findTopScoringMenteeOverall(): Mentee? =
        menteeRepository.getAllMentees().maxByOrNull { m ->
            val scores = performanceRepository.getPerformanceByMenteeId(m.id)
                .map { it.score.toDoubleOrNull() ?: 0.0 }
            scores.averageOrZero()
        }
    fun getPerformanceBreakdownForMentee(menteeId: String): Map<String, Double> {
        val submissions = performanceRepository.getPerformanceByMenteeId(menteeId)
        return submissions.groupBy { it.submissionType }
            .mapValues { (_, list) ->
                list.map { it.score.toDoubleOrNull() ?: 0.0 }.averageOrZero()
            }
    }
    fun findMenteesWithPerfectAttendance(): List<Mentee> {
        return menteeRepository.getAllMentees().filter { mentee ->
            val attendance = attendanceRepository.getAttendanceByMenteeId(mentee.id)
            attendance != null && attendance.weeks.all { it.uppercase() == "PRESENT" }
        }
    }
    fun flagMenteesWithPoorAttendance(minAbsences: Int): List<Mentee> {
        return menteeRepository.getAllMentees().filter { mentee ->
            val attendance = attendanceRepository.getAttendanceByMenteeId(mentee.id)
            attendance != null && attendance.weeks.count { it.uppercase() != "PRESENT" } >= minAbsences
        }
    }
    fun generateTeamAttendanceReport(teamId: String): Map<String, Int> {
        val mentees = menteeRepository.getMenteesByTeamId(teamId)
        return mentees.associate { mentee ->
            val attendance = attendanceRepository.getAttendanceByMenteeId(mentee.id)
            val absences = attendance?.weeks?.count { it.uppercase() != "PRESENT" } ?: 0
            mentee.id to absences
        }
    }
}
fun List<Double>.averageOrZero(): Double = if (isEmpty()) 0.0 else average()
