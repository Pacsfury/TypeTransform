package core

fun getIR(text: String, from: String): String {
    if (from.uppercase()=="INI") {
        return iniToIR(text)
    } else if (from.uppercase()=="TOML") {
        return tomlToIR(text)
    } else {
        return "Error: check the name"
    }
}

fun getResult(ir: String, to: String): String {
    if (to.uppercase()=="INI") {
        return IRToIni(ir)
    } else if (to.uppercase()=="TOML") {
        return IRToToml(ir)
    } else {
        return "Error: check the name"
    }
}