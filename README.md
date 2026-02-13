# oopd-gu-chalmers Lab 2
Lab assignment 2 in the course Object-oriented Programming and Design, GU/Chalmers

## Instruktioner för testning.
Från root-katalogen, skriv följande kommando.
```
mvn clean verify
```

## Testresultat med coverage
Problem med github workern, testresultatet som länkats är gammalt. Se ```.\target\site\jacoco\index.html ``` för aktuellt resultat.

~~[https://dukimy.github.io/LAB2/](https://dukimy.github.io/LAB2)~~

Uppdatering: Min lokala maskin kör testerna i en annan ordning än github actions, detta verkar bero på att junit kör testerna i en annan ordning på Linux än på Windows.

Får ni problem med testerna, kör dem i denna ordning.
1. GarageTests.java
2. LoadableVehicleTests.java
3. TippableVehiclesTest.java
4. VehicleTest.java

## Projekt struktur.
```
Folder PATH listing for volume Local Disk
Volume serial number is 803D-0C49
LAB2
│   .classpath
│   .project
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
├───img
│       Sketch.png
│
├───src
│   ├───main
│   │   └───java
│   │       └───lab2
│   │               Car.java
│   │               ConditionallyMovableVehicle.java
│   │               GameObject.java
│   │               Garage.java
│   │               Loadable.java
│   │               Movable.java
│   │               RampOperated.java
│   │               README.md
│   │               Saab95.java
│   │               Scania.java
│   │               Tippable.java
│   │               TurboChargable.java
│   │               Vehicle.java
│   │               Volvo240.java
│   │               VolvoFH16.java
│   │
│   └───test
│       └───java
│           └───lab2
│                   GarageTests.java
│                   LoadableVehicleTests.java
│                   TippableVehiclesTest.java
│                   VehicleTests.java
│
└───target
    │   jacoco.exec
    │   LAB2-1.0-SNAPSHOT.jar
    │
    ├───classes
    │   └───lab2
    │           Car.class
    │           ConditionallyMovableVehicle.class
    │           GameObject.class
    │           Garage.class
    │           Loadable.class
    │           Movable.class
    │           RampOperated.class
    │           Saab95.class
    │           Scania.class
    │           Tippable.class
    │           TurboChargable.class
    │           Vehicle.class
    │           Volvo240.class
    │           VolvoFH16.class
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
    │       └───lab2
    │               ConditionallyMovableVehicle.html
    │               ConditionallyMovableVehicle.java.html
    │               GameObject.html
    │               GameObject.java.html
    │               Garage.html
    │               Garage.java.html
    │               index.html
    │               index.source.html
    │               Saab95.html
    │               Saab95.java.html
    │               Scania.html
    │               Scania.java.html
    │               Vehicle.html
    │               Vehicle.java.html
    │               Volvo240.html
    │               Volvo240.java.html
    │               VolvoFH16.html
    │               VolvoFH16.java.html
    │
    ├───surefire-reports
    │       lab2.GarageTests.txt
    │       lab2.LoadableVehicleTests.txt
    │       lab2.TippableVehiclesTest.txt
    │       lab2.VehicleTest.txt
    │       TEST-lab2.GarageTests.xml
    │       TEST-lab2.LoadableVehicleTests.xml
    │       TEST-lab2.TippableVehiclesTest.xml
    │       TEST-lab2.VehicleTest.xml
    │
    └───test-classes
        └───lab2
                GarageTests.class
                LoadableVehicleTests.class
                TippableVehiclesTest.class
                VehicleTest.class
```

## Dokumentation av planeringsstadiet.

![Sketch of program structure](./img/Sketch.png)
