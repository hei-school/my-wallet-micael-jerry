from src.model.document import Document
from src.model.document_type import DocumentType, get_type_by_num
from src.model.type.result import Result
from src.view.bar_view import bar


def print_document(document_list: list[Document]) -> None:
    for i, document in enumerate(document_list):
        print(f"N: {i + 1}\tidentifier: {document.id}")


def get_document_by_type(document_list: list[Document], document_type: DocumentType) -> list[Document]:
    documents = [document for document in document_list if document.type == document_type]
    return documents


def print_document_group_by_type(document_list: list[Document]) -> None:
    cin_list = get_document_by_type(document_list, DocumentType.CIN)
    driving_licence_list = get_document_by_type(document_list, DocumentType.DRIVING_LICENCE)
    bank_card_list = get_document_by_type(document_list, DocumentType.BANK_CARD)

    if cin_list:
        bar("CIN")
        print_document(cin_list)
    if driving_licence_list:
        bar("Driving licence")
        print_document(driving_licence_list)
    if bank_card_list:
        bar("Bank card")
        print_document(bank_card_list)


def add_document(document_list: list[Document]) -> Result:
    document: Document = Document()
    input_type: str = input("Document type:\n\t1. CIN\n\t2. Driving Licence\n\t3. Bank Card\n")
    if input_type.isdigit() and 1 <= int(input_type) <= 3:
        input_identifier = input("Document identifier: ")
        if input_identifier:
            document.type = get_type_by_num(int(input_type))
            document.id = input_identifier
            document_list.append(document)
            return Result(True, "Document added successfully")
        else:
            return Result(False, "Invalid Input - retry")
    else:
        return Result(False, "Invalid Input - retry")


def remove_document_in_list(document_list: list[Document], document: Document) -> None:
    for i in range(len(document_list)):
        if document_list[i] == document:
            document_list.pop(i)
            break


def remove_document(documents: list[Document]) -> Result:
    print_document_group_by_type(documents)
    type_doc_remove_input = input("Type of document you want to remove:\n\t1. CIN\n\t2. Driving Licence\n\t3. Bank "
                                  "Card:\n")
    if type_doc_remove_input.isdigit() and 1 <= int(type_doc_remove_input) <= 3:
        type_doc_remove = get_type_by_num(int(type_doc_remove_input))
        index_doc_remove_input = input("Document number (N): ")
        if index_doc_remove_input.isdigit():
            index_doc_remove = int(index_doc_remove_input)
            documents_by_type = get_document_by_type(documents, type_doc_remove)
            if len(documents_by_type) >= index_doc_remove:
                document_removed = documents_by_type[index_doc_remove - 1]
                remove_document_in_list(documents, document_removed)
                return Result(True, "Document removed successfully")
            else:
                return Result(False, "Invalid Input - retry")
    else:
        return Result(False, "Invalid Input - retry")
