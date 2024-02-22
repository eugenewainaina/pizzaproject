package com.example.pizzaproject.sections

import androidx.compose.runtime.*
import com.stevdza.san.kotlinbs.components.BSCarousel
import com.stevdza.san.kotlinbs.models.CarouselItem
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px

@Composable
fun peoplePicsSection() {
    val breakpoint = rememberBreakpoint()

    val size: CSSSizeValue<CSSUnit.px> =
        when (breakpoint) {
            Breakpoint.ZERO -> 160.px
            Breakpoint.SM -> 280.px
            Breakpoint.MD -> 380.px
            Breakpoint.LG -> 500.px
            Breakpoint.XL -> 600.px
        }

    Row(
        modifier = Modifier.fillMaxWidth().backgroundColor(Color("#FDF0D0")),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row {
            BSCarousel(
                showControls = false,
                showIndicators = true,
                items =
                    listOf(
                        CarouselItem(
                            image = "people/people 1.jpg",
                            title = "Diligence",
                        ),
                        CarouselItem(
                            image = "people/people 2.jpg",
                            title = "Celebration",
                        ),
                        CarouselItem(
                            image = "people/people 3.jpg",
                            title = "Joy",
                        ),
                        CarouselItem(
                            image = "people/people 4.jpg",
                            title = "Perseverance",
                        ),
                        CarouselItem(
                            image = "people/people 5.jpg",
                            title = "Attention to detail",
                        ),
                    ),
                objectFit = ObjectFit.Cover,
                width = size,
                height = size,
            )
            // Text("$size")
        }

        Row {
            BSCarousel(
                showControls = false,
                showIndicators = true,
                items =
                    listOf(
                        CarouselItem(
                            image = "people/people 6.jpg",
                            title = "Generational knowledge",
                        ),
                        CarouselItem(
                            image = "people/people 7.jpg",
                            title = "More celebration",
                        ),
                        CarouselItem(
                            image = "people/people 8.jpg",
                            title = "Can't get enough",
                        ),
                        CarouselItem(
                            image = "people/people 9.jpg",
                            title = "Family",
                        ),
                        CarouselItem(
                            image = "people/people 10.jpg",
                            title = "Through time",
                        ),
                    ),
                objectFit = ObjectFit.Cover,
                width = size,
                height = size,
            )
        }
    }
}
