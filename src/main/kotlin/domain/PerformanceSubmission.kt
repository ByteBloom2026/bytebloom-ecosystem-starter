package domain

data class PerformanceSubmission (
    val id: String,
    val menteeId: String,
    val submissionType: String,
    val score: String)