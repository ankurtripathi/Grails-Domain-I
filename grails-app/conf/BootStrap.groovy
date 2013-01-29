import bootcamp.Company

class BootStrap {

    def init = { servletContext ->
        companyToString()
    }

    void getter() {
        Company company = createCompany()
        println "########################################################"
        println "getter ${company.getName()} property ${company.name}"
        println "########################################################"
    }

    void companyToString() {
        println "########################################################"
        println "toString of company ${createCompany()}"
        println "########################################################"
    }

    Company createCompany() {
        return new Company(name: "Intelligrape").save(flush: true)
    }

    def destroy = {
    }
}
