import time
from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/tabs")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    driver.find_element(
        By.XPATH,
        "//button[contains(text(),'Open A New Tab')]"
    ).click()

    
    time.sleep(2)

    
    handles = driver.window_handles

    print("Window Handles:")
    for handle in handles:
        print(handle)

    
    driver.switch_to.window(handles[1])

    
    print("\nSecond Tab Title:", driver.title)

    
    message = driver.find_element(By.TAG_NAME, "h1")
    print("Message:", message.text)

    
    driver.find_element(
        By.XPATH,
        "//button[contains(text(),'Open Another One')]"
    ).click()

    
    time.sleep(2)

    
    handles = driver.window_handles

    print("\nUpdated Window Handles:")
    for handle in handles:
        print(handle)

    
    driver.switch_to.window(handles[2])

    
    print("\nThird Tab Title:", driver.title)

    
    message = driver.find_element(By.TAG_NAME, "h1")
    print("Message:", message.text)

finally:
    
    driver.quit()