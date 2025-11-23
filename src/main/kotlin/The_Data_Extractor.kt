// ByteBloom Academy - Week (2)
// Individual Task: The Data Extractor
// By: Deema Mohammed AL-Maqadma


fun main() {
    val configText = """
      userId: user-123; role: admin;
      authToken=token-xyz-789
      environment : production; expiry: never
    """

    println(extractValue(configText, "role"))        // admin
    println(extractValue(configText, "authToken"))   // token-xyz-789
    println(extractValue(configText, "hostname"))    // null
}

// Main function that extracts the value for a given key
fun extractValue(configText: String, searchKey: String): String? {
    val keyValueLines = splitConfigIntoLines(configText)
    val cleanedPairs = convertLinesToPairs(keyValueLines)
    return findMatchingValue(cleanedPairs, searchKey)
}

// Splits the config text into lines using semicolon and newline
fun splitConfigIntoLines(configText: String): List<String> {
    return configText.split(";", "\n")
}

// Converts each line into a key-value pair if possible
fun convertLinesToPairs(lines: List<String>): List<Pair<String, String>> {
    val keyValuePairs = mutableListOf<Pair<String, String>>()

    lines.forEach { lineText ->
        val separator = if (lineText.contains("=")) "=" else ":"
        val parts = lineText.split(separator)

        if (parts.size == 2) {
            val key = parts[0].trim()
            val value = parts[1].trim()
            keyValuePairs.add(Pair(key, value))
        }
    }

    return keyValuePairs
}

// Searches for the value that matches the given key (case-insensitive)
fun findMatchingValue(pairs: List<Pair<String, String>>, searchKey: String): String? {
    var valueOfKey: String? = null

    pairs.forEach { pair ->
        if (pair.first.equals(searchKey, ignoreCase = true)) {
            valueOfKey = pair.second
        }
    }

    return valueOfKey
}

//--------------------------------------------------------------------------------------------------------------

// fun main() {
//     val config = "user: xyz-12; role: admin; authToken: token-xyz-789;"

//     // Testing the extractValue function with different keys
//     println(extractValue(config, "role"))        // Expected output: admin
//     println(extractValue(config, "authToken"))   // Expected output: token-xyz-789
//     println(extractValue(config, "hostname"))    // Expected output: null
// }

// // Function to extract the value associated with a given key from a formatted string
// fun extractValue(input: String, key: String): String? {
//     var result: String? = null // Variable to store the result if the key is found

//     // Split the input string by semicolon to get individual key-value pairs
//     input.split(";").forEach { line ->

//         // Split each pair by colon and trim spaces around key and value
//         val parts = line.split(":").map { it.trim() }

//         // Check if the pair has exactly two parts and the key matches (case-insensitive)
//         if (parts.size == 2 && parts[0].equals(key, ignoreCase = true)) {
//             result = parts[1] // Store the value if the key matches
//         }
//     }

//     return result // Return the result or null if the key was not found
// }

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