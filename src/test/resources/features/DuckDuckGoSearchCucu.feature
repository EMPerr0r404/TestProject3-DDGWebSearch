Feature: Search with Duck Duck Go

# This feature describes the behavior of successful phrase searches using DuckDuckGo.

  Scenario Outline: Successful phrase search with https://duckduckgo.com/

  # Given the DuckDuckGo search page is opened in the browser
    Given Page https://duckduckgo.com/ opened in browser

  # When a specific search phrase is entered in the search input box and the search button is clicked
    When Phrase '<searchPhrase>' entered in search input box
    And Search button clicked

  # Then the first <meaningfulPositions> search result text should contain the search phrase
    Then First <Positions> search result text contain phrase '<searchPhrase>'

  # And save a screenshot for verification purposes
  # And Save screenshot

  # And close the browser
    And Close browser

# Examples table with different search phrases and expected correct positions in search results
    Examples:
      | searchPhrase          | Positions |
      | w pustyni i w puszczy | 5         |
      | pogoda                | 2         |
      | Józef Piłsudski       | 2         |
