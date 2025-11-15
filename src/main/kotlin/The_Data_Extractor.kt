// ByteBloom Academy - Week (2)
// Individual Task: The Data Extractor
// By: Deema Mohammed AL-Maqadma

fun main() {
    val config = "user: xyz-12; role: admin; authToken: token-xyz-789;"

    println(extractValue(config, "role"))        // admin
    println(extractValue(config, "authToken"))   // token-xyz-789
    println(extractValue(config, "hostname"))    // null
}

// This function extracts the value associated with a specific key from a string formatted
fun extractValue(input: String, key: String): String? {
    val lines = input.split(";") // Split the input text by semicolon
    for (line in lines) {
        val parts = line.split(":") // Split each part into key and value
        if (parts.size == 2) { // The key & value
            val foundKey = parts[0].trim()
            val value = parts[1].trim()
            if (foundKey.equals(key, ignoreCase = true)) {
                return value
            }
        }
    }
    return null // Return null if the key is not found
}