<div align='center'>

<h1>Library for Telegram Web App User Validation</h1>

<h4> <span> · </span> <a href="https://github.com/tofitaV/TelegramDataValidation/blob/master/README.md"> Documentation </a> <span> · </span> <a href="https://github.com/tofitaV/TelegramDataValidation/issues"> Report Bug </a> <span> · </span> <a href="https://github.com/tofitaV/TelegramDataValidation/issues"> Request Feature </a> </h4>


</div>

# :notebook_with_decorative_cover: Table of Contents

- [About the Project](#star2-about-the-project)


## :toolbox: Getting Started

### :bangbang: Prerequisites

- Java 11+


### :running: Run Locally
Call the TelegramAuth.isValid() method and put the initData (it is a string from window.Telegram.WebApp object, you can find doc <a href="https://core.telegram.org/bots/webapps#initializing-mini-apps">here</a> )

Download release TelegramDataValidation.jar file from <a href="https://github.com/tofitaV/TelegramDataValidation/releases/tag/release">release section</a> 

Move this file to your project and run this maven goal

```bash
mvn install:install-file -Dfile=TelegramDataValidation.jar -DgroupId=org.tg.auth  -DartifactId=telegram-auth -Dversion=1.0 -Dpackaging=jar
```

Add dependency to your pom.xml

```xml
<dependency>
  <groupId>org.tg.auth</groupId>
  <artifactId>telegram-auth</artifactId>
  <version>1.0</version>
</dependency>
```

```bash
boolean result = TelegramAuth.isValid(telegramInitData, botToken)
```

or

```bash
import static org.tg.auth.TelegramAuth.isValid;

boolean result = isValid(telegramInitData, botToken)
```
