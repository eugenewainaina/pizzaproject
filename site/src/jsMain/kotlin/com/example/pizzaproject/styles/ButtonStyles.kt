@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.example.pizzaproject.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val buttonStyles by ComponentStyle {
    base {
        Modifier.backgroundColor(Color.black)
            .color(Color.orange)
            .transition(CSSTransition(property = "color", duration = 500.ms))
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Color.orange,
            ).borderRadius(10.px)
            // .boxShadow(blurRadius = 5.px, spreadRadius = 0.2.px, color = Color.orange)
            .fontFamily("verdana")
    }

    hover {
        Modifier.backgroundColor(Color.black)
            .color(Color("#00BF63"))
            .cursor(Cursor.Pointer)
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Color.orange,
            ).borderRadius(10.px)
        // .boxShadow(blurRadius = 10.px, spreadRadius = 0.2.px, color = Color("#00BF63"))
    }
}
