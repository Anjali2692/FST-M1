from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/target-practice")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    third_header = driver.find_element(
        By.XPATH,
        "//h3[@class='text-3xl font-bold text-orange-600']"
    )
    print("3rd Header Text:", third_header.text)

    
    fifth_header = driver.find_element(
        By.XPATH,
        "//h5[@class='text-3xl font-bold text-purple-600']"
    )
    print("5th Header Text:", fifth_header.text)

    
    color = fifth_header.value_of_css_property("color")
    print("5th Header Color:", color)

    
    purple_button_class = driver.find_element(
        By.XPATH,
        "//button[text()='Purple']"
    ).get_attribute("class")

    print("Purple Button Class:", purple_button_class)

    
    slate_button_text = driver.find_element(
        By.XPATH,
        "//button[contains(@class,'slate')]"
    ).text

    print("Slate Button Text:", slate_button_text)

finally:
    
    driver.quit()