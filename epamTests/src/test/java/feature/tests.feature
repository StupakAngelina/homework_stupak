Feature: epamSiteTests

  Scenario: Information search
    Given I’m on the epam home page
    When I click on the search tab and look for "something"
    Then Page title will "Search"


  Scenario: Site language
    Given I’m on the epam home page
    When I click on the language tab and select Ukrainian region and English
    Then Then the site language will English

  Scenario: The connection between the pages
    Given I’m on the «careers» page
    When I press on a button «contact us»
    Then I will go to the «contact» page

  Scenario: Contact
    Given I’m on the «contact» page
    When I press on a button «submit an application»
    Then The registration form will send

  Scenario: Home page
    Given I’m on any page
    When I press on a button «epam»
    Then I will on the main page
    
  Scenario: Customer solution article
    Given I'm on the «Our work» page
    When I press on a button «Healthcare» and click on «Learn more»
    Then I will go to the page about the solution for this customer

  Scenario: epam on Facebook
    Given I’m on the «epam» page
    When I scroll down and press on a button «Facebook»
    Then I will see epam page on Facebook

  Scenario: FAQ
    Given I’m on the main page
    When I press on a button «About»
    Then I will go to the page with FAQ
