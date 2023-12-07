from src.model.type.result import Result
from src.model.wallet import Wallet


def print_wallet(wallet: Wallet) -> None:
    print(f"Wallet:\n  sold: {wallet.sold}")


def deposit(wallet: Wallet) -> Result:
    input_str: str = input("Money to deposit: ")
    try:
        input_int: int = int(input_str)
        wallet.sold = input_int
        return Result(True, "Deposit successfully", wallet)
    except ValueError:
        return Result(False, "Invalid Input - retry", input_str)


def withdrawal(wallet: Wallet) -> Result:
    input_str: str = input("Amount to withdraw: ")
    try:
        input_int: int = int(input_str)
        if input_int > wallet.sold:
            return Result(False, "Insufficient balance", input_int)
        wallet.sold = wallet.sold - input_int
        return Result(True, "Withdrawal successfully", wallet)
    except ValueError:
        return Result(False, "Invalid Input - retry", input_str)
