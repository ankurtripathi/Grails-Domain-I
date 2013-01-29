package bootcamp

class Project {

    String name

    static constraints = {
    }

    static hasMany = [tasks: Task]
}
