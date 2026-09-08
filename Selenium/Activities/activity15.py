from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/dynamic-attributes")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    wait = WebDriverWait(driver, 10)

    
    first_name = driver.find_element(
        By.XPATH,
        "//input[starts-with(@id, 'full-name')]"
    )

    email = driver.find_element(
        By.XPATH,
        "//input[contains(@id, '-email')]"
    )

    event_date = driver.find_element(
        By.XPATH,
        "//input[contains(@name, '-event-date-')]"
    )

    additional_details = driver.find_element(
        By.XPATH,
        "//textarea[contains(@id, '-additional-details-')]"
    )

    
    first_name.send_keys("John")
    email.send_keys("john.doe@example.com")
    event_date.send_keys("2026-06-25")
    additional_details.send_keys("Dealing with dynamic attributes")

    
    submit_button = driver.find_element(
        By.XPATH,
        "//button[text()='Submit']"
    )
    submit_button.click()

    
    success_message = wait.until(
        EC.visibility_of_element_located((By.ID, "action-confirmation"))
    )

    
    print("Success Message:", success_message.text)

finally:
    
    driver.quit()