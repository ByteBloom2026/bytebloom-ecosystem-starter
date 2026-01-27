package domain.usecase
import domain.model.Mentee
import domain.model.Project

class getNumberOfProjectsByMenteeId  (
    private val mentees: List<Mentee>,
    private val projects: List<Project>
){
    fun execute(menteeId: String): Int {
        val mentee = mentees.find { it.id == menteeId }
            ?: return 0
        val teamId = mentee.teamId
        return projects.count { it.teamId == teamId }
    }
}