package domain

data class Mentee (
    val name: String,
    val menteeid:String,
    var team: Team? 
    val submissions: MutableList<PerformanceSubmission> 
)
