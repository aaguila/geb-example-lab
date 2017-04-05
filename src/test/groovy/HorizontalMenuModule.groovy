import geb.Module

class HorizontalMenuModule extends Module {

    static content = {
        aboutUs { $('li#menu-item-158 a') }
        services { $('li#menu-item-155 a') }
        blog { $('li#menu-item-65 a') }
        contact { $('li#menu-item-64 a') }

        toggle { $('.dropdown-toggle') }
        draggable { $('li#menu-item-73 a') }
        tabs { $('li#menu-item-153 a') }
    }
}
