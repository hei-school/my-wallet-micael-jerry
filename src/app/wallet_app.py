from src.app import money_app, document_app
from src.model.wallet import Wallet
from src.view.bar_view import bar
from src.view.menu_view import print_menu


def run():
    wallet: Wallet = Wallet()

    print("Welcome")

    condition_running: bool = True
    while condition_running:
        print_menu("Money", "Document", "Exit")
        input_str: str = input("Choice: ")

        choice: int = int(input_str)
        if choice == 1:
            bar("Money")
            money_app.run(wallet.money)
        elif choice == 2:
            bar("Document")
            document_app.run(wallet.documents)
        elif choice == 3:
            condition_running = False
            print("Bye")
        else:
            print("RETRY")
