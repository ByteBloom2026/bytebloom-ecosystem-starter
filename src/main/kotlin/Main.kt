import java.io.File
import data.datasource.CsvEcosystemDataSource
import domain.usecase.*
import data.repository.*
fun main() {
    val csvDataSource = CsvEcosystemDataSource.getInstance(
        File("src/main/resources/mentees.csv"),
        File("src/main/resources/teams.csv"),
        File("src/main/resources/performance.csv"),
        File("src/main/resources/projects.csv"),
        File("src/main/resources/attendance.csv")
    )
    val menteeRepository = MenteeRepositoryImpl(csvDataSource)
    val teamRepositry = TeamRepositoryImpl(csvDataSource)
    val performanceRepository = PerformanceRepositoryImpl(csvDataSource)
    val projectRepository = ProjectRepositoryImpl(csvDataSource)
    val attendanceRepository = AttendanceRepositoryImpl(csvDataSource)
    val getMenteeNameById = GetMenteeNameByIdUseCase(menteeRepository)
    val getMenteeNamesByTeamName = GetMenteeNamesByTeamNameUseCase(teamRepositry, menteeRepository)
    val getNumberOfProjectsByMenteeId = GetNumberOfProjectsByMenteeIdUseCase(menteeRepository, projectRepository)
    val getTeamByMenteeName = GetTeamByMenteeNameUseCase(teamRepositry, menteeRepository)
    val isMenteeInTeam = IsMenteeInTeamUseCase(teamRepositry, menteeRepository)
    val generateTeamAttendanceReport = GenerateTeamAttendanceReportUseCase(attendanceRepository, menteeRepository)
    val getAverageAttendancePercentagePerTeam =
        GetAverageAttendancePercentagePerTeamUseCase(teamRepositry, menteeRepository, attendanceRepository)
    val getMostAbsentMentees = GetMostAbsentMenteesUseCase(menteeRepository, attendanceRepository)
    val getPerfectAttendanceMentees = GetPerfectAttendanceMenteesUseCase(attendanceRepository, menteeRepository)
    val getPoorAttendanceMentees = GetPoorAttendanceMenteesUseCase(attendanceRepository, menteeRepository)
    val getAverageScorePerSubmissionType = GetAverageScorePerSubmissionTypeUseCase(performanceRepository)
    val getMenteePerformanceBreakdown = GetMenteePerformanceBreakdownUseCase(performanceRepository)
    val getMenteesWithLowAverageScore =
        GetMenteesWithLowAverageScoreUseCase(menteeRepository, performanceRepository)
    val getTeamAverageScore = GetTeamAverageScoreUseCase(menteeRepository, performanceRepository)
    val getTopScoringMentee = GetTopScoringMenteeUseCase(menteeRepository, performanceRepository)
    println("Mentee name (M1): ${getMenteeNameById("M1")}")
    println("Mentees in team Alpha: ${getMenteeNamesByTeamName("Alpha")}")
    println("Projects count for mentee M1: ${getNumberOfProjectsByMenteeId("M1")}")
    println("Team of mentee Alice: ${getTeamByMenteeName("Alice")}")
    println("Is mentee M1 in team Alpha? ${isMenteeInTeam("M1", "Alpha")}")
    println("Attendance report for team T1: ${generateTeamAttendanceReport("T1")}")
    println("Average attendance per team: ${getAverageAttendancePercentagePerTeam()}")
    println("Most absent mentees: ${getMostAbsentMentees()}")
    println("Perfect attendance mentees: ${getPerfectAttendanceMentees()}")
    println("Poor attendance mentees (>=3 absences): ${getPoorAttendanceMentees(3)}")
    println("Average score per submission type: ${getAverageScorePerSubmissionType()}")
    println("Performance breakdown for mentee M1: ${getMenteePerformanceBreakdown("M1")}")
    println("Low average score mentees (<60): ${getMenteesWithLowAverageScore(60.0)}")
    println("Team T1 average score: ${getTeamAverageScore("T1")}")
    println("Top scoring mentee: ${getTopScoringMentee()}")
}