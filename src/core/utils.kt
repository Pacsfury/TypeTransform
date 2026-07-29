package core

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
