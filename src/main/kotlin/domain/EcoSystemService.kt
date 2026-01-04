package domain

import Repo.AttendanceRepository
import Repo.MenteeRepository
import Repo.TeamRepository
import Repo.performanceRepository
import Repo.projectsRepository
import domain.model.Mentee
import domain.model.Team
import domain.model.projects


class EcoSystemService (
    private val teamRepo: TeamRepository,
    private val menteeRepo: MenteeRepository,
    private val performanceRepo: performanceRepository,
    private val projectRepo: projectsRepository,
    private val attendanceRepo: AttendanceRepository
    ){

    fun findTeamsWithNoProject(): List<Team>{
        val allTeams=teamRepo.getAllTeams()
        return allTeams.filter { it.project==null }
    }

    fun findProjectAssignedToTeam(teamId: String): projects?{
        return projectRepo.getProjectByTeamId(teamId)
    }

    fun findLeadMentorForMentee(menteeId: String): String?{
        val mentee=menteeRepo.getMenteeById(menteeId)
        return mentee?.let { teamRepo.getMentorLeadByTeamId(it.teamId) }
    }

    fun getOverallPerformanceAverageForTeam(teamId: String): Double{
        val menteeInTeam=menteeRepo.getMenteesByTeamId(teamId)
        val allScores=menteeInTeam.flatMap { mentee ->
            performanceRepo.getPerfoormanceByMenteeId(mentee.id).map {
                it.score.toDouble()
            }
        }
        if(allScores.isEmpty()) {
            return 0.0
        }else{
            return allScores.average()
        }
    }

    fun findTopScoringMenteeOverall(): Mentee?{
        return menteeRepo.getAllMentees().maxByOrNull { mentee ->
            val scores = performanceRepo.getPerfoormanceByMenteeId(mentee.id).map {
                it.score.toDouble()}
            if(scores.isEmpty()) 0.0
            scores.average()
        }

    }


}


