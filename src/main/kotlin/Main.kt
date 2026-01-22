import java.io.File
import data.dataSource.CsvEcosystemDataSource
import repository.*
import domain.EcosystemService
fun main() {
    val csvDataSource = CsvEcosystemDataSource(
        File("src/main/resources/mentees.csv"),
        File("src/main/resources/teams.csv"),
        File("src/main/resources/performance.csv"),
        File("src/main/resources/projects.csv"),
        File("src/main/resources/attendance.csv")
    )
    val menteeRepo = MenteeRepositoryImpl(csvDataSource)
    val teamRepo = TeamRepositoryImpl(csvDataSource)
    val performanceRepo = PerformanceRepositoryImpl(csvDataSource)
    val projectRepo = ProjectRepositoryImpl(csvDataSource)
    val attendanceRepo = AttendanceRepositoryImpl(csvDataSource)
    val ecosystemService = EcosystemService(
        teamRepo,
        menteeRepo,
        performanceRepo,
        projectRepo,
        attendanceRepo
    )
    ecosystemService.findTeamsWithNoProject().forEach { println(it) }
    println(ecosystemService.findProjectAssignedToTeam("team1"))
    println(ecosystemService.findLeadMentorForMentee("m001"))
    println(ecosystemService.getOverallPerformanceAverageForTeam("team1"))
    println(ecosystemService.findTopScoringMenteeOverall())
    println(ecosystemService.getPerformanceBreakdownForMentee("m001"))
    ecosystemService.findMenteesWithPerfectAttendance().forEach { println(it) }
    ecosystemService.flagMenteesWithPoorAttendance(2).forEach { println(it) }
    println(ecosystemService.generateTeamAttendanceReport("team1"))
}