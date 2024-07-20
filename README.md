<div align='center'>

<h1>Library for Telegram Web App User Validation</h1>

<h4> <span> · </span> <a href="https://github.com/tofitaV/TelegramDataValidation/blob/master/README.md"> Documentation </a> <span> · </span> <a href="https://github.com/tofitaV/TelegramDataValidation/issues"> Report Bug </a> <span> · </span> <a href="https://github.com/tofitaV/TelegramDataValidation/issues"> Request Feature </a> </h4>


</div>

# :notebook_with_decorative_cover: Table of Contents

- [About the Project](#star2-about-the-project)


## :star2: About the Project
<details> <summary>Server</summary> <ul>
<li><a href="">Java 11+</a></li>
</ul> </details>

## :toolbox: Getting Started

### :bangbang: Prerequisites

- Java 11+
- commons-codec 1.15 from apache


### :running: Run Locally
Just invoke is TelegramAuth.isValid() method and put the initData (it is a string from window.Telegram.WebApp object, you can find doc here https://core.telegram.org/bots/webapps#initializing-mini-apps)

Clone the project

```bash
https://github.com/tofitaV/TelegramDataValidation
```

```bash
bool result = TelegramAuth.isValid(telegramInitData, botToken)
```
