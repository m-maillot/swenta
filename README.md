# Swenta

Swenta is a sample project to show how to use most popular Android library. It's a dummy project which I improve to test and show how I use Android librairies.
Today, the project shows a list of news extracted from website Geekwire (provide a complete RSS).

## Architecture

Inspired by clean architecture (but simplified), the project is composed of two modules:
 * core: Contains the business code
 * presentation: Contains the UI code

## Overview

### Core module

Core retrieves data from RSS flow. RSS is parsed by pkrss library and provides a list of Article.
Articles are transformed in a list of NewsEntity. NewsEntity is the persist layer data. NewsEntities are transformed in json with Gson and persisted to local storage.
Then, NewsEntities are transformed in a list of News. News is the business object. It's used to pass data from core module to presentation module.

### Presentation module

Presentation retrieves a list of News. News are transformed in NewsModels. NewsModel is the representation of a news used by all UI views.

### RxJava

All process is performed with RxJava.

# TODO

 * Make same app in Kotlin (for fun)
 * Use MVP pattern for UI

