from src.model.history import History
from src.model.operation_type import OperationType
from src.model.type.result import Result
from src.model.wallet import Wallet
from src.service.wallet_service import print_wallet, deposit, withdrawal
from src.view.bar_view import bar
from src.view.history_view import print_history
from src.view.menu_view import print_menu


def run():
    wallet: Wallet = Wallet()
    history_list: list[History] = []

    print("Welcome")

    condition_running: bool = True
    while condition_running:
        print_menu("Status", "Deposit", "Withdraw", "History", "Exit")
        input_str: str = input("Choice: ")

        choice: int = int(input_str)
        if choice == 1:
            bar("Status")
            print_wallet(wallet)
            history_list.append(History(OperationType.STATUS, wallet))
        elif choice == 2:
            bar("Deposit")
            res: Result = deposit(wallet)
            if res.is_success:
                print(res.message)
                history_list.append(History(OperationType.DEPOSIT, wallet))
            else:
                print(res.message)
        elif choice == 3:
            bar("Withdraw")
            res: Result = withdrawal(wallet)
            if res.is_success:
                print(res.message)
                history_list.append(History(OperationType.WITHDRAW, wallet))
            else:
                print(res.message)
        elif choice == 4:
            print_history(history_list)
        elif choice == 5:
            condition_running = False
            print("Bye")
        else:
            print("RETRY")
