@StudentFeatures
Feature: Add student profile

  sub domain: student-management
  Student record manager

  Domain Story:
  Register student applicant on the system using:
  name {firstName, middleName, lastName},
  address {name, street, city, zipCode},
  grade {gradeType, gradeGroup},
  rollNumber -> auto generated by system with plus one of last sequence over student with same grade.

  >> registerApplicantUseCase.execute(studentInfoParams)

  Only form will be submitted if user provide parameters correctly otherwise system will notify errors on user input.

  Scenario: Notify to errors when adding incomplete student profile parameters
    Given Incomplete student profile parameters
      | firstName | middleName | lastName | addressName    | addressStreet | addressZipCode | gradeType | gradeGroup |
      |           |            |          | Lamki, Kailali | Tilkani       | 00977          | TEN       | A          |
      | BHUWAN    | PRASAD     | UPADHYAY |                | Tilkani       | 00977          | TEN       | A          |

  Scenario: Notify to errors when adding complete student profile parameters
    Given Complete student profile parameters
      | firstName | middleName | lastName | addressName    | addressStreet | addressZipCode | gradeType | gradeGroup |
      | BHUWAN    | PRASAD     | UPADHYAY | Lamki, Kailali | Tilkani       | 00977          | TEN       | A          |
      | BHUWAN    |            | UPADHYAY | Lamki, Kailali | Tilkani       | 00977          | TEN       | A          |
      | BHUWAN    |            | UPADHYAY | Lamki, Kailali |               |                |           |            |