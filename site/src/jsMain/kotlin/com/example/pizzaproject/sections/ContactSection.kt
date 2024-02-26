@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.example.pizzaproject.sections

import androidx.compose.runtime.Composable
import com.example.pizzaproject.models.Section
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.modifiers.padding
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun contactUsSection() {
    Column(
        modifier =
            Modifier
                .id(Section.Contact.id)
                .fillMaxSize()
                .padding(20.px)
                .borderRadius(topLeft = 5.px, topRight = 10.px)
                .backgroundColor(Color.black)
                .color(Color("#00bf63"))
                .fontFamily("verdana")
                .fontWeight(1),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
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
                    .onClick {
                        window.location.href = Section.Contact.path
                    }.cursor(Cursor.Pointer),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Row(
                modifier =
                    Modifier.color(Color.orange),
            ) {
                Text(
                    value = "Contact Us",
                )
            }
        }

        Spacer()

        P {}

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .fontWeight(2)
                    .color(Color("#FDF0D0")),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text("Ready to embark on your pizza adventure? We're just a click away!")
        }

        P {}

        Text(value = "Telephone: ")
        Spacer()

        Column(modifier = Modifier.color(Color.orange)) {
            Text(value = "+254 722 333444")
            Spacer()

            Text(value = "+254 792 345678")
        }
        Spacer()

        P {}

        Text(value = "Email: ")
        Spacer()

        Row(modifier = Modifier.color(Color.orange)) {
            Text(value = "pizzaoven@info.com")
            Spacer()
        }

        P {}

        Text(value = "Thank you!")
        Spacer()
    }
}
