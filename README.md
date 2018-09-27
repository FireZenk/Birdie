# Birdie
Follow and post other account twits

[![Build Status](https://travis-ci.org/FireZenk/Birdie.svg?branch=develop)](https://travis-ci.org/FireZenk/HeyBirthday)
[![codecov](https://codecov.io/gh/FireZenk/Birdie/branch/develop/graph/badge.svg)](https://codecov.io/gh/FireZenk/HeyBirthday)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/FireZenk/HeyBirthday/issues)
[![Beerpay](https://img.shields.io/beerpay/hashdog/scrapfy-chrome-extension.svg)](https://beerpay.io/FireZenk/HeyBirthday)

### Commands

- Configuration
    - TODO
- Usage
    - TODO

Also you can type: `b!info` and see all available commands directly on Discord.

### Result

You will receive every new twit on the `postingChannel` like:

> Twit account + twit text + twit media (if exits)

### Invite me!

[Click here](https://discordapp.com/oauth2/authorize?client_id=494788306052317194&scope=bot&permissions=0)

---

### Or create your own instace

##### How to install

1. `git clone https://github.com/FireZenk/Birdie.git`
2. `cd Birdie/`
2. `./gradlew stage`
3. `export DISCORD=YOUR_DISCORD_BOT_TOKEN`
5. `./build/install/birdie/bin/birdie $DISCORD`
6. Enjoy!

##### How to deploy

1. Create a *free account* on Google Cloud Platform
2. Go to Google App Engine: [link](https://console.cloud.google.com/projectselector/appengine/create?lang=java&st=true&_ga=2.99197598.-1421285151.1528186199)
3. Create a project
4. Open Google Cloud Shell
5. Follow "How to install" above
