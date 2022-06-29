# Mars Rover

Implementation of the Offline testing excercise around the Mars Rover movement logic.

## Getting Started

The exercise has been implemented using Scala and [SBT](https://www.scala-sbt.org) as the build tool. To compile and run the code you will to install SBT locally and the run the following commands:

To compile the code:

```bash
sbt compile
```

To run the tests:

```bash
sbt test
```

Please, check SBT's documentation for additional info.

## IDE

The code presented here has been made IDE-agnostic, but if interested on using one, the recommended ones are as follows:

* [**IntelliJ IDEA**](https://www.jetbrains.com/idea/): One of the most powerful IDEs. You will need the [Scala plugin](https://plugins.jetbrains.com/plugin/1347-scala) to be able to load the project.
* [**Visual Studio Code**](https://code.visualstudio.com): Very powerful and lightweight. You will need the [Scala/Metals](https://olafurpg.github.io/metals/docs/editors/vscode.html) extension to load the project.

Other IDEs can also be used as long as they have some mechanism to understand the SBT project layout.

## Project structure

The project follows the typical structure of most SBT projects:

* `build.sbt`: Main build configuration file.
* `project`: Folder for additional SBT related sources.
* `src/main/scala`: Main folder for the code with the exercise implementation.
* `src/test/scala`: Folder for the code with the unit tests.

In addition to that, under the `src/main/scala` folder you will find the following Scala packages:

* `marsrover.model`: Generic classes that are used in the domain model.
* `marsrover.rover`: Main Rover logic and classes that are very specific to the Rover implementation.

_This repository code implements **Version 1.4** of the Mars Rovers exercise._