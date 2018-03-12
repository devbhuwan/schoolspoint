BDD Cucumber Best Practices
------------------------------
## Features
- RULES:
    - Group feature files by an application domain, not by an actor.
    - 1 Feature = 1 File

## Scenarios
- RULES:
    - Use a declarative style.
    - Make scenarios independent and deterministic.
    - Use backgrounds wisely.
## Steps
- RULES:
    - The step description must contain neither regexen, CSS or XPath selectors, nor any kind of code or data structure.
    - Avoid using conjunctive steps.
    - Anything that is literally used must be in double quotes, otherwise, it should be specified within the sentence.
## Step Definitions
- RULES:
    - Use flexible pluralization.
    - Use non-capturing groups to ensure steps are read naturally.
    - Simplify step definitions.