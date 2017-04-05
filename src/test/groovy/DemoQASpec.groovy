import geb.spock.GebReportingSpec

import pages.AboutUsPage
import pages.Author
import pages.AuthorAdvanceNavigationPage
import pages.AuthorParameterisedPage
import pages.DemoQAHomePage
import pages.DraggablePage
import pages.ServicesPage

class DemoQASpec extends GebReportingSpec {

    /**
     * Test using modules and page verification using "at"
     */
    void "can get horizontal menu pages"() {
        when:
        to DemoQAHomePage

        and:
        horizontalMenu.aboutUs.click()

        then:
        at AboutUsPage

        when:
        horizontalMenu.services.click()

        then:
        at ServicesPage

    }

    /**
     * Test using interact to emulating user actions
     */
    void "can get horizontal toggle menu pages"() {
        when:
        to DemoQAHomePage

        and:
        interact {
            click horizontalMenu.toggle
            click horizontalMenu.draggable
        }

        then:
        at DraggablePage

    }

    /**
     * Test using advance navigation and parameterised page to build url
     */
    void "can get author page"(Author author, int articlesNumber) {
        when:
        def authorPage = to AuthorAdvanceNavigationPage, author

        then:
        "${author.name} has written ${articlesNumber} articles" == authorPage.authorArticlesNumberText.text().trim()

        when:
        to(new AuthorParameterisedPage(author: author))

        then:
        "${author.name} has written ${articlesNumber} articles" == authorArticlesNumberText.text().trim()

        where:
        author                    || articlesNumber
        new Author(name: "admin") || 2

    }

}