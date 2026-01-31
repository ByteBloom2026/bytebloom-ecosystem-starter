import java.io.File
import data.datasource.CsvEcosystemDataSource
import domain.usecase.*
import data.repository.*

fun main() {
    val csvDataSource = CsvEcosystemDataSource(
        File("src/main/resources/mentees.csv"),
        File("src/main/resources/teams.csv"),
        File("src/main/resources/performance.csv"),
        File("src/main/resources/projects.csv"),
        File("src/main/resources/attendance.csv")
    )
    val menteeRepository = MenteeRepositoryImpl(csvDataSource)
    val teamRepositpry = TeamRepositoryImpl(csvDataSource)
    val performanceRepository = PerformanceRepositoryImpl(csvDataSource)
    val projectRepository = ProjectRepositoryImpl(csvDataSource)
    val attendanceRepository = AttendanceRepositoryImpl(csvDataSource)

    // execute the function  GetMenteeNameById
    val GetMenteeNameByIdUseCase = GetMenteeNameByIdUseCase(menteeRepository)
    println("please entre the id mentee : " + GetMenteeNameByIdUseCase)

    // execute the function  getMenteeNamesByTeamName
    val GetMenteeNamesByTeamNameUseCase = GetMenteeNamesByTeamNameUseCase(teamRepositpry, menteeRepository)
    println("please entre the team name : " + GetMenteeNamesByTeamNameUseCase)

    // execute the function getNumberOfProjectsByMenteeId
    val GetNumberOfProjectsByMenteeIdUseCase = GetNumberOfProjectsByMenteeIdUseCase(menteeRepository, projectRepository)
    println("please entre the id mentee" + GetNumberOfProjectsByMenteeIdUseCase)

    //execute the function getTeamByMenteeName
    val GetTeamByMenteeNameUseCase=GetTeamByMenteeNameUseCase(teamRepositpry,menteeRepository)
    println("please the entre the mentee name : "+GetTeamByMenteeNameUseCase)

    //execute the function IsMenteeInTeam
    val IsMenteeInTeamUseCase = IsMenteeInTeamUseCase(teamRepositpry,menteeRepository)
    println("please enter the id mentee and team name"+IsMenteeInTeamUseCase)

    //execute the function GenerateTeamAttendanceReport
    val generateTeamAttendanceReport =GenerateTeamAttendanceReportUseCaes(attendanceRepository,menteeRepository)
    println("please entre the teamid : "+generateTeamAttendanceReport)

   // execute the function  GetAverageAttendancePercentagePerTeam
   val getAverageAttendancePercentagePerTeamUesCase=GetAverageAttendancePercentagePerTeamUesCase(teamRepositpry,menteeRepository,attendanceRepository)
    println("the average attendanc : "+getAverageAttendancePercentagePerTeamUesCase)

    //execute the function GetMostAbsentMentees
    val getMostAbsentMentees=GetMostAbsentMentees(menteeRepository,attendanceRepository)
    println(getMostAbsentMentees)

    //execute the function GetPerfectAttendanceMentees
    val getPerfectAttendanceMentees=GetPerfectAttendanceMentees(attendanceRepository,menteeRepository)
    println("The perfect mentees : "+getPerfectAttendanceMentees)

    //execute the function GetPoorAttendanceMentees
    val getPoorAttendanceMenteesUseCase=GetPoorAttendanceMenteesUseCase(attendanceRepository,menteeRepository)
    println("The poor mentees : "+getPoorAttendanceMenteesUseCase)

   //execute the function  getAverageScorePerSubmissionTypeUseCasel
    val GetAverageScorePerSubmissionTypeUseCasel=GetAverageScorePerSubmissionTypeUseCase(performanceRepository)
    println(GetAverageScorePerSubmissionTypeUseCasel)

    //execute the function getMenteePerformanceBreakdown
    val GetMenteePerformanceBreakdownUseCase=GetMenteePerformanceBreakdownUseCase(performanceRepository)
    println("plesae entre the ib mentee : "+GetMenteePerformanceBreakdownUseCase)


    //execute the function getMenteesWithLowAverageScoreUseCase
   val GetMenteesWithLowAverageScoreUseCase=GetMenteesWithLowAverageScoreUseCase(menteeRepository,performanceRepository)
   println(GetMenteesWithLowAverageScoreUseCase)

    //execute the function getTeamAverageScore
    val GetTeamAverageScoreUseCase=GetTeamAverageScoreUseCase(menteeRepository,performanceRepository)
    println("please entre the id team : "+GetTeamAverageScoreUseCase)

    //execute the function getTopScoringMentee
    val GetTopScoringMenteeUseCase=GetTopScoringMenteeUseCase(menteeRepository,performanceRepository)
    println("The top scor"+GetTopScoringMenteeUseCase)
}