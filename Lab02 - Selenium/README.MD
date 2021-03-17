#TAU LAB2 - Selenium

---

Technologies:
- Java 15.0.2
- Maven 4.0.0
- Selenium 3.141.59
- ChromeDriver 89.0.4389.23
- GeckoDriver 0.29.0
- EdgeDriver 91.0.828.0
- SLF4J Logger 2.0.0-alpha1

---
DDGoTest class - testing site: https://www.duckduckgo.com/

- Search Testing
  - getting search form input object
  - setting text as search value
  - checking if first result is one of three given in statement
- Input Testing
    - getting search form input object
    - setting text as search value
    - clearing text using clear button object
    - checking if text in search input is cleared
- Language Change Testing
  - getting hamburger menu button to click
  - getting polish name of settings to click
  - setting language to German
  - going back to main page
  - checking if text is in German [language is changed]
- SVG Testing
    - getting icon by className
    - checking if address got by attribute "src" matches given in test

---

GmotoTest class - testing site: https://www.gmoto.pl/

- Search Testing
  - selecting a given value in manufacturer select list
  - selecting a given value in model select list
  - selecting a given value in engine-size select list
  - clicking search button
  - clicking fourth search result
  - checking if text in header is equal to given
- Wrong Login Credentials Testing
  - getting button that opens login page
  - entering wrong e-mail and password
  - clicking login button
  - checking if alert of wrong credentials became visible
  
---







