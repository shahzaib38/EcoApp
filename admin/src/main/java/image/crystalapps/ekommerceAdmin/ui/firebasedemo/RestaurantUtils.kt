package image.crystalapps.ekommerceAdmin.ui.firebasedemo

import android.content.Context
import image.crystalapps.ekommerceAdmin.R
import java.util.*

object RestaurantUtils {

    private val NAME_FIRST_WORDS = arrayOf(
        "Foo", "Bar", "Baz", "Qux", "Fire", "Sam's", "World Famous", "Google", "The Best")

    private val NAME_SECOND_WORDS = arrayOf(
        "Restaurant", "Cafe", "Spot", "Eatin' Place", "Eatery", "Drive Thru", "Diner")



    fun getRandom(context:Context) :Restaurant{

        val restaurant = Restaurant()

        val random =Random()
        var cities = context.resources.getStringArray(R.array.cities)
        cities = Arrays.copyOfRange(cities, 1, cities.size)

        var categories = context.resources.getStringArray(R.array.categories)
        categories = Arrays.copyOfRange(categories, 1, categories.size)

        val prices = intArrayOf(1, 2, 3)

        restaurant.name = getRandomName(random)
        restaurant.city = getRandomString(cities, random)
        restaurant.category = getRandomString(categories, random)
     //   restaurant.photo = getRandomImageUrl(random)
        restaurant.price = getRandomInt(prices, random)
        restaurant.numRatings = random.nextInt(20)

        return restaurant
    }


    fun getPriceString(restaurant: Restaurant): String {
        return getPriceString(restaurant.price)
    }

    /**
     * Get price represented as dollar signs.
     */
    fun getPriceString(priceInt: Int): String {
        when (priceInt) {
            1 -> return "$"
            2 -> return "$$"
            3 -> return "$$$"
            else -> return "$$$"
        }
    }

    private fun getRandomName(random: Random): String {
        return (getRandomString(NAME_FIRST_WORDS, random) + " " +
                getRandomString(NAME_SECOND_WORDS, random))
    }

    private fun getRandomString(array: Array<String>, random: Random): String {
        val ind = random.nextInt(array.size)
        return array[ind]
    }

    private fun getRandomInt(array: IntArray, random: Random): Int {
        val ind = random.nextInt(array.size)
        return array[ind]
    }
}