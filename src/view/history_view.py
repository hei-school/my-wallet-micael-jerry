from src.model.history import History


def print_history (history_list: list[History]):
    print("===================== History =====================")
    if len(history_list) == 0:
        print("Empty history")
        return
    for i in range(len(history_list)):
        print(f"{i + 1}. {history_list[i].timestamp} - operation: {history_list[i].operation} - sold: {history_list[i].wallet.sold}")
