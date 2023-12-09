from src.model.money import Money
from src.model.type.result import Result
from src.service.money_service import print_money, deposit, withdrawal
from src.view.bar_view import bar
from src.view.menu_view import print_menu


def run(money: Money):
    condition_running: bool = True
    while condition_running:
        print_menu("Status", "Deposit", "Withdraw", "Exit")
        input_str: str = input("Choice: ")

        choice: int = int(input_str)
        if choice == 1:
            bar("Status")
            print_money(money)
        elif choice == 2:
            bar("Deposit")
            res: Result = deposit(money)
            print(res.message)
        elif choice == 3:
            bar("Withdraw")
            res: Result = withdrawal(money)
            print(res.message)
        elif choice == 4:
            condition_running = False
            print("Bye")
        else:
            print("RETRY")
