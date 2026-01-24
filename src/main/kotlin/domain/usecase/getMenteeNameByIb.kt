package domain.usecase

import domain.model.Mentee


    // ايجا اسم المتدرب بناءا على الايبي يعني بدي ادخل اسم الابي يرجع باسم المتدرب
    class GetMenteeNameById(
        private val mentees: List<Mentee>
    ) {
        fun execute(id: String): String? {
            val mentee = mentees.find { it.id == id }
            return mentee?.name
        }
    }





