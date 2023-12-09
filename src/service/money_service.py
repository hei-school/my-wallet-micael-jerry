from src.model.money import Money
from src.model.type.result import Result


def print_money(money: Money) -> None:
    print(f"money:\n  sold: {money.sold}")


def deposit(money: Money) -> Result:
    input_str: str = input("Money to deposit: ")
    try:
        input_int: int = int(input_str)
        money.sold = money.sold + input_int
        return Result(True, "Deposit successfully", money)
    except ValueError:
        return Result(False, "Invalid Input - retry", input_str)


def withdrawal(money: Money) -> Result:
    input_str: str = input("Amount to withdraw: ")
    try:
        input_int: int = int(input_str)
        if input_int > money.sold:
            return Result(False, "Insufficient balance", input_int)
        money.sold = money.sold - input_int
        return Result(True, "Withdrawal successfully", money)
    except ValueError:
        return Result(False, "Invalid Input - retry", input_str)
