package pages

import geb.Page

class DemoQAHomePage extends Page {

    static at = { title == "Demoqa | Just another WordPress site" }

    static content = {
        horizontalMenu { $("#menu-primary-menu", 0).module(HorizontalMenuModule) }
    }
}

class AboutUsPage extends Page {

    static at = { title.startsWith("About us | Demoqa") }

    static content = {
        horizontalMenu { $("#menu-primary-menu", 0).module(HorizontalMenuModule) }
    }
}

class ServicesPage extends Page {

    static at = { title.startsWith("Services | Demoqa") }

    static content = {
        horizontalMenu { $("#menu-primary-menu", 0).module(HorizontalMenuModule) }
    }
}

class DraggablePage extends Page {

    static at = { title.startsWith("Draggable | Demoqa") }

    static content = {
        horizontalMenu { $("#menu-primary-menu", 0).module(HorizontalMenuModule) }
        draggableComponent { $('.inside_contain', 0) }
    }
}

class AuthorAdvanceNavigationPage extends Page {

    static url = "author"

    String convertToPath(Author author) {
        "/${author.name}"
    }

    static content = {
        horizontalMenu { $("#menu-primary-menu", 0).module(HorizontalMenuModule) }

        authorArticlesNumberText { $('h4') }
    }
}

class AuthorParameterisedPage extends Page {

    Author author

    String getPageUrl() {
        "author/${author.name}"
    }

    static content = {
        horizontalMenu { $("#menu-primary-menu", 0).module(HorizontalMenuModule) }

        authorArticlesNumberText { $('h4') }
    }
}

class Author {
    String name
}