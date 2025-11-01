class Meteorology{
    private val cities = mutableMapOf<String,Int>()
    fun addCity(cityName:String,temperature:Int){
        cities[cityName] = temperature
    }
    fun removeCity(cityName:String){

        cities.remove(cityName)
    }
    fun editTemp(cityName:String,newTemperature:Int){

        cities[cityName] = newTemperature
    }
    fun showCities(){
        for (i in cities.keys){
            when(cities.getValue(i)){
                in -20..0 -> { println("$i ---> ${cities.getValue(i)}°C Weather is so Cold") }
                in 1..25 -> { println("$i ---> ${cities.getValue(i)}°C Weather is Normal") }
                in 26..100 -> { println("$i ---> ${cities.getValue(i)}°C Weather is so Hot") }
            }

        }
    }

}


fun main(){
    val meteorology = Meteorology()

    while (true) {
        println("""
        ------------------
        Welcome to Meteorology!
        1-Add City
        2-Delete City
        3-Edit City Temperature
        4-Show Cities
        0-Exit
        ------------------
    """.trimIndent())
        when (readln().toInt()) {
            1 -> {
                println()
                print("Enter Your City Name : ")
                val cityName = readln()
                print("Enter Your City Temperature : ")
                val temperature = readln()
                meteorology.addCity(cityName,temperature.toInt())
            }
            2 -> {
                println()
                meteorology.showCities()
                print("Enter Your City Want to Delete : ")
                val cityName = readln()
                meteorology.removeCity(cityName)
            }
            3 -> {
                println()
                meteorology.showCities()
                print("Enter Your City Want to Edit temperature : ")
                val cityName = readln()
                print("Enter Your New Temperature : ")
                val temperature = readln().toInt()
                meteorology.editTemp(cityName,temperature)
            }
            4 -> {
                meteorology.showCities()
            }
            0 -> {break}
            else -> {println("Wrong Number !!!")}
        }

    }


}
