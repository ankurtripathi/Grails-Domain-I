package bootcamp

class Employee {

    String firstName
    String lastName

    static transients = ['fullName']

    String getFullName() {
       return "${firstName} ${lastName}"
    }
}
