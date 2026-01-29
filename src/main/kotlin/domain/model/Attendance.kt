package domain.model
data class Attendance(
    val menteeId : String ,
    val weeks: List<String>,
    val states: AttendanceStates
)
enum class AttendanceStates{
    LATE ,ABSENCE,PRESENT
}