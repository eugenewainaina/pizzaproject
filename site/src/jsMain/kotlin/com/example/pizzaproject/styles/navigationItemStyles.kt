package com.example.pizzaproject.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms

val NavigationItemStyle by ComponentStyle {
    base {
        Modifier.color(Color.orange)
            .transition(CSSTransition(property = "color", duration = 500.ms))
    }
    anyLink {
        Modifier.color(Color.orange)
    }

    hover {
        Modifier.color(Color("#00bf63"))
    }
}
