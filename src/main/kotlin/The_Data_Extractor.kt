// ByteBloom Academy - Week (2)
// Individual Task: The Data Extractor
// By: Deema Mohammed AL-Maqadma

fun main() {
    val config = "user: xyz-12; role: admin; authToken: token-xyz-789;"

    println(extractValue(config, "role"))        // admin
    println(extractValue(config, "authToken"))   // token-xyz-789
    println(extractValue(config, "hostname"))    // null
}

// Function to extract the value associated with a given key from a formatted string
fun extractValue(input: String, key: String): String? {
    var result: String? = null // Variable to store the result if key is found

    // Split the input string by semicolon to get individual key-value pairs
    input.split(";").forEach { line ->

        // Split each pair by colon and trim spaces
        val parts = line.split(":").map { it.trim() }

        // Check if the pair has exactly two parts and the key matches (case-insensitive)
        if (parts.size == 2 && parts[0].equals(key, ignoreCase = true)) {
            result = parts[1] // Store the value if key matches
        }
    }

    return result // Return the result or null if not found
}

//--------------------------------------------------------------------------------------------------------------

//// This function extracts the value associated with a specific key from a string formatted
//fun extractValue(input: String, key: String): String? {
//    val lines = input.split(";") // Split the input text by semicolon
//    for (line in lines) {
//        val parts = line.split(":") // Split each part into key and value
//        if (parts.size == 2) { // The key & value
//            val foundKey = parts[0].trim()
//            val value = parts[1].trim()
//            if (foundKey.equals(key, ignoreCase = true)) {
//                return value
//            }
//        }
//    }
//    return null // Return null if the key is not found
//}