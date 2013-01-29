package bootcamp

class Project {

    String name

    static constraints = {
    }

    static belongsTo = Employee

    static hasMany = [tasks: Task, employees: Employee]
}
