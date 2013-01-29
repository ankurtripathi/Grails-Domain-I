package bootcamp

class Task {

    String name

    static belongsTo = [project: Project]

    static constraints = {
    }
}
