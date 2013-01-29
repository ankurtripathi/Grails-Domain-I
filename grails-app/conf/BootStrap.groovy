import bootcamp.Company

class BootStrap {

    def init = { servletContext ->
        getter()
    }

    void getter() {
        Company company = createCompany()
        println "########################################################"
        println "getter ${company.getName()} property ${company.name}"
        println "########################################################"
    }

    Company createCompany(){
        return new Company(name: "Intelligrape").save(flush: true)
    }

    def destroy = {
    }
}
