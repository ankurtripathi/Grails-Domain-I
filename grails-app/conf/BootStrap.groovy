import bootcamp.Company

class BootStrap {

    def init = { servletContext ->
        getter()
    }

    void getter() {
        Company company = new Company(name: "Intelligrape")
        company.save(flush: true)
        println "########################################################"
        println "getter ${company.getName()} property ${company.name}"
        println "########################################################"
    }

    def destroy = {
    }
}
