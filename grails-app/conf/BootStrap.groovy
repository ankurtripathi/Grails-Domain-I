import bootcamp.Car
import bootcamp.Company
import bootcamp.Employee
import bootcamp.Engine
import bootcamp.Project
import bootcamp.Task

class BootStrap {

    def init = { servletContext ->
        oneToManyOwner()
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

    void oneToOne() {
        Car car = new Car()
        car.save()
        Engine engine = new Engine(car: car)
        engine.save()

        println "########################################################"
        println "Engine of Car -: ${car.engine}"
        println "Car of Engine -: ${engine.car}"
        println "########################################################"

    }

    void oneToManyNoOwner() {
        println "########################################################"
        println "Project count before save  ${Project.count()}"
        Project project = new Project(name: "Project")
        project.save()
        project.refresh()
        Task task = new Task(name: "Test")

        println "Task count before save  ${Task.count()}"
        println "Project tasks before adding task -: ${project.tasks}"
        project.addToTasks(task)
        project.save(flush: true)
        println "Project tasks after save -: ${project.tasks}"
        println "########################################################"
        project.delete(flush: true)
        println "Project count after delete -: ${Project.count()}"
        println "Task count after project delete  -: ${Task.count()}"
        println "########################################################"

    }

    void oneToManyOwner() {
        println "########################################################"
        println "Project count before save  ${Project.count()}"
        Project project = new Project(name: "Project")
        Task task = new Task(name: "Test")

        println "Task count before save  ${Task.count()}"
        println "Project tasks before adding task -: ${project.tasks}"
        project.addToTasks(task)
        project.save()
        println "Project tasks after save -: ${project.tasks}"
        println "########################################################"
        project.delete(flush: true)
        println "Project count after delete -: ${Project.count()}"
        println "Task count after project delete  -: ${Task.count()}"
        println "########################################################"

    }

    Company createCompany() {
        return new Company(name: "Intelligrape").save(flush: true)
    }


    def destroy = {
    }
}
