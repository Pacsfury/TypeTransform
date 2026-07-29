fun main() {
    println(IRToIni(iniToIR(
"""[TEST]
willitwork=true
indeedseemstowork=ye,butsomeriskythings
whatdoyoumean=drops,strangerulesthatseemtoalwaysworkuntiltheydont
[AHHH]
idc=true++"""
    )))
}

fun getNextStr(text: String): String {
    var isrecording: Boolean = false
    var type: Int = 0 //1->', 2->"
    var buffer: String = ""
    for (i in text) {
        if (i == '"') {
            if (isrecording && type==2) {
                return buffer
            } else {
                isrecording = true
                type = 2
                continue 
            }
        }
        if (i == '\'') {
            if (isrecording && type==1) {
                return buffer
            } else {
                isrecording = true
                type = 1
                continue 
            }
        }
        
        if (isrecording) {
            buffer += i
        }
    }
    return "nostring"
}



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

fun IRToIni(text: String): String {
    val formatText = "} $text" 
    val sections = formatText.split("} ")
    var result = ""

    for (section in sections) {
        if (section.isEmpty()) continue
        
        val parts = section.split(": {")
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

