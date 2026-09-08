from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/drag-drop")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    ball = driver.find_element(By.ID, "ball")
    dropzone1 = driver.find_element(By.ID, "dropzone1")
    dropzone2 = driver.find_element(By.ID, "dropzone2")

    
    actions = ActionChains(driver)

    
    actions.drag_and_drop(ball, dropzone1).perform()

    
    dropzone1_text = dropzone1.text
    print("Dropzone 1 Text:", dropzone1_text)

    if "Ball" in dropzone1_text:
        print("Ball successfully moved to Dropzone 1")

    
    ball = driver.find_element(By.ID, "ball")

    
    actions = ActionChains(driver)
    actions.drag_and_drop(ball, dropzone2).perform()

    
    dropzone2_text = dropzone2.text
    print("Dropzone 2 Text:", dropzone2_text)

    if "Ball" in dropzone2_text:
        print("Ball successfully moved to Dropzone 2")

finally:
    
    driver.quit()