package domain.model
data class Attendance(
    val menteeId: String,
    val weeks: String,
    val attendanceState: attendanceState
    )
enum class attendanceState(){
    LATE,PRESENT,ABSENT
}