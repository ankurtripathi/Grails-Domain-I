import bootcamp.Company
import bootcamp.Employee

class BootStrap {

    def init = { servletContext ->
        timestampExample()
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

    void transientExample() {
        println "########################################################"
        println new Employee(firstName: "Ankur", lastName: "Tripathi").fullName
        println "########################################################"
    }

    void timestampExample() {
        Employee employee = new Employee(firstName: "Ankur", lastName: "Tripathi")
        println "########################################################"
        println "Timestamps before save Datecreated: ${employee.dateCreated} -- lastUpdated: ${employee.lastUpdated}"
        println "########################################################"
        employee.save()
        println "Timestamps after save Datecreated: ${employee.dateCreated} -- lastUpdated: ${employee.lastUpdated}"
        println "########################################################"
    }

    Company createCompany() {
        return new Company(name: "Intelligrape").save(flush: true)
    }


    def destroy = {
    }
}
