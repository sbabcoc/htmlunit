# HtmlUnit

Version 2.69.0 / January 05, 2023

:heart: [Sponsor](https://github.com/sponsors/rbri)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/net.sourceforge.htmlunit/htmlunit/badge.svg)](https://maven-badges.herokuapp.com/maven-central/net.sourceforge.htmlunit/htmlunit)

**Homepage**

[htmlunit.sourceforge.io][4]

**News**

[HtmlUnit@Twitter][3]

[HtmlUnit Kanban Board][6]

> **Check out HtmlUnit [satellite projects](https://github.com/orgs/HtmlUnit/repositories)**,
such as:
> * [HtmlUnit on android](https://github.com/HtmlUnit/htmlunit-android)
> * [HtmlUnit for .Net](https://github.com/HtmlUnit/NHtmlUnit)
> * or [our Rhino fork](https://github.com/HtmlUnit/htmlunit-rhino-fork) (the JS engine)
>
> Note as well that you can use HtmlUnit with [Selenium](https://www.selenium.dev/) via
> their [htmlunit-driver](https://github.com/SeleniumHQ/htmlunit-driver)!

## Get it!

[Download from Sourceforge][1]

### Maven

Add to your `pom.xml`:

```xml
<dependency>
    <groupId>net.sourceforge.htmlunit</groupId>
    <artifactId>htmlunit</artifactId>
    <version>2.69.0</version>
</dependency>
```

### Gradle

Add to your `build.gradle`:

```groovy
implementation group: 'net.sourceforge.htmlunit', name: 'htmlunit', version: '2.69.0'
```

## Overview
HtmlUnit is a "GUI-less browser for Java programs". It models HTML documents and provides an API that allows you to invoke pages, fill out forms, click links, etc... just like you do in your "normal" browser.

It has fairly good JavaScript support (which is constantly improving) and is able to work even with quite complex AJAX libraries, simulating Chrome, Firefox or Internet Explorer depending on the configuration used.

HtmlUnit is typically used for testing purposes or to retrieve information from web sites.

## Features
* Support for the HTTP and HTTPS protocols
* Support for cookies
* Ability to specify whether failing re
ses from the server should throw exceptions or should be returned as pages of the appropriate type (based on content type)
* Support for submit methods POST and GET (as well as HEAD, DELETE, ...)
* Ability to customize the request headers being sent to the server
* Support for HTML responses
  * Wrapper for HTML pages that provides easy access to all information contained inside them
  * Support for submitting forms
  * Support for clicking links
  * Support for walking the DOM model of the HTML document
* Proxy server support
* Support for basic and NTLM authentication
* Excellent JavaScript support

## Getting Started
You can start here: 
* [Getting Started][7]
* [The Java Web Scraping Handbook][8] A nice tutorial about webscraping with a lot of background information and details about HtmlUnit.
* [Web Scraping][9] Examples how to implement web scraping using HtmlUnit, Selenium or jaunt and compares them.
* [The Complete Guide to Web Scraping with Java][10] A small straightforward guide to web scraping with Java.
* [How to test Jakarta Faces with HTMLUnit and Arquillian][11]

## Contributing
Pull Requests and all other Community Contributions are essential for open source software.
Every contribution - from bug reports to feature requests, typos to full new features - are greatly appreciated.

## Last CI build
The latest builds are available from our
[Jenkins CI build server][2]

[![Build Status](https://jenkins.wetator.org/buildStatus/icon?job=HtmlUnit+-+Headless)](https://jenkins.wetator.org/job/HtmlUnit%20-%20Headless/)

Read on if you want to try the latest bleeding-edge snapshot.

### Maven

Add the snapshot repository and dependency to your `pom.xml`: 

```xml
    <!-- ... --> 
    <repository>
      <id>OSS Sonatype snapshots</id>
      <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
      <snapshots>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy>
      </snapshots>
      <releases>
        <enabled>false</enabled>
      </releases>
    </repository>

    <!-- ... -->
    <dependencies>
      <dependency>
          <groupId>net.sourceforge.htmlunit</groupId>
          <artifactId>htmlunit</artifactId>
          <version>2.70.0-SNAPSHOT</version>
      </dependency>
      <!-- ... -->
    </dependencies>

    <!-- ... -->
```
  
### Gradle

Add the snapshot repository and dependency to your `build.gradle`:

```groovy
repositories {
  maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
  // ...
}
// ...
dependencies {
    implementation group: 'net.sourceforge.htmlunit', name: 'htmlunit', version: '2.70.0-SNAPSHOT'
  // ...
}
```

## Some insights
[HtmlUnit at openhub][5]

## License

This project is licensed under the Apache 2.0 License


[1]: https://sourceforge.net/projects/htmlunit/files/htmlunit/2.69.0/ "HtmlUnit on sourceforge"
[2]: https://jenkins.wetator.org/view/HtmlUnit/ "HtmlUnit CI"
[3]: https://twitter.com/HtmlUnit "https://twitter.com/HtmlUnit"
[4]: https://htmlunit.sourceforge.io/ "https://htmlunit.sourceforge.io/"
[5]: https://www.openhub.net/p/HtmlUnit "https://www.openhub.net/p/HtmlUnit"
[6]: https://github.com/HtmlUnit/htmlunit/projects/1 "https://github.com/HtmlUnit/htmlunit/projects/1"
[7]: https://htmlunit.sourceforge.io/gettingStarted.html
[8]: https://www.scrapingbee.com/java-webscraping-book/
[9]: https://www.innoq.com/en/blog/webscraping/
[10]: https://www.webscrapingapi.com/java-web-scraping/
[11]: http://www.mastertheboss.com/java-ee/jsf/how-to-test-jakarta-faces-with-htmlunit-and-arquillian