@AccountancyFeatures
Feature: Add student profile

  sub domain: accountancy
  Student payment manager

  Domain Story:
  Once new applicant registered then collect first installment payment using:
  studentIdentifier, grade
  >> installmentPaymentUseCase.execute(installmentPaymentInfoParams)

  Only form will be submitted if user provide sufficient paid amount otherwise system will notify errors on user input.

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