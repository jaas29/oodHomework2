# HW2 Problem 1 - Hurricane Prediction System

## Run
```sh
sh run.sh
```
Output is saved in `sample-output.txt`. UML: `uml.png` (source `uml.dot`).

## Design patterns used and why

**Template Method** (`HurricanePredictionTemplate`, `StatisticalPrediction`, `MachineLearningPrediction`)
- `predictHurricane()` is the template method. It calls `fetchData() -> preprocessData() -> applyPredictionModel() -> postprocessResults()` in that order, every time.
- It is `final`, so a subclass cannot reorder or skip steps. Subclasses only fill in the four abstract steps.
- Why: both models share the same workflow but differ in each step (historical only vs historical + real-time). The order lives in one place; each model keeps only its differences.

**Command** (`Command`, `FetchDataCommand`, `PredictionCommand`, `SaveResultsCommand`, `PredictionInvoker`)
- Each task is an object with `execute()`. The command holds a receiver (`WeatherDataFetcher`, `PredictionModel`, `ResultSaver`) and delegates to it.
- `PredictionInvoker` stores a `List<Command>`, `addCommand()` queues tasks, `executeCommands()` runs them in sequence. It only knows the `Command` interface.
- Why: tasks become reusable and independently manageable. Steps can be added, removed, or reordered in the invoker without touching the receivers or the invoker code.

## Class roles
| Role | Class |
|---|---|
| Abstract class / template method | `HurricanePredictionTemplate.predictHurricane()` |
| Concrete subclasses | `StatisticalPrediction`, `MachineLearningPrediction` |
| Command interface | `Command` |
| Concrete commands | `FetchDataCommand`, `PredictionCommand`, `SaveResultsCommand` |
| Receivers | `WeatherDataFetcher`, `PredictionModel`, `ResultSaver` |
| Invoker | `PredictionInvoker` |
| Client | `Main` |

## Resources
- Course Week 9 Template Method example: https://github.com/OOD-NCF/Week9TemplateExample2
- Course Week 9 Command example: https://github.com/OOD-NCF/Week9
- Java `ArrayList` docs: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
