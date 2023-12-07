def print_menu(*menu: str):
    print("===================== Menu =====================")
    for i in range(len(menu)):
        print(f"{i + 1}. {menu[i]}")
