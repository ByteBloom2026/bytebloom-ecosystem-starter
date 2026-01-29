package domain.usecase

import Repository.MenteeRepository


class getMenteeNameById(
    private val menteeRepository: MenteeRepository
) {

     operator fun invoke(id: String): String? {
        val mentee = menteeRepository.getMenteeById(id)
        return mentee?.name

    }

}