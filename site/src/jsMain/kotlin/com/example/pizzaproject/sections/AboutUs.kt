@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.example.pizzaproject.sections

import androidx.compose.runtime.Composable
import com.example.pizzaproject.models.Section
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun aboutUsSection() {
    Column(
        modifier =
            Modifier
                .id(Section.About.id)
                .fillMaxWidth()
                .padding(20.px)
                .backgroundColor(Color("#FDF0D0"))
                .fontFamily("verdana")
                .fontWeight(1),
    ) {
        Row(
            modifier =
                Modifier.fillMaxWidth()
                    .backgroundColor(Color.black)
                    .border(
                        width = 2.px,
                        style = LineStyle.Solid,
                        color = Color.orange,
                    )
                    .borderRadius(20.px)
                    .position(Position.Sticky)
                    .top(10.px)
                    .cursor(Cursor.Pointer)
                    .onClick {
                        window.location.href = Section.About.path
                    },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Row(modifier = Modifier.color(Color.orange)) {
                Text(
                    value = "In Pizza We Trust",
                )
            }

            P(attrs = Modifier.width(5.px).toAttrs()) {}

            Row(modifier = Modifier.color(Color("#00bf63"))) {
                Text(
                    value = "(and Dough We Crust)",
                )
            }
        }

        Spacer()

        P {}

        Text(
            value =
                " At Pizza Oven, we're not just slingin' pies and tossin' toppings , we're conducting flavor symphonies 🎶. " +
                    "Imagine Mozart, but with mozzarella 🧀 and marinara instead of violins 🎻 and harps .",
        )
        Spacer()

        Text(
            value =
                "Driven by the simple belief that \"In Pizza We Trust,\" " +
                    "we pour our passion, fresh ingredients, and time-honored techniques into every slice 🍕." +
                    "Our passion for pizza is so deep, you could drown in it " +
                    "(but luckily, we always have a lifeguard on duty 🛟, so come on down!)",
        )
        Spacer()

        Text(
            value =
                "Born from a love for bringing people together over delicious food, Pizza Oven is more than just a pizza shop. " +
                    "It's a gathering place, a haven for flavor, and a celebration of shared moments. " +
                    "Whether you're a classic pepperoni purist or a daring spice adventurer 🌶️, " +
                    "we have a pizza that will ignite 🔥 your taste buds and leave you wanting more.",
        )
        Spacer()

        P {}

        Text(
            value = "Here's why you'll LOVE Pizza Oven:",
        )
        Spacer()

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                value =
                    "• Ingredients fresher than your ex's new relationship: " +
                        "We handpick produce that looks like it walked straight out of a fairytale, " +
                        "meats that would make a vegetarian reconsider, " +
                        "and cheeses so good they should be illegal (thankfully they're not).",
            )
            Spacer()

            Text(
                value =
                    "• Dough dreams: " +
                        "Our dough is made with the same love and care ♥️ your grandma puts into her holiday baking. " +
                        "It's light, airy, and has a snap 🫰 that'll make your taste buds do the Macarena. 💃",
            )
            Spacer()

            Text(
                value =
                    "• Toppings galore: " +
                        "We've got classics 💯 we've got weirdos (pineapple on pizza, anyone? 👀), and everything in between. " +
                        "Basically, if you can dream it, we can probably put it on a pizza (except durian 🚫 sorry not sorry).",
            )
            Spacer()

            Text(
                value =
                    "• Passion that could fuel a rocket 🚀: " +
                        "Our pizzaiolos are like rockstars, but instead of guitars 🎸, they wield spatulas and mozzarella graters. " +
                        "Witness their culinary artistry and prepare to be amazed " +
                        "(and hungry, and eventually stuffed. So stuffed, you'll need to be carried out in a wheelchair ♿)",
            )
            Spacer()

            Text(
                value =
                    "• Community love : " +
                        "We're not just here to sell pizza, we're here to build community 💪. We support local businesses, " +
                        "sponsor epic pizza-eating contests, and even throw the occasional dance party on the roof 🪩",
            )

            Spacer()

            P {}

            Text(
                value =
                    "So come on down to Pizza Oven. 🫴" +
                        "We promise you an experience that's more than just a meal, it's an adventure for your taste buds. " +
                        "And hey, if you leave unhappy, we'll offer you a free hug 🫂 (or a second slice, whichever you prefer).",
            )
            Spacer()

            P {}

            Text(value = "P.S. We also deliver, because let's be honest, pizza in pajamas is the ultimate life goal 😎")
        }
    }
}
