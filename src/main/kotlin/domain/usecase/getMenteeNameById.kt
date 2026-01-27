package domain.usecase
import domain.model.Mentee
class getMenteeNameById ( private val mentees: List<Mentee>) {
    fun execute(id: String): String? {
        val mentee = mentees.find { it.id == id }
        return mentee?.name
    }
}