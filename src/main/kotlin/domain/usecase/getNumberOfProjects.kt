package domain.usecase
import domain.model.Mentee
import domain.model.Project

class GetNumberOfProjectsByMenteeId(
    private val mentees: List<Mentee>,
    private val projects: List<Project>
) {
    fun execute(menteeId: String): Int {

        // ⃣ نجيب المتدرب
        val mentee = mentees.find { it.id == menteeId }
            ?: return 0

        // ⃣ نجيب teamId تبعه
        val teamId = mentee.teamId

        // ⃣ نعدّ المشاريع التابعة لنفس التيم
        return projects.count { it.teamId == teamId }
    }
}

