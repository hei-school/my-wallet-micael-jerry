from src.view.bar_view import bar


def print_menu(*menu: str):
    bar("Menu")
    for i in range(len(menu)):
        print(f"{i + 1}. {menu[i]}")
