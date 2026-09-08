from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/dynamic-controls")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    textbox = driver.find_element(By.ID, "textInput")

    
    print("Input field is enabled:", textbox.is_enabled())

    
    driver.find_element(By.ID, "textInputButton").click()

    
    textbox = driver.find_element(By.ID, "textInput")

    
    print("Input field is enabled:", textbox.is_enabled())

    
    textbox.send_keys("Sample")

    
    print("Entered text:", textbox.get_attribute("value"))

finally:
    
    driver.quit()