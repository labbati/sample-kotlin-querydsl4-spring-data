# Spring Boot 2 + Spring Data JPA + Kotlin + QueryDsl 4

A basic sample project to demonstrate the usage of Kotlin + QueryDsl 4 in the context of a
Spring Boot application.

## Reference

This is a basic Spring Boot app generated through [SPRING INITIALIZR](https://start.spring.io/) with
the addition of the following configuration steps in our `build.gradle` file.

We require QueryDsl version 4.1.4:
```
ext {
	queryDslVersion = "4.1.4"
}
```

We declare the querydsl plugin as a dependency:
```
buildscript {
	// other configurations
	dependencies {
		// other plugin dependencies
		classpath("gradle.plugin.com.ewerk.gradle.plugins:querydsl-plugin:1.0.9")
	}
}
```

We apply the relevant plugins:
```
// other plugins
apply plugin: "kotlin-kapt"
apply plugin: "com.ewerk.gradle.plugins.querydsl"
```

We set where QueryDsl meta classes will be generated:
```
querydsl {
	jpa = true
	querydslSourcesDir = "build/generated/source/kapt/main"
}
```

We declare dependencies related to QueryDsl and we let `kapt` plugin wrap the QueryDsl annotation
processor libraries.
```
dependencies {
	// other dependencies
	compile("com.querydsl:querydsl-apt:$queryDslVersion")
	compile("com.querydsl:querydsl-jpa:$queryDslVersion")
	kapt("com.querydsl:querydsl-apt:$queryDslVersion:jpa")
}
```

You can run the app using the included Gradle wrapper:

```
./gradlew clean bootRun
```

And then direct your browser to the page `localhost:8080` and you should see a list of companies queried from the database.

The database used is an in-memory H2 database and migrations are provided through [Flyway](https://flywaydb.org/).

### Credits and useful links

1. ewerk Querydsl plugin: https://github.com/ewerk/gradle-plugins/tree/master/querydsl-plugin

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## License

The MIT License (MIT)

Copyright (c) 2018 Luca Abbati

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.