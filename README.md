# Autotests for https://wikipedia.org/ Mobile + Web
___
## Technologies used:
| GitHub | IntelliJ IDEA | Java | Gradle | Browserstack | Selenide |
|:------:|:----:|:----:|:------:|:------:|:--------:|
| <img src="images/GitHub.svg" width="40" height="40"> | <img src="images/IDEA.svg" width="40" height="40"> | <img src="images/JAVA.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/browserstack.jpeg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> |

| Jenkins | Selenoid | Allure Report | Allure TestOps | Telegram |
|:--------:|:-------------:|:---------:|:-------:|:--------:|
| <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/Selenoid.svg" width="40" height="40"> | <img src="images/Allure Report.svg" width="40" height="40"> | <img src="images/Allure TestOps.svg" width="40" height="40"> | <img src="images/Telegram.svg" width="40" height="40"> |
___


## Default settings used [for Jenkins startup](https://jenkins.autotests.cloud/job/c06_egormuratov_wikipedia_mobile_web/) <a href="https://www.jenkins.io/"><img src="./images/Jenkins.svg" width="40" height="40"  alt="Jenkins"/></a>

* DRIVER_TYPE (Required parameter. SelenoidDriver (for WEB), BrowserStackDriver (for mobile), AppiumDriver (in develop))
* TESTS_TYPE (Required parameter. web or android)
* REPOSITORY (Required parameter)
* BROWSER (Web parameter)
* BROWSER_VERSION (Web parameter)
* BROWSER_SIZE (Web parameter)
* DEVICE (Mobile parameter)
* ANDROID.VERSION (Mobile parameter)
* ALLURE_NOTIFICATIONS_VERSION (Required parameter. default 3.0.2)

![alt "Launch via Jenkins"](./images/jenkinsRun.png)

### Run tests with filled local.properties:

```bash
gradle clean android 
```

or

```bash
gradle clean web 
```

### Run tests with not filled local.properties:

```bash
gradle clean android -Ddriver=BrowserStackDriver -Dandroid.version=9.0 -Ddevice="Google Pixel 3"
```

or

```bash
gradle clean web -Dbrowser=chrome -DbrowserVersion=91.0 -DbrowserSize=1920x1080
```

### Serve allure report:

```bash
allure serve build/allure-results
```

## List of tests in Allure TestOps
![alt "Allure TestOps"](./images/ListOfTestsInAllureTestOps.png "Allure TestOps")


## Notification of test results via a bot on Telegram <a href="https://telegram.org/"> <img src="images/telegram2.svg" width="40" height="40"></a>

![alt "Telegram bot"](./images/bot.png "telegram bot")

## Analysis of results in Jenkins via Allure Reports<a href="https://qameta.io/"><img src="images/jenkins_allure.svg" width="40" height="40"></a>
![alt "Allure Reports"](./images/jenkinsResult.png "Allure Reports")
## Analysis of results in Allure TestOps <a href="https://qameta.io/"><img src="images/Allure_EE.svg" width="40" height="40"></a>

![alt "Allure TestOps"](./images/allure1.png "Allure TestOps")
## Video of the test run, taken from the Selenoid runtime environment <a href="https://aerokube.com/selenoid/"><img src="images/Selenoid.svg" width="40" height="40"></a>

![alt "Video from Browserstack"](./images/mobile.gif "Video from Browserstack")

![alt "Video from Selenoid"](./images/web.gif "Video from Selenoid")