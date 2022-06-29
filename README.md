# Mars Rover

Implementation of the Offline testing excercise around the Mars Rover movement logic.

## Getting Started

The exercise has been implemented using Scala and SBT as the build tool. To compile and run the code you will to install SBT locally and the run the following commands:

To compile the code:

```bash
sbt compile
```

To run the tests:

```bash
sbt test
```

Please, check SBT's documentation for additional info.

## Project structure

The project follows the typical structure of most SBT projects:

* `build.sbt`: Main build configuration file.
* `project`: Folder for additional SBT related sources.
* `src/main/scala`: Main folder for the code with the exercise implementation.
* `src/test/scala`: Folder for the code with the unit tests.

In addition to that, under the `src/main/scala` folder you will find the following Scala packages:

* `marsrover.model`: Generic classes that are used in the domain model.
* `marsrover.rover`: Main Rover logic and classes that are very specific to the Rover implementation.