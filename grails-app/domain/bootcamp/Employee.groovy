package bootcamp

class Employee {

    String firstName
    String lastName
    Date dateCreated
    Date lastUpdated

    static transients = ['fullName']

    String getFullName() {
        return "${firstName} ${lastName}"
    }
}
