from src.model.history import History
from src.view.bar_view import bar


def print_history(history_list: list[History]):
    bar("History")
    if len(history_list) == 0:
        print("Empty history")
        return
    for i in range(len(history_list)):
        print(f"{i + 1}. {history_list[i].timestamp} - operation: {history_list[i].operation} - sold: {history_list[i].wallet.sold}")
