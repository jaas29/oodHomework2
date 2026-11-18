# HW2 Problem 3 - User Registration Validation (Chain of Responsibility + Swing)

## Run
```sh
sh run.sh          # opens the Swing form
sh run.sh --test   # console test cases, no window (output in sample-output.txt)
```
Screenshots of the form showing errors are in `screenshots/`. UML: `uml.png`.

## Design pattern used and why

**Chain of Responsibility** (`Validator`, `UsernameValidator`, `PasswordValidator`, `EmailValidator`, `PhoneNumberValidator`)
- `Validator` declares `setNextValidator()` and `validate()`.
- Each validator checks one rule. If it fails, it throws `ValidationException` and the chain stops. If it passes, it calls `nextValidator.validate(request)`.
- `Main.buildChain()` links them: Username -> Password -> Email -> Phone, and returns the head.
- The form only holds the head of the chain. Clicking **Register** calls `chain.validate(user)` once.
- Why: each rule lives in its own class. Adding a new rule (e.g. "confirm password") means writing one class and linking it; no other validator or the UI changes.

## UI details
- `JFrame` with Username, Password (`JPasswordField`), Email, optional Phone, and a Register button.
- Each field has a red `JLabel` next to it. `ValidationException` carries the failing field name, so the UI knows which label to fill.
- On success: green status text plus a `JOptionPane` "Registration successful!" dialog.
- Phone is optional: empty is allowed; if filled it must be exactly 10 digits (`\d{10}`).

## Rules
| Validator | Rule |
|---|---|
| Username | non-empty, at least 5 characters |
| Password | 8+ chars, at least one uppercase, one lowercase, one digit |
| Email | `^[\w._%+-]+@[\w.-]+\.[a-zA-Z]{2,}$` |
| Phone | blank, or exactly 10 digits |

## Resources
- Course Week 9 CoR example: https://github.com/OOD-NCF/Week9CORExampl2
- Course Week 10 Java Swing examples: https://github.com/OOD-NCF/Week10_JavaSwing1, https://github.com/OOD-NCF/Week10_JavaSwing2
- Java Swing tutorial (Oracle): https://docs.oracle.com/javase/tutorial/uiswing/
