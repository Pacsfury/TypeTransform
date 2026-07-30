package core

/* 
    X -> IR 
*/

fun iniToIR(text: String): String {
	val lines = text.split("\n")
    var result = ""
    for (line in lines) {
        var name = ""
        if (line[0] == '[') {
            var idx = 1
            while (line[idx] != ']') {
                name += line[idx]
                idx++
            }
            result += "} $name: {"
        } else {
            if (result.endsWith("{")) {
            	result += "${line.replaceFirst('=', ':')}"
            } else {
                result += ",${line.replaceFirst('=', ':')}"
            }
        }
    }
    result += '}'
    result = result.drop(2)
    return result
}

fun tomlToIR(text: String): String {
	val lines = text.split("\n")
    var result = ""
    for (line in lines) {
        var name = ""
        if (line[0] == '[') {
            var idx = 1
            while (line[idx] != ']') {
                name += line[idx]
                idx++
            }
            result += "} $name: {"
        } else {
            if (result.endsWith("{")) {
            	result += "${line.replaceFirst('=', ':')}"
            } else {
                result += ",${line.replaceFirst('=', ':')}"
            }
        }
    }
    result += '}'
    result = result.drop(2)
    return result
}


/* 
    IR -> X 
*/

fun IRToIni(text: String): String {
    val formatText = "} $text" 
    val sections = formatText.split("} ")
    var result = ""

    for (section in sections) {
        if (section.isEmpty()) continue
        
        val parts = section.split(": {")
        if (parts.size < 2) continue
        
        val sectionName = parts[0].trim()
        val content = parts[1].removeSuffix("}").trim() 
        
        result += "[$sectionName]\n"
        
        val pairs = content.split(",")
        for (pair in pairs) {
            if (pair.isNotEmpty()) {
                result += "${pair.replaceFirst(':', '=')}\n"
            }
        }
    }
    return result.trimEnd()
}

fun IRToToml(text: String): String {
    val formatText = "} $text" 
    val sections = formatText.split("} ")
    var result = ""

    for (section in sections) {
        if (section.isEmpty()) continue
        
        val parts = section.split(": {")
        if (parts.size < 2) continue
        
        val sectionName = parts[0].trim()
        val content = parts[1].removeSuffix("}").trim() 
        
        result += "[$sectionName]\n"
        
        val pairs = content.split(",")
        for (pair in pairs) {
            if (pair.isNotEmpty()) {
                result += "${pair.replaceFirst(":", "=\"") + '"'}\n"
            }
        }
    }
    return result.trimEnd()
}
