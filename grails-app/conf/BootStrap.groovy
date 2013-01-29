import bootcamp.Company
import bootcamp.Employee

class BootStrap {

    def init = { servletContext ->
        validation()
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

    void validation() {
        Company company = createCompany()
        Employee employee = new Employee(firstName: "Ankur", lastName: "Tripathi", company: company, email: 'ankur+1@intelligrape.com', salary: 2000000F)
        println "Validate employee ${employee.save()}"
        println "########################################################"
        employee.errors.allErrors.each {
            println it
        }
        println "########################################################"

        //For more validation examples go through the classes and documentation
    }

    Company createCompany() {
        return new Company(name: "Intelligrape").save(flush: true)
    }


    def destroy = {
    }
}
