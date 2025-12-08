package domain

data class Mentee (
    val id:String,
    val name: String,
    var team: String?,
    val submissions: List<PerformanceSubmission> = listOf()
)
