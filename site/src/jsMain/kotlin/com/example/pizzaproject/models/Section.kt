package com.example.pizzaproject.models

enum class Section(
    val id: String,
    val title: String,
    val path: String,
    val onClick: () -> Unit = {},
) {
    Home(
        id = "home",
        title = "Home",
        path = "#home",
    ),
    Menu(
        id = "menu",
        title = "View Menu",
        path = "#menu",
    ),
    About(
        id = "about",
        title = "About Us",
        path = "#about",
    ),
    Contact(
        id = "contact",
        title = "Contact Us",
        path = "#contact",
    ),
}
