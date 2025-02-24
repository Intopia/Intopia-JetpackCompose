package digital.intopia.compose.ui.helpers

data class Flight(
    val flightNum: String,
    val startPoint: String,
    val endPoint: String,
)

var flights = listOf(
    Flight("IS1234", "Melbourne", "Sydney"),
    Flight("IS4321", "Sydney", "Melbourne"),
    Flight("IS7890", "Melbourne", "Perth"),
    Flight("IS0987", "Perth", "Melbourne"),
    Flight("IS4567", "Melbourne", "Cairns"),
    Flight("IS7654", "Cairns", "Melbourne")
)