// Activity 4: CarCollection.kt
// Program to manage a collection of cars
import cars.Car
import java.io.*

fun main() {
    // Initialize a list of cars
    val cars = arrayListOf(
        Car("Toyota", "Camry", "2020", 15000),
        Car("Honda", "Civic", "2018", 25000),
        Car("Ford", "Mustang", "2022", 5000)
    )

    // Display all cars in the collection
    fun displayAll() = cars.forEach { it.display() }

    // Sort cars by make
    fun sortByMake() = cars.sortBy { it.make }

    // Search cars by make
    fun searchByMake(make: String) = cars.filter { it.make.equals(make, ignoreCase = true) }.forEach { it.display() }

    // Save the car collection to a binary file
    fun saveToFile() {
        ObjectOutputStream(FileOutputStream("cars.dat")).use { it.writeObject(cars) }
    }

    // Load the car collection from a binary file
    @Suppress("UNCHECKED_CAST")
    fun loadFromFile() {
        try {
            ObjectInputStream(FileInputStream("cars.dat")).use { cars.addAll(it.readObject() as ArrayList<Car>) }
        } catch (e: Exception) {
            println("Error loading file: ${e.message}")
        }
    }

    // Main menu loop
    var input: String = ""
    do {
        println("\n1. Display all cars\n2. Sort cars by make\n3. Search cars by make\n4. Save to file\n5. Load from file\n6. Exit")
        print("Choose an option: ")
        input = readlnOrNull() ?: ""
        when (input) {
            "1" -> displayAll()
            "2" -> { sortByMake(); displayAll() }
            "3" -> { print("Enter make: "); searchByMake(readlnOrNull() ?: "") }
            "4" -> saveToFile()
            "5" -> { loadFromFile(); displayAll() }
        }
    } while (input != "6") // Exit on option 6
}
