package com.example.pizzaproject.sections

import androidx.compose.runtime.Composable
import com.example.pizzaproject.models.Section
import com.stevdza.san.kotlinbs.components.BSModal
import com.stevdza.san.kotlinbs.models.ModalSize
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Hr
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val pizzaDetails =
    mapOf(
        "PizzaPics/BBQ Chicken Bonanza.jpeg" to "Our BBQ Chicken Bonanza is a hearty feast of tender chicken, smoky bacon, and caramelized onions, all smothered in a sweet and tangy BBQ sauce. Topped with mozzarella, it's a bold and flavorful choice for meat lovers.\n",
        "PizzaPics/Cheesy Magherita.jpeg" to " A classic favorite, " +
            "our Cheesy Margherita is a delightful blend of tangy tomato sauce, creamy mozzarella, fresh basil, and juicy tomatoes. " +
            "It's a simple yet flavorful choice that's perfect for cheese lovers.",
        "PizzaPics/Four Cheese Fantasy.jpeg" to "A cheese lover's dream, our Four Cheese Fantasy features a decadent blend of mozzarella, cheddar, feta, and blue cheese. Paired with our tomato sauce, it's a creamy and indulgent pizza that's sure to please.",
        "PizzaPics/Hawaiian Heat.jpeg" to " A tropical treat, our Hawaiian Heat pizza combines the sweetness of pineapple with the saltiness of ham. Paired with our signature tomato sauce and mozzarella, it's a unique flavor experience that's both sweet and savory.\n",
        "PizzaPics/Meat Lovers Madness.jpeg" to " For the ultimate carnivore, our Meat Lovers Madness is loaded with pepperoni, sausage, ham, and bacon. Combined with our tomato sauce and mozzarella, it's a meaty feast that's sure to satisfy.\n",
        "PizzaPics/Mushroom Magic.jpeg" to "Our Mushroom Magic pizza is a mushroom lover's dream. Loaded with earthy mushrooms and drizzled with aromatic truffle oil, it's a rich and savory treat that's truly magical.\n",
        "PizzaPics/Pepperoni Passion.jpeg" to "For those who crave a meaty bite, " +
            "our Pepperoni Passion pizza is loaded with savory pepperoni slices atop a bed of rich tomato sauce and melted mozzarella. " +
            "It's a timeless combination that's sure to satisfy.",
        "PizzaPics/Seafood Supreme.jpeg" to "A seafood lover's delight, our Seafood Supreme features tender tuna, succulent prawns, salty anchovies, and tangy capers. Paired with our tomato sauce and mozzarella, it's a taste of the ocean in every bite.\n",
        "PizzaPics/Spicy Inferno.jpeg" to "For those who like it hot, our Spicy Inferno is a fiery mix of jalapenos, hot peppers, onions, and spicy beef. Paired with our tomato sauce and mozzarella, it's a pizza that packs a punch.\n",
        "PizzaPics/Veggie Volcano.jpeg" to "Our Veggie Volcano is a colorful medley of fresh bell peppers, crisp onions, earthy mushrooms, tangy olives, and sweet corn. All these are nestled on a layer of tomato sauce and mozzarella, making it a delicious choice for vegetarians and veggie lovers.\n",
    )

@Composable
fun menuSection() {
    BSModal(
        modifier = Modifier.fillMaxWidth().fontFamily("verdana"),
        size = ModalSize.Large,
        id = "menu_modal",
        title = "Menu",
        negativeButtonText = "Close",
        positiveButtonText = "Contact us",
        closableOutside = true,
        centered = true,
        onPositiveButtonClick = {
            window.location.href = Section.Contact.path
        },
        onNegativeButtonClick = {
            window.location.href = Section.Home.path
        },
        body = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                pizzaDetails.forEach {
                    if (rememberBreakpoint() > Breakpoint.MD) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Box(modifier = Modifier.fillMaxWidth(70.percent)) {
                                Image(
                                    src = it.key,
                                    description = it.key.removePrefix("PizzaPics/").removeSuffix(".jpeg"),
                                    modifier =
                                        Modifier.fillMaxSize()
                                            .objectFit(ObjectFit.Cover)
                                            .borderRadius(10.px),
                                )
                            }

                            Column(
                                modifier =
                                    Modifier.fillMaxWidth(30.percent)
                                        .padding(10.px),
                            ) {
                                Row(
                                    modifier =
                                        Modifier.fillMaxWidth()
                                            .backgroundColor(Color.black)
                                            .color(Color.orange)
                                            .borderRadius(10.px),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                ) {
                                    Text(value = it.key.removePrefix("PizzaPics/").removeSuffix(".jpeg"))
                                }

                                Spacer()

                                P {}

                                Text(value = it.value)
                            }
                        }
                    } else {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                Image(
                                    src = it.key,
                                    description = it.key.removePrefix("PizzaPics/").removeSuffix(".jpeg"),
                                    modifier =
                                        Modifier.fillMaxSize()
                                            .objectFit(ObjectFit.Cover)
                                            .borderRadius(10.px),
                                )
                            }

                            Column(
                                modifier =
                                    Modifier.fillMaxWidth()
                                        .padding(10.px),
                            ) {
                                Row(
                                    modifier =
                                        Modifier.fillMaxWidth()
                                            .backgroundColor(Color.black)
                                            .color(Color.orange)
                                            .borderRadius(10.px),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                ) {
                                    Text(value = it.key.removePrefix("PizzaPics/").removeSuffix(".jpeg"))
                                }

                                Spacer()

                                P {}

                                Text(value = it.value)
                            }
                        }
                    }

                    Hr(attrs = Modifier.fillMaxWidth().color(Color("#F47517")).toAttrs())

                    Hr(attrs = Modifier.fillMaxWidth().color(Color("#00BF63")).toAttrs())

                    Hr(attrs = Modifier.fillMaxWidth().color(Color("#F47517")).toAttrs())
                }
            }
        },
    )
}
