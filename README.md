# 🔍 Individual Task – Week 2: Data Extractor

## 🧠 Task Description
This task focuses on writing a Kotlin function that extracts a value from a messy configuration string.  
The function takes two parameters: the full input string and the key to search for.  
If the key is found, it returns the corresponding value; otherwise, it returns null.

---

## 📌 Function Signatures

```kotlin
// Main function
fun extractValue(input: String, key: String): String?

// Helper functions
fun splitConfigIntoLines(configText: String): List<String>
fun convertLinesToPairs(lines: List<String>): List<Pair<String, String>>
fun findMatchingValue(pairs: List<Pair<String, String>>, searchKey: String): String?

---

## 📌 Example Usage 

val config = """
  userId: user-123; role: admin;
  authToken=token-xyz-789
  environment : production; expiry: never
"""

println(extractValue(config, "role"))        // admin
println(extractValue(config, "authToken"))   // token-xyz-789
println(extractValue(config, "hostname"))    // null