Feature: Number conversion
  Can take a Java int in the range 0 to 999,999,999 inclusive and returns the equivalent number, as a String, in British English words.

  Scenario Outline: converting number to BE words
    Given an instance of a number to word conversion service
    When I convert the number <number>
    Then I should get the words <words>

    Examples:
      | number     | words                                                                                                    |
      |  0         |  zero                                                                                                    |
      |  1         |  one                                                                                                     |
      |  21        |  twenty one                                                                                              |
      |  105       |  one hundred and five                                                                                    |
      |  123       |  one hundred and twenty three                                                                            |
      |  1005      |  one thousand and five                                                                                   |
      |  1042      |  one thousand and forty two                                                                              |
      |  1105      |  one thousand one hundred and five                                                                       |
      |  56945781  |  fifty six million nine hundred and forty five thousand seven hundred and eighty one                     |
      |  999999999 |  nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine |