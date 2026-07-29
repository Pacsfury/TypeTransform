package core

fun getIR(text: String, from: String): String {
    if (from.uppercase()=="INI") {
        return iniToIR(text)
    } else {
        return "Error: check the name"
    }
}

fun getResult(ir: String, to: String): String {
    if (to.uppercase()=="INI") {
        return IRToIni(to)
    } else {
        return "Error: check the name"
    }
}