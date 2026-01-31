# oopd-gu-chalmers Lab 1
Lab assignment 1 in the course Object-oriented Programming and Design, GU/Chalmers

## Instruktioner för testning.
Från root-katalogen, skriv följande kommando.
```
mvn clean verify
```

## Testresultat med coverage
[https://dukimy.github.io/LAB1/](https://dukimy.github.io/LAB1/)

## Svar på frågor från Lab1 - Uppgift 1.
```
-------------------------------------------------------------------------------
|  Svar på frågor i uppgift 1                                                 |
-------------------------------------------------------------------------------
|1.  Bör ni använda implementationsarv (subclassing) eller specifikationsarv  |
|   (interfaces)? Varför? Kan båda användas? Vilka för- och nackdelar ser ni? |
|                                                                             |
|Svar: Implementationsarv används när man vill undvika kodduplicering på två  |
|      eller fler klasser med variabler och metoder som är lika.              |
|                                                                             |
|      Specifikationsarv används när man vill säkerställa att klassmetoder    |
|      beter sig på ett förutsagt sätt.                                       |
|------------------------------------------------------------------------------
|2.  Vilken synlighet bör ni använda för de olika metoder och variabler som   |
|    klasserna innehåller? Vilket gränssnitt bör ni exponera?                 |
|                                                                             |
|Svar: Getters och setters som inte används inom klasshierarkin exponeras     |
|      globalt. Likaså med metoderna för att starta och stoppa motorn samt    |
|      höja och sänka farten. Variabler och objekt som kan modifiera          |
|      klassobjektets interna tillstånd bör inte exponeras.                   |
|------------------------------------------------------------------------------
```

## Projekt struktur.
```
LAB1
│   .classpath
│   .project
│   diff.txt
│   pom.xml
│   README.md
│   session.vim
│
├───.github
│   └───workflows
│           yacoco-pages.yml
│
├───.settings
│       org.eclipse.core.resources.prefs
│       org.eclipse.jdt.apt.core.prefs
│       org.eclipse.jdt.core.prefs
│       org.eclipse.m2e.core.prefs
│
├───.vscode
│       settings.json
│
├───src
│   ├───main
│   │   └───java
│   │       └───lab1
│   │               Movable.java
│   │               README.txt
│   │               Saab95.java
│   │               Vehicle.java
│   │               Volvo240.java
│   │
│   └───test
│       └───java
│           └───lab1
│                   VehicleTest.java
│
└───target
    │   jacoco.exec
    │   lab1-1.0-SNAPSHOT.jar
    │
    ├───classes
    │   └───lab1
    │           Movable.class
    │           Saab95.class
    │           Vehicle.class
    │           Volvo240.class
    │
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───maven-archiver
    │       pom.properties
    │
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       │           createdFiles.lst
    │       │           inputFiles.lst
    │       │
    │       └───testCompile
    │           └───default-testCompile
    │                   createdFiles.lst
    │                   inputFiles.lst
    │
    ├───site
    │   └───jacoco
    │       │   index.html
    │       │   jacoco-sessions.html
    │       │   jacoco.csv
    │       │   jacoco.xml
    │       │
    │       ├───jacoco-resources
    │       │       branchfc.gif
    │       │       branchnc.gif
    │       │       branchpc.gif
    │       │       bundle.gif
    │       │       class.gif
    │       │       down.gif
    │       │       greenbar.gif
    │       │       group.gif
    │       │       method.gif
    │       │       package.gif
    │       │       prettify.css
    │       │       prettify.js
    │       │       redbar.gif
    │       │       report.css
    │       │       report.gif
    │       │       session.gif
    │       │       sort.gif
    │       │       sort.js
    │       │       source.gif
    │       │       up.gif
    │       │
    │       └───lab1
    │               index.html
    │               index.source.html
    │               Saab95.html
    │               Saab95.java.html
    │               Vehicle.html
    │               Vehicle.java.html
    │               Volvo240.html
    │               Volvo240.java.html
    │
    ├───surefire-reports
    │       lab1.VehicleTest.txt
    │       TEST-lab1.VehicleTest.xml
    │
    └───test-classes
        └───lab1
                VehicleTest.class
```
