from src.model.document import Document
from src.model.type.result import Result
from src.service.document_service import print_document_group_by_type, add_document, remove_document
from src.view.bar_view import bar
from src.view.menu_view import print_menu


def run(document_list: list[Document]) -> None:
    condition_running = True
    while condition_running:
        print_menu("Status", "Add", "Remove", "Exit")
        input_str = input("Choice: ")

        choice: int = int(input_str)
        if choice == 1:
            bar("Status")
            print_document_group_by_type(document_list)
        elif choice == 2:
            bar("Add")
            res: Result = add_document(document_list)
            print(res.message)
        elif choice == 3:
            bar("Remove")
            res: Result = remove_document(document_list)
            print(res.message)
        elif choice == 4:
            condition_running = False
        else:
            print("RETRY")
