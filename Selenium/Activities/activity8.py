from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/dynamic-controls")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    wait = WebDriverWait(driver, 10)

    
    checkbox_locator = (By.ID, "checkbox")
    toggle_button = (By.XPATH, "//button[text()='Toggle Checkbox']")

    
    driver.find_element(*toggle_button).click()

    
    wait.until(EC.invisibility_of_element_located(checkbox_locator))
    print("Checkbox removed")

    
    driver.find_element(*toggle_button).click()

    
    checkbox = wait.until(
        EC.presence_of_element_located(checkbox_locator)
    )
    print("Checkbox appeared")

    
    checkbox.click()
    print("Checkbox selected")

finally:
    
    driver.quit()