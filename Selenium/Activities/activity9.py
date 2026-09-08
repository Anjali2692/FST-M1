from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/dynamic-content")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    wait = WebDriverWait(driver, 10)

    
    click_button = driver.find_element(By.XPATH, "//button[text()='Click me!']")
    click_button.click()

    
    wait.until(
        EC.text_to_be_present_in_element(
            (By.TAG_NAME, "body"),
            "release"
        )
    )

    
    page_text = driver.find_element(By.TAG_NAME, "body").text

    print("Page Text contains 'release':")
    print(page_text)

finally:
    
    driver.quit()