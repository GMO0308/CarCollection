// Activity 4: Car.kt (in package 'cars')
// Class to represent a car
package cars

import java.io.Serializable

data class Car(
    val make: String,
    val model: String?,
    val year: String?,
    val odometer: Int
) : Serializable {
    // Display car details
    fun display() {
        println("$make $model\t\tYear: $year")
        println("\t\t\tkm travelled: $odometer")
    }
}
