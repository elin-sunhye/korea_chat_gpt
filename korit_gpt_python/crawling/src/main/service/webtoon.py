from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from time import sleep
def run():
    # pass 하면 실행문 없이 넘길 수 있음
    # pass
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
    driver.get("https://comic.naver.com/webtoon?tab=mon")
    sleep(1)

    webtoonDict = {}

    days = driver.find_elements(by=By.CSS_SELECTOR, value="#wrap > header > div.SubNavigationBar__snb_wrap--A5gfM > nav > ul > li")
    print(days)

    for day in days[1:3]: # 1번 인덱스부터 8번 인덱스 전!까지 반복
        print(day.text)
        link = day.find_element(by=By.CSS_SELECTOR, value="a")
        driver.execute_script("arguments[0].scrollIntoView(true);", link) # selenium은 화면 안에 안 보이는 것은 크롤링을 못하기 때문에 scrollIntoView를 해줘야한다
        driver.execute_script("arguments[0].click()", link)
        sleep(2)

        weekdayWebtoonList = []

        items = driver.find_elements(by=By.CSS_SELECTOR, value="#content > div:nth-child(1) > ul > li")
        for item in items:
            driver.execute_script("arguments[0].scrollIntoView(true);", item) # selenium은 화면 안에 안 보이는 것은 크롤링을 못하기 때문에 scrollIntoView를 해줘야한다
            imgElement = item.find_element(by=By.CSS_SELECTOR, value="a > div > img")
            imgSrc = imgElement.get_attribute("src")
            print(imgSrc)

            titleElement = item.find_element(by=By.CSS_SELECTOR, value="div > a > span > span")
            titleTxt = titleElement.text
            print(titleTxt)

            authElement = item.find_element(by=By.CSS_SELECTOR, value="div > .ContentAuthor__author--CTAAP")
            authTxt = authElement.text
            print(authTxt)

            ratingElement = item.find_element(by=By.CSS_SELECTOR, value="div > div:last-of-type > span > span")
            ratingTxt = ratingElement.text
            print(ratingTxt)

            weekdayWebtoonList.append({
                "표지":imgSrc,
                "제목":titleTxt,
                "저자":authTxt,
                "별점":ratingTxt
            })
            sleep(0.2)

        webtoonDict[day.text] = weekdayWebtoonList
        print(webtoonDict)
