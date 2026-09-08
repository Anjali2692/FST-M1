from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/selects")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    single_select_element = driver.find_element(By.CSS_SELECTOR, "select.h-10")

    
    single_select = Select(single_select_element)

    
    single_select.select_by_visible_text("Two")

    
    single_select.select_by_index(3)

    
    single_select.select_by_value("four")

    
    options = single_select.options

    print("\nAvailable Options:")
    for option in options:
        print(option.text)

finally:
    
    driver.quit()